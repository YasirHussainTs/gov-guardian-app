import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

import dayjs from 'dayjs/esm';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IReportHeader, NewReportHeader } from '../report-header.model';

export type PartialUpdateReportHeader = Partial<IReportHeader> & Pick<IReportHeader, 'id'>;

type RestOf<T extends IReportHeader | NewReportHeader> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

export type RestReportHeader = RestOf<IReportHeader>;

export type NewRestReportHeader = RestOf<NewReportHeader>;

export type PartialUpdateRestReportHeader = RestOf<PartialUpdateReportHeader>;

export type EntityResponseType = HttpResponse<IReportHeader>;
export type EntityArrayResponseType = HttpResponse<IReportHeader[]>;

@Injectable({ providedIn: 'root' })
export class ReportHeaderService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/report-headers');

  constructor(
    protected http: HttpClient,
    protected applicationConfigService: ApplicationConfigService,
  ) {}

  create(reportHeader: NewReportHeader): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportHeader);
    return this.http
      .post<RestReportHeader>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  update(reportHeader: IReportHeader): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportHeader);
    return this.http
      .put<RestReportHeader>(`${this.resourceUrl}/${this.getReportHeaderIdentifier(reportHeader)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  partialUpdate(reportHeader: PartialUpdateReportHeader): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(reportHeader);
    return this.http
      .patch<RestReportHeader>(`${this.resourceUrl}/${this.getReportHeaderIdentifier(reportHeader)}`, copy, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  find(id: string): Observable<EntityResponseType> {
    return this.http
      .get<RestReportHeader>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map(res => this.convertResponseFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<RestReportHeader[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map(res => this.convertResponseArrayFromServer(res)));
  }

  delete(id: string): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getReportHeaderIdentifier(reportHeader: Pick<IReportHeader, 'id'>): string {
    return reportHeader.id;
  }

  compareReportHeader(o1: Pick<IReportHeader, 'id'> | null, o2: Pick<IReportHeader, 'id'> | null): boolean {
    return o1 && o2 ? this.getReportHeaderIdentifier(o1) === this.getReportHeaderIdentifier(o2) : o1 === o2;
  }

  addReportHeaderToCollectionIfMissing<Type extends Pick<IReportHeader, 'id'>>(
    reportHeaderCollection: Type[],
    ...reportHeadersToCheck: (Type | null | undefined)[]
  ): Type[] {
    const reportHeaders: Type[] = reportHeadersToCheck.filter(isPresent);
    if (reportHeaders.length > 0) {
      const reportHeaderCollectionIdentifiers = reportHeaderCollection.map(
        reportHeaderItem => this.getReportHeaderIdentifier(reportHeaderItem)!,
      );
      const reportHeadersToAdd = reportHeaders.filter(reportHeaderItem => {
        const reportHeaderIdentifier = this.getReportHeaderIdentifier(reportHeaderItem);
        if (reportHeaderCollectionIdentifiers.includes(reportHeaderIdentifier)) {
          return false;
        }
        reportHeaderCollectionIdentifiers.push(reportHeaderIdentifier);
        return true;
      });
      return [...reportHeadersToAdd, ...reportHeaderCollection];
    }
    return reportHeaderCollection;
  }

  protected convertDateFromClient<T extends IReportHeader | NewReportHeader | PartialUpdateReportHeader>(reportHeader: T): RestOf<T> {
    return {
      ...reportHeader,
      timestamp: reportHeader.timestamp?.toJSON() ?? null,
    };
  }

  protected convertDateFromServer(restReportHeader: RestReportHeader): IReportHeader {
    return {
      ...restReportHeader,
      timestamp: restReportHeader.timestamp ? dayjs(restReportHeader.timestamp) : undefined,
    };
  }

  protected convertResponseFromServer(res: HttpResponse<RestReportHeader>): HttpResponse<IReportHeader> {
    return res.clone({
      body: res.body ? this.convertDateFromServer(res.body) : null,
    });
  }

  protected convertResponseArrayFromServer(res: HttpResponse<RestReportHeader[]>): HttpResponse<IReportHeader[]> {
    return res.clone({
      body: res.body ? res.body.map(item => this.convertDateFromServer(item)) : null,
    });
  }
}
