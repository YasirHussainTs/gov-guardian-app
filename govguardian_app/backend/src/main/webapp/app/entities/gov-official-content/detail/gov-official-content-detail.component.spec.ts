import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { GovOfficialContentDetailComponent } from './gov-official-content-detail.component';

describe('GovOfficialContent Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GovOfficialContentDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: GovOfficialContentDetailComponent,
              resolve: { govOfficialContent: () => of({ id: 123 }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(GovOfficialContentDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load govOfficialContent on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', GovOfficialContentDetailComponent);

      // THEN
      expect(instance.govOfficialContent).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
