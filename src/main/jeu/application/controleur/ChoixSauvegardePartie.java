/*
 * ChoixSauvegardePartie.java                                      31 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class ChoixSauvegardePartie {

    @FXML
    private void retourMenu(ActionEvent event) {
            Hanabi.activerParametres();
    }
}
