import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { ReportHeaderComponent } from './list/report-header.component';
import { ReportHeaderDetailComponent } from './detail/report-header-detail.component';
import { ReportHeaderUpdateComponent } from './update/report-header-update.component';
import ReportHeaderResolve from './route/report-header-routing-resolve.service';

const reportHeaderRoute: Routes = [
  {
    path: '',
    component: ReportHeaderComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ReportHeaderDetailComponent,
    resolve: {
      reportHeader: ReportHeaderResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ReportHeaderUpdateComponent,
    resolve: {
      reportHeader: ReportHeaderResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ReportHeaderUpdateComponent,
    resolve: {
      reportHeader: ReportHeaderResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default reportHeaderRoute;
