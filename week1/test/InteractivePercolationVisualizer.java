/****************************************************************************
 *  Compilation:  javac InteractivePercolationVisualizer.java
 *  Execution:    java InteractivePercolationVisualizer N
 *  Dependencies: Percolation.java StdDraw.java StdOut.java
 *
 *  This program takes the grid size N as a command-line argument.
 *  Then, the user repeatdly clicks sites to open with the mouse.
 *  After each site is opened, it draws full sites in light blue,
 *  open sites (that aren't full) in white, and blocked sites in black.
 *
 ****************************************************************************/

import java.awt.Font;

public class InteractivePercolationVisualizer {

    public static void main(String[] args) {
        // N-by-N percolation system (read from command-line, default = 10)
        int N = 10;
        if (args.length == 1) N = Integer.parseInt(args[0]);

        // number of sites opened
        int opened = 0;

        // turn on animation mode
        StdDraw.show(0);

        // set background
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // repeatedly open site specified my mouse click and draw resulting system
        StdOut.println(N);
        Percolation perc = new Percolation(N);
        while (true) {

            // detected mouse click
            if (StdDraw.mousePressed()) {

                // screen coordinates
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();

                // convert to row i, column j
                int i = (int) (N - Math.floor(y));
                int j = (int) (1 + Math.floor(x));
                if (i >= 1 && i <= N && j >= 1 && j <= N) {
                    if (!perc.isOpen(i, j)) {
                        StdOut.println(i + " " + j);
                        opened++;
                    }
                    perc.open(i, j);
                }

                // draw percolation system
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);
                for (int row = 1; row <= N; row++) {
                    for (int col = 1; col <= N; col++) {
                        if (perc.isFull(row, col))
                            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                        else if (perc.isOpen(row, col))
                            StdDraw.setPenColor(StdDraw.WHITE);
                        else
                            StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
                    }
                }

                // write status text
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(.25*N, -N*.025, "sites opened = " + opened);
                if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
                else                   StdDraw.text(.75*N, -N*.025, "does not percolate");
            }
            StdDraw.show(20);
        }
    }
}