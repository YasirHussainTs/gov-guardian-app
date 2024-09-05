import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IReward, NewReward } from '../reward.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IReward for edit and NewRewardFormGroupInput for create.
 */
type RewardFormGroupInput = IReward | PartialWithRequiredKeyOf<NewReward>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IReward | NewReward> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

type RewardFormRawValue = FormValueOf<IReward>;

type NewRewardFormRawValue = FormValueOf<NewReward>;

type RewardFormDefaults = Pick<NewReward, 'id' | 'timestamp'>;

type RewardFormGroupContent = {
  id: FormControl<RewardFormRawValue['id'] | NewReward['id']>;
  description: FormControl<RewardFormRawValue['description']>;
  points: FormControl<RewardFormRawValue['points']>;
  timestamp: FormControl<RewardFormRawValue['timestamp']>;
};

export type RewardFormGroup = FormGroup<RewardFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class RewardFormService {
  createRewardFormGroup(reward: RewardFormGroupInput = { id: null }): RewardFormGroup {
    const rewardRawValue = this.convertRewardToRewardRawValue({
      ...this.getFormDefaults(),
      ...reward,
    });
    return new FormGroup<RewardFormGroupContent>({
      id: new FormControl(
        { value: rewardRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      description: new FormControl(rewardRawValue.description),
      points: new FormControl(rewardRawValue.points),
      timestamp: new FormControl(rewardRawValue.timestamp),
    });
  }

  getReward(form: RewardFormGroup): IReward | NewReward {
    return this.convertRewardRawValueToReward(form.getRawValue() as RewardFormRawValue | NewRewardFormRawValue);
  }

  resetForm(form: RewardFormGroup, reward: RewardFormGroupInput): void {
    const rewardRawValue = this.convertRewardToRewardRawValue({ ...this.getFormDefaults(), ...reward });
    form.reset(
      {
        ...rewardRawValue,
        id: { value: rewardRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): RewardFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      timestamp: currentTime,
    };
  }

  private convertRewardRawValueToReward(rawReward: RewardFormRawValue | NewRewardFormRawValue): IReward | NewReward {
    return {
      ...rawReward,
      timestamp: dayjs(rawReward.timestamp, DATE_TIME_FORMAT),
    };
  }

  private convertRewardToRewardRawValue(
    reward: IReward | (Partial<NewReward> & RewardFormDefaults),
  ): RewardFormRawValue | PartialWithRequiredKeyOf<NewRewardFormRawValue> {
    return {
      ...reward,
      timestamp: reward.timestamp ? reward.timestamp.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
