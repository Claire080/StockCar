package esiea.dao;

import esiea.metier.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoitureDAOTest {

    private final VoitureDAO voitureDAO = new VoitureDAO();
    private final Voiture voitureOk = new Voiture();
    private final Voiture voitureError = new Voiture();

    @BeforeEach
    public void setup() {
        voitureOk.setId(12);
        voitureOk.setMarque("Bouval");
        voitureOk.setModele("Belford");
        voitureOk.setFinition("Elegance");
        voitureOk.setCarburant(Voiture.Carburant.DIESEL);
        voitureOk.setKm(2500);
        voitureOk.setAnnee(200);
        voitureOk.setPrix(3000);

        voitureError.setId(-1);
        voitureError.setMarque("Ouskit");
        voitureError.setCarburant(Voiture.Carburant.ESSENCE);
    }

    @Test
    public void ajouter_une_voiture_OK() throws SQLException {
        assertDoesNotThrow(() -> voitureDAO.ajouterVoiture(voitureOk), "La voiture n'a pas pu être ajouter");
    }

    @Test
    public void ajouter_une_voiture_Erreur() throws SQLException {
        assertThrows(SQLException.class, () -> voitureDAO.ajouterVoiture(voitureError), "La voiture a été ajouter");
    }


    @Test
    public void supprimer_une_voiture_OK() {

    }
}
