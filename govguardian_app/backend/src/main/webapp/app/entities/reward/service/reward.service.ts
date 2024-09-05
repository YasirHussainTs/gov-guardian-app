import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IReward, NewReward } from '../reward.model';

export type PartialUpdateReward = Partial<IReward> & Pick<IReward, 'id'>;

type RestOf<T extends IReward | NewReward> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

export type RestReward = RestOf<IReward>;

export type NewRestReward = RestOf<NewReward>;

export type PartialUpdateRestReward = RestOf<PartialUpdateReward>;

export type EntityResponseType = HttpResponse<IReward>;
export type EntityArrayResponseType = HttpResponse<IReward[]>;

@Injectable({ providedIn: 'root' })
export class RewardService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/rewards');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(reward: NewReward): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reward);
    return this.http
      .post<RestReward>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(reward: IReward): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reward);
    return this.http
      .put<RestReward>(`${this.resourceUrl}/${this.getRewardIdentifier(reward)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(reward: PartialUpdateReward): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reward);
    return this.http
      .patch<RestReward>(`${this.resourceUrl}/${this.getRewardIdentifier(reward)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestReward>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestReward[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getRewardIdentifier(reward: Pick<IReward, 'id'>): number {
    return reward.id;
  }

  compareReward(o1: Pick<IReward, 'id'> | null, o2: Pick<IReward, 'id'> | null): boolean {
    return o1 && o2 ? this.getRewardIdentifier(o1) === this.getRewardIdentifier(o2) : o1 === o2;
  }

  addRewardToCollectionIfMissing<Type extends Pick<IReward, 'id'>>(
    rewardCollection: Type[],
    ...rewardsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const rewards: Type[] = rewardsToCheck.filter(isPresent);
    if (rewards.length > 0) {
      const rewardCollectionIdentifiers = rewardCollection.map(rewardItem => this.getRewardIdentifier(rewardItem)!);
      const rewardsToAdd = rewards.filter(rewardItem => {
        const rewardIdentifier = this.getRewardIdentifier(rewardItem);
        if (rewardCollectionIdentifiers.includes(rewardIdentifier)) {
          return false;
        }
        rewardCollectionIdentifiers.push(rewardIdentifier);
        return true;
      });
      return [...rewardsToAdd, ...rewardCollection];
    }
    return rewardCollection;
  }

  protected convertDateFromClient<T extends IReward | NewReward | PartialUpdateReward>(reward: T): RestOf<T> {
    return {
      ...reward,
      timestamp: reward.timestamp?.toJSON() ?? null,
    };
  }

  protected convertDateFromServer(restReward: RestReward): IReward {
    return {
      ...restReward,
      timestamp: restReward.timestamp ? dayjs(restReward.timestamp) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestReward>): HttpResponse<IReward> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestReward[]>): HttpResponse<IReward[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}
