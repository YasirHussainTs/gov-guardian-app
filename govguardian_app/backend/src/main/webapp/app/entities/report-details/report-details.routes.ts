import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { ReportDetailsComponent } from './list/report-details.component';
import { ReportDetailsDetailComponent } from './detail/report-details-detail.component';
import { ReportDetailsUpdateComponent } from './update/report-details-update.component';
import ReportDetailsResolve from './route/report-details-routing-resolve.service';

const reportDetailsRoute: Routes = [
  {
    path: '',
    component: ReportDetailsComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ReportDetailsDetailComponent,
    resolve: {
      reportDetails: ReportDetailsResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ReportDetailsUpdateComponent,
    resolve: {
      reportDetails: ReportDetailsResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ReportDetailsUpdateComponent,
    resolve: {
      reportDetails: ReportDetailsResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default reportDetailsRoute;
