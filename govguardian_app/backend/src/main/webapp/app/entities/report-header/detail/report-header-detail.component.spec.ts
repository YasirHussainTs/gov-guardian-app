import { TestBed } from '@angular/core/testing';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { RouterTestingHarness, RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { ReportHeaderDetailComponent } from './report-header-detail.component';

describe('ReportHeader Management Detail Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReportHeaderDetailComponent, RouterTestingModule.withRoutes([], { bindToComponentInputs: true })],
      providers: [
        provideRouter(
          [
            {
              path: '**',
              component: ReportHeaderDetailComponent,
              resolve: { reportHeader: () => of({ id: 'ABC' }) },
            },
          ],
          withComponentInputBinding(),
        ),
      ],
    })
      .overrideTemplate(ReportHeaderDetailComponent, '')
      .compileComponents();
  });

  describe('OnInit', () => {
    it('Should load reportHeader on init', async () => {
      const harness = await RouterTestingHarness.create();
      const instance = await harness.navigateByUrl('/', ReportHeaderDetailComponent);

      // THEN
      expect(instance.reportHeader).toEqual(expect.objectContaining({ id: 'ABC' }));
    });
  });
});
