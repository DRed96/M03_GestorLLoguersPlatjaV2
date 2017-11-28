package principal;

import element.Velomar;
import element.Ombrella;
import element.Lloguer;
import element.Encarregat;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Zona {

    private String codi;
    private Lloguer lloguers[];
    private static int indexLloguers = 0;
    private Velomar velomars[];
    private Ombrella ombrelles[];
    private Encarregat encarregats[];

    public Zona(String pCodi) {
        codi = pCodi;
        lloguers = new Lloguer[300];
        velomars = new Velomar[5];
        ombrelles = new Ombrella[20];
        encarregats = new Encarregat[3];
    }

    /*
     Mètodes accessors.
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public Lloguer[] getLloguers() {
        return lloguers;
    }

    public void setLloguers(Lloguer[] pLloguers) {
        lloguers = pLloguers;
    }

    public int getIndexLloguers() {
        return indexLloguers;
    }

    public void setIndexLloguers(int pIndexLloguers) {
        indexLloguers = pIndexLloguers;
    }

    public Velomar[] getVelomars() {
        return velomars;
    }

    public void setVelomars(Velomar[] velomars) {
        this.velomars = velomars;
    }

    public Ombrella[] getOmbrelles() {
        return ombrelles;
    }

    public void setOmbrelles(Ombrella[] ombrelles) {
        this.ombrelles = ombrelles;
    }

    public Encarregat[] getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(Encarregat[] encarregats) {
        this.encarregats = encarregats;
    }

    public static Zona novaZona() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Codi de la zona:");

        return new Zona(dades.next());
    }

    public void mostrarZona() {
        System.out.println("\nLes dades de la zona amb codi " + codi + " són:");

        System.out.println("\nLloguers:");
        for (int i = 0; i < lloguers.length; i++) {
            if (lloguers[i] != null) {
                lloguers[i].mostrarLloguer();
            }
        }

        System.out.println("\nOmbrel.les:");
        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i] != null) {
                ombrelles[i].mostrarOmbrella();
            }
        }

        System.out.println("\nVelomars:");
        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i] != null) {
                velomars[i].mostrarVelomar();
            }
        }

        System.out.println("\nEncarregats:");
        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i] != null) {
                encarregats[i].mostrarEncarregat();
            }
        }
    }

    /*
     LLOGUERS
     */
    public void afegirLloguer(Lloguer lloguer) {
        lloguers[indexLloguers] = lloguer;
        indexLloguers++;
    }

    public void tancarLloguer() {
        boolean trobat = false;

        int pos = seleccionarLloguer();

        if (pos != -1) {
            for (int i = 0; i < velomars.length; i++) {
                if (velomars[i] != null && velomars[i].getCodi() == lloguers[pos].getIdElementLloguer()) {
                    velomars[i].setLlogat(false);
                    trobat = true;
                }
            }

            if (!trobat) {
                for (int i = 0; i < ombrelles.length; i++) {
                    if (ombrelles[i] != null && ombrelles[i].getCodi() == lloguers[pos].getIdElementLloguer()) {
                        ombrelles[i].setLlogat(false);

                        for (int j = 0; j < ombrelles[i].getHamaques().length; j++) {
                            if (ombrelles[i].getHamaques()[j] != null) {
                                ombrelles[i].getHamaques()[j].setLlogat(false);
                            }
                        }

                        trobat = true;
                    }
                }
            }
        }else{
            System.out.println("\nEl lloguer no existeix");
        }
    }

    public int seleccionarLloguer() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi del lloguer?:");
        int codi = dades.nextInt();

        int pos = -1;

        for (int i = 0; i < indexLloguers; i++) {
            if (lloguers[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     VELOMAR
     */
    public void afegirVelomar(Velomar velomar) {
        boolean trobat = false;

        for (int i = 0; i < velomars.length && !trobat; i++) {
            if (velomars[i] == null) {
                velomars[i] = velomar;
                trobat = true;
            }
        }

    }

    public void treureVelomar(int codi) {
        boolean trobat = false;

        for (int i = 0; i < velomars.length && !trobat; i++) {
            if (velomars[i] != null && velomars[i].getCodi() == codi) {
                velomars[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarVelomar(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi del velomar?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i] != null && velomars[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     ENCARREGAT
     */
    public void afegirEncarregat(Encarregat encarregat) {
        boolean trobat = false;

        for (int i = 0; i < encarregats.length && !trobat; i++) {
            if (encarregats[i] == null) {
                encarregats[i] = encarregat;
                trobat = true;
            }
        }

    }

    public void treureEncarregat(String dni) {
        boolean trobat = false;

        for (int i = 0; i < encarregats.length && !trobat; i++) {
            if (encarregats[i] != null && encarregats[i].getDni().equals(dni)) {
                encarregats[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarEncarregat(String dni) {
        int pos = -1;

        if (dni == null) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nDni de l'encarregat?:");
            dni = dades.next();
        }

        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i] != null && encarregats[i].getDni().equals(dni)) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     OMBRELLA
     */
    public void afegirOmbrella(Ombrella ombrella) {
        boolean trobat = false;

        for (int i = 0; i < ombrelles.length && !trobat; i++) {
            if (ombrelles[i] == null) {
                ombrelles[i] = ombrella;
                trobat = true;
            }
        }

    }

    public void treureOmbrella(int codi) {
        boolean trobat = false;

        for (int i = 0; i < ombrelles.length && !trobat; i++) {
            if (ombrelles[i] != null && ombrelles[i].getCodi() == codi) {
                ombrelles[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarOmbrella(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi de l'ombrel.la?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i] != null && ombrelles[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

}
