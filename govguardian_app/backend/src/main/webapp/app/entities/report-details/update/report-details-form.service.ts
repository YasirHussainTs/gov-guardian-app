import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IReportDetails, NewReportDetails } from '../report-details.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IReportDetails for edit and NewReportDetailsFormGroupInput for create.
 */
type ReportDetailsFormGroupInput = IReportDetails | PartialWithRequiredKeyOf<NewReportDetails>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IReportDetails | NewReportDetails> = Omit<T, 'timestamp'> & {
  timestamp?: string | null;
};

type ReportDetailsFormRawValue = FormValueOf<IReportDetails>;

type NewReportDetailsFormRawValue = FormValueOf<NewReportDetails>;

type ReportDetailsFormDefaults = Pick<NewReportDetails, 'id' | 'timestamp'>;

type ReportDetailsFormGroupContent = {
  id: FormControl<ReportDetailsFormRawValue['id'] | NewReportDetails['id']>;
  owner: FormControl<ReportDetailsFormRawValue['owner']>;
  responder: FormControl<ReportDetailsFormRawValue['responder']>;
  description: FormControl<ReportDetailsFormRawValue['description']>;
  title: FormControl<ReportDetailsFormRawValue['title']>;
  timestamp: FormControl<ReportDetailsFormRawValue['timestamp']>;
  status: FormControl<ReportDetailsFormRawValue['status']>;
  image: FormControl<ReportDetailsFormRawValue['image']>;
  imageContentType: FormControl<ReportDetailsFormRawValue['imageContentType']>;
  video: FormControl<ReportDetailsFormRawValue['video']>;
  videoContentType: FormControl<ReportDetailsFormRawValue['videoContentType']>;
  voiceData: FormControl<ReportDetailsFormRawValue['voiceData']>;
  voiceDataContentType: FormControl<ReportDetailsFormRawValue['voiceDataContentType']>;
  file1: FormControl<ReportDetailsFormRawValue['file1']>;
  file1ContentType: FormControl<ReportDetailsFormRawValue['file1ContentType']>;
  file2: FormControl<ReportDetailsFormRawValue['file2']>;
  file2ContentType: FormControl<ReportDetailsFormRawValue['file2ContentType']>;
  file3: FormControl<ReportDetailsFormRawValue['file3']>;
  file3ContentType: FormControl<ReportDetailsFormRawValue['file3ContentType']>;
  appUser: FormControl<ReportDetailsFormRawValue['appUser']>;
};

export type ReportDetailsFormGroup = FormGroup<ReportDetailsFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ReportDetailsFormService {
  createReportDetailsFormGroup(reportDetails: ReportDetailsFormGroupInput = { id: null }): ReportDetailsFormGroup {
    const reportDetailsRawValue = this.convertReportDetailsToReportDetailsRawValue({
      ...this.getFormDefaults(),
      ...reportDetails,
    });
    return new FormGroup<ReportDetailsFormGroupContent>({
      id: new FormControl(
        { value: reportDetailsRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      owner: new FormControl(reportDetailsRawValue.owner),
      responder: new FormControl(reportDetailsRawValue.responder),
      description: new FormControl(reportDetailsRawValue.description),
      title: new FormControl(reportDetailsRawValue.title),
      timestamp: new FormControl(reportDetailsRawValue.timestamp),
      status: new FormControl(reportDetailsRawValue.status),
      image: new FormControl(reportDetailsRawValue.image),
      imageContentType: new FormControl(reportDetailsRawValue.imageContentType),
      video: new FormControl(reportDetailsRawValue.video),
      videoContentType: new FormControl(reportDetailsRawValue.videoContentType),
      voiceData: new FormControl(reportDetailsRawValue.voiceData),
      voiceDataContentType: new FormControl(reportDetailsRawValue.voiceDataContentType),
      file1: new FormControl(reportDetailsRawValue.file1),
      file1ContentType: new FormControl(reportDetailsRawValue.file1ContentType),
      file2: new FormControl(reportDetailsRawValue.file2),
      file2ContentType: new FormControl(reportDetailsRawValue.file2ContentType),
      file3: new FormControl(reportDetailsRawValue.file3),
      file3ContentType: new FormControl(reportDetailsRawValue.file3ContentType),
      appUser: new FormControl(reportDetailsRawValue.appUser),
    });
  }

  getReportDetails(form: ReportDetailsFormGroup): IReportDetails | NewReportDetails {
    return this.convertReportDetailsRawValueToReportDetails(form.getRawValue() as ReportDetailsFormRawValue | NewReportDetailsFormRawValue);
  }

  resetForm(form: ReportDetailsFormGroup, reportDetails: ReportDetailsFormGroupInput): void {
    const reportDetailsRawValue = this.convertReportDetailsToReportDetailsRawValue({ ...this.getFormDefaults(), ...reportDetails });
    form.reset(
      {
        ...reportDetailsRawValue,
        id: { value: reportDetailsRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): ReportDetailsFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      timestamp: currentTime,
    };
  }

  private convertReportDetailsRawValueToReportDetails(
    rawReportDetails: ReportDetailsFormRawValue | NewReportDetailsFormRawValue,
  ): IReportDetails | NewReportDetails {
    return {
      ...rawReportDetails,
      timestamp: dayjs(rawReportDetails.timestamp, DATE_TIME_FORMAT),
    };
  }

  private convertReportDetailsToReportDetailsRawValue(
    reportDetails: IReportDetails | (Partial<NewReportDetails> & ReportDetailsFormDefaults),
  ): ReportDetailsFormRawValue | PartialWithRequiredKeyOf<NewReportDetailsFormRawValue> {
    return {
      ...reportDetails,
      timestamp: reportDetails.timestamp ? reportDetails.timestamp.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
