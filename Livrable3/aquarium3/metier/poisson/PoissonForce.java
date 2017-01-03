package aquarium3.metier.poisson;

import aquarium3.metier.vecteur.Vecteur;

/**
 * Classe PoissonForce
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonForce extends Poisson
{
	private Vecteur force;


	/**
	 * Créé un poisson avec une position, une vitesse et une force
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 * @param force    le vecteur force qui attire le poisson
	 */
	public PoissonForce(Vecteur position, Vecteur vitesse, Vecteur force)
	{
		super(position, vitesse);
		this.force = force;
	}

	@Override
	public void avancer()
	{
		ajouterAccel(this.force);
		super.avancer();
	}
}
