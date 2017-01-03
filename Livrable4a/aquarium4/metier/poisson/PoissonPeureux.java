package aquarium4.metier.poisson;

import aquarium4.metier.vecteur.Vecteur;

/**
 * Classe PoissonPeureux
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonPeureux extends Poisson
{
	private Poisson predateur;

	/**
	 * Créé un poisson avec une position, une vitesse et un poisson a fuir
	 *
	 * @param position     son vecteur position
	 * @param vitesse      son vecteur vitesse
	 * @param predateur    le poisson qu'il cherche a fuir
	 */
	public PoissonPeureux(Vecteur position, Vecteur vitesse, Poisson predateur)
	{
		super(position, vitesse);
		this.predateur = predateur;
	}

	@Override
	public void avancer()
	{
		int x = this.getElement().posX() - this.predateur.getElement().posX();
		int y = this.getElement().posY() - this.predateur.getElement().posY();
		Vecteur distance = new Vecteur(x, y);

		if (distance.getNorme() < 100) ajouterAccel(distance.normaliser().multiplier(3));
		super.avancer();
	}
}
