package ui;

/**
 * Contains functions used to interact with the user.
 */
public class Ui {

    /**
     * Prints a line made up of '_'.
     */
    public void printLine() {
        System.out.println("____________________________________________________________________________________");
    }

    public void printWithIndentation(String line) {
        System.out.println("    " + line);
    }
}