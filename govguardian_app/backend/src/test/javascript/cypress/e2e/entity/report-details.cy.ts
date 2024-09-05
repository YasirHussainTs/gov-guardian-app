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

describe('ReportDetails e2e test', () => {
  const reportDetailsPageUrl = '/report-details';
  const reportDetailsPageUrlPattern = new RegExp('/report-details(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const reportDetailsSample = { owner: 'telnet capital ah' };

  let reportDetails;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/report-details+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/report-details').as('postEntityRequest');
    cy.intercept('DELETE', '/api/report-details/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (reportDetails) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/report-details/${reportDetails.id}`,
      }).then(() => {
        reportDetails = undefined;
      });
    }
  });

  it('ReportDetails menu should load ReportDetails page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('report-details');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('ReportDetails').should('exist');
    cy.url().should('match', reportDetailsPageUrlPattern);
  });

  describe('ReportDetails page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(reportDetailsPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create ReportDetails page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/report-details/new$'));
        cy.getEntityCreateUpdateHeading('ReportDetails');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportDetailsPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/report-details',
          body: reportDetailsSample,
        }).then(({ body }) => {
          reportDetails = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/report-details+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/report-details?page=0&size=20>; rel="last",<http://localhost/api/report-details?page=0&size=20>; rel="first"',
              },
              body: [reportDetails],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(reportDetailsPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details ReportDetails page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('reportDetails');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportDetailsPageUrlPattern);
      });

      it('edit button click should load edit ReportDetails page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('ReportDetails');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportDetailsPageUrlPattern);
      });

      it.skip('edit button click should load edit ReportDetails page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('ReportDetails');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportDetailsPageUrlPattern);
      });

      it('last delete button click should delete instance of ReportDetails', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('reportDetails').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', reportDetailsPageUrlPattern);

        reportDetails = undefined;
      });
    });
  });

  describe('new ReportDetails page', () => {
    beforeEach(() => {
      cy.visit(`${reportDetailsPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('ReportDetails');
    });

    it('should create an instance of ReportDetails', () => {
      cy.get(`[data-cy="owner"]`).type('once who ew');
      cy.get(`[data-cy="owner"]`).should('have.value', 'once who ew');

      cy.get(`[data-cy="responder"]`).type('towards');
      cy.get(`[data-cy="responder"]`).should('have.value', 'towards');

      cy.get(`[data-cy="description"]`).type('philosophise cot evenly');
      cy.get(`[data-cy="description"]`).should('have.value', 'philosophise cot evenly');

      cy.get(`[data-cy="title"]`).type('enrage');
      cy.get(`[data-cy="title"]`).should('have.value', 'enrage');

      cy.get(`[data-cy="timestamp"]`).type('2024-05-05T16:37');
      cy.get(`[data-cy="timestamp"]`).blur();
      cy.get(`[data-cy="timestamp"]`).should('have.value', '2024-05-05T16:37');

      cy.get(`[data-cy="status"]`).type('atop disclose');
      cy.get(`[data-cy="status"]`).should('have.value', 'atop disclose');

      cy.setFieldImageAsBytesOfEntity('image', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('video', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('voiceData', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('file1', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('file2', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('file3', 'integration-test.png', 'image/png');

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        reportDetails = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', reportDetailsPageUrlPattern);
    });
  });
});
