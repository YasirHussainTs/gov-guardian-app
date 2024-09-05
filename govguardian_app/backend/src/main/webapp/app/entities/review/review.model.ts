import dayjs from 'dayjs/esm';
import { IAppUser } from 'app/entities/app-user/app-user.model';

export interface IReview {
  id: number;
  content?: string | null;
  rating?: number | null;
  feedback?: string | null;
  timestamp?: dayjs.Dayjs | null;
  appUsers?: Pick<IAppUser, 'id'>[] | null;
}

export type NewReview = Omit<IReview, 'id'> & { id: null };
