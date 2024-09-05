import dayjs from 'dayjs/esm';
import { IAppUser } from 'app/entities/app-user/app-user.model';

export interface IGovOfficialContent {
  id: number;
  law?: string | null;
  description?: string | null;
  action?: string | null;
  date?: dayjs.Dayjs | null;
  appUsers?: Pick<IAppUser, 'id'>[] | null;
}

export type NewGovOfficialContent = Omit<IGovOfficialContent, 'id'> & { id: null };
