import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../report-details.test-samples';

import { ReportDetailsFormService } from './report-details-form.service';

describe('ReportDetails Form Service', () => {
  let service: ReportDetailsFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportDetailsFormService);
  });

  describe('Service methods', () => {
    describe('createReportDetailsFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createReportDetailsFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            owner: expect.any(Object),
            responder: expect.any(Object),
            description: expect.any(Object),
            title: expect.any(Object),
            timestamp: expect.any(Object),
            status: expect.any(Object),
            image: expect.any(Object),
            video: expect.any(Object),
            voiceData: expect.any(Object),
            file1: expect.any(Object),
            file2: expect.any(Object),
            file3: expect.any(Object),
            appUser: expect.any(Object),
          }),
        );
      });

      it('passing IReportDetails should create a new form with FormGroup', () => {
        const formGroup = service.createReportDetailsFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            owner: expect.any(Object),
            responder: expect.any(Object),
            description: expect.any(Object),
            title: expect.any(Object),
            timestamp: expect.any(Object),
            status: expect.any(Object),
            image: expect.any(Object),
            video: expect.any(Object),
            voiceData: expect.any(Object),
            file1: expect.any(Object),
            file2: expect.any(Object),
            file3: expect.any(Object),
            appUser: expect.any(Object),
          }),
        );
      });
    });

    describe('getReportDetails', () => {
      it('should return NewReportDetails for default ReportDetails initial value', () => {
        const formGroup = service.createReportDetailsFormGroup(sampleWithNewData);

        const reportDetails = service.getReportDetails(formGroup) as any;

        expect(reportDetails).toMatchObject(sampleWithNewData);
      });

      it('should return NewReportDetails for empty ReportDetails initial value', () => {
        const formGroup = service.createReportDetailsFormGroup();

        const reportDetails = service.getReportDetails(formGroup) as any;

        expect(reportDetails).toMatchObject({});
      });

      it('should return IReportDetails', () => {
        const formGroup = service.createReportDetailsFormGroup(sampleWithRequiredData);

        const reportDetails = service.getReportDetails(formGroup) as any;

        expect(reportDetails).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IReportDetails should not enable id FormControl', () => {
        const formGroup = service.createReportDetailsFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewReportDetails should disable id FormControl', () => {
        const formGroup = service.createReportDetailsFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
