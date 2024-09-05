import { IUser } from 'app/entities/user/user.model';
import { IReportHeader } from 'app/entities/report-header/report-header.model';
import { IReportDetails } from 'app/entities/report-details/report-details.model';
import { IReview } from 'app/entities/review/review.model';
import { IReward } from 'app/entities/reward/reward.model';
import { IGovOfficialContent } from 'app/entities/gov-official-content/gov-official-content.model';
import { UserType } from 'app/entities/enumerations/user-type.model';

export interface IAppUser {
  id: number;
  email?: string | null;
  address?: string | null;
  phone?: string | null;
  gender?: string | null;
  department?: string | null;
  description?: string | null;
  latitude?: number | null;
  longitude?: number | null;
  userType?: keyof typeof UserType | null;
  user?: Pick<IUser, 'id'> | null;
  reportHeaders?: Pick<IReportHeader, 'id'>[] | null;
  reportDetails?: Pick<IReportDetails, 'id'>[] | null;
  reviews?: Pick<IReview, 'id'> | null;
  rewards?: Pick<IReward, 'id'> | null;
  govOfficialContent?: Pick<IGovOfficialContent, 'id'> | null;
}

export type NewAppUser = Omit<IAppUser, 'id'> & { id: null };
