import dayjs from 'dayjs/esm';

import { IReview, NewReview } from './review.model';

export const sampleWithRequiredData: IReview = {
  id: 15265,
};

export const sampleWithPartialData: IReview = {
  id: 15081,
  rating: 24873,
  timestamp: dayjs('2024-05-05T23:56'),
};

export const sampleWithFullData: IReview = {
  id: 5714,
  content: 'instantly',
  rating: 24326,
  feedback: 'calmly kindheartedly',
  timestamp: dayjs('2024-05-05T09:28'),
};

export const sampleWithNewData: NewReview = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
