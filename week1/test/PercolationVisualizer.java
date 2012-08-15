/****************************************************************************
 *  Compilation:  javac PercolationVisualizer.java
 *  Execution:    java PercolationVisualizer input.txt
 *  Dependencies: Percolation.java StdDraw.java In.java
 *
 *  This program takes the name of a file as a command-line argument.
 *  From that file, it
 *
 *    - Reads the grid size N of the percolation system.
 *    - Creates an N-by-N grid of sites (intially all blocked)
 *    - Reads in a sequence of sites (row i, column j) to open.
 *
 *  After each site is opened, it draws full sites in light blue,
 *  open sites (that aren't full) in white, and blocked sites in black,
 *  with with site (1, 1) in the upper left-hand corner.
 *
 ****************************************************************************/

public class PercolationVisualizer {

    public static void main(String[] args) {
        In in = new In(args[0]);    // input file
        int N = in.readInt();       // N-by-N percolation system
        int opened = 0;             // number of distinct sites opened

        // set x- and y-scale
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);

        // turn on animation mode
        StdDraw.show(0);

        // draw background
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            if (!perc.isOpen(i, j)) {
                perc.open(i, j);
                opened++;
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

            StdDraw.show(10);
        }
    }
}
