import java.util.*;
import static java.lang.System.out;

public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		input.nextLine();
		while (count > 0) {
			String equation = input.nextLine();
			out.println(toPostfix(equation));
			out.println(countPostfix(toPostfix(equation)));
			count--;
		}
		input.close();
	}

	private static int getPriority(char c) {
		// 傳入運算子，回傳優先度
		return c == '+' || c == '-' ? 1 : c == '*' || c == '/' ? 2 : 0;
	}

	public static String toPostfix(String equa) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder output = new StringBuilder();
		for (char c : equa.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!stack.isEmpty()
				// getPriority(stack.pop()))寫pop就直接pop了，要判斷的話用peek
						&& getPriority(c) <= getPriority(stack.peek())) {

					output.append(stack.pop());
				}
				stack.push(c);
				// 一個C只會push一次，所以不要寫在while裡
			} else if (c == ')') {
				while (stack.peek() != '(') {
					output.append(stack.pop());
				}
				stack.pop();
			} else {
				output.append(c);
				// output.append(stack.pop()) 字元不會在stack中;
			}
		}
		/*
		 * while(!stack.isEmpty()){ output.append(stack.pop()); }
		 */
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}
		return output.toString();
	}

	public static float countPostfix(String PostfixStack) {
		Stack<Float> stack = new Stack<Float>();
		for (char c : PostfixStack.toCharArray()) {
			if ("+-*/".indexOf(c) != -1) {// 包含+-*/
				float operand2 = stack.pop();
				// operand1
				// 可以在pop出來的同時轉換型別?
				float operand1 = stack.pop();
				// operand2
				stack.push(countTwoElements(operand1, operand2, c));
			} else {
				stack.push(Float.parseFloat(String.valueOf(c)));
			}
		}
		return stack.peek();
	}

	public static float countTwoElements(float o1, float o2, char op) {
		switch (op) {
		case '+':
			return o1 + o2;
		case '-':
			return o1 - o2;
		case '*':
			return o1 * o2;
		case '/':
			return o1 / o2;
		default:
			throw new ArithmeticException(op + " not defined");
		}
	}
}
