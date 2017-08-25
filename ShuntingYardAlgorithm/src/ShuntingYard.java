import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * Created by AlinaCh on 03.02.2017.
 */
public class ShuntingYard {

    private LinkedQueue<String> output = new LinkedQueue<>();
    private LinkedStack<String> operator = new LinkedStack<>();
    private StreamTokenizer check;

    public LinkedQueue shuntingYard(Reader r) throws IOException, MissmatchedParanthesesException {
        check = new StreamTokenizer(r);
        checkToken();

        while (!operator.isEmpty()) {
            if (operator.peek().equals("(")) throw new MissmatchedParanthesesException("Wrong input");
            output.enqueue(operator.pop());
        }
        return output;
    }

    private void checkToken() throws IOException, MissmatchedParanthesesException {
        boolean end = false;
        while (!end) {
            check.ordinaryChar(47);
            int token = check.nextToken();
            switch (token) {
                case StreamTokenizer.TT_EOF:    end = true;
                                                break;
                case StreamTokenizer.TT_NUMBER: output.enqueue(Double.toString(check.nval));
                                                break;
                case 43:                        checkPrecedence();
                                                operator.push("+");
                                                break;
                case 45:                        checkPrecedence();
                                                operator.push("-");
                                                break;
                case 42:                        operator.push("*");
                                                break;
                case 47:                        operator.push("/");
                                                break;
                case 40:                        operator.push("(");
                                                break;
                case 41:                        checkOperator();
                                                break;
            }
        }
    }

    private void checkOperator() throws MissmatchedParanthesesException {
        boolean flag = false;
        while (!operator.isEmpty()) {
            if (!operator.peek().equals("(")) {
                output.enqueue(operator.pop());
            } else {
                String temporal = operator.pop();
                flag = true;
            }
        }
        if (!flag) throw new MissmatchedParanthesesException("Wrong input");
    }

    public void checkPrecedence() {
        if (!operator.isEmpty() && (operator.peek().equals("/") || operator.peek().equals("*"))) {
            output.enqueue(operator.pop());
        }
    }

    /*public String toString() {
        String result = "";
        while (!output.isEmpty()) {
            result = result + output.dequeue() + " ";
        }
        return result;
    }*/

    public static void main(String[] args) {

    }
}
