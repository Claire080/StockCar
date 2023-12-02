package esiea.dao;

import esiea.metier.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AjouterVoitureIT {

    private VoitureDAO voitureDAO_1;
    private VoitureDAO voitureDAO_add;
    private VoitureDAO voitureDAO_2;
    private Voiture voiture;
    private ReponseVoiture reponseVoiture_1;
    private ReponseVoiture reponseVoiture_2;
    int id_sup;

    @BeforeEach
    public void initObject(){
        voitureDAO_1 = new VoitureDAO();
        voitureDAO_add = new VoitureDAO();
        voitureDAO_2 = new VoitureDAO();
        voiture = new Voiture();
        reponseVoiture_1 = new ReponseVoiture();
        reponseVoiture_2 = new ReponseVoiture();
        id_sup = 0;
    }

    @Test
    public void addRightCarAndFindItByMarque() throws SQLException {

        reponseVoiture_1 = voitureDAO_1.rechercherVoitures("Toyota",1,5);
        int sizeOfDataBeforeInsertion = reponseVoiture_1.getVolume();

        voiture.setMarque("Toyota");
        voiture.setModele("tya");
        voiture.setFinition("semi-fini");
        voiture.setCarburant(Voiture.Carburant.DIESEL);
        voiture.setKm(12);
        voiture.setAnnee(2000);
        voiture.setPrix(1200);

        voitureDAO_add.ajouterVoiture(voiture);

        reponseVoiture_2 = voitureDAO_2.rechercherVoitures("Toyota", 1, 5);
        int sizeOfDataAfterInsertion = reponseVoiture_2.getVolume();

        assertEquals(sizeOfDataBeforeInsertion+1, sizeOfDataAfterInsertion);
    }

    @Test
    public void addRightCarAndFindItByModele() throws SQLException {

        reponseVoiture_1 = voitureDAO_1.rechercherVoitures("tya",1,5);
        int sizeOfDataBeforeInsertion = reponseVoiture_1.getVolume();

        voiture.setMarque("Peugeot");
        voiture.setModele("tya");
        voiture.setFinition("semi-fini");
        voiture.setCarburant(Voiture.Carburant.DIESEL);
        voiture.setKm(12);
        voiture.setAnnee(2000);
        voiture.setPrix(1200);

        voitureDAO_add.ajouterVoiture(voiture);

        reponseVoiture_2 = voitureDAO_2.rechercherVoitures("tya", 1, 5);
        int sizeOfDataAfterInsertion = reponseVoiture_2.getVolume();

        assertEquals(sizeOfDataBeforeInsertion+1, sizeOfDataAfterInsertion);
    }

    @Test
    public void addRightCarAndFindItByFinition() throws SQLException {

        reponseVoiture_1 = voitureDAO_1.rechercherVoitures("fini",1,5);
        int sizeOfDataBeforeInsertion = reponseVoiture_1.getVolume();

        voiture.setMarque("Peugeot");
        voiture.setModele("tya");
        voiture.setFinition("fini");
        voiture.setCarburant(Voiture.Carburant.DIESEL);
        voiture.setKm(12);
        voiture.setAnnee(2000);
        voiture.setPrix(1200);

        voitureDAO_add.ajouterVoiture(voiture);

        reponseVoiture_2 = voitureDAO_2.rechercherVoitures("fini", 1, 5);
        int sizeOfDataAfterInsertion = reponseVoiture_2.getVolume();

        assertEquals(sizeOfDataBeforeInsertion+1, sizeOfDataAfterInsertion);
    }

    @Test
    public void dropACarAndNotFindIt() throws SQLException {

        reponseVoiture_1 = voitureDAO_1.rechercherVoitures("peugeot",1,5);
        int sizeOfDataBeforeInsertion = reponseVoiture_1.getVolume();

        voitureDAO_add.supprimerVoiture(Integer.toString(reponseVoiture_1.getData()[0].getId()));

        reponseVoiture_2 = voitureDAO_2.rechercherVoitures("peugeot", 1, 5);
        int sizeOfDataAfterInsertion = reponseVoiture_2.getVolume();

        assertEquals(sizeOfDataBeforeInsertion-1, sizeOfDataAfterInsertion);
    }
}
