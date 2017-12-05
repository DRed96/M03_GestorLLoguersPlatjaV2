package element;


import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Velomar extends ElementLloguer{

    private boolean tobogan;
  

    public Velomar(String pDataAlta, boolean pTobogan) {
 
        super(pDataAlta);
        tobogan = pTobogan;
    }

    /*
     Mètodes accessors.    
     */

    public boolean isTobogan() {
        return tobogan;
    }

    public void setTobogan(boolean tobogan) {
        this.tobogan = tobogan;
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
        String da;
        da = super.getDataAlta();
        Scanner dades = new Scanner(System.in);
        int opcio;
        System.out.println("\nData d'alta del velomar: " + da);
        System.out.println("\nEntra la nova data d'alta:");
        da = dades.next();

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
        Boolean llo;
        llo = super.isLlogat();
        int co;
        co = super.getCodi();
        String da;
        da = super.getDataAlta();
        System.out.println("\nLes dades del velomar amb codi " + co + " són:");
        System.out.println("\nData d'alta:" + da);

        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }

        System.out.println("\nEstat de lloguer:");
        if (llo) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }
    }

    public void modificarEstatLloguer() {
        Boolean llo;
        llo = super.isLlogat();
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llo) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogat o 1 si està llogat)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    llo = true;
                    break;
                case 1:
                    llo = false;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);
    }
}
