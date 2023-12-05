describe('Page d\'accueil', () => {
  it('Affichage de la page d\'accueil', () => {
    cy.visit('http://localhost:8080/esieaFront/');
    cy.get('h2').should('contain', 'Liste des voitures en stock');
  });

  it('Pagination de la page de la liste des voitures', () => {
    cy.visit('http://localhost:8080/esieaFront/');
    cy.get('div#pages a[value="2"]').click();
    cy.get('div#pages a.active').should('contain', '2');
    cy.get('#listeVoitureTable tbody tr').should('have.length', 5);
    cy.get('div.pagination a.next').click();
    cy.get('div#pages a.active').should('contain', '3');
    cy.get('div.pagination a.previous').click();
    cy.get('div#pages a.active').should('contain', '2');
  });
});
