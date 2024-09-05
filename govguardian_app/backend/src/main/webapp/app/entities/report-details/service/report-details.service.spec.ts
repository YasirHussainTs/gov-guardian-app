import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IReportDetails } from '../report-details.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../report-details.test-samples';

import { ReportDetailsService, RestReportDetails } from './report-details.service';

const requireRestSample: RestReportDetails = {
  ...sampleWithRequiredData,
  timestamp: sampleWithRequiredData.timestamp?.toJSON(),
};

describe('ReportDetails Service', () => {
  let service: ReportDetailsService;
  let httpMock: HttpTestingController;
  let expectedResult: IReportDetails | IReportDetails[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(ReportDetailsService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should create a ReportDetails', () => {
      const reportDetails = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(reportDetails).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a ReportDetails', () => {
      const reportDetails = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(reportDetails).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a ReportDetails', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of ReportDetails', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a ReportDetails', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addReportDetailsToCollectionIfMissing', () => {
      it('should add a ReportDetails to an empty array', () => {
        const reportDetails: IReportDetails = sampleWithRequiredData;
        expectedResult = service.addReportDetailsToCollectionIfMissing([], reportDetails);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(reportDetails);
      });

      it('should not add a ReportDetails to an array that contains it', () => {
        const reportDetails: IReportDetails = sampleWithRequiredData;
        const reportDetailsCollection: IReportDetails[] = [
          {
            ...reportDetails,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addReportDetailsToCollectionIfMissing(reportDetailsCollection, reportDetails);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a ReportDetails to an array that doesn't contain it", () => {
        const reportDetails: IReportDetails = sampleWithRequiredData;
        const reportDetailsCollection: IReportDetails[] = [sampleWithPartialData];
        expectedResult = service.addReportDetailsToCollectionIfMissing(reportDetailsCollection, reportDetails);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(reportDetails);
      });

      it('should add only unique ReportDetails to an array', () => {
        const reportDetailsArray: IReportDetails[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const reportDetailsCollection: IReportDetails[] = [sampleWithRequiredData];
        expectedResult = service.addReportDetailsToCollectionIfMissing(reportDetailsCollection, ...reportDetailsArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const reportDetails: IReportDetails = sampleWithRequiredData;
        const reportDetails2: IReportDetails = sampleWithPartialData;
        expectedResult = service.addReportDetailsToCollectionIfMissing([], reportDetails, reportDetails2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(reportDetails);
        expect(expectedResult).toContain(reportDetails2);
      });

      it('should accept null and undefined values', () => {
        const reportDetails: IReportDetails = sampleWithRequiredData;
        expectedResult = service.addReportDetailsToCollectionIfMissing([], null, reportDetails, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(reportDetails);
      });

      it('should return initial array if no ReportDetails is added', () => {
        const reportDetailsCollection: IReportDetails[] = [sampleWithRequiredData];
        expectedResult = service.addReportDetailsToCollectionIfMissing(reportDetailsCollection, undefined, null);
        expect(expectedResult).toEqual(reportDetailsCollection);
      });
    });

    describe('compareReportDetails', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareReportDetails(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareReportDetails(entity1, entity2);
        const compareResult2 = service.compareReportDetails(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareReportDetails(entity1, entity2);
        const compareResult2 = service.compareReportDetails(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareReportDetails(entity1, entity2);
        const compareResult2 = service.compareReportDetails(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
