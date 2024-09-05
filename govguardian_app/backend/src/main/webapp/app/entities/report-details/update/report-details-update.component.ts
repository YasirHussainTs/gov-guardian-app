import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AlertError } from 'app/shared/alert/alert-error.model';
import { EventManager, EventWithContent } from 'app/core/util/event-manager.service';
import { DataUtils, FileLoadError } from 'app/core/util/data-util.service';
import { IAppUser } from 'app/entities/app-user/app-user.model';
import { AppUserService } from 'app/entities/app-user/service/app-user.service';
import { ReportDetailsService } from '../service/report-details.service';
import { IReportDetails } from '../report-details.model';
import { ReportDetailsFormService, ReportDetailsFormGroup } from './report-details-form.service';

@Component({
  standalone: true,
  selector: 'jhi-report-details-update',
  templateUrl: './report-details-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class ReportDetailsUpdateComponent implements OnInit {
  isSaving = false;
  reportDetails: IReportDetails | null = null;

  appUsersSharedCollection: IAppUser[] = [];

  editForm: ReportDetailsFormGroup = this.reportDetailsFormService.createReportDetailsFormGroup();

  constructor(
    protected dataUtils: DataUtils,
    protected eventManager: EventManager,
    protected reportDetailsService: ReportDetailsService,
    protected reportDetailsFormService: ReportDetailsFormService,
    protected appUserService: AppUserService,
    protected elementRef: ElementRef,
    protected activatedRoute: ActivatedRoute,
  ) {}

  compareAppUser = (o1: IAppUser | null, o2: IAppUser | null): boolean => this.appUserService.compareAppUser(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ reportDetails }) => {
      this.reportDetails = reportDetails;
      if (reportDetails) {
        this.updateForm(reportDetails);
      }

      this.loadRelationshipsOptions();
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(base64String: string, contentType: string | null | undefined): void {
    this.dataUtils.openFile(base64String, contentType);
  }

  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe({
      error: (err: FileLoadError) =>
        this.eventManager.broadcast(new EventWithContent<AlertError>('govGuardianApp.error', { ...err, key: 'error.file.' + err.key })),
    });
  }

  clearInputImage(field: string, fieldContentType: string, idInput: string): void {
    this.editForm.patchValue({
      [field]: null,
      [fieldContentType]: null,
    });
    if (idInput && this.elementRef.nativeElement.querySelector('#' + idInput)) {
      this.elementRef.nativeElement.querySelector('#' + idInput).value = null;
    }
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const reportDetails = this.reportDetailsFormService.getReportDetails(this.editForm);
    if (reportDetails.id !== null) {
      this.subscribeToSaveResponse(this.reportDetailsService.update(reportDetails));
    } else {
      this.subscribeToSaveResponse(this.reportDetailsService.create(reportDetails));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IReportDetails>>): void {
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

  protected updateForm(reportDetails: IReportDetails): void {
    this.reportDetails = reportDetails;
    this.reportDetailsFormService.resetForm(this.editForm, reportDetails);

    this.appUsersSharedCollection = this.appUserService.addAppUserToCollectionIfMissing<IAppUser>(
      this.appUsersSharedCollection,
      reportDetails.appUser,
    );
  }

  protected loadRelationshipsOptions(): void {
    this.appUserService
      .query()
      .pipe(map((res: HttpResponse<IAppUser[]>) => res.body ?? []))
      .pipe(
        map((appUsers: IAppUser[]) => this.appUserService.addAppUserToCollectionIfMissing<IAppUser>(appUsers, this.reportDetails?.appUser)),
      )
      .subscribe((appUsers: IAppUser[]) => (this.appUsersSharedCollection = appUsers));
  }
}
