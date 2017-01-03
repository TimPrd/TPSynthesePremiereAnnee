import javax.swing.*;
import java.awt.*;

/**
 * Classe IHM Fenetre qui gère la fenêtre GUI
 * @author Bruno LEGRIX et Philippe LE PIVERT
 * @version 2016-04-26
 */

class Fenetre extends JFrame
{
	// ATTRIBUTS
	private Controleur ctrl;
	private Plateau    plateau;

	// CONSTRUCTEUR
	/**
	 * Construit une fenêtre avec un plateau où sera affiché les éléments.
	 * @param ctrl est le contrôleur qui va faire le lien 
	 * entre la partie métier et la partie IHM.
	 */
	public Fenetre(Controleur ctrl)
	{
		this.ctrl    = ctrl             ;
		this.plateau = new Plateau(ctrl);

		this.setTitle("Mon aquarium");                       // titre de la fenêtre
		this.setSize(ctrl.getTailleX(),ctrl.getTailleY());   // taille de la fenêtre
		this.setLocationRelativeTo(null);                    // fenêtre centrée à l'écran
		this.add(this.plateau,BorderLayout.CENTER);          // on rajoute le panneau
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on peut fermer la fenêtre
		this.pack();                                         // pour utiliser PreferredSize
		this.setVisible(true);                               // fenêtre visible
	}

	/**
	 * Fait la mise à jour de l'IHM.
	 */
	public void majIHM()
	{
		this.plateau.repaint();
	}

}

