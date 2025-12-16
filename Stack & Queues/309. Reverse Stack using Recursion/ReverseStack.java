import java.util.Stack;

public class ReverseStack {
    // Insert element at bottom of stack
    private static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }

    // Reverse the stack
    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty())
            return;

        int top = st.pop();
        reverse(st); // reverse remaining
        insertAtBottom(st, top); // insert popped at bottom
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverse(st);

        System.out.println(st); // Output: [1, 2, 3, 4] → reversed order
    }
}
