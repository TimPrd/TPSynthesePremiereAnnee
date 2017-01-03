package aquarium5.metier.poisson;

import aquarium5.metier.vecteur.Vecteur;

/**
 * Classe PoissonForce
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public abstract class PoissonForce extends Poisson
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
		super(position, vitesse, -1, -1);
		this.force = force;
	}

	@Override
	public void avancer()
	{
		ajouterAccel(this.force);
		super.avancer();
	}

}
