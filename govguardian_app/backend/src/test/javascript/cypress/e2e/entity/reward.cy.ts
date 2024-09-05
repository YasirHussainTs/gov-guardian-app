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

describe('Reward e2e test', () => {
  const rewardPageUrl = '/reward';
  const rewardPageUrlPattern = new RegExp('/reward(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const rewardSample = { description: 'jaggedly off' };

  let reward;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/rewards+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/rewards').as('postEntityRequest');
    cy.intercept('DELETE', '/api/rewards/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (reward) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/rewards/${reward.id}`,
      }).then(() => {
        reward = undefined;
      });
    }
  });

  it('Rewards menu should load Rewards page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('reward');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Reward').should('exist');
    cy.url().should('match', rewardPageUrlPattern);
  });

  describe('Reward page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(rewardPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Reward page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/reward/new$'));
        cy.getEntityCreateUpdateHeading('Reward');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rewardPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/rewards',
          body: rewardSample,
        }).then(({ body }) => {
          reward = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/rewards+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/rewards?page=0&size=20>; rel="last",<http://localhost/api/rewards?page=0&size=20>; rel="first"',
              },
              body: [reward],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(rewardPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Reward page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('reward');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rewardPageUrlPattern);
      });

      it('edit button click should load edit Reward page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Reward');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rewardPageUrlPattern);
      });

      it.skip('edit button click should load edit Reward page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Reward');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rewardPageUrlPattern);
      });

      it('last delete button click should delete instance of Reward', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('reward').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rewardPageUrlPattern);

        reward = undefined;
      });
    });
  });

  describe('new Reward page', () => {
    beforeEach(() => {
      cy.visit(`${rewardPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Reward');
    });

    it('should create an instance of Reward', () => {
      cy.get(`[data-cy="description"]`).type('under supposing enlighten');
      cy.get(`[data-cy="description"]`).should('have.value', 'under supposing enlighten');

      cy.get(`[data-cy="points"]`).type('14305');
      cy.get(`[data-cy="points"]`).should('have.value', '14305');

      cy.get(`[data-cy="timestamp"]`).type('2024-05-06T06:04');
      cy.get(`[data-cy="timestamp"]`).blur();
      cy.get(`[data-cy="timestamp"]`).should('have.value', '2024-05-06T06:04');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        reward = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', rewardPageUrlPattern);
    });
  });
});
