package aquarium3.metier.poisson;

import aquarium3.metier.vecteur.Vecteur;

/**
 * Classe PoissonSuiveur
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonSuiveur extends Poisson
{
	private Poisson cible;

	/**
	 * Créé un poisson avec une position, une vitesse et un poisson a poursuivre
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 * @param cible    le poisson qu'il poursuit
	 */
	public PoissonSuiveur(Vecteur position, Vecteur vitesse, Poisson cible)
	{
		super(position, vitesse);
		this.cible = cible;
	}

	/**
	 * Retourne le vecteur acceleration qui rapprochera
	 * le poisson courant de sa cible
	 * @param autre la cible du poisson
	 * @return le vecteur acceleration
	 */
	public Vecteur calcAcceleration(Poisson autre)
	{
		int x = 0, y = 0;
		if (this.getElement().posX() < autre.getElement().posX()) x = 1;
		if (this.getElement().posX() > autre.getElement().posX()) x = -1;
		if (this.getElement().posY() < autre.getElement().posY()) y = 1;
		if (this.getElement().posY() > autre.getElement().posY()) y = -1;

		return new Vecteur(x, y);
	}

	@Override
	public void avancer()
	{
		ajouterAccel(calcAcceleration(this.cible));
		super.avancer();
	}
}
