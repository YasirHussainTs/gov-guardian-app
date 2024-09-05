import dayjs from 'dayjs/esm';

import { IReward, NewReward } from './reward.model';

export const sampleWithRequiredData: IReward = {
  id: 7479,
};

export const sampleWithPartialData: IReward = {
  id: 28726,
};

export const sampleWithFullData: IReward = {
  id: 18667,
  description: 'metallic of',
  points: 3667,
  timestamp: dayjs('2024-05-06T02:21'),
};

export const sampleWithNewData: NewReward = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
