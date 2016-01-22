import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int c = 0;
        while(sc.hasNext()) {
            c ++;
            int l = sc.nextInt();
            if (l == 0) break;
            int w = sc.nextInt();
            char[][] field = new char[l][w];
            for (int i = 0; i < l; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < w; j++) {
                    field[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < w; j++) {
                    char loc = field[i][j];
                    int count = 0;
                    if (loc == '*') continue;
                    else {
                        try { if (field[i - 1][j - 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i - 1][j] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i - 1][j + 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i][j - 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i][j + 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i + 1][j - 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i + 1][j + 1] == '*') count ++; } catch (Exception e) {};
                        try { if (field[i + 1][j] == '*') count ++; } catch (Exception e) {};
                        field[i][j] = (char)(count + '0');
                    }
                }
            }
            if (c == 1) out.println("Field #1:");
            else out.println("\nField #" + c + ":");
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < w; j++) {
                    out.print(field[i][j]);
                }
                out.print("\n");
            }
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
