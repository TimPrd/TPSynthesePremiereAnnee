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
		Vecteur tmp = new Vecteur(this.vitesse).ajouter(accel);
		if(tmp.getNorme() < Poisson.VITESSE_MAX)
			this.vitesse.ajouter(accel);
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
