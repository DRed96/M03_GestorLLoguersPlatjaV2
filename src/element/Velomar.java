package element;


import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Velomar {

    private int codi;
    private static int properCodi = 0;
    private String dataAlta;
    private boolean tobogan;
    private boolean llogat;

    public Velomar(String pDataAlta, boolean pTobogan) {
        codi = properCodi;
        properCodi++;
        dataAlta = pDataAlta;
        tobogan = pTobogan;
        llogat = false;
    }

    /*
     Mètodes accessors.    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi(int pCodi) {
        codi = pCodi;
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

    public boolean getTobogan() {
        return tobogan;
    }

    public void setTobogan(boolean pTobogan) {
        tobogan = pTobogan;
    }

    public boolean getLLogat() {
        return llogat;
    }

    public void setLlogat(boolean pLlogat) {
        llogat = pLlogat;
    }

    public static Velomar nouVelomar() {
        Scanner dades = new Scanner(System.in);
        String dataAltaVelomar;
        boolean toboganVelomar = false;
        int opcio;

        System.out.println("Data d'alta del velomar:");
        dataAltaVelomar = dades.next();

        do {
            System.out.println("\nTé tobogan? (0 si és no o 1 si és si)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    toboganVelomar = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);

        return new Velomar(dataAltaVelomar, toboganVelomar);
    }

    public void modificarVelomar() {
        Scanner dades = new Scanner(System.in);
        int opcio;
        System.out.println("\nData d'alta del velomar: " + dataAlta);
        System.out.println("\nEntra la nova data d'alta:");
        dataAlta = dades.next();

        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }

        do {
            System.out.println("\nAra té tobogan? (0 si és no o 1 si és si)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    tobogan = false;
                    break;
                case 1:
                    tobogan = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);

        modificarEstatLloguer();
    }

    public void mostrarVelomar() {
        System.out.println("\nLes dades del velomar amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);

        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }

        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }
    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogat o 1 si està llogat)");
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
