package element;

import element.Hamaca;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Ombrella {

    private int codi;
    private static int properCodi = 0;
    private String dataAlta;
    private Hamaca[] hamaques;
    private boolean llogat;

    public Ombrella(String pDataAlta) {
        codi = properCodi;
        properCodi++;
        hamaques = new Hamaca[4];
        dataAlta = pDataAlta;
        llogat = false;
    }

    /*
     Mètodes accessors.
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi++;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String pDataAlta) {
        dataAlta = pDataAlta;
    }

    public Hamaca[] getHamaques() {
        return hamaques;
    }

    public void setHamaques(Hamaca[] pHamaques) {
        hamaques = pHamaques;
    }

    public boolean getLLogat() {
        return llogat;
    }

    public void setLlogat(boolean pLlogat) {
        llogat = pLlogat;
    }

    public static Ombrella novaOmbrella() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'ombrel.la:");

        return new Ombrella(dades.next());
    }

    public void modificarOmbrella() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta de l'ombrel.la: " + dataAlta);
        System.out.println("\nEntra la nova data d'alta:");
        dataAlta = dades.next();
        modificarEstatLloguer();
    }

    public void mostrarOmbrella() {
        System.out.println("\nLes dades de l'ombrel.la amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);
        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }

        for (int i = 0; i < hamaques.length && hamaques != null; i++) {
            if (hamaques[i] != null) {
                hamaques[i].mostrarHamaca();
            }
        }
    }

    public void afegirHamaca(Hamaca hamaca) {
        boolean trobat = false;
        //Afegim l'hamaca en el primer espai buit del vector
        for (int i = 0; i < hamaques.length && !trobat; i++) {
            if (hamaques[i] == null) { //Espai buit
                hamaques[i] = hamaca;
                hamaques[i].setLlogat(true);
                trobat = true;
            }
        }
    }

    public void treureHamaca(Hamaca hamaca) {
        boolean trobat = false;

        //Treiem l'hamaca
        for (int i = 0; i < hamaques.length && !trobat; i++) {
            if (hamaques[i].equals(hamaca)) { //Trobat
                hamaques[i] = null;
                hamaques[i].setLlogat(false);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("L'hamaca no està en el llistat");
        }

    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogada o 1 si està llogada)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    llogat = true;
                    break;
                case 1:
                    llogat = false;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);
    }
}
