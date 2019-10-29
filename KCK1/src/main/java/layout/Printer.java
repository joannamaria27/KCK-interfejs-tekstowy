package layout;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import domain.Klient;
import domain.Pojazd;
import domain.Wypozyczenie;
import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
import layout.STerminal;

import java.io.IOException;
import java.util.List;

public class Printer {

    private static int menuOptions = 4;
    private static int carMenuOptions = 5;
    private static int bicycleMenuOptions = 5;
    private static int scooterMenuOptions = 5;
    private static String[] optionsTexts;

    public static int printMainMenu() throws IOException, InterruptedException {

        Printer.clearWorkingArea();
        int options = 4;
        optionsTexts = new String[options];
//        final String OPTION_1 = "1. Samochód";
//        final String OPTION_2 = "2. Skuter";
//        final String OPTION_3 = "3. Rower";
        optionsTexts[0] = "1. Samochód";
        optionsTexts[1] = "2. Skuter";
        optionsTexts[2] = "3. Rower";
        optionsTexts[3] = "4. Klient";


        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Wybierz pojazd", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, optionsTexts[0], SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, optionsTexts[1]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, optionsTexts[2]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, optionsTexts[3]);
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getMenuOptions());
        if (choice == -1) return -1;
        else if (choice == 1) printCarMenu();
        else if (choice == 2) printScooterMenu();
        else if (choice == 3) printBicycleMenu();
        else if (choice == 4) printClientMenu();


        return 0;
    }

    public static int printClientMenu() throws IOException, InterruptedException {
        int options = 2;
        optionsTexts = new String[options];
        optionsTexts[0] = "1. Dodaj";
        optionsTexts[1] = "2. Usuń";

        STerminal sTerminal = STerminal.getInstance();
        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Wybierz akcję dotyczącą klienta", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, optionsTexts[0], SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, optionsTexts[1]);
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(options);
        if (choice == -1) return -1;
        else if (choice == 1) printAddClientMenu();
        else if (choice == 2) printDeleteClientMenu();


        return 0;
    }

    public static void refreshMenu(String[] optionsArray, int currentOption) throws IOException {
        STerminal sTerminal = STerminal.getInstance();
        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();
        for (int i = 0; i < optionsArray.length; i++) {
            if (currentOption == i)
                sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + i + 1, optionsArray[i], SGR.REVERSE);
            else sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + i + 1, optionsArray[i]);
        }
        sTerminal.getScreen().refresh();
    }

    public static int printCarMenu() throws IOException, InterruptedException {
        int options = 5;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Dodaj";
        final String OPTION_2 = "2. Usuń";
        final String OPTION_3 = "3. Edytuj";
        final String OPTION_4 = "4. Wypożycz";
        final String OPTION_5 = "5. Wypisz";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getCarMenuOptions());
        if (choice == -1) return -1;
        else if (choice == 1) printCarInputMenu();
        else if(choice == 2) printCarDeleteMenu();
        else if(choice == 3) printCarEditMenu();
        else if(choice == 4) printCarRentalMenu();
        else if(choice == 5) printAllCars();

        return 0;

    }

    public static int printCarInputMenu() throws IOException {
        int options = 5, localMargin = 10;
        optionsTexts = new String[options];
        optionsTexts[0] = "1. MODEL: ";
        optionsTexts[1] = "2. MARKA: ";
        optionsTexts[2] = "3. NR_UBEZPIECZENIA: ";
        optionsTexts[3] = "4. STAN DOSTEPU: ";
        optionsTexts[4] = "5. DOSTEPNOSC: ";

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, optionsTexts[0]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, optionsTexts[1]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, optionsTexts[2]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, optionsTexts[3]);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, optionsTexts[4]);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices, "Samochód");
        dbConnector.start();
        dbConnector.addPojazd(pojazd);
        dbConnector.stop();

        return 0;
    }

    public static int printCarEditMenu() throws IOException {
        Printer.clearWorkingArea();
        List<Pojazd> list = DBConnector.getAllCars();
        STerminal sTerminal = STerminal.getInstance();
        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();
        optionsTexts = new String[1];
        optionsTexts[0] = "Podaj ID pojazdu, który chcesz edytować: ";

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, optionsTexts[0]);


        //sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow+list.size(), "Podaj ID pojazdu, który chcesz edytować: ", SGR.BOLD);
        sTerminal.getScreen().refresh();
        String[] choice = UserInput.getUserInput(1);
        DBConnector.getInstance().start();
        Pojazd pojazd = DBConnector.getInstance().entityManager.find(Pojazd.class, Long.parseLong(choice[0]));
        DBConnector.getInstance().stop();
        if(pojazd == null){
            sTerminal.getTextGraphics().putString(sTerminal.getErrorPosition().getColumn(), sTerminal.getErrorPosition().getRow(), "Nie ma pojazdu o podanym ID");
            return -1;
        }


        Printer.clearWorkingArea();

        //if(list.size() == 0) sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, "Brak pojazdów");
//        for (int i = 0; i < list.size(); i++) {
//            sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + i+5, list.get(i).getId() + " - " + list.get(i).getMarka()+" - "+list.get(i).getModel()+" - "+list.get(i).getDostepnosc()+" - "+list.get(i).getId_ubezpieczenia()+" - "+list.get(i).getStan_pojazdu()+" - "+list.get(i).getTyp());
//        }
        sTerminal.getScreen().refresh();

        sTerminal.getTextGraphics().putString(sTerminal.getWorkspacePosition().getColumn()+3, sTerminal.getWorkspacePosition().getRow() + 8, "Aktualne dane:", SGR.BOLD);
        //sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + +5, list.get(0).getId() + " - " + list.get(0).getMarka()+" - "+list.get(0).getModel()+" - "+list.get(0).getDostepnosc()+" - "+list.get(0).getId_ubezpieczenia()+" - "+list.get(0).getStan_pojazdu()+" - "+list.get(0).getTyp());

        optionsTexts = new String[5];
        optionsTexts[0] = "1. MODEL: ";
        optionsTexts[1] = "2. MARKA: ";
        optionsTexts[2] = "3. NR_UBEZPIECZENIA: ";
        optionsTexts[3] = "4. STAN DOSTEPU: ";
        optionsTexts[4] = "5. DOSTEPNOSC: ";
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 9, optionsTexts[0] + pojazd.getModel());
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 10, optionsTexts[1] + pojazd.getMarka());
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 11, optionsTexts[2] + pojazd.getId_ubezpieczenia());
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 12, optionsTexts[3] + pojazd.getStan_pojazdu());
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 13, optionsTexts[4] + pojazd.getDostepnosc());

        String[] choices = UserInput.getUserInput(optionsTexts.length);
        
        //printCarInputMenu();




        return 0;
    }

    public static int printCarDeleteMenu() throws IOException { ///Pojazdy wszystkie
        int options = 1, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "ID pojazdu: ";

        optionsTexts[0] = OPTION_1;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj ID pojazdu, którego chcesz usunąć", SGR.BOLD);

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        dbConnector.start();
        Pojazd pojazd = dbConnector.entityManager.find(Pojazd.class, Long.parseLong(choices[0]));
        if (pojazd == null) {
            sTerminal.getTextGraphics().putString(sTerminal.getErrorPosition().getColumn(), sTerminal.getErrorPosition().getRow(), "Nie ma pojazdu o tym id");
            dbConnector.stop();
            return -1;
        }
        else dbConnector.deletePojazd(pojazd);
        dbConnector.stop();

        return 0;
    }

    public static void clearWorkingArea() throws IOException {
        STerminal sTerminal = STerminal.getInstance();
        sTerminal.getTextGraphics().fillRectangle(sTerminal.getWorkspacePosition(), sTerminal.getWorkspaceSize(), ' ');
        sTerminal.getScreen().refresh();
    }

    public static int getMenuOptions() {
        return menuOptions;
    }

    public static int getCarMenuOptions() {
        return carMenuOptions;
    }

    public static String[] getOptionsTexts() {
        return optionsTexts;
    }

    public static int printBicycleMenu() throws IOException, InterruptedException {
        int options = 5;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Dodaj";
        final String OPTION_2 = "2. Usuń";
        final String OPTION_3 = "3. Edytuj";
        final String OPTION_4 = "4. Wypożycz";
        final String OPTION_5 = "5. Wypisz";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getBicycleMenuOptions());
        if (choice == -1) return -1;
        else if (choice == 1) printBicycleInputMenu();
//        else if(choice == 2) printBicycleDeleteMenu();
//        else if(choice == 3) printBicycleEditMenu();
        else if(choice == 4) printBicycleRentalMenu();
//        else if(choice == 5) printBicycle();


        return 0;

    }

    public static int printBicycleInputMenu() throws IOException {
        int options = 5, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. MODEL: ";
        final String OPTION_2 = "2. MARKA: ";
        final String OPTION_3 = "3. NR_UBEZPIECZENIA: ";
        final String OPTION_4 = "4. STAN DOSTEPU: ";
        final String OPTION_5 = "5. DOSTEPNOSC: ";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices, "Rower");
        dbConnector.addPojazd(pojazd);

        return 0;
    }

    public static int getBicycleMenuOptions() {
        return bicycleMenuOptions;
    }

    public static int printScooterMenu() throws IOException, InterruptedException {
        int options = 5;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Dodaj";
        final String OPTION_2 = "2. Usuń";
        final String OPTION_3 = "3. Edytuj";
        final String OPTION_4 = "4. Wypożycz";
        final String OPTION_5 = "5. Wypisz";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getScooterMenuOptions());
        if (choice == -1) return -1;
        else if (choice == 1) printScooterInputMenu();
//        else if(choice == 2) printScooterDeleteMenu();
//        else if(choice == 3) printScooterEditMenu();
        else if(choice == 4) printScooterRentalMenu();
//        else if(choice == 5) printScooter();

        return 0;

    }

    public static int printScooterInputMenu() throws IOException {
        int options = 5, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. MODEL: ";
        final String OPTION_2 = "2. MARKA: ";
        final String OPTION_3 = "3. NR_UBEZPIECZENIA: ";
        final String OPTION_4 = "4. STAN DOSTEPU: ";
        final String OPTION_5 = "5. DOSTEPNOSC: ";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
//todo
// dodanie klienta i pojazdu
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices, "Skuter");
        dbConnector.addPojazd(pojazd);

        return 0;
    }

    public static int getScooterMenuOptions() {
        return scooterMenuOptions;
    }


    public static int printScooterRentalMenu() throws IOException {

        int options = 7, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. POJAZD: SKUTER";
        final String OPTION_2 = "1. DATA WYPOZYCZENIA: ";
        final String OPTION_3 = "2. DATA ODDANIA: ";
        final String OPTION_4 = "3. KOD DOSTEPU: ";
        final String OPTION_5 = "4. KLIENT: ";
        final String OPTION_6 = "5. CENA: ";
        final String OPTION_7 = "6. PRACWNIK";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;
        optionsTexts[5] = OPTION_6;
        optionsTexts[6] = OPTION_7;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 6, OPTION_6);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 7, OPTION_7);
        sTerminal.getScreen().refresh();
//todo
// dodanie klienta i pojazdu

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Wypozyczenie wypozyczenie = new Wypozyczenie(choices);
        dbConnector.addWypozyczenie(wypozyczenie);

        return 0;

    }
    public static int printCarRentalMenu() throws IOException, InterruptedException {

        int options = 6, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. DATA WYPOZYCZENIA: ";
        final String OPTION_2 = "2. DATA ODDANIA: ";
        final String OPTION_3 = "3. KOD DOSTEPU: ";
        final String OPTION_4 = "4. KLIENT: ";
        final String OPTION_5 = "5. CENA: ";
        final String OPTION_6 = "6. PRACWNIK";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;
        optionsTexts[5] = OPTION_6;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
//todo
// dodanie klienta i pojazdu

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 6, OPTION_6);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Wypozyczenie wypozyczenie = new Wypozyczenie(choices);

        dbConnector.start();
        Pojazd pojazd = (Pojazd)dbConnector.entityManager.find(Pojazd.class, Long.parseLong(choices[0]));
        if(pojazd == null){
            sTerminal.getTextGraphics().putString(sTerminal.getErrorPosition().getColumn(), sTerminal.getErrorPosition().getRow(), "Nie ma pojazdu o tym id");
            sTerminal.getScreen().refresh();
            System.out.println("Nie ma pojazu o tym id");
            Thread.sleep(2000);
            dbConnector.stop();
            return -1;
        }
        Klient klient = dbConnector.entityManager.find(Klient.class, Long.parseLong(choices[4]));
        if(klient == null){
            sTerminal.getTextGraphics().putString(sTerminal.getErrorPosition().getColumn(), sTerminal.getErrorPosition().getRow(), "Nie ma klienta o tym id");
            sTerminal.getScreen().refresh();
            System.out.println("Nie ma klienta o tym id");
            dbConnector.stop();
            return -1;
        }
        wypozyczenie.setId_pojazdu(pojazd);
        wypozyczenie.setId_klienta(klient);
        dbConnector.addWypozyczenie(wypozyczenie);
        dbConnector.stop();

        return 0;

    }

    public static int printBicycleRentalMenu() throws IOException {

        int options = 7, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. POJAZD: ROWER";
        final String OPTION_2 = "1. DATA WYPOZYCZENIA: ";
        final String OPTION_3 = "2. DATA ODDANIA: ";
        final String OPTION_4 = "3. KOD DOSTEPU: ";
        final String OPTION_5 = "4. KLIENT: ";
        final String OPTION_6 = "5. CENA: ";
        final String OPTION_7 = "6. PRACWNIK";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;
        optionsTexts[5] = OPTION_6;
        optionsTexts[6] = OPTION_7;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
        //todo
        //typ automatycznie dodawany
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 6, OPTION_6);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 7, OPTION_7);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Wypozyczenie wypozyczenie = new Wypozyczenie(choices);
        dbConnector.start();
        dbConnector.addWypozyczenie(wypozyczenie);
        dbConnector.addPojazd(wypozyczenie.getId_pojazdu());
        dbConnector.stop();

        return 0;

    }

    public static int printAddClientMenu() throws IOException {

        int options = 7, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. NUMER PRAWA JAZDY: ";
        final String OPTION_2 = "2. NAZWISKO: ";
        final String OPTION_3 = "3. IMIE: ";
        final String OPTION_4 = "4. DATA URODZENIA: ";
        final String OPTION_5 = "5. ADRES: ";
        final String OPTION_6 = "6. PESEL: ";
        final String OPTION_7 = "7. TELEFON";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;
        optionsTexts[4] = OPTION_5;
        optionsTexts[5] = OPTION_6;
        optionsTexts[6] = OPTION_7;


        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj dane", SGR.BOLD);
        //todo
        //typ automatycznie dodawany
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 4, OPTION_4);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, OPTION_5);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 6, OPTION_6);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 7, OPTION_7);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        Klient klient = new Klient(choices);
        dbConnector.addKlient(klient);

        return 0;
    }

    public static int printDeleteClientMenu() throws IOException {
        int options = 1, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "ID klienta: ";

        optionsTexts[0] = OPTION_1;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow, "Podaj ID klienta, którego chcesz usunąć", SGR.BOLD);
        //todo
        //typ automatycznie dodawany
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 1, OPTION_1);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(options);
        DBConnector dbConnector = DBConnector.getInstance();
        dbConnector.start();
        Klient klient = dbConnector.entityManager.find(Klient.class, Long.parseLong(choices[0]));
        if (klient == null) {
            sTerminal.getTextGraphics().putString(sTerminal.getErrorPosition().getColumn(), sTerminal.getErrorPosition().getRow(), "Nie ma klienta o tym id");
            dbConnector.stop();
            return -1;
        }
        else dbConnector.deleteKlient(klient);
        dbConnector.stop();


        return 0;
    }

    public static void printFooter() throws IOException {
        STerminal.getInstance().getTextGraphics().putString(STerminal.getInstance().getFooterPosition().getColumn()+17, STerminal.getInstance().getFooterPosition().getRow(), "All Rights Reserved © Klimek & Gawędzki");
    }

    public static int printAllCars() throws IOException {
        List<Pojazd> list = DBConnector.getInstance().entityManager.createQuery("SELECT a FROM Pojazd a", Pojazd.class).getResultList();
        for (Pojazd pojazd : list) {
            System.out.println(pojazd.getId());
        }

        STerminal sTerminal = STerminal.getInstance();

        Printer.clearWorkingArea();
        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();
        Printer.clearWorkingArea();
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow+1, "Znalezione pojazdy", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow+3, "ID - Marka - Model - Dostępność - ID ubezpieczenia - Stan - Typ", SGR.ITALIC);

        if(list.size() == 0) sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + 5, "Brak pojazdów");
        for (int i = 0; i < list.size(); i++) {
            sTerminal.getTextGraphics().putString(workspaceColumn + margin, workspaceRow + i+5, list.get(i).getId() + " - " + list.get(i).getMarka()+" - "+list.get(i).getModel()+" - "+list.get(i).getDostepnosc()+" - "+list.get(i).getId_ubezpieczenia()+" - "+list.get(i).getStan_pojazdu()+" - "+list.get(i).getTyp());
        }
        sTerminal.getScreen().refresh();

        KeyStroke keyPressed;
        while(true){
            keyPressed = sTerminal.getTerminal().pollInput();
            if (keyPressed != null) {
                switch(keyPressed.getKeyType()){
                    case Enter:
                    case Escape:
                        return 0;
                }
            }
        }


        //return 0;
    }


}