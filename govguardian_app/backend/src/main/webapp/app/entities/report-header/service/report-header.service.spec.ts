import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IReportHeader } from '../report-header.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../report-header.test-samples';

import { ReportHeaderService, RestReportHeader } from './report-header.service';

const requireRestSample: RestReportHeader = {
  ...sampleWithRequiredData,
  timestamp: sampleWithRequiredData.timestamp?.toJSON(),
};

describe('ReportHeader Service', () => {
  let service: ReportHeaderService;
  let httpMock: HttpTestingController;
  let expectedResult: IReportHeader | IReportHeader[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(ReportHeaderService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.find('ABC').subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should create a ReportHeader', () => {
      const reportHeader = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(reportHeader).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a ReportHeader', () => {
      const reportHeader = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(reportHeader).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a ReportHeader', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of ReportHeader', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a ReportHeader', () => {
      const expected = true;

      service.delete('ABC').subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addReportHeaderToCollectionIfMissing', () => {
      it('should add a ReportHeader to an empty array', () => {
        const reportHeader: IReportHeader = sampleWithRequiredData;
        expectedResult = service.addReportHeaderToCollectionIfMissing([], reportHeader);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(reportHeader);
      });

      it('should not add a ReportHeader to an array that contains it', () => {
        const reportHeader: IReportHeader = sampleWithRequiredData;
        const reportHeaderCollection: IReportHeader[] = [
          {
            ...reportHeader,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addReportHeaderToCollectionIfMissing(reportHeaderCollection, reportHeader);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a ReportHeader to an array that doesn't contain it", () => {
        const reportHeader: IReportHeader = sampleWithRequiredData;
        const reportHeaderCollection: IReportHeader[] = [sampleWithPartialData];
        expectedResult = service.addReportHeaderToCollectionIfMissing(reportHeaderCollection, reportHeader);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(reportHeader);
      });

      it('should add only unique ReportHeader to an array', () => {
        const reportHeaderArray: IReportHeader[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const reportHeaderCollection: IReportHeader[] = [sampleWithRequiredData];
        expectedResult = service.addReportHeaderToCollectionIfMissing(reportHeaderCollection, ...reportHeaderArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const reportHeader: IReportHeader = sampleWithRequiredData;
        const reportHeader2: IReportHeader = sampleWithPartialData;
        expectedResult = service.addReportHeaderToCollectionIfMissing([], reportHeader, reportHeader2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(reportHeader);
        expect(expectedResult).toContain(reportHeader2);
      });

      it('should accept null and undefined values', () => {
        const reportHeader: IReportHeader = sampleWithRequiredData;
        expectedResult = service.addReportHeaderToCollectionIfMissing([], null, reportHeader, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(reportHeader);
      });

      it('should return initial array if no ReportHeader is added', () => {
        const reportHeaderCollection: IReportHeader[] = [sampleWithRequiredData];
        expectedResult = service.addReportHeaderToCollectionIfMissing(reportHeaderCollection, undefined, null);
        expect(expectedResult).toEqual(reportHeaderCollection);
      });
    });

    describe('compareReportHeader', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareReportHeader(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 'ABC' };
        const entity2 = null;

        const compareResult1 = service.compareReportHeader(entity1, entity2);
        const compareResult2 = service.compareReportHeader(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 'ABC' };
        const entity2 = { id: 'CBA' };

        const compareResult1 = service.compareReportHeader(entity1, entity2);
        const compareResult2 = service.compareReportHeader(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 'ABC' };
        const entity2 = { id: 'ABC' };

        const compareResult1 = service.compareReportHeader(entity1, entity2);
        const compareResult2 = service.compareReportHeader(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
