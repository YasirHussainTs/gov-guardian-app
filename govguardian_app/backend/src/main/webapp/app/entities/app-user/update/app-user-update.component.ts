import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IReview } from 'app/entities/review/review.model';
import { ReviewService } from 'app/entities/review/service/review.service';
import { IReward } from 'app/entities/reward/reward.model';
import { RewardService } from 'app/entities/reward/service/reward.service';
import { IGovOfficialContent } from 'app/entities/gov-official-content/gov-official-content.model';
import { GovOfficialContentService } from 'app/entities/gov-official-content/service/gov-official-content.service';
import { UserType } from 'app/entities/enumerations/user-type.model';
import { AppUserService } from '../service/app-user.service';
import { IAppUser } from '../app-user.model';
import { AppUserFormService, AppUserFormGroup } from './app-user-form.service';

@Component({
  standalone: true,
  selector: 'jhi-app-user-update',
  templateUrl: './app-user-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class AppUserUpdateComponent implements OnInit {
  isSaving = false;
  appUser: IAppUser | null = null;
  userTypeValues = Object.keys(UserType);

  usersSharedCollection: IUser[] = [];
  reviewsSharedCollection: IReview[] = [];
  rewardsSharedCollection: IReward[] = [];
  govOfficialContentsSharedCollection: IGovOfficialContent[] = [];

  editForm: AppUserFormGroup = this.appUserFormService.createAppUserFormGroup();

  constructor(
    protected appUserService: AppUserService,
    protected appUserFormService: AppUserFormService,
    protected userService: UserService,
    protected reviewService: ReviewService,
    protected rewardService: RewardService,
    protected govOfficialContentService: GovOfficialContentService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  compareUser = (o1: IUser | null, o2: IUser | null): boolean => this.userService.compareUser(o1, o2);

  compareReview = (o1: IReview | null, o2: IReview | null): boolean => this.reviewService.compareReview(o1, o2);

  compareReward = (o1: IReward | null, o2: IReward | null): boolean => this.rewardService.compareReward(o1, o2);

  compareGovOfficialContent = (o1: IGovOfficialContent | null, o2: IGovOfficialContent | null): boolean =>
    this.govOfficialContentService.compareGovOfficialContent(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ appUser }) => {
      this.appUser = appUser;
      if (appUser) {
        this.updateForm(appUser);
      }

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const appUser = this.appUserFormService.getAppUser(this.editForm);
    if (appUser.id !== null) {
      this.subscribeToSaveResponse(this.appUserService.update(appUser));
    } else {
      this.subscribeToSaveResponse(this.appUserService.create(appUser));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAppUser>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(appUser: IAppUser): void {
    this.appUser = appUser;
    this.appUserFormService.resetForm(this.editForm, appUser);

    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing<IUser>(this.usersSharedCollection, appUser.user);
    this.reviewsSharedCollection = this.reviewService.addReviewToCollectionIfMissing<IReview>(
      this.reviewsSharedCollection,
      appUser.reviews,
    );
    this.rewardsSharedCollection = this.rewardService.addRewardToCollectionIfMissing<IReward>(
      this.rewardsSharedCollection,
      appUser.rewards,
    );
    this.govOfficialContentsSharedCollection =
      this.govOfficialContentService.addGovOfficialContentToCollectionIfMissing<IGovOfficialContent>(
        this.govOfficialContentsSharedCollection,
        appUser.govOfficialContent,
      );
  }

  protected loadRelationshipsOptions(): void {
    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(map((users: IUser[]) => this.userService.addUserToCollectionIfMissing<IUser>(users, this.appUser?.user)))
      .subscribe((users: IUser[]) => (this.usersSharedCollection = users));

    this.reviewService
      .query()
      .pipe(map((res: HttpResponse<IReview[]>) => res.body ?? []))
      .pipe(map((reviews: IReview[]) => this.reviewService.addReviewToCollectionIfMissing<IReview>(reviews, this.appUser?.reviews)))
      .subscribe((reviews: IReview[]) => (this.reviewsSharedCollection = reviews));

    this.rewardService
      .query()
      .pipe(map((res: HttpResponse<IReward[]>) => res.body ?? []))
      .pipe(map((rewards: IReward[]) => this.rewardService.addRewardToCollectionIfMissing<IReward>(rewards, this.appUser?.rewards)))
      .subscribe((rewards: IReward[]) => (this.rewardsSharedCollection = rewards));

    this.govOfficialContentService
      .query()
      .pipe(map((res: HttpResponse<IGovOfficialContent[]>) => res.body ?? []))
      .pipe(
        map((govOfficialContents: IGovOfficialContent[]) =>
          this.govOfficialContentService.addGovOfficialContentToCollectionIfMissing<IGovOfficialContent>(
            govOfficialContents,
            this.appUser?.govOfficialContent,
          ),
        ),
      )
      .subscribe((govOfficialContents: IGovOfficialContent[]) => (this.govOfficialContentsSharedCollection = govOfficialContents));
  }
}
