package principal;

import element.Lloguer;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Aplicacio {

    private static Platja[] platges = new Platja[4];//Platges d'illa Tortuga
    private static int indexPlatges = 0; //La propera posició buida del vector platges
    private static Platja platjaActual = null; //PlatjaSeleccionada

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de platges");
            System.out.println("\n2. Gestió de zones");
            System.out.println("\n3. Gestió de velomars");
            System.out.println("\n4. Gestió d'ombrel.les");
            System.out.println("\n5. Gestió d'hamaques");
            System.out.println("\n6. Gestió d'encarregats");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuPlatges();
                    break;
                case 2:
                    if (platjaActual != null) {
                        menuZones();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 3:
                    if (platjaActual != null) {
                        menuVelomars();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 4:
                    if (platjaActual != null) {
                        menuOmbrelles();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 5:
                    if (platjaActual != null) {
                        menuHamaques();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 6:
                    if (platjaActual != null) {
                        menuEncarregats();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuPlatges() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar platges");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platges[indexPlatges] = Platja.novaPlatja();
                    indexPlatges++;
                    break;
                case 2:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platjaActual = platges[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 3:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platges[pos].modificarPlatja();
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 4:
                    for (int i = 0; i < indexPlatges; i++) {
                        platges[i].mostrarPlatja();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuZones() {
        int opcio = 0;
        int posZona, posElement, posElementZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Afegir encarregat");
            System.out.println("\n3. Afegir ombrel.la");
            System.out.println("\n4. Afegir velomar");
            System.out.println("\n5. Treure encarregat");
            System.out.println("\n6. Treure ombrel.la");
            System.out.println("\n7. Treure velomar");
            System.out.println("\n8. Gestionar lloguers");
            System.out.println("\n9. Llistar zones");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirZona();
                    break;
                case 2:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarEncarregat();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarEncarregat(platjaActual.getEncarregats()[posElement].getDni());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirEncarregat(platjaActual.getEncarregats()[posElement]);
                        } else {
                            System.out.println("\nL'encarregat ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'encarregat.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarOmbrella();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarOmbrella(platjaActual.getOmbrelles()[posElement].getCodi());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirOmbrella(platjaActual.getOmbrelles()[posElement]);
                        } else {
                            System.out.println("\nL'ombrel.la ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'ombrel.la.");
                    }
                    break;
                case 4:
                    posZona = platjaActual.seleccionarZona();
                    posElement = platjaActual.seleccionarVelomar();
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarVelomar(platjaActual.getVelomars()[posElement].getCodi());
                        if (posElementZona == -1) {
                            platjaActual.getZones()[posZona].afegirVelomar(platjaActual.getVelomars()[posElement]);
                        } else {
                            System.out.println("\nEl velomar ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix el velomar.");
                    }
                    break;
                case 5:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarEncarregat(null);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureEncarregat(platjaActual.getZones()[posZona].getEncarregats()[posElementZona].getDni());
                        } else {
                            System.out.println("\nL'encarregat no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 6:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarOmbrella(-1);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureOmbrella(platjaActual.getZones()[posZona].getOmbrelles()[posElementZona].getCodi());
                        } else {
                            System.out.println("\nL'ombrel.la no està assignada a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 7:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        posElementZona = platjaActual.getZones()[posZona].seleccionarVelomar(-1);
                        if (posElementZona >= 0) {
                            platjaActual.getZones()[posZona].treureVelomar(platjaActual.getZones()[posZona].getVelomars()[posElementZona].getCodi());
                        } else {
                            System.out.println("\nEl velomar no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 8:
                    menuLloguers();
                    break;
                case 9:
                    for (int i = 0; i < platjaActual.getZones().length; i++) {
                        if (platjaActual.getZones()[i] != null) {
                            platjaActual.getZones()[i].mostrarZona();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuLloguers() {
        int opcio = 0;
        int posZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Crear");
            System.out.println("\n2. Tancar");
            System.out.println("\n3. Llistar lloguers");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        platjaActual.getZones()[posZona].afegirLloguer(Lloguer.nouLloguer(platjaActual));
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 2:
                    posZona = platjaActual.seleccionarZona();
                    if (posZona >= 0) {
                        platjaActual.getZones()[posZona].tancarLloguer();
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarZona();
                    for (int i = 0; i < platjaActual.getZones()[posZona].getLloguers().length; i++) {
                        if (platjaActual.getZones()[posZona].getLloguers()[i] != null) {
                            platjaActual.getZones()[posZona].getLloguers()[i].mostrarLloguer();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuVelomars() {
        int opcio = 0;
        int posZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Baixa");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar velomars");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirVelomar();
                    break;
                case 2:
                    platjaActual.treureVelomar();
                    break;
                case 3:
                    int pos = platjaActual.seleccionarVelomar();
                    if (pos >= 0) {
                        platjaActual.getVelomars()[pos].modificarVelomar();
                    } else {
                        System.out.println("\nNo existeix aquesta velomar");
                    }
                    break;
                case 4:
                    for (int i = 0; i < platjaActual.getVelomars().length; i++) {
                        if (platjaActual.getVelomars()[i] != null) {
                            platjaActual.getVelomars()[i].mostrarVelomar();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuOmbrelles() {
        int opcio = 0;

        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Baixa");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar ombrel.les");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirOmbrella();
                    break;
                case 2:
                    platjaActual.treureOmbrella();
                    break;
                case 3:
                    int pos = platjaActual.seleccionarOmbrella();
                    if (pos >= 0) {
                        platjaActual.getOmbrelles()[pos].modificarOmbrella();
                    } else {
                        System.out.println("\nNo existeix aquesta ombrel.la");
                    }
                    break;
                case 4:
                    for (int i = 0; i < platjaActual.getOmbrelles().length; i++) {
                        if (platjaActual.getOmbrelles()[i] != null) {
                            platjaActual.getOmbrelles()[i].mostrarOmbrella();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuHamaques() {
        int opcio = 0;

        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Baixa");
            System.out.println("\n3. Modificar");
            System.out.println("\n6. Llistar hamaques");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirHamaca();
                    break;
                case 2:
                    platjaActual.treureHamaca();
                    break;
                case 3:
                    int pos = platjaActual.seleccionarHamaca();
                    if (pos >= 0) {
                        platjaActual.getHamaques()[pos].modificarHamaca();
                    } else {
                        System.out.println("\nNo existeix aquesta hamaca");
                    }
                    break;
                case 6:
                    for (int i = 0; i < platjaActual.getHamaques().length; i++) {
                        if (platjaActual.getHamaques()[i] != null) {
                            platjaActual.getHamaques()[i].mostrarHamaca();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuEncarregats() {
        int opcio = 0;

        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Baixa");
            System.out.println("\n3. Modificar");
            System.out.println("\n6. Llistar encarregats");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirEncarregat(null);
                    break;
                case 2:
                    platjaActual.treureEncarregat();
                    break;
                case 3:
                    int pos = platjaActual.seleccionarEncarregat();
                    if (pos >= 0) {
                        platjaActual.getEncarregats()[pos].modificarEncarregat();
                    } else {
                        System.out.println("\nNo existeix aquest encarregat");
                    }
                    break;
                case 6:
                    for (int i = 0; i < platjaActual.getEncarregats().length; i++) {
                        if (platjaActual.getEncarregats()[i] != null) {
                            platjaActual.getEncarregats()[i].mostrarEncarregat();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static int seleccionarPlatja() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCoordenades de la platja?:");
        String coordenades = dades.next();
        int pos = -1;
        for (int i = 0; i < indexPlatges; i++) {
            if (platges[i].getCoordenades().equals(coordenades)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }
}
