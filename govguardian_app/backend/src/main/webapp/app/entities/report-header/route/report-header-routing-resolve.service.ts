import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IReportHeader } from '../report-header.model';
import { ReportHeaderService } from '../service/report-header.service';

export const reportHeaderResolve = (route: ActivatedRouteSnapshot): Observable<null | IReportHeader> => {
  const id = route.params['id'];
  if (id) {
    return inject(ReportHeaderService)
      .find(id)
      .pipe(
        mergeMap((reportHeader: HttpResponse<IReportHeader>) => {
          if (reportHeader.body) {
            return of(reportHeader.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default reportHeaderResolve;
