import java.util.Stack;

public class HanoiDynamicRoles {

    static int step = 0;

    public static void main(String[] args) {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> C = new Stack<>();

        // 3 Scheiben auf Stange A
        A.push(3);
        A.push(2);
        A.push(1);

        System.out.println("Schritt\tA\tB\tC\tRollen\t\tAnweisung");

        // Rollen: Q = A, Zw = B, Zi = C
        hanoi(3, A, B, C, "A", "B", "C");
    }

    static void hanoi(int n, Stack<Integer> Q, Stack<Integer> Zw, Stack<Integer> Zi,
                      String Qname, String Zwname, String Ziname) {

        if (n == 1) {
            logState(Q, Zw, Zi, Qname, Zwname, Ziname, "N=1 Basis");
            int disk = Q.pop();
            Zi.push(disk);
            logState(Q, Zw, Zi, Qname, Zwname, Ziname, "Move " + disk + " von " + Qname + " nach " + Ziname);
            return;
        }
// Rek1 
        logState(Q, Zw, Zi, Qname, Zwname, Ziname, "N=" + n + " Rek 1");
        hanoi(n - 1, Q, Zi, Zw, Qname, Ziname, Zwname);
// Rek II
        logState(Q, Zw, Zi, Qname, Zwname, Ziname, "N=" + n + " Rek 2");
        int disk = Q.pop();
        Zi.push(disk);
        logState(Q, Zw, Zi, Qname, Zwname, Ziname, "Move " + disk + " von " + Qname + " nach " + Ziname);
// Rek III
        logState(Q, Zw, Zi, Qname, Zwname, Ziname, "N=" + n + " Rek 3");
        hanoi(n - 1, Zw, Q, Zi, Zwname, Qname, Ziname);
    }

    static void logState(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C,
                         String Qname, String Zwname, String Ziname, String action) {
        System.out.printf("%d\t%s\t%s\t%s\tQ=%s, Zw=%s, Zi=%s\t%s%n",
                step++,
                stackToString(A),
                stackToString(B),
                stackToString(C),
                Qname, Zwname, Ziname,
                action
        );
    }

    static String stackToString(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
