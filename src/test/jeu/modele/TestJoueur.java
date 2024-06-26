/*
 * TestJoueur.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link jeu.modele.Joueur}
 */
class TestJoueur {

    /**
     * Méthode de test pour
     * {@link jeu.modele.Joueur#Joueur(java.lang.String)}.
     */
    @Test
    void testJoueur() {
        assertDoesNotThrow(() -> new Joueur("Kamasi"));
        assertDoesNotThrow(() -> new Joueur("Washington"));
        assertDoesNotThrow(() -> new Joueur("Magda"));
        assertDoesNotThrow(() -> new Joueur("Kuras"));
        assertDoesNotThrow(() -> new Joueur("12"));
        assertDoesNotThrow(() -> new Joueur("0123456789"));
        assertDoesNotThrow(() -> new Joueur("O U I "));

        assertThrows(IllegalArgumentException.class, () -> new Joueur(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Joueur("          "));
        assertThrows(NullPointerException.class, () -> new Joueur(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Joueur("01234567890"));
        assertThrows(IllegalArgumentException.class, () -> new Joueur("a"));
    }

    /**
     * Méthode de test pour {@link jeu.modele.Joueur#getPseudo()}.
     */
    @Test
    void testGetPseudo() {

        assertEquals("Kamasi", new Joueur("Kamasi").getPseudo());
        assertEquals("Washington", new Joueur("Washington").getPseudo());
        assertEquals("Magda", new Joueur("Magda").getPseudo());
        assertEquals("Kuras", new Joueur("Kuras").getPseudo());
        assertEquals("12", new Joueur("12").getPseudo());
        assertEquals("0123456789", new Joueur("0123456789").getPseudo());
        assertEquals("O U I ", new Joueur("O U I ").getPseudo());

        assertNotEquals("kamasi", new Joueur("Kamasi").getPseudo());
        assertNotEquals(" Washington", new Joueur("Washington").getPseudo());
        assertNotEquals("Magda ", new Joueur("Magda").getPseudo());
        assertNotEquals("KURAS", new Joueur("Kuras").getPseudo());
        assertNotEquals(" 12 ", new Joueur("12").getPseudo());
        assertNotEquals("0...9", new Joueur("0123456789").getPseudo());
        assertNotEquals("o_u_i_", new Joueur("O U I ").getPseudo());
    }

    /**
     * Méthode de test pour {@link jeu.modele.Joueur#getCartesEnMains()}.
     */
    @Test
    void testGetCartesEnMains() {

        /* Main vide lors de l'instanciation du Joueur */
        assertTrue(new Joueur("O U I ").getCartesEnMains().size() == 0);

        /*
         * Tests getter avec main non vides dans {@link
         * modele.jeu.TestJoueur#testSetCartesEnMains()}.
         */
    }

    /**
     * Méthode de test pour
     * {@link jeu.modele.Joueur#setCartesEnMains(Carte carte)}.
     */
    @Test
    void testSetCartesEnMains() {

        /* Cartes valides pour test */
        Carte unRouge = new Carte(Couleur.ROUGE, Valeur.UN);
        Carte deuxRouge = new Carte(Couleur.ROUGE, Valeur.DEUX);

        /* Joueurs valides pour test. Main null à ce stade */
        Joueur Kamasi = new Joueur("Kamasi");
        Joueur Washington = new Joueur("Washington");

        /* Listes de vérification */
        ArrayList<Carte> verifKamasi = new ArrayList<>();
        ArrayList<Carte> verifWashington = new ArrayList<>();

        /* On donne une carte à chacun */
        verifKamasi.add(unRouge);
        Kamasi.setCartesEnMains(unRouge);

        verifWashington.add(deuxRouge);
        Washington.setCartesEnMains(deuxRouge);

        /* On vérifie la main des joueurs */
        assertEquals(verifKamasi, Kamasi.getCartesEnMains());
        assertEquals(verifWashington, Washington.getCartesEnMains());
        assertNotEquals(verifWashington, Kamasi.getCartesEnMains());
        assertNotEquals(verifKamasi, Washington.getCartesEnMains());
    }
}
