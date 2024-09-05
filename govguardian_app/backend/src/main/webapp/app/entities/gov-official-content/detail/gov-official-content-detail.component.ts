import { Component, Input } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IGovOfficialContent } from '../gov-official-content.model';

@Component({
  standalone: true,
  selector: 'jhi-gov-official-content-detail',
  templateUrl: './gov-official-content-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class GovOfficialContentDetailComponent {
  @Input() govOfficialContent: IGovOfficialContent | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  previousState(): void {
    window.history.back();
  }
}
