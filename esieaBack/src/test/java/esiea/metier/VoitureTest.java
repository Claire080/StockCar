package esiea.metier;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VoitureTest {

    @Test
    public void voiture_equal() {
        Voiture voiture = new Voiture();
        voiture.setMarque("Ferrari");
        voiture.setCarburant(Voiture.Carburant.HYBRIDE);
        Voiture voiture1 = new Voiture();
        voiture1.setMarque("Ferrari");
        voiture1.setCarburant(Voiture.Carburant.HYBRIDE);

        assertEquals(voiture, voiture1, "Les deux voitures ne pas sont égales.");
    }

    @Test
    public void voiture_not_equal() {
        Voiture voiture = new Voiture();
        voiture.setMarque("Ferrari");
        voiture.setCarburant(Voiture.Carburant.HYBRIDE);
        Voiture voiture1 = new Voiture();
        voiture1.setMarque("Mercedes");
        voiture1.setCarburant(Voiture.Carburant.HYBRIDE);

        assertNotEquals(voiture, voiture1, "Les deux voitures sont égales.");
    }

    @Test
    public void verify_modele() {
        String model = "Corsa";
        Voiture voiture = new Voiture();
        voiture.setModele(model);
        assertEquals(voiture.getModele(), model);
    }

    @Test
    public void verify_marque() {
        String marque = "Peugeot";
        Voiture voiture = new Voiture();
        voiture.setMarque(marque);
        assertEquals(voiture.getMarque(), marque);
    }

    @Test
    public void verify_carburant() {
        Voiture.Carburant carburant = Voiture.Carburant.DIESEL;
        Voiture voiture = new Voiture();
        voiture.setCarburant(carburant);
        assertEquals(voiture.getCarburant(), carburant);
    }

    @Test
    public void verify_finition() {
        String finition = "Peugeot";
        Voiture voiture = new Voiture();
        voiture.setFinition(finition);
        assertEquals(voiture.getFinition(), finition);
    }

    @Test
    public void verify_kilometers() {
        int km = 2560;
        Voiture voiture = new Voiture();
        voiture.setKm(km);
        assertEquals(voiture.getKm(), km);
    }

    @Test
    public void verify_prix() {
        int prix = 5000;
        Voiture voiture = new Voiture();
        voiture.setPrix(prix);
        assertEquals(voiture.getPrix(), prix);
    }
}
