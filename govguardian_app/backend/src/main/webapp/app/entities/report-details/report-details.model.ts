import dayjs from 'dayjs/esm';
import { IAppUser } from 'app/entities/app-user/app-user.model';

export interface IReportDetails {
  id: number;
  owner?: string | null;
  responder?: string | null;
  description?: string | null;
  title?: string | null;
  timestamp?: dayjs.Dayjs | null;
  status?: string | null;
  image?: string | null;
  imageContentType?: string | null;
  video?: string | null;
  videoContentType?: string | null;
  voiceData?: string | null;
  voiceDataContentType?: string | null;
  file1?: string | null;
  file1ContentType?: string | null;
  file2?: string | null;
  file2ContentType?: string | null;
  file3?: string | null;
  file3ContentType?: string | null;
  appUser?: Pick<IAppUser, 'id'> | null;
}

export type NewReportDetails = Omit<IReportDetails, 'id'> & { id: null };
