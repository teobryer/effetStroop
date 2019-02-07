package effetstroop.application;

import javafx.scene.paint.Color;

public class Couleur {
private Color couleurApercu;
private String couleurNom;


public Couleur(Color couleurApercu, String couleurNom) {
	super();
	this.couleurApercu = couleurApercu;
	this.couleurNom = couleurNom;
}


public Color getCouleurApercu() {
	return couleurApercu;
}


public String getCouleurNom() {
	return couleurNom;
}


public void setCouleurApercu(Color couleurApercu) {
	this.couleurApercu = couleurApercu;
}


public void setCouleurNom(String couleurNom) {
	this.couleurNom = couleurNom;
}


}
