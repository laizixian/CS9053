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
        final int col = asciiArt[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0 ; j < col; j++) {
                sb.append(asciiArt[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    protected void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
