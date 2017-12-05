package element;


import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Velomar {

    private boolean tobogan;
  

    public Velomar(String pDataAlta, boolean pTobogan) {
 
        super(pDataAlta);
        tobogan = pTobogan;
    }

    /*
     Mètodes accessors.    
     */
   
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
