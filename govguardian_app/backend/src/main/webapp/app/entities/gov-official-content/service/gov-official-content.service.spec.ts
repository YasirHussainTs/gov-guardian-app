import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IGovOfficialContent } from '../gov-official-content.model';
import { sampleWithRequiredData, sampleWithNewData, sampleWithPartialData, sampleWithFullData } from '../gov-official-content.test-samples';

import { GovOfficialContentService, RestGovOfficialContent } from './gov-official-content.service';

const requireRestSample: RestGovOfficialContent = {
  ...sampleWithRequiredData,
  date: sampleWithRequiredData.date?.toJSON(),
};

describe('GovOfficialContent Service', () => {
  let service: GovOfficialContentService;
  let httpMock: HttpTestingController;
  let expectedResult: IGovOfficialContent | IGovOfficialContent[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(GovOfficialContentService);
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

    it('should create a GovOfficialContent', () => {
      const govOfficialContent = { ...sampleWithNewData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.create(govOfficialContent).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a GovOfficialContent', () => {
      const govOfficialContent = { ...sampleWithRequiredData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.update(govOfficialContent).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a GovOfficialContent', () => {
      const patchObject = { ...sampleWithPartialData };
      const returnedFromService = { ...requireRestSample };
      const expected = { ...sampleWithRequiredData };

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of GovOfficialContent', () => {
      const returnedFromService = { ...requireRestSample };

      const expected = { ...sampleWithRequiredData };

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toMatchObject([expected]);
    });

    it('should delete a GovOfficialContent', () => {
      const expected = true;

      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult).toBe(expected);
    });

    describe('addGovOfficialContentToCollectionIfMissing', () => {
      it('should add a GovOfficialContent to an empty array', () => {
        const govOfficialContent: IGovOfficialContent = sampleWithRequiredData;
        expectedResult = service.addGovOfficialContentToCollectionIfMissing([], govOfficialContent);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(govOfficialContent);
      });

      it('should not add a GovOfficialContent to an array that contains it', () => {
        const govOfficialContent: IGovOfficialContent = sampleWithRequiredData;
        const govOfficialContentCollection: IGovOfficialContent[] = [
          {
            ...govOfficialContent,
          },
          sampleWithPartialData,
        ];
        expectedResult = service.addGovOfficialContentToCollectionIfMissing(govOfficialContentCollection, govOfficialContent);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a GovOfficialContent to an array that doesn't contain it", () => {
        const govOfficialContent: IGovOfficialContent = sampleWithRequiredData;
        const govOfficialContentCollection: IGovOfficialContent[] = [sampleWithPartialData];
        expectedResult = service.addGovOfficialContentToCollectionIfMissing(govOfficialContentCollection, govOfficialContent);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(govOfficialContent);
      });

      it('should add only unique GovOfficialContent to an array', () => {
        const govOfficialContentArray: IGovOfficialContent[] = [sampleWithRequiredData, sampleWithPartialData, sampleWithFullData];
        const govOfficialContentCollection: IGovOfficialContent[] = [sampleWithRequiredData];
        expectedResult = service.addGovOfficialContentToCollectionIfMissing(govOfficialContentCollection, ...govOfficialContentArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const govOfficialContent: IGovOfficialContent = sampleWithRequiredData;
        const govOfficialContent2: IGovOfficialContent = sampleWithPartialData;
        expectedResult = service.addGovOfficialContentToCollectionIfMissing([], govOfficialContent, govOfficialContent2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(govOfficialContent);
        expect(expectedResult).toContain(govOfficialContent2);
      });

      it('should accept null and undefined values', () => {
        const govOfficialContent: IGovOfficialContent = sampleWithRequiredData;
        expectedResult = service.addGovOfficialContentToCollectionIfMissing([], null, govOfficialContent, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(govOfficialContent);
      });

      it('should return initial array if no GovOfficialContent is added', () => {
        const govOfficialContentCollection: IGovOfficialContent[] = [sampleWithRequiredData];
        expectedResult = service.addGovOfficialContentToCollectionIfMissing(govOfficialContentCollection, undefined, null);
        expect(expectedResult).toEqual(govOfficialContentCollection);
      });
    });

    describe('compareGovOfficialContent', () => {
      it('Should return true if both entities are null', () => {
        const entity1 = null;
        const entity2 = null;

        const compareResult = service.compareGovOfficialContent(entity1, entity2);

        expect(compareResult).toEqual(true);
      });

      it('Should return false if one entity is null', () => {
        const entity1 = { id: 123 };
        const entity2 = null;

        const compareResult1 = service.compareGovOfficialContent(entity1, entity2);
        const compareResult2 = service.compareGovOfficialContent(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey differs', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 456 };

        const compareResult1 = service.compareGovOfficialContent(entity1, entity2);
        const compareResult2 = service.compareGovOfficialContent(entity2, entity1);

        expect(compareResult1).toEqual(false);
        expect(compareResult2).toEqual(false);
      });

      it('Should return false if primaryKey matches', () => {
        const entity1 = { id: 123 };
        const entity2 = { id: 123 };

        const compareResult1 = service.compareGovOfficialContent(entity1, entity2);
        const compareResult2 = service.compareGovOfficialContent(entity2, entity1);

        expect(compareResult1).toEqual(true);
        expect(compareResult2).toEqual(true);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
