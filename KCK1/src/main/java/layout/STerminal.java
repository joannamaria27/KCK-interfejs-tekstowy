package layout;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.LinkedList;

public class STerminal {

    private int rows = 35, columns = 78, margin = 3;

    private TerminalSize headerSize = new TerminalSize(columns, 8);
    private TerminalSize workspaceSize = new TerminalSize(columns, 20);
    private TerminalSize terminalSize = new TerminalSize(columns, rows);
    private TerminalSize footerSize = new TerminalSize(columns, 2);
    private TerminalSize errorSize = new TerminalSize(columns, 3);

    private TerminalPosition headerPosition = new TerminalPosition(0, 0);
    private TerminalPosition workspacePosition = new TerminalPosition(0, headerSize.getRows()+1);
    private TerminalPosition menuPosition = new TerminalPosition(0, headerSize.getRows()+1);
    private TerminalPosition inputPosition = new TerminalPosition(25, headerSize.getRows()+2);
    private TerminalPosition pathPosition = new TerminalPosition(1, headerSize.getRows()+1);
    private TerminalPosition footerPosition = new TerminalPosition(1, 34);
    private TerminalPosition errorPosition = new TerminalPosition(0, 30);

    private TextColor headerFrontColor = new TextColor.RGB(255, 240, 175);
    private TextColor headerBackColor = new TextColor.RGB(87, 68, 59);

    private TextColor workspaceFrontColor = new TextColor.RGB(87, 68, 59);
    private TextColor workspaceBackColor = new TextColor.RGB(177, 233, 255);

    public void setHeaderFrontColor(TextColor headerFrontColor) {
        this.headerFrontColor = headerFrontColor;
    }

    public void setHeaderBackColor(TextColor headerBackColor) {
        this.headerBackColor = headerBackColor;
    }

    public void setWorkspaceFrontColor(TextColor workspaceFrontColor) {
        this.workspaceFrontColor = workspaceFrontColor;
    }

    public void setWorkspaceBackColor(TextColor workspaceBackColor) {
        this.workspaceBackColor = workspaceBackColor;
    }

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
        screen.setCursorPosition(null);
        textGraphics.setForegroundColor(headerFrontColor);
        textGraphics.setBackgroundColor(headerBackColor);
        textGraphics.putString(tp.getColumn(), tp.getRow(), "                                                                              \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+1, "     ██╗    ██╗██╗   ██╗██████╗  █████╗ ███████╗██╗   ██╗ █████╗███████╗         \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+2, "     ██║    ██║╚██╗ ██╔╝██╔══██╗██╔══██╗╚══███╔╝╚██╗ ██╔╝██╔═══╝╚══███╔╝       \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+3, "     ██║ █╗ ██║ ╚████╔╝ ██████╔╝██║  ██║  ███╔╝  ╚████╔╝ ██║      ███╔╝        \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+4, "     ██║███╗██║  ╚██╔╝  ██╔═══╝ ██║  ██║ ███╔╝    ╚██╔╝  ██║     ███╔╝         \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+5, "     ╚███╔███╔╝   ██║   ██║     ╚█████╔╝███████╗   ██║   ╚█████╗███████╗       \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+6, "      ╚══╝╚══╝    ╚═╝   ╚═╝      ╚════╝ ╚══════╝   ╚═╝    ╚════╝╚══════╝       \n");
        textGraphics.putString(tp.getColumn(), tp.getRow()+7, "                                                                               \n\n");
        screen.refresh();
        textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
        textGraphics.setForegroundColor(TextColor.ANSI.BLUE);
    }


    public void auto(TerminalPosition tp) throws IOException, InterruptedException {
        textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);

        textGraphics.setForegroundColor(headerFrontColor);
        for (int j = 0; j < 80; j++) {
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+1, "            :%XS@8XSSSSSS@%                       ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+2, "            S8   :8        @@                     ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+3, "         .@X.   .8        .XX.                    ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+4, "     ..:S8%;;;;;t8t;;;;;;:::X@.                   ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+5, "  %XXXS%S%tt;t;;;8t;;t;tttt%%@@SSSSSXSX:          ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+6, "  8;           ..8.          8;;SS:   %@.         ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+7, "  8t t@S%%SS;   .8.         .XXXt%S@t ;8          ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+8, " %8X8@     .8:. :8.         %@     .8S@8%.        ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+9, " @t.8:      X%  .8          @t      X% ;8         ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+10, "  XS8S     :@@SSS8XSSSSSSSSS88.    :8XSX          ");
            textGraphics.putString(tp.getColumn()+j, tp.getRow()+11, "    S8S888@8@                @8@88@8@X            ");
            textGraphics.putString(j, 25, String.valueOf(Symbols.BOLD_SINGLE_LINE_VERTICAL));
            Thread.sleep(25);
            screen.refresh();
        }
        textGraphics.setBackgroundColor(workspaceBackColor);
        textGraphics.setForegroundColor(workspaceFrontColor);
    }
}
