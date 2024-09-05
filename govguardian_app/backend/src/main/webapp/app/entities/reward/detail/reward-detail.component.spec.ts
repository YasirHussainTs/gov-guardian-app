import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { RewardDetailComponent } from './reward-detail.component';

describe('Reward Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RewardDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: RewardDetailComponent,
              resolve: { reward: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(RewardDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load reward on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', RewardDetailComponent);

      // THEN
      expect(instance.reward).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
