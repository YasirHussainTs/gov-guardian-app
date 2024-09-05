import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IGovOfficialContent, NewGovOfficialContent } from '../gov-official-content.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IGovOfficialContent for edit and NewGovOfficialContentFormGroupInput for create.
 */
type GovOfficialContentFormGroupInput = IGovOfficialContent | PartialWithRequiredKeyOf<NewGovOfficialContent>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IGovOfficialContent | NewGovOfficialContent> = Omit<T, 'date'> & {
  date?: string | null;
};

type GovOfficialContentFormRawValue = FormValueOf<IGovOfficialContent>;

type NewGovOfficialContentFormRawValue = FormValueOf<NewGovOfficialContent>;

type GovOfficialContentFormDefaults = Pick<NewGovOfficialContent, 'id' | 'date'>;

type GovOfficialContentFormGroupContent = {
  id: FormControl<GovOfficialContentFormRawValue['id'] | NewGovOfficialContent['id']>;
  law: FormControl<GovOfficialContentFormRawValue['law']>;
  description: FormControl<GovOfficialContentFormRawValue['description']>;
  action: FormControl<GovOfficialContentFormRawValue['action']>;
  date: FormControl<GovOfficialContentFormRawValue['date']>;
};

export type GovOfficialContentFormGroup = FormGroup<GovOfficialContentFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class GovOfficialContentFormService {
  createGovOfficialContentFormGroup(govOfficialContent: GovOfficialContentFormGroupInput = { id: null }): GovOfficialContentFormGroup {
    const govOfficialContentRawValue = this.convertGovOfficialContentToGovOfficialContentRawValue({
      ...this.getFormDefaults(),
      ...govOfficialContent,
    });
    return new FormGroup<GovOfficialContentFormGroupContent>({
      id: new FormControl(
        { value: govOfficialContentRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      law: new FormControl(govOfficialContentRawValue.law),
      description: new FormControl(govOfficialContentRawValue.description),
      action: new FormControl(govOfficialContentRawValue.action),
      date: new FormControl(govOfficialContentRawValue.date),
    });
  }

  getGovOfficialContent(form: GovOfficialContentFormGroup): IGovOfficialContent | NewGovOfficialContent {
    return this.convertGovOfficialContentRawValueToGovOfficialContent(
      form.getRawValue() as GovOfficialContentFormRawValue | NewGovOfficialContentFormRawValue,
    );
  }

  resetForm(form: GovOfficialContentFormGroup, govOfficialContent: GovOfficialContentFormGroupInput): void {
    const govOfficialContentRawValue = this.convertGovOfficialContentToGovOfficialContentRawValue({
      ...this.getFormDefaults(),
      ...govOfficialContent,
    });
    form.reset(
      {
        ...govOfficialContentRawValue,
        id: { value: govOfficialContentRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): GovOfficialContentFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      date: currentTime,
    };
  }

  private convertGovOfficialContentRawValueToGovOfficialContent(
    rawGovOfficialContent: GovOfficialContentFormRawValue | NewGovOfficialContentFormRawValue,
  ): IGovOfficialContent | NewGovOfficialContent {
    return {
      ...rawGovOfficialContent,
      date: dayjs(rawGovOfficialContent.date, DATE_TIME_FORMAT),
    };
  }

  private convertGovOfficialContentToGovOfficialContentRawValue(
    govOfficialContent: IGovOfficialContent | (Partial<NewGovOfficialContent> & GovOfficialContentFormDefaults),
  ): GovOfficialContentFormRawValue | PartialWithRequiredKeyOf<NewGovOfficialContentFormRawValue> {
    return {
      ...govOfficialContent,
      date: govOfficialContent.date ? govOfficialContent.date.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
