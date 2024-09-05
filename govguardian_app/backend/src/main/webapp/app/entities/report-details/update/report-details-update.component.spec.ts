import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { IAppUser } from 'app/entities/app-user/app-user.model';
import { AppUserService } from 'app/entities/app-user/service/app-user.service';
import { ReportDetailsService } from '../service/report-details.service';
import { IReportDetails } from '../report-details.model';
import { ReportDetailsFormService } from './report-details-form.service';

import { ReportDetailsUpdateComponent } from './report-details-update.component';

describe('ReportDetails Management Update Component', () => {
  let comp: ReportDetailsUpdateComponent;
  let fixture: ComponentFixture<ReportDetailsUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let reportDetailsFormService: ReportDetailsFormService;
  let reportDetailsService: ReportDetailsService;
  let appUserService: AppUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), ReportDetailsUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(ReportDetailsUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(ReportDetailsUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    reportDetailsFormService = TestBed.inject(ReportDetailsFormService);
    reportDetailsService = TestBed.inject(ReportDetailsService);
    appUserService = TestBed.inject(AppUserService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call AppUser query and add missing value', () => {
      const reportDetails: IReportDetails = { id: 456 };
      const appUser: IAppUser = { id: 22506 };
      reportDetails.appUser = appUser;

      const appUserCollection: IAppUser[] = [{ id: 11283 }];
      jest.spyOn(appUserService, 'query').mockReturnValue(of(new HttpResponse({ body: appUserCollection })));
      const additionalAppUsers = [appUser];
      const expectedCollection: IAppUser[] = [...additionalAppUsers, ...appUserCollection];
      jest.spyOn(appUserService, 'addAppUserToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ reportDetails });
      comp.ngOnInit();

      expect(appUserService.query).toHaveBeenCalled();
      expect(appUserService.addAppUserToCollectionIfMissing).toHaveBeenCalledWith(
        appUserCollection,
        ...additionalAppUsers.map(expect.objectContaining),
      );
      expect(comp.appUsersSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const reportDetails: IReportDetails = { id: 456 };
      const appUser: IAppUser = { id: 1540 };
      reportDetails.appUser = appUser;

      activatedRoute.data = of({ reportDetails });
      comp.ngOnInit();

      expect(comp.appUsersSharedCollection).toContain(appUser);
      expect(comp.reportDetails).toEqual(reportDetails);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportDetails>>();
      const reportDetails = { id: 123 };
      jest.spyOn(reportDetailsFormService, 'getReportDetails').mockReturnValue(reportDetails);
      jest.spyOn(reportDetailsService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportDetails });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: reportDetails }));
      saveSubject.complete();

      // THEN
      expect(reportDetailsFormService.getReportDetails).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(reportDetailsService.update).toHaveBeenCalledWith(expect.objectContaining(reportDetails));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportDetails>>();
      const reportDetails = { id: 123 };
      jest.spyOn(reportDetailsFormService, 'getReportDetails').mockReturnValue({ id: null });
      jest.spyOn(reportDetailsService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportDetails: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: reportDetails }));
      saveSubject.complete();

      // THEN
      expect(reportDetailsFormService.getReportDetails).toHaveBeenCalled();
      expect(reportDetailsService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportDetails>>();
      const reportDetails = { id: 123 };
      jest.spyOn(reportDetailsService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportDetails });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(reportDetailsService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareAppUser', () => {
      it('Should forward to appUserService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(appUserService, 'compareAppUser');
        comp.compareAppUser(entity, entity2);
        expect(appUserService.compareAppUser).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});
