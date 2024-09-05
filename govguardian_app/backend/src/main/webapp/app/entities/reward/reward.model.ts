import dayjs from 'dayjs/esm';
import { IAppUser } from 'app/entities/app-user/app-user.model';

export interface IReward {
  id: number;
  description?: string | null;
  points?: number | null;
  timestamp?: dayjs.Dayjs | null;
  appUsers?: Pick<IAppUser, 'id'>[] | null;
}

export type NewReward = Omit<IReward, 'id'> & { id: null };
