package layout;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class UserInput {

    public static int chooseOption(int possibleOptions) throws IOException {
        int currentOption = 1;
        STerminal sTerminal = STerminal.getInstance();
        boolean keepRunning = true;

        KeyStroke keyPressed;

        while (keepRunning) {

            keyPressed = sTerminal.getTerminal().pollInput();
            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case ArrowDown:
                        if (currentOption + 1 <= possibleOptions) currentOption++;
                        Printer.refreshMenu(Printer.getOptionsTexts(), currentOption - 1);
                        break;
                    case ArrowUp:
                        if (currentOption - 1 >= 1) currentOption--;
                        Printer.refreshMenu(Printer.getOptionsTexts(), currentOption - 1);
                        break;
                    case Enter:
                        System.out.println("wybrano: " + currentOption);
                        Printer.clearWorkingArea();
                        return currentOption;
                    case Escape:
                        Printer.clearWorkingArea();
                        return -1;
                }
            }
        }
        return currentOption;
    }

    public static String[] getUserInput(int inputsNumber) throws IOException {
        String[] strings = new String[inputsNumber];
        int currentIndex = 0, i = 1;
        STerminal sTerminal = STerminal.getInstance();
        KeyStroke keyPressed;
        StringBuilder sb = new StringBuilder();
        Printer.refreshMenu(Printer.getOptionsTexts(), 0);
        while (true) {
            keyPressed = sTerminal.getTerminal().pollInput();
            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case Character:
                        sb.append(keyPressed.getCharacter());
                        sTerminal.getTextGraphics().putString(sTerminal.getWorkspacePosition().getColumn()+20, sTerminal.getWorkspacePosition().getRow()+i, sb.toString());
                        sTerminal.getScreen().refresh();
                        System.out.println(keyPressed.getCharacter());
                        break;
                    case Enter:
                        strings[currentIndex] = sb.toString();
                        Printer.refreshMenu(Printer.getOptionsTexts(), i);
                        currentIndex++;
                        i++;
                        sb = new StringBuilder();
                        if (currentIndex >= inputsNumber) {
                            Printer.clearWorkingArea();
                            return strings;
                        }
                        break;
                    case Backspace:
                        if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
                        sTerminal.getTextGraphics().putString(sTerminal.getWorkspacePosition().getColumn()+20, sTerminal.getWorkspacePosition().getRow()+i, "                  ");
                        sTerminal.getTextGraphics().putString(sTerminal.getWorkspacePosition().getColumn()+20, sTerminal.getWorkspacePosition().getRow()+i, sb.toString());
                        sTerminal.getScreen().refresh();
                        break;
                }
            }
        }
    }
}
