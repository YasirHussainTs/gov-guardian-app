import dayjs from 'dayjs/esm';
import { IAppUser } from 'app/entities/app-user/app-user.model';

export interface IReportHeader {
  id: string;
  description?: string | null;
  title?: string | null;
  timestamp?: dayjs.Dayjs | null;
  status?: string | null;
  appUser?: Pick<IAppUser, 'id'> | null;
}

export type NewReportHeader = Omit<IReportHeader, 'id'> & { id: null };
