import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IReportHeader, NewReportHeader } from '../report-header.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IReportHeader for edit and NewReportHeaderFormGroupInput for create.
 */
type ReportHeaderFormGroupInput = IReportHeader | PartialWithRequiredKeyOf<NewReportHeader>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IReportHeader | NewReportHeader> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

type ReportHeaderFormRawValue = FormValueOf<IReportHeader>;

type NewReportHeaderFormRawValue = FormValueOf<NewReportHeader>;

type ReportHeaderFormDefaults = Pick<NewReportHeader, 'id' | 'timestamp'>;

type ReportHeaderFormGroupContent = {
  id: FormControl<ReportHeaderFormRawValue['id'] | NewReportHeader['id']>;
  description: FormControl<ReportHeaderFormRawValue['description']>;
  title: FormControl<ReportHeaderFormRawValue['title']>;
  timestamp: FormControl<ReportHeaderFormRawValue['timestamp']>;
  status: FormControl<ReportHeaderFormRawValue['status']>;
  appUser: FormControl<ReportHeaderFormRawValue['appUser']>;
};

export type ReportHeaderFormGroup = FormGroup<ReportHeaderFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ReportHeaderFormService {
  createReportHeaderFormGroup(reportHeader: ReportHeaderFormGroupInput = { id: null }): ReportHeaderFormGroup {
    const reportHeaderRawValue = this.convertReportHeaderToReportHeaderRawValue({
      ...this.getFormDefaults(),
      ...reportHeader,
    });
    return new FormGroup<ReportHeaderFormGroupContent>({
      id: new FormControl(
        { value: reportHeaderRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      description: new FormControl(reportHeaderRawValue.description),
      title: new FormControl(reportHeaderRawValue.title),
      timestamp: new FormControl(reportHeaderRawValue.timestamp),
      status: new FormControl(reportHeaderRawValue.status),
      appUser: new FormControl(reportHeaderRawValue.appUser),
    });
  }

  getReportHeader(form: ReportHeaderFormGroup): IReportHeader | NewReportHeader {
    return this.convertReportHeaderRawValueToReportHeader(form.getRawValue() as ReportHeaderFormRawValue | NewReportHeaderFormRawValue);
  }

  resetForm(form: ReportHeaderFormGroup, reportHeader: ReportHeaderFormGroupInput): void {
    const reportHeaderRawValue = this.convertReportHeaderToReportHeaderRawValue({ ...this.getFormDefaults(), ...reportHeader });
    form.reset(
      {
        ...reportHeaderRawValue,
        id: { value: reportHeaderRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): ReportHeaderFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      timestamp: currentTime,
    };
  }

  private convertReportHeaderRawValueToReportHeader(
    rawReportHeader: ReportHeaderFormRawValue | NewReportHeaderFormRawValue,
  ): IReportHeader | NewReportHeader {
    return {
      ...rawReportHeader,
      timestamp: dayjs(rawReportHeader.timestamp, DATE_TIME_FORMAT),
    };
  }

  private convertReportHeaderToReportHeaderRawValue(
    reportHeader: IReportHeader | (Partial<NewReportHeader> & ReportHeaderFormDefaults),
  ): ReportHeaderFormRawValue | PartialWithRequiredKeyOf<NewReportHeaderFormRawValue> {
    return {
      ...reportHeader,
      timestamp: reportHeader.timestamp ? reportHeader.timestamp.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
