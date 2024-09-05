import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IGovOfficialContent, NewGovOfficialContent } from '../gov-official-content.model';

export type PartialUpdateGovOfficialContent = Partial<IGovOfficialContent> & Pick<IGovOfficialContent, 'id'>;

type RestOf<T extends IGovOfficialContent | NewGovOfficialContent> = Omit<T, 'date'> & {
  date?: string | null;
};

export type RestGovOfficialContent = RestOf<IGovOfficialContent>;

export type NewRestGovOfficialContent = RestOf<NewGovOfficialContent>;

export type PartialUpdateRestGovOfficialContent = RestOf<PartialUpdateGovOfficialContent>;

export type EntityResponseType = HttpResponse<IGovOfficialContent>;
export type EntityArrayResponseType = HttpResponse<IGovOfficialContent[]>;

@Injectable({ providedIn: 'root' })
export class GovOfficialContentService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/gov-official-contents');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(govOfficialContent: NewGovOfficialContent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(govOfficialContent);
    return this.http
      .post<RestGovOfficialContent>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(govOfficialContent: IGovOfficialContent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(govOfficialContent);
    return this.http
      .put<RestGovOfficialContent>(`${this.resourceUrl}/${this.getGovOfficialContentIdentifier(govOfficialContent)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(govOfficialContent: PartialUpdateGovOfficialContent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(govOfficialContent);
    return this.http
      .patch<RestGovOfficialContent>(`${this.resourceUrl}/${this.getGovOfficialContentIdentifier(govOfficialContent)}`, copy, {
        observe: 'response',
      })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestGovOfficialContent>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestGovOfficialContent[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getGovOfficialContentIdentifier(govOfficialContent: Pick<IGovOfficialContent, 'id'>): number {
    return govOfficialContent.id;
  }

  compareGovOfficialContent(o1: Pick<IGovOfficialContent, 'id'> | null, o2: Pick<IGovOfficialContent, 'id'> | null): boolean {
    return o1 && o2 ? this.getGovOfficialContentIdentifier(o1) === this.getGovOfficialContentIdentifier(o2) : o1 === o2;
  }

  addGovOfficialContentToCollectionIfMissing<Type extends Pick<IGovOfficialContent, 'id'>>(
    govOfficialContentCollection: Type[],
    ...govOfficialContentsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const govOfficialContents: Type[] = govOfficialContentsToCheck.filter(isPresent);
    if (govOfficialContents.length > 0) {
      const govOfficialContentCollectionIdentifiers = govOfficialContentCollection.map(
        govOfficialContentItem => this.getGovOfficialContentIdentifier(govOfficialContentItem)!,
      );
      const govOfficialContentsToAdd = govOfficialContents.filter(govOfficialContentItem => {
        const govOfficialContentIdentifier = this.getGovOfficialContentIdentifier(govOfficialContentItem);
        if (govOfficialContentCollectionIdentifiers.includes(govOfficialContentIdentifier)) {
          return false;
        }
        govOfficialContentCollectionIdentifiers.push(govOfficialContentIdentifier);
        return true;
      });
      return [...govOfficialContentsToAdd, ...govOfficialContentCollection];
    }
    return govOfficialContentCollection;
  }

  protected convertDateFromClient<T extends IGovOfficialContent | NewGovOfficialContent | PartialUpdateGovOfficialContent>(
    govOfficialContent: T,
  ): RestOf<T> {
    return {
      ...govOfficialContent,
      date: govOfficialContent.date?.toJSON() ?? null,
    };
  }

  protected convertDateFromServer(restGovOfficialContent: RestGovOfficialContent): IGovOfficialContent {
    return {
      ...restGovOfficialContent,
      date: restGovOfficialContent.date ? dayjs(restGovOfficialContent.date) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestGovOfficialContent>): HttpResponse<IGovOfficialContent> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestGovOfficialContent[]>): HttpResponse<IGovOfficialContent[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}
