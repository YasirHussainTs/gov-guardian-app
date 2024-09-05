import { IAppUser, NewAppUser } from './app-user.model';

export const sampleWithRequiredData: IAppUser = {
  id: 14311,
};

export const sampleWithPartialData: IAppUser = {
  id: 31162,
  address: 'woot project fearful',
  phone: '5141563276',
  gender: 'hence ha ouch',
  department: 'quicker suspiciously',
  description: 'godfather',
  latitude: 13370.61,
  longitude: 6583.07,
};

export const sampleWithFullData: IAppUser = {
  id: 22649,
  email: 'Nona31@hotmail.com',
  address: 'yum',
  phone: '1582105159',
  gender: 'pattypan mmm',
  department: 'gel separately',
  description: 'uplift noisily so',
  latitude: 28360.84,
  longitude: 5332.44,
  userType: 'COMMUNITY_MEMBER',
};

export const sampleWithNewData: NewAppUser = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
