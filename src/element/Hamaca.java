package element;


import java.util.Scanner;


    
    public class Hamaca extends ElementLloguer{
          
    public Hamaca(String pDataAlta) {
        
        super(pDataAlta);
        
    }

    /*
     Mètodes accessors.
     */ 
    public static Hamaca novaHamaca() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'hamaca:");

        return new Hamaca(dades.next());
    }

    public void modificarHamaca() {
        String da;
        da = super.getDataAlta();
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta de l'hamaca: " + da);
        System.out.println("\nEntra la nova data d'alta:");
        da = dades.next();
        modificarEstatLloguer();
    }

    public void mostrarHamaca() {
        String dt;
        dt = super.getDataAlta();
        int co;
        co = super.getCodi();
        Boolean llo;
        llo = super.isLlogat();
        System.out.println("\nLes dades de l'hamaca amb codi " + co + " són:");
        System.out.println("\nData d'alta:" + dt);
        System.out.println("\nEstat de lloguer:");
        if (llo) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }
    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;
        Boolean llo;
        llo = super.isLlogat();
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
    
