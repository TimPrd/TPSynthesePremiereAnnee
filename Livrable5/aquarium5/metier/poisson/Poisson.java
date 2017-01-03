package aquarium5.metier.poisson;

import aquarium5.metier.vecteur.IPosition;
import aquarium5.metier.vecteur.Vecteur;

/**
 * Classe Poisson
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class Poisson
{
	public static final int VITESSE_MAX = 15;

	private Vecteur position;
	private Vecteur vitesse;
	private int angleVision;
	private int distVision;

	/**
	 * Créé un poisson avec une position et une vitesse
	 *
	 * @param position son vecteur position
	 * @param vitesse  son vecteur vitesse
	 */
	public Poisson(Vecteur position, Vecteur vitesse, int angleVision, int distVision)
	{
		this.position = position;
		this.vitesse = vitesse;
		this.angleVision = angleVision;
		this.distVision = distVision;
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
	 * Retourne le vecteur position du poisson courant
	 * @return
     */
	public Vecteur getPosition()
	{
		return this.position;
	}

	/**
	 * Retourne le vecteur vitesse du poisson courant
	 * @return
     */
	public Vecteur getVitesse() {return this.vitesse;}

	/**
	 * Retourne l'angle de vision du poisson courant
	 * @return
     */
	public int getAngleVision() {return this.angleVision;}

	/**
	 * Retourne la distance de vision du poisson courant
	 * @return
     */
	public int getDistVision() {return this.distVision;}

	/**
	 * Retourne un booleen qui indique si le poisson est visible par un autre passé en parametre
	 * @param autre
	 * @return
     */
	public boolean estVisible(Vecteur autre) {
		double distance = this.position.distance(autre);
		if (distance <= this.distVision) {
			double angle = this.vitesse.angle(autre);
			return (-angleVision/2 < angle && angle < angleVision/2);
		}
		return false;
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
