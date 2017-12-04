
package element;
import java.util.Scanner;


public abstract class ElementLloguer {
    
    private int codi;
    static int properCodi = 0;
    private String dataAlta;
    private boolean llogat;

public ElementLloguer(String pdataAlta){
    
      codi = properCodi;
      properCodi++;
      dataAlta = pdataAlta;
      llogat = false;
}

    public String getDataAlta() {
        return dataAlta;
    }
    
    public boolean isLlogat() {
        return llogat;
    }

    public int getCodi() {
        return codi;
    }

    public void setLlogat(boolean llogat) {
        this.llogat = llogat;
    }

   


    public void modificarElement(){
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta: " + dataAlta);
        System.out.println("\nEntra la nova data d'alta:");
        dataAlta = dades.next();
        modificarEstatLloguer();
    }
    
    
    public void mostrarElement(){
        
        System.out.println("\nLes dades amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);
        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }
    }
    
    public void modificarEstatLloguer(){
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
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
    
    

