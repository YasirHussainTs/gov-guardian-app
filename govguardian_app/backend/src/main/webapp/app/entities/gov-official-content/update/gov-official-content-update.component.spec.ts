import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { GovOfficialContentService } from '../service/gov-official-content.service';
import { IGovOfficialContent } from '../gov-official-content.model';
import { GovOfficialContentFormService } from './gov-official-content-form.service';

import { GovOfficialContentUpdateComponent } from './gov-official-content-update.component';

describe('GovOfficialContent Management Update Component', () => {
  let comp: GovOfficialContentUpdateComponent;
  let fixture: ComponentFixture<GovOfficialContentUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let govOfficialContentFormService: GovOfficialContentFormService;
  let govOfficialContentService: GovOfficialContentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), GovOfficialContentUpdateComponent],
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
      .overrideTemplate(GovOfficialContentUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(GovOfficialContentUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    govOfficialContentFormService = TestBed.inject(GovOfficialContentFormService);
    govOfficialContentService = TestBed.inject(GovOfficialContentService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const govOfficialContent: IGovOfficialContent = { id: 456 };

      activatedRoute.data = of({ govOfficialContent });
      comp.ngOnInit();

      expect(comp.govOfficialContent).toEqual(govOfficialContent);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IGovOfficialContent>>();
      const govOfficialContent = { id: 123 };
      jest.spyOn(govOfficialContentFormService, 'getGovOfficialContent').mockReturnValue(govOfficialContent);
      jest.spyOn(govOfficialContentService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ govOfficialContent });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: govOfficialContent }));
      saveSubject.complete();

      // THEN
      expect(govOfficialContentFormService.getGovOfficialContent).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(govOfficialContentService.update).toHaveBeenCalledWith(expect.objectContaining(govOfficialContent));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IGovOfficialContent>>();
      const govOfficialContent = { id: 123 };
      jest.spyOn(govOfficialContentFormService, 'getGovOfficialContent').mockReturnValue({ id: null });
      jest.spyOn(govOfficialContentService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ govOfficialContent: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: govOfficialContent }));
      saveSubject.complete();

      // THEN
      expect(govOfficialContentFormService.getGovOfficialContent).toHaveBeenCalled();
      expect(govOfficialContentService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IGovOfficialContent>>();
      const govOfficialContent = { id: 123 };
      jest.spyOn(govOfficialContentService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ govOfficialContent });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(govOfficialContentService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});
