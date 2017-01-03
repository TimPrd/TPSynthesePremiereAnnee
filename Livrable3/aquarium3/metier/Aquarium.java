package aquarium3.metier;

import aquarium3.metier.poisson.Poisson;
import aquarium3.metier.poisson.PoissonForce;
import aquarium3.metier.poisson.PoissonSuiveur;
import aquarium3.metier.vecteur.IPosition;
import aquarium3.metier.vecteur.Vecteur;

import java.util.ArrayList;

/**
 * Classe Aquarium
 * @author Justin ALLARD, Julia MARINELLI, Timothé PARDIEU
 */

public class Aquarium
{
    private int tailleX;
    private int tailleY;
    private ArrayList<Poisson> alPoisson;

    /**
     * Créé un aquarium avec un nombre de poisson max et une taille
     * @param nbPoisson le nombre max de poisson
     * @param tailleX la taille en x
     * @param tailleY la taille en y
     */
    public Aquarium(int nbPoisson, int tailleX, int tailleY)
    {
        this.tailleX = tailleX;
        this.tailleY = tailleY;

        this.alPoisson = new ArrayList<Poisson>();
        for (int i = 0; i < nbPoisson; i++)
        {
            int rnd1 = genAlea(tailleX, 1);
            int rnd2 = genAlea(tailleY, 1);
            int rnd3 = genAlea(5, 1);
            int rnd4 = genAlea(5, 1);

            Vecteur v1 = new Vecteur(rnd1, rnd2, 0, 0, tailleX, tailleY);
            Vecteur v2 = new Vecteur(rnd3, rnd4);

            if (i == 0) this.alPoisson.add(new Poisson(v1, v2));
            //else        this.alPoisson.add(new PoissonForce(v1, v2, Vecteur.AIR));
            else        this.alPoisson.add(new PoissonSuiveur(v1, v2, alPoisson.get(0)));
        }
    }

    /**
     * Fait avancer tous les poissons de l'aquarium
     */
    public void avancer()
    {
        for (Poisson p : alPoisson) p.avancer();
    }

    /**
     * Genere un nombre aleatoire compris entre un minimum(inclus) et un maximum(exclus)
     * @param max borne maximale
     * @param min borne minimale
     * @return nombre aleatoire
     */
    public int genAlea(int max, int min)
    {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Permet de connaitre la taille sur l'axe des abscisses
     * @return tailleX
     */
    public int getTailleX()
    {
        return this.tailleX;
    }

    /**
     * Permet de connaitre la taille sur l'axe des ordonnés
     * @return tailleY
     */
    public int getTailleY()
    {
        return this.tailleY;
    }

    /**
     * Permet de connaitre le nombre de poissons dans l'aquarium
     * @return le nombre de poissons
     */
    public int getNombrePoisson()
    {
        return this.alPoisson.size();
    }

    /**
     * Retourne le vecteur position d'un poisson
     * @param i l'indice du poisson
     * @return le vecteur position du poisson
     */
    public IPosition getPoissonPosition(int i)
    {
        return this.alPoisson.get(i).getElement();
    }
}
