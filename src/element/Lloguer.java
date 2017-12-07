package element;

import principal.Platja;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Lloguer {

    private static final double VALOR = 8.0;
    private int codi;
    private static int properCodi = 0;
    private String codiZona;
    private String dniEncarregat;
    private ElementLloguer elementLloguer;
    private String dniClient;
    private LocalTime horaLloguer;
    private LocalTime tempsLloguer;
    private double totalPagar;
    private boolean pagat;

    public Lloguer(String pCodiZona, String pDniEncarregat, ElementLloguer pElementLloguer, String pDniClient, LocalTime pTempsLloguer, double pTotalPagar, boolean pPagat) {
        codi = properCodi;
        properCodi++;
        codiZona = pCodiZona;
        dniEncarregat = pDniEncarregat;
        elementLloguer = pElementLloguer;
        dniClient = pDniClient;
        horaLloguer = LocalTime.now();
        tempsLloguer = pTempsLloguer;
        totalPagar = pTotalPagar;
        pagat = pPagat;
    }

    /*
     Mètodes accessors.
     */
    
    /*
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

    public String getCodiZona() {
        return codiZona;
    }

    public void setCodiZona(String pCodiZona) {
        codiZona = pCodiZona;
    }

    public String getDniEncarregat() {
        return dniEncarregat;
    }

    public void setDniEncarregat(String pDniEncarregat) {
        dniEncarregat = pDniEncarregat;
    }

    public int getIdElementLloguer() {
        return idElementLloguer;
    }

    public void setIdElementLloguer(int pIdElementLloguer) {
        idElementLloguer = pIdElementLloguer;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String pDniClient) {
        dniClient = pDniClient;
    }

    public LocalTime getHoraLloguer() {
        return horaLloguer;
    }

    public void setHoraLloguer(LocalTime pHoraLloguer) {
        horaLloguer = pHoraLloguer;
    }

    public LocalTime getTempsLloguer() {
        return tempsLloguer;
    }

    public void setTempsLloguer(LocalTime pTempsLloguer) {
        tempsLloguer = pTempsLloguer;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double pTotalPagar) {
        totalPagar = pTotalPagar;
    }

    public boolean getPagat() {
        return pagat;
    }

    public void setPagat(boolean pPagat) {
        pagat = pPagat;
    }
    */
    public static Lloguer nouLloguer(Platja platja) {
        Scanner dades = new Scanner(System.in);
        String codiZonaNou = null;
        String dniEncarregatNou = null;
        ElementLloguer idElementLloguerNou;
        String dniClientNou;
        LocalTime tempsLloguerNou;
        double totalPagarNou;
        boolean estatPagat = false;
        int posZona, posEncarregat;
        int hores, minuts;

        do {
            posZona = platja.seleccionarZona();
            if (posZona == -1) {
                System.out.println("\nLa zona no existeix.");
            } else {
                codiZonaNou = platja.getZones()[posZona].getCodi();
            }
        } while (posZona == -1);

        do {
            posEncarregat = platja.getZones()[posZona].seleccionarEncarregat(null);
            if (posEncarregat == -1) {
                System.out.println("\nL'encarregat no existeix.");
            } else {
                dniEncarregatNou = platja.getZones()[posZona].getEncarregats()[posEncarregat].getDni();
            }
        } while (posEncarregat == -1);

        idElementLloguerNou = seleccionarElementLloguer(posZona, platja);

        System.out.println("\nDNI del client:");
        dniClientNou = dades.next();

        System.out.println("\nHores del lloguer:");
        hores = dades.nextInt();
        System.out.println("\nNecessites mitja hora?: (1 si és si, 0 si és no)");
        minuts = 0;
        if (dades.nextInt() == 1) {
            minuts = 30;
        }
        tempsLloguerNou = LocalTime.of(hores, minuts);

        totalPagarNou = hores * VALOR + minuts * (VALOR / 2);

        System.out.println("\nEstà pagat? (1 si és si, 0 si és no)");
        if (dades.nextInt() == 1) {
            estatPagat = true;
        }

        return new Lloguer(codiZonaNou, dniEncarregatNou, idElementLloguerNou, dniClientNou, tempsLloguerNou, totalPagarNou, estatPagat);
    }

    public static ElementLloguer seleccionarElementLloguer(Platja platja, int posZona) {
        Scanner dades = new Scanner(System.in);
        int opcio = 0, pos;
        ElementLloguer element;
        
        element = demanaElementLloguer(platja,posZona);
        
        if(element instanceof Ombrella){
            int hamaques = 0;
            do {
                System.out.println("Quantes hamaques vols?");
                hamaques = dades.nextInt();
                if (hamaques < 0 && hamaques > 4) {
                    System.out.println("Selecciona una opció correcte");
                }
            } while (hamaques < 0 && hamaques > 4);

            for (int i = 0; i < hamaques; i++) {
                do {
                    pos = platja.seleccionarHamaca();
                    if (pos == -1) {
                        System.out.println("\nL'hamaca no existeix.");
                    } else {
                        platja.getZones()[posZona].getOmbrelles()[pos].afegirHamaca(platja.getHamaques()[pos]);
                    }
                } while (pos == -1);
            }
        }
        
        return element;
    }
    
    private static ElementLloguer demanaElementLloguer(Platja platja,int posZona){
        int pos;
        ElementLloguer element = null;
        do {
            pos = platja.getZones()[posZona].seleccionarElementLloguer(-1);
            if (pos == -1) {
                System.out.println("\nL'element de lloguer no existeix");
            } else {
                element = platja.getZones()[posZona].getElementsLloguer(pos);
                element.setLlogat(true); 
            }
        } while (pos == -1);
        
        return element;
    }
    
    public void mostrarLloguer() {
        System.out.println("\nLes dades del lloguer amb codi " + codi + " són:");
        System.out.println("\nEncarregat: " + dniEncarregat);
        System.out.println("\nCodi de l'element lloguer: " + elementLloguer.getCodi());
        System.out.println("\nClient: " + dniClient);
        System.out.println("\nHora lloguer: " + horaLloguer.getHour() + ":" + horaLloguer.getMinute() + ":" + horaLloguer.getSecond());
        System.out.println("\nTemps lloguer: " + tempsLloguer.getHour() + ":" + tempsLloguer.getMinute());
        System.out.println("\nTotal pagar: " + totalPagar);
        if (pagat) {
            System.out.println("\nPagat");
        } else {
            System.out.println("\nPendent de pagar");
        }
    }
}
