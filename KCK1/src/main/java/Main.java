import layout.DBConnector;
import layout.Printer;
import layout.STerminal;
import layout.UserInput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        STerminal sTerminal = STerminal.getInstance();
        sTerminal.getScreen().startScreen();
        sTerminal.printHeader(sTerminal.getHeaderPosition());
        sTerminal.getScreen().refresh();
        sTerminal.auto(sTerminal.getWorkspacePosition());
        Printer.printFooter();
        while(Printer.printMainMenu()!=-1) { }

        sTerminal.getScreen().stopScreen();

    }
}