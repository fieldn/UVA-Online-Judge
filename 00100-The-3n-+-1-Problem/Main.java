import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        while (sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int l = 0, m = 0;
            if (j < i) {
                l = j;
                m = i;
            } else {
                l = i;
                m = j;
            }
            int max = Integer.MIN_VALUE;
            for (int k = l; k <= m; k++) {
                int v = k;
                int curr = 1;
                while (v != 1) {
                    v = (v % 2 == 1) ? (3 * v + 1) : (v / 2);
                    curr++;
                }
                if (curr > max) max = curr;
            }
            System.out.println("" + i + " " + j + " " + max);
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
