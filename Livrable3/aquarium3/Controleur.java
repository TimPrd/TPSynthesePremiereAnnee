package aquarium3;

import aquarium3.ihm.Fenetre;
import aquarium3.metier.Aquarium;
import aquarium3.metier.vecteur.IPosition;

/**
 * Classe contrôleur qui fait la liaison entre la partie métier et l'IHM
 * @author Bruno LEGRIX et Philippe LE PIVERT
 * @version 2016-04-26
 */
 
public class Controleur
{

	// ATTRIBUTS
	private Aquarium aquarium        ; // oui c'est mieux !
	private Fenetre fenetre         ;
	
	// CONSTRUCTEURS
	public Controleur()
	{
		// 10 poissons dans un aquarium de 500 pixels horizontaux et 500 verticaux
		this.aquarium = new Aquarium(10,500,500); 
		this.fenetre  = new Fenetre(this);
	}

	public void lancer()
	{
		for(int i=0; i<10000; i++)
		{
			this.avancer();
			this.fenetre.majIHM();

			try {Thread.sleep(50);} catch(InterruptedException e){e.printStackTrace();}
		}
	}

	// ACCESSEURS
	/**
	 * Permet de donner la taille horizontale.
	 * @return la taille en nombre de pixels.
	 */
	public int     getTailleX()      {return this.aquarium.getTailleX      ();}

	/**
	 * Permet de donner la taille verticale.
	 * @return la taille en nombre de pixels.
	 */
	public int     getTailleY()      {return this.aquarium.getTailleY      ();}

	/**
	 * Permet de donner le nombre d'élements.
	 * @return le nombre d'élements.
	 */
	public int     getNombreElement(){return this.aquarium.getNombrePoisson();}

	/**
	 * Retourne l'élément d'indice i.
	 * @param i l'indice de l'élement qu'on souhaite.
	 * @return  la position du poisson.
	 */
	public IPosition getElement (int i) {return this.aquarium.getPoissonPosition(i);}

	// METHODES
	/**
	 * Méthode qui fait avancer l'ensemble des poissons de l'aquarium.
	 */
	public void avancer()
	{
		this.aquarium.avancer();
	}

	/**
	 * Méthode principale.
	 * @param arg peut contenir le nom d'un fichier de définition d'aquarium.
	 */
	public static void main(String[] arg)
	{
		Controleur ctrl = new Controleur();

		ctrl.lancer();
	}

}

