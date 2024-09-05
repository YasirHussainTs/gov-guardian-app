import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IGovOfficialContent } from '../gov-official-content.model';
import { GovOfficialContentService } from '../service/gov-official-content.service';

export const govOfficialContentResolve = (route: ActivatedRouteSnapshot): Observable<null | IGovOfficialContent> => {
  const id = route.params['id'];
  if (id) {
    return inject(GovOfficialContentService)
      .find(id)
      .pipe(
        mergeMap((govOfficialContent: HttpResponse<IGovOfficialContent>) => {
          if (govOfficialContent.body) {
            return of(govOfficialContent.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default govOfficialContentResolve;
