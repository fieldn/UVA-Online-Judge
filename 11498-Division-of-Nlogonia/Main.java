import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        String d = "divisa", nw = "NO", ne = "NE", se = "SE", sw = "SO";
        while(sc.hasNext()) {
            int iter = sc.nextInt();
            if (iter == 0) return;
            int divX = sc.nextInt();
            int divY = sc.nextInt();
            for (int i = 0; i< iter; i++) {
                int coorX = sc.nextInt();
                int coorY = sc.nextInt();
                if (coorX == divX || coorY == divY) System.out.println(d);
                else if (coorX < divX) {
                    if (coorY < divY) System.out.println(sw);
                    else System.out.println(nw);
                } else {
                    if (coorY < divY) System.out.println(se);
                    else System.out.println(ne);
                }
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

