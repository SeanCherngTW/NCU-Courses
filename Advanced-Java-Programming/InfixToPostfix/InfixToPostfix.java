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
		// �ǤJ�B��l�A�^���u����
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
				// getPriority(stack.pop()))�gpop�N����pop�F�A�n�P�_���ܥ�peek
						&& getPriority(c) <= getPriority(stack.peek())) {

					output.append(stack.pop());
				}
				stack.push(c);
				// �@��C�u�|push�@���A�ҥH���n�g�bwhile��
			} else if (c == ')') {
				while (stack.peek() != '(') {
					output.append(stack.pop());
				}
				stack.pop();
			} else {
				output.append(c);
				// output.append(stack.pop()) �r�����|�bstack��;
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
			if ("+-*/".indexOf(c) != -1) {// �]�t+-*/
				float operand2 = stack.pop();
				// operand1
				// �i�H�bpop�X�Ӫ��P���ഫ���O?
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
