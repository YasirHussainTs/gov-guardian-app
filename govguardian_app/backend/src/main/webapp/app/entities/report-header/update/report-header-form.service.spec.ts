import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../report-header.test-samples';

import { ReportHeaderFormService } from './report-header-form.service';

describe('ReportHeader Form Service', () => {
  let service: ReportHeaderFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportHeaderFormService);
  });

  describe('Service methods', () => {
    describe('createReportHeaderFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createReportHeaderFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            description: expect.any(Object),
            title: expect.any(Object),
            timestamp: expect.any(Object),
            status: expect.any(Object),
            appUser: expect.any(Object),
          }),
        );
      });

      it('passing IReportHeader should create a new form with FormGroup', () => {
        const formGroup = service.createReportHeaderFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            description: expect.any(Object),
            title: expect.any(Object),
            timestamp: expect.any(Object),
            status: expect.any(Object),
            appUser: expect.any(Object),
          }),
        );
      });
    });

    describe('getReportHeader', () => {
      it('should return NewReportHeader for default ReportHeader initial value', () => {
        const formGroup = service.createReportHeaderFormGroup(sampleWithNewData);

        const reportHeader = service.getReportHeader(formGroup) as any;

        expect(reportHeader).toMatchObject(sampleWithNewData);
      });

      it('should return NewReportHeader for empty ReportHeader initial value', () => {
        const formGroup = service.createReportHeaderFormGroup();

        const reportHeader = service.getReportHeader(formGroup) as any;

        expect(reportHeader).toMatchObject({});
      });

      it('should return IReportHeader', () => {
        const formGroup = service.createReportHeaderFormGroup(sampleWithRequiredData);

        const reportHeader = service.getReportHeader(formGroup) as any;

        expect(reportHeader).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IReportHeader should not enable id FormControl', () => {
        const formGroup = service.createReportHeaderFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewReportHeader should disable id FormControl', () => {
        const formGroup = service.createReportHeaderFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
