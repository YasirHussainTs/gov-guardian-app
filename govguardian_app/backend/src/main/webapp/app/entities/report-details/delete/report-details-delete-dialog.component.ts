import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IReportDetails } from '../report-details.model';
import { ReportDetailsService } from '../service/report-details.service';

@Component({
  standalone: true,
  templateUrl: './report-details-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class ReportDetailsDeleteDialogComponent {
  reportDetails?: IReportDetails;

  constructor(
    protected reportDetailsService: ReportDetailsService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.reportDetailsService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}
