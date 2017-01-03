package aquarium5.metier;

import aquarium5.metier.poisson.*;
import aquarium5.metier.vecteur.IPosition;
import aquarium5.metier.vecteur.Vecteur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
     *
     */
    public Aquarium(String fileName)
    {
        this.alPoisson = new ArrayList<Poisson>();
        lecture(fileName);

        for (Poisson p : alPoisson)
        {
            if (p instanceof PoissonPeureux) ((PoissonPeureux) p).setPredateurs(this.alPoisson);
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
     * Permet de connaitre la taille sur l'axe des abscisses
     *
     * @return tailleX
     */
    public int getTailleX()
    {
        return this.tailleX;
    }

    /**
     * Permet de connaitre la taille sur l'axe des ordonnés
     *
     * @return tailleY
     */
    public int getTailleY()
    {
        return this.tailleY;
    }

    /**
     * Permet de connaitre le nombre de poissons dans l'aquarium
     *
     * @return le nombre de poissons
     */
    public int getNombrePoisson()
    {
        return this.alPoisson.size();
    }

    /**
     * Retourne le vecteur position d'un poisson
     *
     * @param i l'indice du poisson
     * @return le vecteur position du poisson
     */
    public IPosition getPoissonPosition(int i)
    {
        return this.alPoisson.get(i).getElement();
    }

    public String getCible(String quiS)
    {
        if (quiS.equals("normal"))         quiS = "Poisson";
        if (quiS.equals("air"))            quiS = "PoissonAir";
        if (quiS.equals("gravite"))        quiS = "PoissonGravite";
        if (quiS.equals("peureux"))        quiS = "PoissonPeureux";
        if (quiS.equals("suiveur"))        quiS = "PoissonSuiveur";
        if (quiS.equals("suiveurGravite")) quiS = "PoissonSuiveurGravite";
        return quiS;
    }

    /**
     * Ajoute les poissons d'un fichier texte dans l'aquarium
     * @param fileName fichier a lire
     */
    public void lecture(String fileName)
    {
        Scanner scPoisson;
        int x, y, vx, vy;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line;

            int cpt = 0;
            while ((line = in.readLine()) != null)
            {
                scPoisson = new Scanner(line);
                if (cpt == 0)
                {
                    this.tailleX = scPoisson.nextInt();
                    this.tailleY = scPoisson.nextInt();
                }

                if (cpt > 1) {
                    String typePoisson = scPoisson.next();
                    String quiS = null;
                    int quiI = -1;
                    int vueDist = -1;
                    int vueAngl = -1;

                    x = scPoisson.nextInt();
                    y = scPoisson.nextInt();
                    Vecteur v1 = new Vecteur(x, y, 0, 0, tailleX, tailleY);

                    vx = scPoisson.nextInt();
                    vy = scPoisson.nextInt();
                    Vecteur v2 = new Vecteur(vx, vy);

                    if (typePoisson.equals("peureux")) {
                        if (scPoisson.hasNextInt()) quiI = scPoisson.nextInt();
                        else if (scPoisson.hasNext()) quiS = scPoisson.next();
                    }
                    if (scPoisson.hasNextInt()){
                        vueDist = scPoisson.nextInt();
                        vueAngl = scPoisson.nextInt();
                    }

                    if (typePoisson.equals("normal")) this.alPoisson.add(new Poisson(v1, v2, vueDist, vueAngl));


                    if (typePoisson.equals("peureux"))
                    {
                        if (quiI == -1)
                        {
                            getCible(quiS);
                            this.alPoisson.add(new PoissonPeureux(v1, v2, vueDist, vueAngl, quiS));
                        }
                        else this.alPoisson.add(new PoissonPeureux(v1, v2,vueDist, vueAngl, quiI));
                    }

                    if (typePoisson.equals("suiveur")) this.alPoisson.add(new PoissonSuiveur(v1, v2,vueDist, vueAngl, alPoisson.get(quiI)));

                    if (typePoisson.equals("suiveurGravite")) this.alPoisson.add(new PoissonSuiveur(v1, v2,vueDist, vueAngl, alPoisson.get(quiI)));

                }
                cpt++;
            }



        } catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}