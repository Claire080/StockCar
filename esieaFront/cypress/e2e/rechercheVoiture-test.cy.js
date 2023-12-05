describe('Recherche de voiture', () => {
  it('Rechercher un voiture', () => {
    cy.visit('http://localhost:8080/esieaFront/');
    cy.wait(2000)
    cy.get('#saisieRecherche').type('Volvo', {force: true});
    cy.get('#saisieRecherche + button').click({force : true})
  })
});
