import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = sc.nextInt();
        for (int cc = 0; cc < cases; cc++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if (r == 0 || c == 0) continue;
            char[][] grid1 = new char[r][c], grid2 = new char[r][c];
            for (int i = 0; i < r; i++) {
                String strin = sc.nextLine();
                for (int j = 0; j < c; j++) {
                    grid1[i][j] = strin.charAt(j);
                    grid2[i][j] = grid1[i][j];
                }
            }
            for (int k = 0; k < d; k++) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        char place = grid1[i][j];
                        if (i != 0) {
                            char p = grid1[i-1][j];
                            if (place == 'R') {
                                if (p == 'P')       {grid2[i][j] = 'P'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'S') {
                                if (p == 'R')       {grid2[i][j] = 'R'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'P') { 
                                if (p == 'S')       {grid2[i][j] = 'S'; continue; }
                                else                grid2[i][j] = place;
                            }
                        }
                        if (j != c - 1) {
                            char p = grid1[i][j + 1]; 
                            if (place == 'R') {
                                if (p == 'P')       {grid2[i][j] = 'P'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'S') {
                                if (p == 'R')       {grid2[i][j] = 'R'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'P') { 
                                if (p == 'S')       {grid2[i][j] = 'S'; continue; }
                                else                grid2[i][j] = place;
                            }
                        }
                        if (i != r - 1) {
                            char p = grid1[i + 1][j];
                            if (place == 'R') {
                                if (p == 'P')       {grid2[i][j] = 'P'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'S') {
                                if (p == 'R')       {grid2[i][j] = 'R'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'P') { 
                                if (p == 'S')       {grid2[i][j] = 'S'; continue; }
                                else                grid2[i][j] = place;
                            }
                        }
                        if (j != 0) {
                            char p = grid1[i][j - 1];
                            if (place == 'R') {
                                if (p == 'P')       {grid2[i][j] = 'P'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'S') {
                                if (p == 'R')       {grid2[i][j] = 'R'; continue; }
                                else                grid2[i][j] = place;
                            } else if (place == 'P') { 
                                if (p == 'S')       {grid2[i][j] = 'S'; continue; }
                                else                grid2[i][j] = place;
                            }
                        }
                    }
                }
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        grid1[i][j] = grid2[i][j];
                    }
                }
            }
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    out.print(grid2[i][j]);
                }
                out.print("\n");
            }
            if (cc != cases - 1) out.print("\n");
        }
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public boolean hasNext() {
            try {
                boolean a = br.ready();
                return a;
            } catch (IOException e) {
                return false;
            }
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
