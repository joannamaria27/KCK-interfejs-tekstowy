import layout.Printer;
import layout.STerminal;
import layout.UserInput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        STerminal sTerminal = STerminal.getInstance();
        sTerminal.getScreen().startScreen();
        sTerminal.printHeader(sTerminal.getHeaderPosition());
        sTerminal.getScreen().refresh();
        while(Printer.printMainMenu()!=-1) { }


        sTerminal.getScreen().stopScreen();

    }
}