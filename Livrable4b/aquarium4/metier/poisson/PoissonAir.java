package aquarium4.metier.poisson;

import aquarium4.metier.vecteur.Vecteur;

public class PoissonAir extends PoissonForce
{
    /**
     * Créé un poisson avec une position, une vitesse et une force
     *
     * @param position son vecteur position
     * @param vitesse  son vecteur vitesse
     */
    public PoissonAir(Vecteur position, Vecteur vitesse)
    {
        super(position, vitesse, Vecteur.AIR);
    }
}
