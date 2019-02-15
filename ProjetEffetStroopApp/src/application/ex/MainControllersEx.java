package application.ex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import application.Couleur;
import application.Main;
import application.parametres.MainControllersParametres;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainControllersEx {

	// Déclarations des variables FMXL liées à Scene Builder
	@FXML
	VBox Vb1;
	@FXML
	HBox Hb1;
	@FXML
	Button verif;
	@FXML
	HBox Hb2;

	@FXML
	HBox Hb3;
	@FXML
	HBox Hb4;
	@FXML
	HBox Hb5;

	// Déclarations de listes et autres variables

	public ArrayList<Integer> tirageAuSort = new ArrayList<Integer>();
	public ArrayList<Label> mesLabels = new ArrayList<Label>();
	public ArrayList<Label> bonnesRep = new ArrayList<Label>();
	public ArrayList<Label> mesLabelsSelec = new ArrayList<Label>();
	public int nbCouleurs;
	public int nbMots;
	public  int repValid;
	public static float pourcentValid;

	@SuppressWarnings("static-access")
	
	// initialisation à l'ouverture de la scene 

	public void initialize() {
		
	//	System.out.println(MainControllersParametres.pourcentageSelect + "%");

    // System.out.println(MainControllersParametres.listSelection);

		nbCouleurs = MainControllersParametres.listSelection.size(); // Calcul du nombre de couleurs selectionnés dans l'interface précédente

		nbMots = MainControllersParametres.getLignes() * MainControllersParametres.getColonnes();  // Calcul du nombre de mots ( disposition ) selectionnés dans l'interface précédente

		Random r = new Random(); // Objet Random ( permet de généré un nombre aléatoire) 
		int compteur = 0;
		
		 // tire au sort ( selon le pourcentage selectionné) les Label( mots ) qui seront correctement associés à leurs couleurs
		for (int j = 0; compteur < (int) nbMots * (MainControllersParametres.pourcentageSelect / 100); j++) {
			int valeur = 1 + r.nextInt(nbMots - 1); // intervalle du tirage au sort
			if (tirageAuSort.contains(valeur)) {
				System.out.println("déjà");

			} else {

				tirageAuSort.add(valeur);
				compteur++;
			}
		}

	//	System.out.println(tirageAuSort);
		int mot = 1;
		Label leLabel;
		int k = 0;
		int valeur;
		int valeur1;
		int valeur2;
		
		//Placement des Labels dans leurs Hbox respectives, avec association des couleurs ou non si ces derniers se trouvent ou non dans liste du tirage au sort
		for (int i = 1; i < MainControllersParametres.getLignes() + 1; i++) {
			for (int j = 1; j < MainControllersParametres.getColonnes() + 1; j++) {

				switch (i) {
				case 1:
					if (tirageAuSort.contains(mot)) {
						valeur = 0 + r.nextInt((nbCouleurs));
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur).getCouleurApercu());
						Hb5.getChildren().add(leLabel);
						Hb5.setMargin(leLabel, new Insets(5, 5, 5, 5));
					} else {

						valeur1 = 0 + r.nextInt((nbCouleurs));
						valeur2 = 0 + r.nextInt((nbCouleurs));
						while (valeur2 == valeur1) {
							valeur2 = 0 + r.nextInt((nbCouleurs));
						}
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur1).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur2).getCouleurApercu());
						Hb5.getChildren().add(leLabel);
						bonnesRep.add(leLabel);
						Hb5.setMargin(leLabel, new Insets(5, 5, 5, 5));

					}
					break;
				case 2:
					if (tirageAuSort.contains(mot)) {
						valeur = 0 + r.nextInt((nbCouleurs));
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur).getCouleurApercu());
						Hb4.getChildren().add(leLabel);
						Hb4.setMargin(leLabel, new Insets(5, 5, 5, 5));

					} else {

						valeur1 = 0 + r.nextInt((nbCouleurs));
						valeur2 = 0 + r.nextInt((nbCouleurs - 1));
						while (valeur2 == valeur1) {
							valeur2 = 0 + r.nextInt((nbCouleurs));
						}
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur1).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur2).getCouleurApercu());
						Hb4.getChildren().add(leLabel);
						bonnesRep.add(leLabel);
						Hb4.setMargin(leLabel, new Insets(5, 5, 5, 5));

					}
					break;
				case 3:
					if (tirageAuSort.contains(mot)) {
						valeur = 0 + r.nextInt((nbCouleurs));
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur).getCouleurApercu());
						Hb3.getChildren().add(leLabel);
						Hb3.setMargin(leLabel, new Insets(5, 5, 5, 5));

					} else {

						valeur1 = 0 + r.nextInt((nbCouleurs));
						valeur2 = 0 + r.nextInt((nbCouleurs));
						while (valeur2 == valeur1) {
							valeur2 = 0 + r.nextInt((nbCouleurs));
						}
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur1).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur2).getCouleurApercu());
						Hb3.getChildren().add(leLabel);
						bonnesRep.add(leLabel);
						Hb3.setMargin(leLabel, new Insets(5, 5, 5, 5));
					}
					break;
				case 4:
					if (tirageAuSort.contains(mot)) {
						valeur = 0 + r.nextInt((nbCouleurs));
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur).getCouleurApercu());
						Hb2.getChildren().add(leLabel);
						Hb2.setMargin(leLabel, new Insets(5, 5, 5, 5));

					} else {

						valeur1 = 0 + r.nextInt((nbCouleurs));
						valeur2 = 0 + r.nextInt((nbCouleurs));
						while (valeur2 == valeur1) {
							valeur2 = 0 + r.nextInt((nbCouleurs));
						}
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur1).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur2).getCouleurApercu());
						Hb2.getChildren().add(leLabel);
						bonnesRep.add(leLabel);
						Hb2.setMargin(leLabel, new Insets(5, 5, 5, 5));

					}
					break;
				default:
					if (tirageAuSort.contains(mot)) {
						valeur = 0 + r.nextInt((nbCouleurs));
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur).getCouleurApercu());
						Hb1.getChildren().add(leLabel);
						Hb1.setMargin(leLabel, new Insets(5, 5, 5, 5));

					} else {

						valeur1 = 0 + r.nextInt((nbCouleurs));
						valeur2 = 0 + r.nextInt((nbCouleurs));
						while (valeur2 == valeur1) {
							valeur2 = 0 + r.nextInt((nbCouleurs));
						}
						leLabel = new Label(MainControllersParametres.listSelection.get(valeur1).getCouleurNom());
						leLabel.setTextFill(MainControllersParametres.listSelection.get(valeur2).getCouleurApercu());
						Hb1.getChildren().add(leLabel);
						bonnesRep.add(leLabel);
						Hb1.setMargin(leLabel, new Insets(5, 5, 5, 5));

					}
					;
				}
				
				// éléments complentaires sur le label
				leLabel.setFont(Font.font(MainControllersParametres.policeSelect, 30));
				leLabel.setMinWidth(150);
				leLabel.setMinHeight(150);
				leLabel.setAlignment(Pos.CENTER);
				leLabel.setStyle("-fx-border-color:white;");

				mesLabels.add(leLabel);

				mot++;
				k++;
			}
		}
// creation des evenements au clic sur un label
		for (Label lab : mesLabels) { // parcours de la liste des Labels affichés

			lab.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					if (!mesLabelsSelec.contains(lab)) { // vérification si le label est selectionné ou non
						lab.setStyle("-fx-border-color:black;");
						mesLabelsSelec.add(lab); // ajout à la liste des labels selectionnés
					} else {
						lab.setStyle("-fx-border-color:white;");
						mesLabelsSelec.remove(lab);
					}

					

				}
			});
		}
	}

	public void verif() throws IOException { // méthode permettant de vérifier le nombre de bonnes réponses
		repValid = 0;
		for (Label selec : mesLabelsSelec) {
			for (Label rep : bonnesRep) {
				if (rep.equals(selec)) {
					repValid++;
				}
			}
		}

		System.out.println("size " + bonnesRep.size());
		if (repValid == bonnesRep.size()) {
			System.out.println("100%");
		}
		pourcentValid= repValid*100/bonnesRep.size();
		
		System.out.println(pourcentValid= repValid*100/bonnesRep.size());
			
		Alert dialog = new Alert(AlertType.INFORMATION);

		dialog.setTitle("Information");
		dialog.setHeaderText("Résulat");
		dialog.setContentText("Vous avez selectionné "+ pourcentValid +"% de bonnes réponses");
		dialog.showAndWait();
		System.exit(0);
			
		}
	

}
