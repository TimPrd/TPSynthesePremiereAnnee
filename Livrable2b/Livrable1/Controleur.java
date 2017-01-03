/**
 * Classe contrôleur qui fait la liaison entre la partie métier et l'IHM
 * @author Bruno LEGRIX et Philippe LE PIVERT
 * @version 2016-04-26
 */

public class Controleur
{

	// ATTRIBUTS
	private Vecteur position        ; // ça devrait être là ?
	private Vecteur vitesse         ; // ça devrait être là ?
	private int     tailleX, tailleY; // ça devrait être là ?
	private Fenetre fenetre         ;
	
	// CONSTRUCTEURS
	public Controleur()
	{
		this.tailleX  = 500; // taille horizontale de l'aquarium
		this.tailleY  = 500; // taille verticale   de l'aquarium
		this.position = new Vecteur(400,400,0   ,0   ,this.tailleX,this.tailleY);
		         // arguments :    (  x,  y,xMin,yMin,        xMax,        yMax)
		this.vitesse  = new Vecteur( 3 , 2 );
		         // arguments :    ( x,  y ), pas de xMin,yMin,xMax,yMax
		this.fenetre  = new Fenetre(this);
	}

	public void lancer()
	{
		for(int i=0; i<10000; i++)
		{
			this.avancer();
			this.fenetre.majIHM();

			try {Thread.sleep(50);} catch(InterruptedException e){e.printStackTrace();}
		}
	}

	// ACCESSEURS
	/**
	 * Permet de donner la taille horizontale.
	 * @return la taille en nombre de pixels.
	 */
	public int     getTailleX()      {return this.tailleX                 ;}

	/**
	 * Permet de donner la taille verticale.
	 * @return la taille en nombre de pixels.
	 */
	public int     getTailleY()      {return this.tailleY                 ;}

	/**
	 * Permet de donner le nombre d'élements.
	 * @return le nombre d'élements.
	 */
	public int     getNombreElement(){return 1                            ;}

	/**
	 * Retourne l'élément d'indice i.
	 * @param i l'indice de l'élement qu'on souhaite.
	 * @return  la position du poisson.
	 */
	public IPosition getElement (int i) {return this.position;}

	// METHODES
	/**
	 * Méthode qui fait avancer l'élément.
	 */
	public void avancer()
	{
		this.position.ajouterVitesse(this.vitesse);
	}

	/**
	 * Méthode principale.
	 */
	public static void main(String[] arg)
	{
		Controleur ctrl = new Controleur();

		ctrl.lancer();
	}

}
