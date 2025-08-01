import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() ||
                    (c == ')' && stack.pop() != '(') ||
                    (c == '}' && stack.pop() != '{') ||
                    (c == ']' && stack.pop() != '[')) {
                    System.out.println("Not Matching");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Matching" : "Not Matching");
    }
}
