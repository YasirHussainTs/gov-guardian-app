import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IGovOfficialContent } from '../gov-official-content.model';
import { GovOfficialContentService } from '../service/gov-official-content.service';
import { GovOfficialContentFormService, GovOfficialContentFormGroup } from './gov-official-content-form.service';

@Component({
  standalone: true,
  selector: 'jhi-gov-official-content-update',
  templateUrl: './gov-official-content-update.component.html',
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
})
export class GovOfficialContentUpdateComponent implements OnInit {
  isSaving = false;
  govOfficialContent: IGovOfficialContent | null = null;

  editForm: GovOfficialContentFormGroup = this.govOfficialContentFormService.createGovOfficialContentFormGroup();

  constructor(
    protected govOfficialContentService: GovOfficialContentService,
    protected govOfficialContentFormService: GovOfficialContentFormService,
    protected activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ govOfficialContent }) => {
      this.govOfficialContent = govOfficialContent;
      if (govOfficialContent) {
        this.updateForm(govOfficialContent);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const govOfficialContent = this.govOfficialContentFormService.getGovOfficialContent(this.editForm);
    if (govOfficialContent.id !== null) {
      this.subscribeToSaveResponse(this.govOfficialContentService.update(govOfficialContent));
    } else {
      this.subscribeToSaveResponse(this.govOfficialContentService.create(govOfficialContent));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IGovOfficialContent>>): void {
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

  protected updateForm(govOfficialContent: IGovOfficialContent): void {
    this.govOfficialContent = govOfficialContent;
    this.govOfficialContentFormService.resetForm(this.editForm, govOfficialContent);
  }
}
