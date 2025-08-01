import java.util.*;

public class LombokVM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> instructions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            instructions.add(sc.nextLine());
        }

        Stack<Integer> stack = new Stack<>();
        int register = 0;
        int ip = 0; 

        while (ip < instructions.size()) {
            String[] parts = instructions.get(ip).split(" ");
            String instr = parts[0];

            switch (instr) {
                case "PUSH":
                    int value = Integer.parseInt(parts[1]);
                    stack.push(value);
                    ip++;
                    break;

                case "STORE":
                    if (!stack.isEmpty()) {
                        register = stack.pop();
                    }
                    ip++;
                    break;

                case "LOAD":
                    stack.push(register);
                    ip++;
                    break;

                case "PLUS":
                    if (stack.size() >= 2) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a + b);
                    }
                    ip++;
                    break;

                case "TIMES":
                    if (stack.size() >= 2) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a * b);
                    }
                    ip++;
                    break;

                case "IFZERO":
                    int target = Integer.parseInt(parts[1]);
                    if (!stack.isEmpty() && stack.pop() == 0) {
                        ip = target;
                    } else {
                        ip++;
                    }
                    break;

                case "DONE":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    }
                    return;

                default:
                    System.err.println("Unknown instruction: " + instr);
                    return;
            }
        }
    }
}
