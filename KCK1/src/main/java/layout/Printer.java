package layout;

import com.googlecode.lanterna.SGR;
import domain.Pojazd;
import layout.STerminal;

import java.io.IOException;

public class Printer {

    private static int menuOptions = 3;
    private static int carMenuOptions = 5;
    private static int bicycleMenuOptions = 5;
    private static int scooterMenuOptions = 5;
    private static String[] optionsTexts;

    public static int printMainMenu() throws IOException {

        int options = 3;
        optionsTexts = new String[menuOptions];
        final String OPTION_1 = "1. Samochód";
        final String OPTION_2 = "2. Skuter";
        final String OPTION_3 = "3. Rower";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Wybierz pojazd", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, "1. Samochód", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, "2. Skuter");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, "3. Rower");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getMenuOptions());
        if(choice == -1) return -1;
        else if(choice == 1) printCarMenu();
        else if(choice == 2) printScooterMenu();
        else if(choice == 3) printBicycleMenu();


        return 0;
    }

    public static void refreshMenu(String[] optionsArray, int currentOption) throws IOException {
        STerminal sTerminal = STerminal.getInstance();
        int workspaceColumn = sTerminal.getWorkspacePosition().getColumn();
        int workspaceRow = sTerminal.getWorkspacePosition().getRow();
        int margin = sTerminal.getMargin();
        for (int i = 0; i < optionsArray.length; i++) {
            if(currentOption == i) sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+i+1, optionsArray[i], SGR.REVERSE);
            else sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+i+1, optionsArray[i]);
        }
        sTerminal.getScreen().refresh();
    }

    public static int printCarMenu() throws IOException {
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

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getCarMenuOptions());
        if(choice == -1) return -1;
        else if(choice == 1) printCarInputMenu();

        return 0;

    }

    public static int printCarInputMenu() throws IOException {
        int options = 4, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Marka: ";
        final String OPTION_2 = "2. Model: ";
        final String OPTION_3 = "3. Stan pojazdu: ";
        final String OPTION_4 = "4. Dostępność";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Podaj dane", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, OPTION_4);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(4);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices);
        dbConnector.addPojazd(pojazd);

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

    public static int printBicycleMenu() throws IOException {
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

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getBicycleMenuOptions());
        if(choice == -1) return -1;
        else if(choice == 1) printBicycleInputMenu();

        return 0;

    }
    public static int printBicycleInputMenu() throws IOException {
        int options = 4, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Marka: ";
        final String OPTION_2 = "2. Model: ";
        final String OPTION_3 = "3. Stan pojazdu: ";
        final String OPTION_4 = "4. Dostępność";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Podaj dane", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, OPTION_4);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(4);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices);
        dbConnector.addPojazd(pojazd);

        return 0;
    }
    public static int getBicycleMenuOptions() {
        return bicycleMenuOptions;
    }

    public static int printScooterMenu() throws IOException {
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

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Co chcesz zrobić z pojazdem", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, "1. Dodaj", SGR.REVERSE);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, "2. Usuń");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, "3. Edytuj");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, "4. Wypożycz");
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+5, "5. Wypisz");
        sTerminal.getScreen().refresh();

        int choice = UserInput.chooseOption(Printer.getScooterMenuOptions());
        if(choice == -1) return -1;
        else if(choice == 1) printScooterInputMenu();

        return 0;

    }

    public static int printScooterInputMenu() throws IOException {
        int options = 4, localMargin = 10;
        optionsTexts = new String[options];
        final String OPTION_1 = "1. Marka: ";
        final String OPTION_2 = "2. Model: ";
        final String OPTION_3 = "3. Stan pojazdu: ";
        final String OPTION_4 = "4. Dostępność";
        optionsTexts[0] = OPTION_1;
        optionsTexts[1] = OPTION_2;
        optionsTexts[2] = OPTION_3;
        optionsTexts[3] = OPTION_4;

        STerminal sTerminal = STerminal.getInstance();

        int workspaceColumn = sTerminal.getMenuPosition().getColumn();
        int workspaceRow = sTerminal.getMenuPosition().getRow();
        int margin = sTerminal.getMargin();

        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow, "Podaj dane", SGR.BOLD);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+1, OPTION_1);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+2, OPTION_2);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+3, OPTION_3);
        sTerminal.getTextGraphics().putString(workspaceColumn+margin, workspaceRow+4, OPTION_4);
        sTerminal.getScreen().refresh();

        String[] choices = UserInput.getUserInput(4);
        DBConnector dbConnector = DBConnector.getInstance();
        Pojazd pojazd = new Pojazd(choices);
        dbConnector.addPojazd(pojazd);

        return 0;
    }

    public static int getScooterMenuOptions() {
        return scooterMenuOptions;
    }
}
