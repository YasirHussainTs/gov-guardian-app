import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IReview, NewReview } from '../review.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IReview for edit and NewReviewFormGroupInput for create.
 */
type ReviewFormGroupInput = IReview | PartialWithRequiredKeyOf<NewReview>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IReview | NewReview> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

type ReviewFormRawValue = FormValueOf<IReview>;

type NewReviewFormRawValue = FormValueOf<NewReview>;

type ReviewFormDefaults = Pick<NewReview, 'id' | 'timestamp'>;

type ReviewFormGroupContent = {
  id: FormControl<ReviewFormRawValue['id'] | NewReview['id']>;
  content: FormControl<ReviewFormRawValue['content']>;
  rating: FormControl<ReviewFormRawValue['rating']>;
  feedback: FormControl<ReviewFormRawValue['feedback']>;
  timestamp: FormControl<ReviewFormRawValue['timestamp']>;
};

export type ReviewFormGroup = FormGroup<ReviewFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ReviewFormService {
  createReviewFormGroup(review: ReviewFormGroupInput = { id: null }): ReviewFormGroup {
    const reviewRawValue = this.convertReviewToReviewRawValue({
      ...this.getFormDefaults(),
      ...review,
    });
    return new FormGroup<ReviewFormGroupContent>({
      id: new FormControl(
        { value: reviewRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      content: new FormControl(reviewRawValue.content),
      rating: new FormControl(reviewRawValue.rating),
      feedback: new FormControl(reviewRawValue.feedback),
      timestamp: new FormControl(reviewRawValue.timestamp),
    });
  }

  getReview(form: ReviewFormGroup): IReview | NewReview {
    return this.convertReviewRawValueToReview(form.getRawValue() as ReviewFormRawValue | NewReviewFormRawValue);
  }

  resetForm(form: ReviewFormGroup, review: ReviewFormGroupInput): void {
    const reviewRawValue = this.convertReviewToReviewRawValue({ ...this.getFormDefaults(), ...review });
    form.reset(
      {
        ...reviewRawValue,
        id: { value: reviewRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): ReviewFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      timestamp: currentTime,
    };
  }

  private convertReviewRawValueToReview(rawReview: ReviewFormRawValue | NewReviewFormRawValue): IReview | NewReview {
    return {
      ...rawReview,
      timestamp: dayjs(rawReview.timestamp, DATE_TIME_FORMAT),
    };
  }

  private convertReviewToReviewRawValue(
    review: IReview | (Partial<NewReview> & ReviewFormDefaults),
  ): ReviewFormRawValue | PartialWithRequiredKeyOf<NewReviewFormRawValue> {
    return {
      ...review,
      timestamp: review.timestamp ? review.timestamp.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
