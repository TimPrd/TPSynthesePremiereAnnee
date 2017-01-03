package aquarium4.metier.poisson;

import aquarium4.metier.vecteur.Vecteur;
import java.lang.*;
import java.util.ArrayList;

/**
 * Classe PoissonPeureux
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class PoissonPeureux extends Poisson
{
	private String typePredateur;
	private int    predateur;
	private ArrayList<Poisson> alPredateur;

	/**
	 * Créé un poisson avec une position, une vitesse et un poisson a fuir
	 *
	 * @param position      son vecteur position
	 * @param vitesse       son vecteur vitesse
	 * @param typePredateur le type de poisson qu'il cherche a fuir
	 */
	public PoissonPeureux(Vecteur position, Vecteur vitesse, String typePredateur)
	{
		super(position, vitesse);
		this.typePredateur = typePredateur;
		this.alPredateur = new ArrayList<Poisson>();
	}

	public PoissonPeureux(Vecteur position, Vecteur vitesse, int predateur)
	{
		this(position, vitesse, null);
		this.predateur = predateur;
	}

	/**
	 * Assigne tous les poissons de l'aquarium qui corresponde au type de predateur
	 * ou au numero d'un poisson a l'arrayList de predateur du poisson courrant
	 * @param alPoisson
	 */
	public void setPredateurs(ArrayList<Poisson> alPoisson)
	{
		for(Poisson p:alPoisson)
		{
			if(this.typePredateur != null)
			{
				if (p.getClass().getSimpleName().equals(this.typePredateur))
					this.alPredateur.add(p);
			}
			else
			{
				this.alPredateur.add(alPoisson.get(this.predateur));
			}
		}
	}

	@Override
	public void avancer()
	{
		Vecteur accelTmp = new Vecteur (0, 0);
		for (Poisson p:alPredateur)
		{
			int x = this.getElement().posX() - p.getElement().posX();
			int y = this.getElement().posY() - p.getElement().posY();
			Vecteur distance = new Vecteur(x, y);
			if(distance.getNorme() < 100) accelTmp.ajouter(distance);
		}
		if(alPredateur != null) ajouterAccel(accelTmp.normaliser().multiplier(3));
		super.avancer();
	}
}
