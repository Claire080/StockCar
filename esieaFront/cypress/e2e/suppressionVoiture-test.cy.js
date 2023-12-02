describe('Suppression d\'une voiture', () => {
  it('Devrait supprimer une voiture existante', () => {
    cy.visit('http://localhost:8080/esieaFront/');
    cy.wait(2000)
    cy.get('#saisieRecherche').type('NouvelleMarque', {force: true});
    cy.get('#saisieRecherche + button').click({force : true});
    cy.wait(2000)
    // Sélectionnez la nouvelle voiture dans la liste et cliquez sur le bouton de suppression
    cy.get('#listeVoitureTable tbody a:contains("Détails")').click({ multiple: true });
    cy.wait(3000)
    cy.get('#divSupprimer button').click({force : true})
  });
});
