import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { IAppUser } from 'app/entities/app-user/app-user.model';
import { AppUserService } from 'app/entities/app-user/service/app-user.service';
import { ReportHeaderService } from '../service/report-header.service';
import { IReportHeader } from '../report-header.model';
import { ReportHeaderFormService } from './report-header-form.service';

import { ReportHeaderUpdateComponent } from './report-header-update.component';

describe('ReportHeader Management Update Component', () => {
  let comp: ReportHeaderUpdateComponent;
  let fixture: ComponentFixture<ReportHeaderUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let reportHeaderFormService: ReportHeaderFormService;
  let reportHeaderService: ReportHeaderService;
  let appUserService: AppUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), ReportHeaderUpdateComponent],
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
      .overrideTemplate(ReportHeaderUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(ReportHeaderUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    reportHeaderFormService = TestBed.inject(ReportHeaderFormService);
    reportHeaderService = TestBed.inject(ReportHeaderService);
    appUserService = TestBed.inject(AppUserService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call AppUser query and add missing value', () => {
      const reportHeader: IReportHeader = { id: 'CBA' };
      const appUser: IAppUser = { id: 10145 };
      reportHeader.appUser = appUser;

      const appUserCollection: IAppUser[] = [{ id: 17893 }];
      jest.spyOn(appUserService, 'query').mockReturnValue(of(new HttpResponse({ body: appUserCollection })));
      const additionalAppUsers = [appUser];
      const expectedCollection: IAppUser[] = [...additionalAppUsers, ...appUserCollection];
      jest.spyOn(appUserService, 'addAppUserToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ reportHeader });
      comp.ngOnInit();

      expect(appUserService.query).toHaveBeenCalled();
      expect(appUserService.addAppUserToCollectionIfMissing).toHaveBeenCalledWith(
        appUserCollection,
        ...additionalAppUsers.map(expect.objectContaining),
      );
      expect(comp.appUsersSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const reportHeader: IReportHeader = { id: 'CBA' };
      const appUser: IAppUser = { id: 5426 };
      reportHeader.appUser = appUser;

      activatedRoute.data = of({ reportHeader });
      comp.ngOnInit();

      expect(comp.appUsersSharedCollection).toContain(appUser);
      expect(comp.reportHeader).toEqual(reportHeader);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportHeader>>();
      const reportHeader = { id: 'ABC' };
      jest.spyOn(reportHeaderFormService, 'getReportHeader').mockReturnValue(reportHeader);
      jest.spyOn(reportHeaderService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportHeader });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: reportHeader }));
      saveSubject.complete();

      // THEN
      expect(reportHeaderFormService.getReportHeader).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(reportHeaderService.update).toHaveBeenCalledWith(expect.objectContaining(reportHeader));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportHeader>>();
      const reportHeader = { id: 'ABC' };
      jest.spyOn(reportHeaderFormService, 'getReportHeader').mockReturnValue({ id: null });
      jest.spyOn(reportHeaderService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportHeader: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: reportHeader }));
      saveSubject.complete();

      // THEN
      expect(reportHeaderFormService.getReportHeader).toHaveBeenCalled();
      expect(reportHeaderService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IReportHeader>>();
      const reportHeader = { id: 'ABC' };
      jest.spyOn(reportHeaderService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ reportHeader });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(reportHeaderService.update).toHaveBeenCalled();
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
