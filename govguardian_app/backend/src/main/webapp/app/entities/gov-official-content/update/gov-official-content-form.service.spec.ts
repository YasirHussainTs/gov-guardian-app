import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../gov-official-content.test-samples';

import { GovOfficialContentFormService } from './gov-official-content-form.service';

describe('GovOfficialContent Form Service', () => {
  let service: GovOfficialContentFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GovOfficialContentFormService);
  });

  describe('Service methods', () => {
    describe('createGovOfficialContentFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createGovOfficialContentFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            law: expect.any(Object),
            description: expect.any(Object),
            action: expect.any(Object),
            date: expect.any(Object),
          }),
        );
      });

      it('passing IGovOfficialContent should create a new form with FormGroup', () => {
        const formGroup = service.createGovOfficialContentFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            law: expect.any(Object),
            description: expect.any(Object),
            action: expect.any(Object),
            date: expect.any(Object),
          }),
        );
      });
    });

    describe('getGovOfficialContent', () => {
      it('should return NewGovOfficialContent for default GovOfficialContent initial value', () => {
        const formGroup = service.createGovOfficialContentFormGroup(sampleWithNewData);

        const govOfficialContent = service.getGovOfficialContent(formGroup) as any;

        expect(govOfficialContent).toMatchObject(sampleWithNewData);
      });

      it('should return NewGovOfficialContent for empty GovOfficialContent initial value', () => {
        const formGroup = service.createGovOfficialContentFormGroup();

        const govOfficialContent = service.getGovOfficialContent(formGroup) as any;

        expect(govOfficialContent).toMatchObject({});
      });

      it('should return IGovOfficialContent', () => {
        const formGroup = service.createGovOfficialContentFormGroup(sampleWithRequiredData);

        const govOfficialContent = service.getGovOfficialContent(formGroup) as any;

        expect(govOfficialContent).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IGovOfficialContent should not enable id FormControl', () => {
        const formGroup = service.createGovOfficialContentFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewGovOfficialContent should disable id FormControl', () => {
        const formGroup = service.createGovOfficialContentFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
