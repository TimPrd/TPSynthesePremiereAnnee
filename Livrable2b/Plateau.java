import javax.swing.*;
import java.awt.*;

/**
 * Classe IHM Plateau qui gère le plateau qui est 
 * la représentation graphique de l'aquarium.
 * @author Bruno LEGRIX et Philippe LE PIVERT
 * @version 2016-04-26
 */

class Plateau extends JPanel
{
	// ATTRIBUTS
	private Controleur ctrl;

	// CONSTRUCTEUR
	/**
	 * Construit un plateau où sera affiché un aquarium.
	 * @param ctrl est le contrôleur qui va faire le lien 
	 * entre la partie métier et la partie IHM.
	 */
	public Plateau(Controleur ctrl)
	{
		this.ctrl = ctrl;
		Dimension dim = new Dimension(ctrl.getTailleX(), ctrl.getTailleY());
		this.setPreferredSize( dim        );
		this.setBackground   ( Color.BLUE );
	}

	// METHODE
	/**
	 * Quand le plateau se rafraîchit,
	 * on affiche chaque poisson sous la forme d'un disque de couleur selon le type.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for(int i=0; i<this.ctrl.getNombreElement(); i++)
		{
			IPosition pos = this.ctrl.getElement(i);
			if(i == 0) g.setColor(Color.RED);
			else       g.setColor(Color.WHITE);
			g.fillOval(pos.posX(),pos.posY(),5,5);
		}
	}

}
