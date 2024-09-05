import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IReportDetails } from '../report-details.model';
import { ReportDetailsService } from '../service/report-details.service';

export const reportDetailsResolve = (route: ActivatedRouteSnapshot): Observable<null | IReportDetails> => {
  const id = route.params['id'];
  if (id) {
    return inject(ReportDetailsService)
      .find(id)
      .pipe(
        mergeMap((reportDetails: HttpResponse<IReportDetails>) => {
          if (reportDetails.body) {
            return of(reportDetails.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default reportDetailsResolve;
