package aquarium4.metier.poisson;

import aquarium4.metier.vecteur.Vecteur;

/**
 * Classe PoissonSuiveurForce
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonSuiveurGravite extends PoissonSuiveur
{
	private Vecteur force;

	/**
	 * Créé un poisson avec une position, une vitesse, un poisson a poursuivre et une force
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 * @param cible    le poisson qu'il poursuit
	 */
	public PoissonSuiveurGravite(Vecteur position, Vecteur vitesse, Poisson cible)
	{
		super(position, vitesse, cible);
		this.force = Vecteur.SOL;
	}

	@Override
	public void avancer() {
		ajouterAccel(this.force);
		super.avancer();
	}
}
