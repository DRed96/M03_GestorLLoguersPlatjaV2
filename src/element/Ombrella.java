package element;

import element.Hamaca;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Ombrella extends ElementLloguer{

    private Hamaca[] hamaques;

    public Ombrella(String pDataAlta) {
        super(pDataAlta);
        hamaques = new Hamaca[4];
    }

    /*
     Mètodes accessors.
     */
    public Hamaca[] getHamaques() {
        return hamaques;
    }

    public void setHamaques(Hamaca[] pHamaques) {
        hamaques = pHamaques;
    }

  

    public static Ombrella novaOmbrella() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'ombrel.la:");

        return new Ombrella(dades.next());
    }

    public void modificarOmbrella() {
        String dt;
        dt = super.getDataAlta();
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta de l'ombrel.la: " + dt);
        System.out.println("\nEntra la nova data d'alta:");
        dt = dades.next();
        modificarEstatLloguer();
    }

    public void mostrarOmbrella() {
        String dt;
        dt = super.getDataAlta();
        int co;
        co = super.getCodi();
        Boolean llo;
        llo = super.isLlogat();
        System.out.println("\nLes dades de l'ombrel.la amb codi " + co + " són:");
        System.out.println("\nData d'alta:" + dt);
        System.out.println("\nEstat de lloguer:");
        if (llo) {
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
        Boolean llo;
        llo = super.isLlogat();
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llo) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogada o 1 si està llogada)");
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
