import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IReview } from 'app/entities/review/review.model';
import { ReviewService } from 'app/entities/review/service/review.service';
import { IReward } from 'app/entities/reward/reward.model';
import { RewardService } from 'app/entities/reward/service/reward.service';
import { IGovOfficialContent } from 'app/entities/gov-official-content/gov-official-content.model';
import { GovOfficialContentService } from 'app/entities/gov-official-content/service/gov-official-content.service';
import { IAppUser } from '../app-user.model';
import { AppUserService } from '../service/app-user.service';
import { AppUserFormService } from './app-user-form.service';

import { AppUserUpdateComponent } from './app-user-update.component';

describe('AppUser Management Update Component', () => {
  let comp: AppUserUpdateComponent;
  let fixture: ComponentFixture<AppUserUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let appUserFormService: AppUserFormService;
  let appUserService: AppUserService;
  let userService: UserService;
  let reviewService: ReviewService;
  let rewardService: RewardService;
  let govOfficialContentService: GovOfficialContentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([]), AppUserUpdateComponent],
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
      .overrideTemplate(AppUserUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(AppUserUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    appUserFormService = TestBed.inject(AppUserFormService);
    appUserService = TestBed.inject(AppUserService);
    userService = TestBed.inject(UserService);
    reviewService = TestBed.inject(ReviewService);
    rewardService = TestBed.inject(RewardService);
    govOfficialContentService = TestBed.inject(GovOfficialContentService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call User query and add missing value', () => {
      const appUser: IAppUser = { id: 456 };
      const user: IUser = { id: 6214 };
      appUser.user = user;

      const userCollection: IUser[] = [{ id: 19802 }];
      jest.spyOn(userService, 'query').mockReturnValue(of(new HttpResponse({ body: userCollection })));
      const additionalUsers = [user];
      const expectedCollection: IUser[] = [...additionalUsers, ...userCollection];
      jest.spyOn(userService, 'addUserToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      expect(userService.query).toHaveBeenCalled();
      expect(userService.addUserToCollectionIfMissing).toHaveBeenCalledWith(
        userCollection,
        ...additionalUsers.map(expect.objectContaining),
      );
      expect(comp.usersSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Review query and add missing value', () => {
      const appUser: IAppUser = { id: 456 };
      const reviews: IReview = { id: 234 };
      appUser.reviews = reviews;

      const reviewCollection: IReview[] = [{ id: 7624 }];
      jest.spyOn(reviewService, 'query').mockReturnValue(of(new HttpResponse({ body: reviewCollection })));
      const additionalReviews = [reviews];
      const expectedCollection: IReview[] = [...additionalReviews, ...reviewCollection];
      jest.spyOn(reviewService, 'addReviewToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      expect(reviewService.query).toHaveBeenCalled();
      expect(reviewService.addReviewToCollectionIfMissing).toHaveBeenCalledWith(
        reviewCollection,
        ...additionalReviews.map(expect.objectContaining),
      );
      expect(comp.reviewsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Reward query and add missing value', () => {
      const appUser: IAppUser = { id: 456 };
      const rewards: IReward = { id: 3951 };
      appUser.rewards = rewards;

      const rewardCollection: IReward[] = [{ id: 8353 }];
      jest.spyOn(rewardService, 'query').mockReturnValue(of(new HttpResponse({ body: rewardCollection })));
      const additionalRewards = [rewards];
      const expectedCollection: IReward[] = [...additionalRewards, ...rewardCollection];
      jest.spyOn(rewardService, 'addRewardToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      expect(rewardService.query).toHaveBeenCalled();
      expect(rewardService.addRewardToCollectionIfMissing).toHaveBeenCalledWith(
        rewardCollection,
        ...additionalRewards.map(expect.objectContaining),
      );
      expect(comp.rewardsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call GovOfficialContent query and add missing value', () => {
      const appUser: IAppUser = { id: 456 };
      const govOfficialContent: IGovOfficialContent = { id: 30488 };
      appUser.govOfficialContent = govOfficialContent;

      const govOfficialContentCollection: IGovOfficialContent[] = [{ id: 30629 }];
      jest.spyOn(govOfficialContentService, 'query').mockReturnValue(of(new HttpResponse({ body: govOfficialContentCollection })));
      const additionalGovOfficialContents = [govOfficialContent];
      const expectedCollection: IGovOfficialContent[] = [...additionalGovOfficialContents, ...govOfficialContentCollection];
      jest.spyOn(govOfficialContentService, 'addGovOfficialContentToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      expect(govOfficialContentService.query).toHaveBeenCalled();
      expect(govOfficialContentService.addGovOfficialContentToCollectionIfMissing).toHaveBeenCalledWith(
        govOfficialContentCollection,
        ...additionalGovOfficialContents.map(expect.objectContaining),
      );
      expect(comp.govOfficialContentsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const appUser: IAppUser = { id: 456 };
      const user: IUser = { id: 30390 };
      appUser.user = user;
      const reviews: IReview = { id: 9928 };
      appUser.reviews = reviews;
      const rewards: IReward = { id: 23561 };
      appUser.rewards = rewards;
      const govOfficialContent: IGovOfficialContent = { id: 19783 };
      appUser.govOfficialContent = govOfficialContent;

      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      expect(comp.usersSharedCollection).toContain(user);
      expect(comp.reviewsSharedCollection).toContain(reviews);
      expect(comp.rewardsSharedCollection).toContain(rewards);
      expect(comp.govOfficialContentsSharedCollection).toContain(govOfficialContent);
      expect(comp.appUser).toEqual(appUser);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAppUser>>();
      const appUser = { id: 123 };
      jest.spyOn(appUserFormService, 'getAppUser').mockReturnValue(appUser);
      jest.spyOn(appUserService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: appUser }));
      saveSubject.complete();

      // THEN
      expect(appUserFormService.getAppUser).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(appUserService.update).toHaveBeenCalledWith(expect.objectContaining(appUser));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAppUser>>();
      const appUser = { id: 123 };
      jest.spyOn(appUserFormService, 'getAppUser').mockReturnValue({ id: null });
      jest.spyOn(appUserService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ appUser: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: appUser }));
      saveSubject.complete();

      // THEN
      expect(appUserFormService.getAppUser).toHaveBeenCalled();
      expect(appUserService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAppUser>>();
      const appUser = { id: 123 };
      jest.spyOn(appUserService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ appUser });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(appUserService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareUser', () => {
      it('Should forward to userService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(userService, 'compareUser');
        comp.compareUser(entity, entity2);
        expect(userService.compareUser).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareReview', () => {
      it('Should forward to reviewService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(reviewService, 'compareReview');
        comp.compareReview(entity, entity2);
        expect(reviewService.compareReview).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareReward', () => {
      it('Should forward to rewardService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(rewardService, 'compareReward');
        comp.compareReward(entity, entity2);
        expect(rewardService.compareReward).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareGovOfficialContent', () => {
      it('Should forward to govOfficialContentService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(govOfficialContentService, 'compareGovOfficialContent');
        comp.compareGovOfficialContent(entity, entity2);
        expect(govOfficialContentService.compareGovOfficialContent).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});
