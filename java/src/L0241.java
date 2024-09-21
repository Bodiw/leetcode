import java.util.ArrayList;
import java.util.List;

public class L0241 {

    private static List<Integer> aux(List<Integer> numbers, List<Character> operations) {
        List<Integer> answer = new ArrayList<>();

        if (numbers.size() == 1) {
            return numbers;
        } else if (numbers.size() == 2) {
            switch (operations.get(0)) {
                case '+':
                    return List.of(numbers.get(0) + numbers.get(1));
                case '-':
                    return List.of(numbers.get(0) - numbers.get(1));
                default: // *
                    return List.of(numbers.get(0) * numbers.get(1));
            }
        } else {
            for (int i = 0; i < operations.size(); i++) {
                List<Integer> leftside = aux(
                        numbers.subList(0, i + 1),
                        operations.subList(0, i));
                List<Integer> rightside = aux(
                        numbers.subList(i + 1, numbers.size()),
                        operations.subList(i + 1, operations.size()));

                for (Integer i1 : leftside) {
                    for (Integer i2 : rightside) {
                        switch (operations.get(i)) {
                            case '+':
                                answer.add(i1 + i2);
                                break;
                            case '-':
                                answer.add(i1 - i2);
                                break;
                            default: // *
                                answer.add(i1 * i2);
                                break;
                        }
                    }
                }
            }
            return answer;
        }
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder currentNumber = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else if (c == '+' || c == '-' || c == '*') {
                numbers.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0); // Reiniciamos para el siguiente número
                operators.add(c);
            }
        }

        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }

        return aux(numbers, operators);
    }
}
