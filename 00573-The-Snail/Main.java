import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        while(sc.hasNext()) {
            int h = sc.nextInt();
            if (h == 0) return;
            int success = 1, day = 0;
            double u = (double)sc.nextInt();
            double d = (double)sc.nextInt();
            double f = (double)sc.nextInt() / 100;
            double fatigue = u * f, inH = 0.0;
            while(inH <= h) {
                if (inH < 0) {
                    success = 0;
                    break;
                }
                inH += u;
                if (inH > h) break;
                inH -= d;
                u -= fatigue;
                if (u < 0) u = 0;
                day ++;
            }
            if (success == 1) System.out.println("success on day " + (day + 1));
            else System.out.println("failure on day " + day);
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
