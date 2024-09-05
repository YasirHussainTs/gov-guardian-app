import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IReportDetails, NewReportDetails } from '../report-details.model';

export type PartialUpdateReportDetails = Partial<IReportDetails> & Pick<IReportDetails, 'id'>;

type RestOf<T extends IReportDetails | NewReportDetails> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

export type RestReportDetails = RestOf<IReportDetails>;

export type NewRestReportDetails = RestOf<NewReportDetails>;

export type PartialUpdateRestReportDetails = RestOf<PartialUpdateReportDetails>;

export type EntityResponseType = HttpResponse<IReportDetails>;
export type EntityArrayResponseType = HttpResponse<IReportDetails[]>;

@Injectable({ providedIn: 'root' })
export class ReportDetailsService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/report-details');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(reportDetails: NewReportDetails): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportDetails);
    return this.http
      .post<RestReportDetails>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(reportDetails: IReportDetails): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportDetails);
    return this.http
      .put<RestReportDetails>(`${this.resourceUrl}/${this.getReportDetailsIdentifier(reportDetails)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(reportDetails: PartialUpdateReportDetails): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportDetails);
    return this.http
      .patch<RestReportDetails>(`${this.resourceUrl}/${this.getReportDetailsIdentifier(reportDetails)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<RestReportDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestReportDetails[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getReportDetailsIdentifier(reportDetails: Pick<IReportDetails, 'id'>): number {
    return reportDetails.id;
  }

  compareReportDetails(o1: Pick<IReportDetails, 'id'> | null, o2: Pick<IReportDetails, 'id'> | null): boolean {
    return o1 && o2 ? this.getReportDetailsIdentifier(o1) === this.getReportDetailsIdentifier(o2) : o1 === o2;
  }

  addReportDetailsToCollectionIfMissing<Type extends Pick<IReportDetails, 'id'>>(
    reportDetailsCollection: Type[],
    ...reportDetailsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const reportDetails: Type[] = reportDetailsToCheck.filter(isPresent);
    if (reportDetails.length > 0) {
      const reportDetailsCollectionIdentifiers = reportDetailsCollection.map(
        reportDetailsItem => this.getReportDetailsIdentifier(reportDetailsItem)!,
      );
      const reportDetailsToAdd = reportDetails.filter(reportDetailsItem => {
        const reportDetailsIdentifier = this.getReportDetailsIdentifier(reportDetailsItem);
        if (reportDetailsCollectionIdentifiers.includes(reportDetailsIdentifier)) {
          return false;
        }
        reportDetailsCollectionIdentifiers.push(reportDetailsIdentifier);
        return true;
      });
      return [...reportDetailsToAdd, ...reportDetailsCollection];
    }
    return reportDetailsCollection;
  }

  protected convertDateFromClient<T extends IReportDetails | NewReportDetails | PartialUpdateReportDetails>(reportDetails: T): RestOf<T> {
    return {
      ...reportDetails,
      timestamp: reportDetails.timestamp?.toJSON() ?? null,
    };
  }

  protected convertDateFromServer(restReportDetails: RestReportDetails): IReportDetails {
    return {
      ...restReportDetails,
      timestamp: restReportDetails.timestamp ? dayjs(restReportDetails.timestamp) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestReportDetails>): HttpResponse<IReportDetails> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestReportDetails[]>): HttpResponse<IReportDetails[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}
