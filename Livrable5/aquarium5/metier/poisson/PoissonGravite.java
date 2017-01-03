package aquarium5.metier.poisson;

import aquarium5.metier.vecteur.Vecteur;

public class PoissonGravite extends PoissonForce
{
    /**
     * Créé un poisson avec une position, une vitesse et une force
     *
     * @param position son vecteur position
     * @param vitesse  son vecteur vitesse
     */
    public PoissonGravite(Vecteur position, Vecteur vitesse)
    {
        super(position, vitesse, Vecteur.SOL);
    }
}
