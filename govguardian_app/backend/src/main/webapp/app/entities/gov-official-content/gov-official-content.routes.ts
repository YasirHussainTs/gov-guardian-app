import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { GovOfficialContentComponent } from './list/gov-official-content.component';
import { GovOfficialContentDetailComponent } from './detail/gov-official-content-detail.component';
import { GovOfficialContentUpdateComponent } from './update/gov-official-content-update.component';
import GovOfficialContentResolve from './route/gov-official-content-routing-resolve.service';

const govOfficialContentRoute: Routes = [
  {
    path: '',
    component: GovOfficialContentComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: GovOfficialContentDetailComponent,
    resolve: {
      govOfficialContent: GovOfficialContentResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: GovOfficialContentUpdateComponent,
    resolve: {
      govOfficialContent: GovOfficialContentResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: GovOfficialContentUpdateComponent,
    resolve: {
      govOfficialContent: GovOfficialContentResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default govOfficialContentRoute;
