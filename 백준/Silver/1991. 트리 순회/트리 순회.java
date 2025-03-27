import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    solved.ac
    class4
    1991번 문제 : 트리 순회
 */

public class Main {

    static int N;

    static Node[] nodes;

    static StringBuilder forPreOrder = new StringBuilder();
    static StringBuilder forMiddleOrder = new StringBuilder();
    static StringBuilder forPostOrder = new StringBuilder();


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node((char) ('A' + i), null, null);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Node current = nodes[st.nextToken().charAt(0) - 'A'];
            char left = st.nextToken().charAt(0);

            if (left != '.') {
                current.left = nodes[left - 'A'];
            }

            char right = st.nextToken().charAt(0);
            if (right != '.') {
                current.right = nodes[right - 'A'];
            }
        }

        preOrder(nodes[0]);

        middleOrder(nodes[0]);

        postOrder(nodes[0]);

        System.out.println(forPreOrder);
        System.out.println(forMiddleOrder);
        System.out.println(forPostOrder);


    }

    static void preOrder(Node current) {

        forPreOrder.append(current.value);

        if (current.left != null) {
            preOrder(current.left);
        }

        if (current.right != null) {
            preOrder(current.right);
        }

    }

    static void middleOrder(Node current) {
        if (current.left != null) {
            middleOrder(current.left);
        }

        forMiddleOrder.append(current.value);

        if (current.right != null) {
            middleOrder(current.right);
        }
    }

    static void postOrder(Node current) {
        if (current.left != null) {
            postOrder(current.left);
        }

        if (current.right != null) {
            postOrder(current.right);
        }

        forPostOrder.append(current.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
