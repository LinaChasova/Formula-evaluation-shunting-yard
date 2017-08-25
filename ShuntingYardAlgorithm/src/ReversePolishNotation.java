/**
 * Created by AlinaCh on 03.02.2017.
 */
public class ReversePolishNotation {

    private LinkedStack<String> operator = new LinkedStack<>();

    public String reversePolishNotation(LinkedQueue<String> output) {
        while (!output.isEmpty()) {
            String check = output.dequeue();
            checkString(check);
        }
        String formated = String.format("%.2f",Double.parseDouble(operator.pop()));
        return formated;
    }

    private void checkString(String s) {
        switch(s) {
            case "+": case "-": case "*": case "/": calculation(s);
                                                    break;
            default:                                operator.push(s);
        }
    }

    private void calculation(String s) {
        Double a = Double.parseDouble(operator.pop());
        Double b = Double.parseDouble(operator.pop());
        Double result = 0.0;
        switch(s) {
            case "+":   result = b + a;
                        break;
            case "-":   result = b - a;
                        break;
            case "*":   result = b * a;
                        break;
            case "/":   result = b / a;
                        break;
        }
        operator.push(Double.toString(result));
    }
}
