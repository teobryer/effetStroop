package application.parametres.addColor;

import java.io.IOException;

import application.Couleur;
import application.Main;
import application.parametres.MainControllersParametres;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainControllersAddColor {
@FXML
Button valider;

@FXML
ColorPicker colorPicker;
@FXML
TextField nom;


	
	public static String nomCouleur; // variable permettant de stocker le nom de la couleur
	public static Color couleurApercu;// variable permettant de stocker la couleur RVB
	
	public void valider() throws IOException { // méthode valider un ajout de couleur
		
		if(nom.getLength()>0 && nom.getLength()<20 ) { // permettre l'ajout de nom de couleur seulement si le nom fait  entre et  20 lettres
		
		nomCouleur=nom.getText(); // récupère le nom inséré dans le TextField
		couleurApercu= colorPicker.getValue();// récupère le Color dans le ColorPicker
		
		
		CheckBox tmp= new CheckBox(nomCouleur); // instanciation d'une nouvelle CheckBox( Couleur)
		tmp.setFont(Font.font("Carlito")); // ajout d'un font 
	    tmp.setPadding(new Insets(5, 0, 0, 0));// modification du padding de la CheckBox
		MainControllersParametres.listNewsColorsCb.add(tmp); // ajoute la couleur à la liste de couleur (checkBox)
		
		Couleur newColor = new Couleur(couleurApercu,nomCouleur);// instanciation d'une nouvelle Couleur( Couleur)
		MainControllersParametres.listNewsColors.add(newColor);// ajoute la couleur à la liste de couleur (Couleur)
		
		
		
		// Lancement de l'interface de paramètres
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("../InterfaceParametres.fxml"));
		BorderPane root = rootLoader.load();

		Scene scene = new Scene(root, 650, 470);
		// scene.getStylesheets().add(getClass().getResource("application/application.css").toExternalForm());

		Main.myPrimaryStage.setScene(scene);
		Main.myPrimaryStage.show();
		
		}
		
		else {
			
			//Boite de dialogue si les conditions ne sont pas respectés
			
			Alert dialog = new Alert(AlertType.INFORMATION);

			dialog.setTitle("Information");
			dialog.setHeaderText("STOP !");
			dialog.setContentText("Veuillez entrer un nom valide \n");
			dialog.showAndWait();
		}
		
		
	}
	
	public void annuler() throws IOException { // methode annulation de la création d'une couleur
		
		//Lancement de l'interface de Parametrages
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("../InterfaceParametres.fxml"));
		BorderPane root = rootLoader.load();

		Scene scene = new Scene(root, 650, 470);
		// scene.getStylesheets().add(getClass().getResource("application/application.css").toExternalForm());

		Main.myPrimaryStage.setScene(scene);
		Main.myPrimaryStage.show();
		
	}

	
	
	
}
