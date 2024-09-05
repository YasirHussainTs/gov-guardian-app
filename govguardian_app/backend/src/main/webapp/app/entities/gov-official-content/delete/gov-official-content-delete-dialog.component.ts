import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import SharedModule from 'app/shared/shared.module';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';
import { IGovOfficialContent } from '../gov-official-content.model';
import { GovOfficialContentService } from '../service/gov-official-content.service';

@Component({
  standalone: true,
  templateUrl: './gov-official-content-delete-dialog.component.html',
  imports: [SharedModule, FormsModule],
})
export class GovOfficialContentDeleteDialogComponent {
  govOfficialContent?: IGovOfficialContent;

  constructor(
    protected govOfficialContentService: GovOfficialContentService,
    protected activeModal: NgbActiveModal,
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.govOfficialContentService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}
