describe('Ajout d\'une nouvelle voiture', () => {
  it('Ajouter une nouvelle voiture', () => {

    cy.visit('http://localhost:8080/esieaFront/');
    cy.wait(2000)
    cy.get('#nav a:contains("Ajouter une voiture")').click({ force: true });
    cy.get('#nouvelle').should('be.visible');
    cy.get('#marque').type('Hyundai');
    cy.get('#modele').type('KONA Hybrid');
    cy.get('#finition').type('Electrique');
    cy.get("select#carburant").select("Essence");
    cy.get('#km').type('500000');
    cy.get('#annee').type('2022');
    cy.get('#prix').type('1000000');
    cy.get('#nouvelle').click(); // Soumettez le formulaire
  });
});

