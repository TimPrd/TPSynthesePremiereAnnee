package aquarium5.metier.poisson;

import aquarium5.metier.vecteur.Vecteur;

/**
 * Classe PoissonSuiveurForce
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonSuiveurForce extends PoissonSuiveur
{
	private Vecteur force;

	/**
	 * Créé un poisson avec une position, une vitesse, un poisson a poursuivre et une force
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 * @param cible    le poisson qu'il poursuit
	 * @param force    le vecteur force qui attire le poisson
	 */
	public PoissonSuiveurForce(Vecteur position, Vecteur vitesse,int angleVision, int distVision, Poisson cible, Vecteur force)
	{
		super(position, vitesse, angleVision, distVision, cible);
		this.force = force;
	}

	@Override
	public void avancer() {
		ajouterAccel(this.force);
		super.avancer();
	}
}
