package principal;

import element.Velomar;
import element.Ombrella;
import element.Hamaca;
import element.Encarregat;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Platja {

    private String coordenades;
    private String nom;
    private Velomar velomars[];
    private Ombrella ombrelles[];
    private static Hamaca hamaques[];
    private Encarregat encarregats[];
    private static Zona zones[];

    public Platja(String pCoordenades, String pNom) {
        coordenades = pCoordenades;
        nom = pNom;
        velomars = new Velomar[50];
        ombrelles = new Ombrella[200];
        hamaques = new Hamaca[800];
        encarregats = new Encarregat[30];
        zones = new Zona[10];
    }

    /*
     Mètodes accessors.
     */
    public String getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(String pCoordenades) {
        coordenades = pCoordenades;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public Velomar[] getVelomars() {
        return velomars;
    }

    public void setVelomars(Velomar[] pVelomars) {
        velomars = pVelomars;
    }

    public Ombrella[] getOmbrelles() {
        return ombrelles;
    }

    public void setOmbrelles(Ombrella[] pOmbrelles) {
        ombrelles = pOmbrelles;
    }

    public Hamaca[] getHamaques() {
        return hamaques;
    }

    public void setHamaca(Hamaca[] pHamaques) {
        hamaques = pHamaques;
    }

    public Encarregat[] getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(Encarregat[] pEncarregats) {
        encarregats = pEncarregats;
    }

    public Zona[] getZones() {
        return zones;
    }

    public void setZones(Zona[] pZones) {
        zones = pZones;
    }

    public static Platja novaPlatja() {
        Scanner dades = new Scanner(System.in);
        String coordenadesNoves;
        String nomNou;

        System.out.println("Coordenades de la platja:");
        coordenadesNoves = dades.next();
        dades.nextLine();
        System.out.println("Nom de la platja:");
        nomNou = dades.nextLine();

        return new Platja(coordenadesNoves, nomNou);
    }

    public void modificarPlatja() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nNom de la  platja: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = dades.nextLine();
    }

    public void mostrarPlatja() {
        System.out.println("\nLes dades de la platja amb nom " + nom + " i coordenades " + coordenades + " són:");

        System.out.println("\nZones:");
        for (int i = 0; i < zones.length; i++) {
            if (zones[i] != null) {
                zones[i].mostrarZona();
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

        System.out.println("\nHamaques:");
        for (int i = 0; i < hamaques.length; i++) {
            if (hamaques[i] != null) {
                hamaques[i].mostrarHamaca();
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
     VELOMAR
     */
    public void afegirVelomar() {
        boolean trobat = false;
        for (int i = 0; i < velomars.length && !trobat; i++) {
            if (velomars[i] == null) {
                velomars[i] = Velomar.nouVelomar();
                trobat = true;
            }
        }
    }

    public void treureVelomar() {
        int pos = seleccionarVelomar();

        if (pos != -1) {
            velomars[pos] = null;
        } else {
            System.out.println("El velomar no és d'aquesta platja.");
        }
    }

    public int seleccionarVelomar() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi del velomar?:");
        int codi = dades.nextInt();
        int pos = -1;
        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i] != null && velomars[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    /*
    OMBREL.LA
     */
    public void afegirOmbrella() {
        boolean trobat = false;
        for (int i = 0; i < ombrelles.length && !trobat; i++) {
            if (ombrelles[i] == null) {
                ombrelles[i] = Ombrella.novaOmbrella();
                trobat = true;
            }
        }
    }

    public void treureOmbrella() {
        int pos = seleccionarOmbrella();

        if (pos != -1) {
            ombrelles[pos] = null;
        } else {
            System.out.println("L'ombrel.la no és d'aquesta platja.");
        }
    }

    public int seleccionarOmbrella() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi de l'Ombrella?:");
        int codi = dades.nextInt();
        int pos = -1;
        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i] != null && ombrelles[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    /*
    HAMACA
     */
    public void afegirHamaca() {
        boolean trobat = false;
        for (int i = 0; i < hamaques.length && !trobat; i++) {
            if (hamaques[i] == null) {
                hamaques[i] = Hamaca.novaHamaca();
                trobat = true;
            }
        }
    }

    public void treureHamaca() {
        int pos = seleccionarHamaca();

        if (pos != -1) {
            hamaques[pos] = null;
        } else {
            System.out.println("L'hamaca no és d'aquesta platja.");
        }
    }

    public int seleccionarHamaca() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi de l'hamaca?:");
        int codi = dades.nextInt();
        int pos = -1;
        for (int i = 0; i < hamaques.length; i++) {
            if (hamaques[i] != null && hamaques[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    /*
    ZONA
     */
    public void afegirZona() {
        boolean trobat = false;
        int pos = seleccionarZona();

        if (pos == -1) {
            for (int i = 0; i < zones.length && !trobat; i++) {
                if (zones[i] == null) {
                    zones[i] = Zona.novaZona(null);
                    trobat = true;
                }
            }
        } else {
            System.out.println("La zona ja està assignada a la platja");
        }

    }

    public void treureZona() {
        int pos = seleccionarZona();

        if (pos != -1) {
            zones[pos] = null;
        } else {
            System.out.println("La zona no és d'aquesta platja.");
        }
    }

    public int seleccionarZona() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi de la zona?:");
        String codi = dades.next();
        int pos = -1;
        for (int i = 0; i < zones.length; i++) {
            if (zones[i] != null && zones[i].getCodi().equals(codi)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    /*
    ENCARREGAT
     */
    public void afegirEncarregat(String dni) {
        boolean trobat = false;
        int pos = seleccionarEncarregat();

        if (pos == -1) {
            for (int i = 0; i < encarregats.length && !trobat; i++) {
                if (encarregats[i] == null) {
                    encarregats[i] = Encarregat.nouEncarregat(dni);
                    trobat = true;
                }
            }
        } else {
            System.out.println("L'encarregat ja està assignat a la platja");
        }

    }

    public void treureEncarregat() {
        int pos = seleccionarEncarregat();

        if (pos != -1) {
            encarregats[pos] = null;
        } else {
            System.out.println("L'encarregat no és d'aquesta platja.");
        }
    }

    public int seleccionarEncarregat() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nDNI de l'encarregat?:");
        String dni = dades.next();
        int pos = -1;
        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i] != null && encarregats[i].getDni().equals(dni)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }
}
