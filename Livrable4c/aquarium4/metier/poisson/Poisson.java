package aquarium4.metier.poisson;

import aquarium4.metier.vecteur.IPosition;
import aquarium4.metier.vecteur.Vecteur;

/**
 * Classe Poisson
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class Poisson
{
	public static final int VITESSE_MAX = 15;

	private Vecteur position;
	private Vecteur vitesse;

	/**
	 * Créé un poisson avec une position et une vitesse
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 */
	public Poisson(Vecteur position, Vecteur vitesse)
	{
		this.position = position;
		this.vitesse = vitesse;
	}

	/**
	 * Fait avancer le poisson de sa vitesse
	 */
	public void avancer()
	{
		this.position.ajouterVitesse(this.vitesse);
	}

	/**
	 * Ajoute l'acceleration a la vitesse sans quelle ne dépasse la vitesse max
	 * @param accel le vecteur acceleration du poisson
	 */
	public void ajouterAccel(Vecteur accel)
	{
		this.vitesse.ajouter(accel);
		if (this.vitesse.getNorme() > Poisson.VITESSE_MAX)
			this.vitesse.normaliser().multiplier(Poisson.VITESSE_MAX);
	}

	/**
	 * Retourne la position du Poisson courant
	 * @return la position du poisson sous forme de vecteur
     */
	public IPosition getElement()
	{
		return this.position;
	}
}
