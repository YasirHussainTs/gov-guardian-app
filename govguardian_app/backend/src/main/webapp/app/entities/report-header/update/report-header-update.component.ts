import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IAppUser } from 'app/entities/app-user/app-user.model';
import { AppUserService } from 'app/entities/app-user/service/app-user.service';
import { IReportHeader } from '../report-header.model';
import { ReportHeaderService } from '../service/report-header.service';
import { ReportHeaderFormService, ReportHeaderFormGroup } from './report-header-form.service';

@Component({
  standalone: true,
  selector: 'jhi-report-header-update',
  templateUrl: './report-header-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class ReportHeaderUpdateComponent implements OnInit {
  isSaving = false;
  reportHeader: IReportHeader | null = null;

  appUsersSharedCollection: IAppUser[] = [];

  editForm: ReportHeaderFormGroup = this.reportHeaderFormService.createReportHeaderFormGroup();

  constructor(
    protected reportHeaderService: ReportHeaderService,
    protected reportHeaderFormService: ReportHeaderFormService,
    protected appUserService: AppUserService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  compareAppUser = (o1: IAppUser | null, o2: IAppUser | null): boolean => this.appUserService.compareAppUser(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ reportHeader }) => {
      this.reportHeader = reportHeader;
      if (reportHeader) {
        this.updateForm(reportHeader);
      }

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const reportHeader = this.reportHeaderFormService.getReportHeader(this.editForm);
    if (reportHeader.id !== null) {
      this.subscribeToSaveResponse(this.reportHeaderService.update(reportHeader));
    } else {
      this.subscribeToSaveResponse(this.reportHeaderService.create(reportHeader));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IReportHeader>>): void {
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

  protected updateForm(reportHeader: IReportHeader): void {
    this.reportHeader = reportHeader;
    this.reportHeaderFormService.resetForm(this.editForm, reportHeader);

    this.appUsersSharedCollection = this.appUserService.addAppUserToCollectionIfMissing<IAppUser>(
      this.appUsersSharedCollection,
      reportHeader.appUser,
    );
  }

  protected loadRelationshipsOptions(): void {
    this.appUserService
      .query()
      .pipe(map((res: HttpResponse<IAppUser[]>) => res.body ?? []))
      .pipe(
        map((appUsers: IAppUser[]) => this.appUserService.addAppUserToCollectionIfMissing<IAppUser>(appUsers, this.reportHeader?.appUser)),
      )
      .subscribe((appUsers: IAppUser[]) => (this.appUsersSharedCollection = appUsers));
  }
}
