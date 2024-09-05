import dayjs from 'dayjs/esm';

import { IGovOfficialContent, NewGovOfficialContent } from './gov-official-content.model';

export const sampleWithRequiredData: IGovOfficialContent = {
  id: 20924,
};

export const sampleWithPartialData: IGovOfficialContent = {
  id: 24922,
  law: 'softly onto for',
  description: 'huzzah mmm considering',
  action: 'recess uh-huh productive',
};

export const sampleWithFullData: IGovOfficialContent = {
  id: 25973,
  law: 'vote wherever partially',
  description: 'duh meager',
  action: 'utterly',
  date: dayjs('2024-05-05T13:02'),
};

export const sampleWithNewData: NewGovOfficialContent = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
