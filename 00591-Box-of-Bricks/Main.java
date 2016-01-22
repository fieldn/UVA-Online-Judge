import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int setNum = 1;
        while(sc.hasNext()) {
            int setSize = sc.nextInt();
            if (setSize == 0) return;
            int[] nums = new int[setSize];
            int total = 0;
            for (int i = 0; i < setSize; i++) {
                nums[i] = sc.nextInt();
                total += nums[i];
            }
            int stackHeight = total / setSize;
            int moves = 0;
            for (int i : nums) if (i > stackHeight) moves += (i - stackHeight);
            System.out.print("Set #" + setNum + "\nThe minimum number of moves is " + moves + ".\n\n");
            setNum++;
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
