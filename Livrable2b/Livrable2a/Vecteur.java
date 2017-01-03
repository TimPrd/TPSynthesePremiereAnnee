import java.lang.Math;

/**
 * Classe Vecteur
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class Vecteur implements IPosition
{
	public static final Vecteur SOL = new Vecteur(0, 2);
	public static final Vecteur AIR = new Vecteur(0, -2);

	private double x;
	private double y;
	private int xMin;
	private int yMin;
	private int xMax;
	private int yMax;

	/**
	 * Créé un vecteur vitesse
	 * @param x la direction vers x
	 * @param y la direction vers y
     */
	public Vecteur(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Créé un vecteur position
	 * @param x la position en x
	 * @param y la position en y
	 * @param xMin la position minimale en x
	 * @param yMin la position minimale en y
	 * @param xMax la position maximale en x
     * @param yMax la position maximale en y
     */
	public Vecteur(double x, double y, int xMin, int yMin, int xMax, int yMax)
	{
		this(x, y);
		this.xMin = xMin;
		this.yMin = yMin;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * Ajoute le vecteur vitesse du poisson courant a son vecteur position
	 * @param autre le vecteur vitesse
     */
	public void ajouterVitesse(Vecteur autre)
	{
		this.x = calcPosSuiv('x', autre, this.x + autre.posX());
		this.y = calcPosSuiv('y', autre, this.y + autre.posY());
	}

	/**
	 * Retourne la prochaine postion d'une coordonée d'un point,
	 * et gere le rebond s'il est supposé sortir du plateau
	 * @param coord       la coordonée a calculer
	 * @param v           le vecteur acceleration
	 * @param calcPosSuiv la prochaine position de la coordonée
     * @return la prochaine position de la coordonée
     */
	public double calcPosSuiv(char coord, Vecteur v, double calcPosSuiv)
	{
		int vMax = 0, vMin = 0, bordure = -1;
		if (coord == 'x')
		{
			vMax = this.xMax;
			vMin = this.xMin;
		}
		if (coord == 'y')
		{
			vMax = this.yMax;
			vMin = this.yMin;
		}
		if (calcPosSuiv > vMax) bordure = vMax;
		if (calcPosSuiv < vMin) bordure = vMin;

		if (bordure >= 0)
		{
			if (coord == 'x') v.x *= -1;
			if (coord == 'y') v.y *= -1;
			calcPosSuiv = bordure * 2 - calcPosSuiv;
		}
		return calcPosSuiv;
	}

	/**
	 * Retourne le vecteur somme du vecteur courant et d'un autre vecteur
	 * @param autre autre vecteur
	 * @return le vecteur somme des deux vecteurs
     */
	public Vecteur ajouter(Vecteur autre)
	{
		this.x += autre.posX();
		this.y += autre.posY();

		return this;
	}

	/**
	 * Permet d'aggrandir ou de retrecir un vecteur
	 * @param lambda ratio?
	 * @return le vecteur produit du vecteur courant et d'un double
     */
	public Vecteur multiplier(double lambda)
	{
		this.x *= lambda;
		this.y *= lambda;

		return this;
	}

	/**
	 * Permet d'obtenir la distance entre le vecteur courant et un autre
	 * @param autre autre vecteur
	 * @return distance entre deux vecteurs
     */
	public double distance(Vecteur autre)
	{
		return Math.sqrt(Math.pow((autre.posX() - this.posX()), 2.0) + Math.pow((autre.posY() - this.posY()), 2.0));
	}

	/**
	 * Normalise un vecteur
	 * @return vecteur normalisé
     */
	public Vecteur normaliser()
	{
		this.x /= this.getNorme();
		this.y /= this.getNorme();
		return this;
	}

	/**
	 * Permet d'obtenir la taille d'un vecteur
	 * @return norme du vecteur
     */
	public double getNorme()
	{
		return Math.sqrt(Math.pow((this.x), 2.0) + Math.pow((this.y), 2.0));
	}

	/**
	 * Retourne la position minimale en x du vecteur position
	 * @return xMin
     */
	public int posXMin()
	{
		return this.xMin;
	}

	/**
	 * Retourne la position minimale en y du vecteur position
	 * @return yMin
     */
	public int posYMin()
	{
		return this.yMin;
	}

	/**
	 * Retourne la position en x du vecteur position
	 * @return x
     */
	public int posX()
	{
		return (int) this.x;
	}

	/**
	 * Retourne la position en y du vecteur position
	 * @return y
     */
	public int posY()
	{
		return (int) this.y;
	}
}
