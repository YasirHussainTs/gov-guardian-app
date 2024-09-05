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

describe('GovOfficialContent e2e test', () => {
  const govOfficialContentPageUrl = '/gov-official-content';
  const govOfficialContentPageUrlPattern = new RegExp('/gov-official-content(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const govOfficialContentSample = { law: 'rations left woeful' };

  let govOfficialContent;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/gov-official-contents+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/gov-official-contents').as('postEntityRequest');
    cy.intercept('DELETE', '/api/gov-official-contents/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (govOfficialContent) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/gov-official-contents/${govOfficialContent.id}`,
      }).then(() => {
        govOfficialContent = undefined;
      });
    }
  });

  it('GovOfficialContents menu should load GovOfficialContents page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('gov-official-content');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('GovOfficialContent').should('exist');
    cy.url().should('match', govOfficialContentPageUrlPattern);
  });

  describe('GovOfficialContent page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(govOfficialContentPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create GovOfficialContent page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/gov-official-content/new$'));
        cy.getEntityCreateUpdateHeading('GovOfficialContent');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', govOfficialContentPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/gov-official-contents',
          body: govOfficialContentSample,
        }).then(({ body }) => {
          govOfficialContent = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/gov-official-contents+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/gov-official-contents?page=0&size=20>; rel="last",<http://localhost/api/gov-official-contents?page=0&size=20>; rel="first"',
              },
              body: [govOfficialContent],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(govOfficialContentPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details GovOfficialContent page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('govOfficialContent');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', govOfficialContentPageUrlPattern);
      });

      it('edit button click should load edit GovOfficialContent page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('GovOfficialContent');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', govOfficialContentPageUrlPattern);
      });

      it.skip('edit button click should load edit GovOfficialContent page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('GovOfficialContent');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', govOfficialContentPageUrlPattern);
      });

      it('last delete button click should delete instance of GovOfficialContent', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('govOfficialContent').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', govOfficialContentPageUrlPattern);

        govOfficialContent = undefined;
      });
    });
  });

  describe('new GovOfficialContent page', () => {
    beforeEach(() => {
      cy.visit(`${govOfficialContentPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('GovOfficialContent');
    });

    it('should create an instance of GovOfficialContent', () => {
      cy.get(`[data-cy="law"]`).type('enthusiastically');
      cy.get(`[data-cy="law"]`).should('have.value', 'enthusiastically');

      cy.get(`[data-cy="description"]`).type('reset');
      cy.get(`[data-cy="description"]`).should('have.value', 'reset');

      cy.get(`[data-cy="action"]`).type('impudence mesmerise');
      cy.get(`[data-cy="action"]`).should('have.value', 'impudence mesmerise');

      cy.get(`[data-cy="date"]`).type('2024-05-05T09:44');
      cy.get(`[data-cy="date"]`).blur();
      cy.get(`[data-cy="date"]`).should('have.value', '2024-05-05T09:44');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        govOfficialContent = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', govOfficialContentPageUrlPattern);
    });
  });
});
