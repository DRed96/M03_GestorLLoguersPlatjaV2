package element;


import java.util.Scanner;


    
    public class Hamaca extends ElementLloguer{

    private int codi;
    private static int codiEs;
    private static int properCodi = 0;
    private String dataAlta;
    private boolean llogat;

    public Hamaca(String pDataAlta) {
        codi = properCodi;
        properCodi++;
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

    public boolean getLLogat() {
        return llogat;
    }

    public void setLlogat(boolean pLlogat) {
        llogat = pLlogat;
    }
    
    public static Hamaca novaHamaca() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'hamaca:");

        return new Hamaca(dades.next());
    }

    public void modificarHamaca() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta de l'hamaca: " + dataAlta);
        System.out.println("\nEntra la nova data d'alta:");
        dataAlta = dades.next();
        modificarEstatLloguer();
    }

    public void mostrarHamaca() {
        System.out.println("\nLes dades de l'hamaca amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);
        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
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
    
