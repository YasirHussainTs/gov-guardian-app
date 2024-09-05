import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('ReportHeader e2e test', () => {
  const reportHeaderPageUrl = '/report-header';
  const reportHeaderPageUrlPattern = new RegExp('/report-header(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const reportHeaderSample = { description: 'unfortunately' };

  let reportHeader;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/report-headers+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/report-headers').as('postEntityRequest');
    cy.intercept('DELETE', '/api/report-headers/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (reportHeader) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/report-headers/${reportHeader.id}`,
      }).then(() => {
        reportHeader = undefined;
      });
    }
  });

  it('ReportHeaders menu should load ReportHeaders page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('report-header');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('ReportHeader').should('exist');
    cy.url().should('match', reportHeaderPageUrlPattern);
  });

  describe('ReportHeader page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(reportHeaderPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create ReportHeader page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/report-header/new$'));
        cy.getEntityCreateUpdateHeading('ReportHeader');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportHeaderPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/report-headers',
          body: reportHeaderSample,
        }).then(({ body }) => {
          reportHeader = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/report-headers+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/report-headers?page=0&size=20>; rel="last",<http://localhost/api/report-headers?page=0&size=20>; rel="first"',
              },
              body: [reportHeader],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(reportHeaderPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details ReportHeader page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('reportHeader');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportHeaderPageUrlPattern);
      });

      it('edit button click should load edit ReportHeader page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('ReportHeader');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportHeaderPageUrlPattern);
      });

      it.skip('edit button click should load edit ReportHeader page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('ReportHeader');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportHeaderPageUrlPattern);
      });

      it('last delete button click should delete instance of ReportHeader', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('reportHeader').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportHeaderPageUrlPattern);

        reportHeader = undefined;
      });
    });
  });

  describe('new ReportHeader page', () => {
    beforeEach(() => {
      cy.visit(`${reportHeaderPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('ReportHeader');
    });

    it('should create an instance of ReportHeader', () => {
      cy.get(`[data-cy="description"]`).type('flame');
      cy.get(`[data-cy="description"]`).should('have.value', 'flame');

      cy.get(`[data-cy="title"]`).type('lazily');
      cy.get(`[data-cy="title"]`).should('have.value', 'lazily');

      cy.get(`[data-cy="timestamp"]`).type('2024-05-05T14:59');
      cy.get(`[data-cy="timestamp"]`).blur();
      cy.get(`[data-cy="timestamp"]`).should('have.value', '2024-05-05T14:59');

      cy.get(`[data-cy="status"]`).type('once without');
      cy.get(`[data-cy="status"]`).should('have.value', 'once without');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        reportHeader = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', reportHeaderPageUrlPattern);
    });
  });
});
