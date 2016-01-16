import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                int price = sc.nextInt();
                if (price * n > b) { 
                    String s = sc.nextLine();
                    continue;
                } else {
                    for (int j = 0; j < w; j++) {
                        int k = sc.nextInt();
                        if (k < n) continue;
                        else if (price * n < min) min = price * n;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) System.out.println("stay home");
            else System.out.println(min);
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

