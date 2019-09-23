package edu.nyu.cs9053.homework3;

/**
 * User: blangel
 */
public class AsciiArtPrinter {

    /**
     * @implNote should only print values within {@code asciiArt} and nothing else within this method
     * @param asciiArt to print
     */
    public void print(char[][] asciiArt) {
	// TODO - implement this
        final int row = asciiArt.length;
        final int col = asciiArt.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0 ; j < col; j++) {
                System.out.print(asciiArt[i][j]);
            }
            System.out.println("");
        }
    }

    protected void clearScreen() {
        System.out.printf("\u001B[51;1H");
    }

}
