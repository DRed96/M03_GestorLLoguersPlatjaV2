package principal;

import element.Velomar;
import element.Ombrella;
import element.Hamaca;
import element.Lloguer;
import element.Encarregat;
import element.Element;
import element.ElementLloguer;
import java.util.Scanner;
/**
 *
 * @author fta
 */
public class Zona implements Element{

    private String codi;
    private Lloguer lloguers[];
    private static int indexLloguers = 0;
    private ElementLloguer elementsLloguer [];
    private Encarregat encarregats[];

    public Zona(String pCodi) {
        codi = pCodi;
        elementsLloguer = new ElementLloguer [28];
        lloguers = new Lloguer[300];
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
    /*
    

    

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

    public Encarregat[] getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(Encarregat[] encarregats) {
        this.encarregats = encarregats;
    }
    
    public ElementLloguer getElementLloguer(int i){
        return elements[i];
    }
    */
    /*
        
    */
    public static Zona novaZona(String codi) {
        Zona novaZona;
        if(codi != null && codi.isEmpty()== true){
            Scanner dades = new Scanner(System.in);
            String in;
            System.out.println("Codi de la zona:");
            in = dades.nextLine();
            novaZona = new Zona(in);
        }
        else{
            novaZona = new Zona(codi);
        }

        return novaZona;
    }
    
    @Override
    public void mostrarElement(){
        System.out.println("\nLes dades de la zona amb codi " + codi + " són:");

        System.out.println("\nLloguers:");
        for (int i = 0; i < lloguers.length; i++) {
            if (lloguers[i] != null) {
                lloguers[i].mostrarLloguer();
            }
        }
        
        System.out.println("\nElements de lloguer");
        for (int i = 0; i < elementsLloguer.length; i++) {
            if (elementsLloguer[i] != null) {
                elementsLloguer[i].mostrarElement();
            }
        }

        System.out.println("\nEncarregats:");
        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i] != null) {
                encarregats[i].mostrarElement();
            }
        }
    }

    @Override
    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nEscriu un nou codi de zona");
        System.out.println("Codi anterior: "+this.getCodi());
        this.setCodi(dades.nextLine());
    }
    
    /*
     LLOGUERS
     */
    public void afegirLloguer(Lloguer lloguer) {
        lloguers[indexLloguers] = lloguer;
        indexLloguers++;
    }
    
    private int trobarIndexElementLloguer(int pos){
        for(int i = 0; i < elementsLloguer.length; i++){
            if (elementsLloguer[i] !=null && elementsLloguer[i].getCodi() == lloguers[pos].getIdElementLloguer()){
                return i;
            }
        }
        return -1;
    }
    
    public void tancarLloguer() {
        /*Treure les hamaques si tanques una ombrella*/
        int pos = seleccionarLloguer();
        
        if (pos != -1) {
            //Aquest mètode busca el codi d'element amb el lloguer a esborrar
            //També hem afegit una comprovacio
            int index = trobarIndexElementLloguer(pos);
            if(index != -1){
                if(elementsLloguer[index] instanceof Ombrella){
                    Ombrella omb = (Ombrella) elementsLloguer[index];
                    Hamaca ham [] = omb.getHamaques();
                    for (int j = 0; j < ham.length; j++) {
                        if (ham[j] != null) {
                            ham[j].setLlogat(false);
                        }
                    }
                }
            }
            
            elementsLloguer[index].setLlogat(false);
     
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

    public void afegirElementLloguer(ElementLloguer element){
        boolean trobat = false;
        for(int i = 0; i < elementsLloguer.length && !trobat; i++){
            if (elementsLloguer[i] == null){
                elementsLloguer[i] = element;
                trobat = true;
            }
        }
    }
    
    public void treureElementLloguer(int codi) {
        boolean trobat = false;

        for (int i = 0; i < elementsLloguer.length && !trobat; i++) {
            if (elementsLloguer[i] != null && elementsLloguer[i].getCodi() == codi) {
                elementsLloguer[i] = null;
                trobat = true;
            }
        }
    }

    public int seleccionarElementLloguer(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi del velomar?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < elementsLloguer.length; i++) {
            if (elementsLloguer[i] != null && elementsLloguer[i].getCodi() == codi) {
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
}
