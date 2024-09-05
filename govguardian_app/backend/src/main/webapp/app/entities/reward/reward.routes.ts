import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { RewardComponent } from './list/reward.component';
import { RewardDetailComponent } from './detail/reward-detail.component';
import { RewardUpdateComponent } from './update/reward-update.component';
import RewardResolve from './route/reward-routing-resolve.service';

const rewardRoute: Routes = [
  {
    path: '',
    component: RewardComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: RewardDetailComponent,
    resolve: {
      reward: RewardResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: RewardUpdateComponent,
    resolve: {
      reward: RewardResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: RewardUpdateComponent,
    resolve: {
      reward: RewardResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default rewardRoute;
