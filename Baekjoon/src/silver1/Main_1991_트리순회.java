package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
//            System.out.println(s+" "+left+" "+right);
            list.get(s).add(new Node(left, right));
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb.toString());
    }

    private static void preOrder(int parent) {
        for (Node node : list.get(parent)) {
            int l = node.left;
            int r = node.right;
            sb.append((char) (parent + 'A'));
            if (l != -19) preOrder(l);
            if (r != -19) preOrder(r);
        }
    }

    private static void inOrder(int parent) {
        for (Node node : list.get(parent)) {
            int l = node.left;
            int r = node.right;
            if (l != -19) inOrder(l);
            sb.append((char) (parent + 'A'));
            if (r != -19) inOrder(r);
        }
    }

    private static void postOrder(int parent) {
        for (Node node : list.get(parent)) {
            int l = node.left;
            int r = node.right;
            if (l != -19) postOrder(l);
            if (r != -19) postOrder(r);
            sb.append((char) (parent + 'A'));
        }
    }

}
