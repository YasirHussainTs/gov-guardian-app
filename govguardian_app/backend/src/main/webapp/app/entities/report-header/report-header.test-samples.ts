import dayjs from 'dayjs/esm';

import { IReportHeader, NewReportHeader } from './report-header.model';

export const sampleWithRequiredData: IReportHeader = {
  id: 'fb0d04dd-a21f-4d6c-bdb4-dcc6d2a76f54',
};

export const sampleWithPartialData: IReportHeader = {
  id: '5ac642e9-b4fc-4afb-807c-d75d9df32fcc',
  title: 'whose ugh excepting',
  status: 'general letter',
};

export const sampleWithFullData: IReportHeader = {
  id: 'eb6caf6d-17fa-4acb-ac80-980d971e25f9',
  description: 'larva',
  title: 'by accompanist ouch',
  timestamp: dayjs('2024-05-05T20:13'),
  status: 'tightly',
};

export const sampleWithNewData: NewReportHeader = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
