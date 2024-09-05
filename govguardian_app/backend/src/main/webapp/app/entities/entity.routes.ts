import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'app-user',
    data: { pageTitle: 'govGuardianApp.appUser.home.title' },
    loadChildren: () => import('./app-user/app-user.routes'),
  },
  {
    path: 'review',
    data: { pageTitle: 'govGuardianApp.review.home.title' },
    loadChildren: () => import('./review/review.routes'),
  },
  {
    path: 'reward',
    data: { pageTitle: 'govGuardianApp.reward.home.title' },
    loadChildren: () => import('./reward/reward.routes'),
  },
  {
    path: 'report-header',
    data: { pageTitle: 'govGuardianApp.reportHeader.home.title' },
    loadChildren: () => import('./report-header/report-header.routes'),
  },
  {
    path: 'report-details',
    data: { pageTitle: 'govGuardianApp.reportDetails.home.title' },
    loadChildren: () => import('./report-details/report-details.routes'),
  },
  {
    path: 'gov-official-content',
    data: { pageTitle: 'govGuardianApp.govOfficialContent.home.title' },
    loadChildren: () => import('./gov-official-content/gov-official-content.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
