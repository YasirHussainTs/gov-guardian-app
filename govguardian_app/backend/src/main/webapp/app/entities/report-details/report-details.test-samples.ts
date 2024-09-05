import dayjs from 'dayjs/esm';

import { IReportDetails, NewReportDetails } from './report-details.model';

export const sampleWithRequiredData: IReportDetails = {
  id: 13809,
};

export const sampleWithPartialData: IReportDetails = {
  id: 23874,
  owner: 'hence',
  responder: 'alarm brightly offensively',
  title: 'thorough siege',
  timestamp: dayjs('2024-05-05T23:34'),
  status: 'likewise jubilant thoughtfully',
  voiceData: '../fake-data/blob/hipster.png',
  voiceDataContentType: 'unknown',
  file1: '../fake-data/blob/hipster.png',
  file1ContentType: 'unknown',
  file2: '../fake-data/blob/hipster.png',
  file2ContentType: 'unknown',
};

export const sampleWithFullData: IReportDetails = {
  id: 25218,
  owner: 'cruelly colorfully',
  responder: 'meanwhile',
  description: 'hollow',
  title: 'volcano',
  timestamp: dayjs('2024-05-05T17:23'),
  status: 'scornful yuck ew',
  image: '../fake-data/blob/hipster.png',
  imageContentType: 'unknown',
  video: '../fake-data/blob/hipster.png',
  videoContentType: 'unknown',
  voiceData: '../fake-data/blob/hipster.png',
  voiceDataContentType: 'unknown',
  file1: '../fake-data/blob/hipster.png',
  file1ContentType: 'unknown',
  file2: '../fake-data/blob/hipster.png',
  file2ContentType: 'unknown',
  file3: '../fake-data/blob/hipster.png',
  file3ContentType: 'unknown',
};

export const sampleWithNewData: NewReportDetails = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
