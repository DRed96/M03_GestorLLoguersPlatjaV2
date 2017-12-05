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
    
    private int trobarElementTancar(int pos){
        for(int i = 0; i < elementsLloguer.length; i++){
            if (elementsLloguer[i] !=null && elementsLloguer[i].getCodi() == lloguers[pos].getIdElementLloguer()){
                return i;
            }
        }
        return -1;
    }
    
    public void tancarLloguer() {
        boolean trobat = false;
        /*Treure les hamaques si tanques una ombrella*/
        int pos = seleccionarLloguer();
        
        if (pos != -1) {
            int index = trobarElementTancar(pos);
            
            if(elementsLloguer[index] instanceof Ombrella){
                Ombrella omb = (Ombrella) elementsLloguer[index];
                Hamaca ham [] = omb.getHamaques();
                for (int j = 0; j < ham.length; j++) {
                    if (ham[j] != null) {
                        ham[j].setLlogat(false);
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

    /*
     VELOMAR
     */
    public void afegirVelomar(Velomar velomar) {
        boolean trobat = false;

        for (int i = 0; i < velomars.length && !trobat; i++) {
            if (velomars[i] == null) {
                velomars[i] = velomar;
                trobat = true;
            }
        }

    }

    public void treureVelomar(int codi) {
        boolean trobat = false;

        for (int i = 0; i < velomars.length && !trobat; i++) {
            if (velomars[i] != null && velomars[i].getCodi() == codi) {
                velomars[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarVelomar(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi del velomar?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < velomars.length; i++) {
            if (velomars[i] != null && velomars[i].getCodi() == codi) {
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

    /*
     OMBRELLA
     */
    public void afegirOmbrella(Ombrella ombrella) {
        boolean trobat = false;

        for (int i = 0; i < ombrelles.length && !trobat; i++) {
            if (ombrelles[i] == null) {
                ombrelles[i] = ombrella;
                trobat = true;
            }
        }

    }

    public void treureOmbrella(int codi) {
        boolean trobat = false;

        for (int i = 0; i < ombrelles.length && !trobat; i++) {
            if (ombrelles[i] != null && ombrelles[i].getCodi() == codi) {
                ombrelles[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarOmbrella(int codi) {
        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi de l'ombrel.la?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < ombrelles.length; i++) {
            if (ombrelles[i] != null && ombrelles[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

}
