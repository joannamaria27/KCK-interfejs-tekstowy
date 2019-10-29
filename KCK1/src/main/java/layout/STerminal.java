package layout;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.LinkedList;

public class STerminal {

    private int rows = 35, columns = 78, margin = 3;

    private TerminalSize headerSize = new TerminalSize(columns, 8);
    private TerminalSize workspaceSize = new TerminalSize(columns, 22);
    private TerminalSize terminalSize = new TerminalSize(columns, rows);
    private TerminalSize footerSize = new TerminalSize(columns, 2);
    private TerminalSize errorSize = new TerminalSize(columns, 2);

    private TerminalPosition headerPosition = new TerminalPosition(0, 0);
    private TerminalPosition workspacePosition = new TerminalPosition(0, headerSize.getRows()+1);
    private TerminalPosition menuPosition = new TerminalPosition(0, headerSize.getRows()+1);
    private TerminalPosition inputPosition = new TerminalPosition(25, headerSize.getRows()+2);
    private TerminalPosition pathPosition = new TerminalPosition(1, headerSize.getRows()+1);
    private TerminalPosition footerPosition = new TerminalPosition(1, 34);
    private TerminalPosition errorPosition = new TerminalPosition(0, 32);

    private TextColor headerFrontColor = new TextColor.RGB(255, 119, 74);
    private TextColor headerBackColor = new TextColor.RGB(21, 15, 64);
    private TextColor workspaceFrontColor = headerFrontColor;
    private TextColor workspaceBackColor = new TextColor.RGB(31, 59, 14);

    private static STerminal instance;
    private Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).createTerminal();

    private Screen screen = new TerminalScreen(terminal);
    private TextGraphics textGraphics = screen.newTextGraphics();

    private STerminal() throws IOException {}

    public static STerminal getInstance() throws IOException {
        if(instance == null) instance = new STerminal();
        return instance;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public int getMargin() {
        return margin;
    }
    public TerminalPosition getPathPosition() {
        return pathPosition;
    }
    public TerminalPosition getErrorPosition() {
        return errorPosition;
    }
    public TerminalSize getHeaderSize() {
        return headerSize;
    }
    public TerminalSize getWorkspaceSize() {
        return workspaceSize;
    }
    public TerminalSize getTerminalSize() {
        return terminalSize;
    }
    public TerminalPosition getHeaderPosition() {
        return headerPosition;
    }
    public TerminalPosition getWorkspacePosition() {
        return workspacePosition;
    }
    public TextColor getHeaderFrontColor() {
        return headerFrontColor;
    }
    public TextColor getHeaderBackColor() {
        return headerBackColor;
    }
    public TextColor getWorkspaceFrontColor() {
        return workspaceFrontColor;
    }
    public TextColor getWorkspaceBackColor() {
        return workspaceBackColor;
    }
    public Terminal getTerminal() {
        return terminal;
    }
    public Screen getScreen() {
        return screen;
    }
    public TextGraphics getTextGraphics() {
        return textGraphics;
    }
    public TerminalPosition getMenuPosition() {
        return menuPosition;
    }
    public TerminalPosition getInputPosition() {
        return inputPosition;
    }

    public TerminalSize getFooterSize() {
        return footerSize;
    }

    public TerminalSize getErrorSize() {
        return errorSize;
    }

    public TerminalPosition getFooterPosition() {
        return footerPosition;
    }

    public void printHeader(TerminalPosition tp) throws IOException {
        textGraphics.setForegroundColor(headerFrontColor);
        textGraphics.setBackgroundColor(headerBackColor);
        textGraphics.putString(tp.getColumn(), tp.getRow(), "                                                                              \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+1, "#    # #   # ####   ####  ##### #   #  ####  #####   ##   #    #    # #   ##  \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+2, "#    #  # #  #   # #    #    #   # #  #    #     #  #  #  #    ##   # #  #  # \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+3, "#    #   #   #   # #    #   #     #   #         #  #    # #    # #  # # #    #\n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+4, "# ## #   #   ####  #    #  #      #   #        #   ###### #    #  # # # ######\n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+5, "##  ##   #   #     #    # #       #   #    #  #    #    # #    #   ## # #    #\n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+6, "#    #   #   #      #### ######   #    #### ##### #     # #### #    # # #    #\n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+7, "                                                                              \n\n");
        screen.refresh();
        textGraphics.setBackgroundColor(workspaceBackColor);
        textGraphics.setForegroundColor(workspaceFrontColor);
    }
}