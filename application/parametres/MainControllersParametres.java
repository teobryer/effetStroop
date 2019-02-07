package effetstroop.application.parametres;

import java.awt.GraphicsEnvironment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.GroupLayout.Alignment;

import effetstroop.application.Couleur;
import effetstroop.application.Main;
import effetstroop.application.parametres.addColor.MainControllersAddColor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainControllersParametres {
	
	//D�clarations des variables FMXL li�es � Scene Builder
	@FXML
	CheckBox rougeCb;
	@FXML
	CheckBox vertCb;
	@FXML
	CheckBox bleuCb;
	@FXML
	CheckBox noirCb;
	@FXML
	CheckBox jauneCb;
    @FXML
	Button addColor;
	@FXML
	Button suppColor;
	@FXML
	private VBox lesCouleurs;
	@FXML
	Button lancerEx;
	@FXML
	Slider slideV;
	@FXML
	Slider slideH;
    @FXML
	VBox Vb1;
    @FXML
	HBox Hb1;
	@FXML
	HBox Hb2;
	@FXML
	HBox Hb3;
	@FXML
	HBox Hb4;
	@FXML
	HBox Hb5;
	@FXML
	ComboBox<Label> lesPolices;
	@FXML
	ComboBox<Integer> pourcentage;
	@FXML
	ProgressIndicator pourcentageIndic;
	@FXML
	Button apercu;
	
	//Instancation d'objets de la classe Couleur( couleurs basiques )
	Couleur rouge = new Couleur(Color.RED, "Rouge");
	Couleur vert = new Couleur(Color.GREEN, "Vert");
	Couleur bleu = new Couleur(Color.BLUE, "Bleu");
	Couleur noir = new Couleur(Color.BLACK, "Noir");
	Couleur jaune = new Couleur(Color.YELLOW, "Jaune");
	
	//D�claration des listes utiles et d'autres variables
	
	public static float pourcentageSelect;
	ArrayList<effetstroop.application.Couleur> listColorsBase = new ArrayList<Couleur>();
	ArrayList<CheckBox> listColorsBaseCb = new ArrayList<CheckBox>();
    public static ArrayList<Couleur> listNewsColors = new ArrayList<Couleur>();
	public static ArrayList<CheckBox> listNewsColorsCb = new ArrayList<CheckBox>();
	public ArrayList<Couleur> listColorSup = new ArrayList<Couleur>();
	public ArrayList<CheckBox> listColorSupCb = new ArrayList<CheckBox>();
	public static ArrayList<Couleur> listSelection = new ArrayList<Couleur>();
	public String fonts[] = new String[GraphicsEnvironment.getLocalGraphicsEnvironment()
	       .getAvailableFontFamilyNames().length];
	ColorPicker cPicker = new ColorPicker(Color.BLUE);
	public static int lignes;
	public static int colonnes;
	public static String policeSelect;

	
	// initialisation � l'ouverture de la scene 
	public void initialize() {
		
		pourcentage.setValue(50); // donne comme valeur 50 � la comboBox pour choisir le pourcentage de bonnes couleurs associ�s
		pourcentageIndic.setProgress(0.5); // donne comme valeur 50% au visuel de mots ayant leurs bonnes couleurs associ�s
		pourcentageSelect=50; // Le pourcentage selectionn� iniatialement est 50%
		pourcentage.getItems().addAll(10, 20, 30, 40, 50, 60, 70, 80, 90); // ajout des possibilt�s de pourcentages � la comboBox
		CheckBox tmp;
		listColorsBase.add(bleu);
		listColorsBaseCb.add(bleuCb);
		listColorsBase.add(rouge);
		listColorsBaseCb.add(rougeCb); // Ajout de toutes les couleurs de base dans deux lsites, une pour la comboBox, une pour prendre l'information du nom et du code RVB;
		listColorsBase.add(noir);
		listColorsBaseCb.add(noirCb);
		listColorsBase.add(jaune);
		listColorsBaseCb.add(jauneCb);
		listColorsBase.add(vert);
		listColorsBaseCb.add(vertCb);
		
		getLesCouleurs().getChildren().addAll(listNewsColorsCb); // Ajout de la liste de nouvelles couleurs (initialement vide au 1er lancement de la scene)
		//System.out.println(listNewsColors);
		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // r�cup�re les polices du systeme dans un tableau pr�vu � cet effet

		for (int i = 0; i < fonts.length; i++) {
			// System.out.println(fonts[i]);
			String pol = fonts[i];                        // ComboBox remplit par des Labels de chaque Police ayant comme Police la leur
			Label label = new Label(pol);
			lesPolices.getItems().add(label);
			label.setFont(Font.font(pol));

		}
		lesPolices.setValue(new Label("Arial")); // Donne comme valeur � la ComboBox la police Arial

	}

	public void ajouterCouleur() throws IOException { // m�thode permettant l'ajout d'une couleur en ouvrant une autre interface
		
		if(listNewsColors.size()<5) { // restriction en nombre de cr�ation couleur, � 5 ainsi 
			
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("../parametres/addColor/InterfaceAddColor.fxml"));  
		BorderPane root = rootLoader.load();                                               
		Scene scene = new Scene(root, 200, 200);
		Main.myPrimaryStage.setScene(scene);
		Main.myPrimaryStage.show();


	}
		
		else {
			Alert dialog = new Alert(AlertType.INFORMATION); // Boite de dialogue si les conditions ne sont pas respect�s

			dialog.setTitle("Information");
			dialog.setHeaderText("STOP !");
			dialog.setContentText("Vous avez atteint le nombre maximal de couleurs � ajouter \n" +
			"(5 maximum), veuillez en supprimer.");
			dialog.showAndWait();
		}
		
	
	}

	public void suppColor() { //m�thode permettant la suppression d'un couleur
		int i = 0;
		for (CheckBox cb : listNewsColorsCb) { // Parcours de la liste de nouvelles couleurs
			if (cb.isSelected()) { // V�rification de l'�tat de la checkBox
				lesCouleurs.getChildren().remove(cb); // suppression de la CheckBox si celle-ci est selectionn�e
				listColorSupCb.add(cb);// ajout de celle-ci � la liste des couleurs � supprimer dans liste des CheckBox
				listColorSup.add(listNewsColors.get(i));// ainsi que dans la liste des Couleurs de type Couleur
			}
			i++;

		}
		listNewsColorsCb.removeAll(listColorSupCb);// Suppression des couleurs � supprimer dans la liste des Nouvelles Couleurs (CheckBox )
		listNewsColors.removeAll(listColorSup); //Suppression des couleurs � supprimer dans la liste des Nouvelles Couleurs (Couleur )
		//System.out.println(listNewsColors + "\n" + listNewsColorsCb);

	}

	public void lancerEx() throws IOException { // m�thode pour lancer un exercice

		int i = 0;

		for (CheckBox cb1 : listColorsBaseCb) { // Parcours de la liste ( checkBox) des couleurs Basiques et v�rification de l'�tat
			if (cb1.isSelected()) {

				listSelection.add(listColorsBase.get(i)); // ajout � la liste des couleurs selectionn�es
			}
			i++;
		}

		System.out.println(listSelection);

		int j = 0;
		for (CheckBox cb2 : listNewsColorsCb) { // Parcours de la liste ( checkBox) des Nouvelles couleurs et v�rification de l'�tat
			if (cb2.isSelected()) {

				listSelection.add(listNewsColors.get(j));// ajout � la liste des couleurs selectionn�es
			}
			j++;

		}
// Lancement de l'interface de l'exercice
		FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("../ex/InterfaceEx.fxml"));
		BorderPane root = rootLoader.load();

		Scene scene = new Scene(root, 900, 900);
		// scene.getStylesheets().add(getClass().getResource("application/application.css").toExternalForm());

		Main.myPrimaryStage.setScene(scene);
		Main.myPrimaryStage.show();

	}

	public void disposer() { // m�thode permettant de choisir la disposition 

		Hb1.getChildren().clear(); //
		Hb2.getChildren().clear();//
		Hb3.getChildren().clear();//   "Nettoyage" de toutes les Hbox
		Hb4.getChildren().clear();//
		Hb5.getChildren().clear();//
		slideV.valueProperty().addListener((obs, oldval, newVal) -> slideV.setValue(newVal.intValue())); // Arrondissement de la valeur du Slider Vertical � un entier
		slideH.valueProperty().addListener((obs, oldval, newVal) -> slideH.setValue(newVal.intValue()));// m�me chose pour le slider Horizontal

		colonnes = (int) slideH.getValue(); // r�cup�ration du nombres de colonnes voulues par l'utilisateur
		lignes = (int) slideV.getValue(); // m�me chose pour les lignes
		
		
		for (int i = 1; i < lignes + 1; i++) { // donne un aper�u avec des points de la disposition
			for (int j = 1; j < colonnes + 1; j++) {
				Label point= new Label("�");
				point.setPadding(new Insets(0,0,0,30));
				point.setFont(Font.font(policeSelect, 20));
				point.setAlignment(Pos.BOTTOM_LEFT);
				//point.setMaxHeight(5);
				switch (i) {
				case 1:
					Hb5.getChildren().add(point);
					break;
				case 2:
					Hb4.getChildren().add(point);
					;
					break;
				case 3:
					Hb3.getChildren().add(point);
					;
					break;
				case 4:
					Hb2.getChildren().add(point);
					;
					break;
				default:
					Hb1.getChildren().add(point);
					;
				}

			}
		}

	
// getters & setters
	}

	public VBox getLesCouleurs() {
		return lesCouleurs;
	}

	public void setLesCouleurs(VBox lesCouleurs) {
		this.lesCouleurs = lesCouleurs;
	}

	public void recherchePolice() {

		policeSelect = lesPolices.getValue().getText();
		System.out.println(policeSelect);
		apercu.setFont(Font.font(policeSelect));
	}

	public void choisirPourcent() {
		pourcentageSelect= pourcentage.getValue();
		pourcentageIndic.setProgress(pourcentageSelect/100);
	
		System.out.println(pourcentageSelect);
		

	}

	

	public static ArrayList<Couleur> getListSelection() {
		return listSelection;
	}

	public static void setListSelection(ArrayList<Couleur> listSelection) {
		MainControllersParametres.listSelection = listSelection;
	}

	public static int getLignes() {
		return lignes;
	}

	public static void setLignes(int lignes) {
		MainControllersParametres.lignes = lignes;
	}

	public static int getColonnes() {
		return colonnes;
	}

	public static void setColonnes(int colonnes) {
		MainControllersParametres.colonnes = colonnes;
	}
}
