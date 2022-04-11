public class Calculator {
    private final Number first;
    private final Number second;
    private final String operator;

    public Calculator(Number first, Number second, String operator) {
        this.first = first;
        this.second = second;
        this.operator = operator;
        checkForRules();
    }

    public Calculator(String first, String operator, String second) {
        this.operator = operator;
        this.first = ArabicNumber.getNumberObject(first);
        this.second = ArabicNumber.getNumberObject(second);
        checkForRules();
    }

    public Calculator(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("Invalid input: bad input format");
        }
        this.first = ArabicNumber.getNumberObject(input[0]);
        this.operator = input[1];
        this.second = ArabicNumber.getNumberObject(input[2]);
        checkForRules();
    }

    private void checkForRules() {
        if (first.getType() != second.getType()) {
            throw new IllegalArgumentException("Invalid input: mismatch types");
        }
        if (first.getValue() < 1 || first.getValue() > 10 || second.getValue() < 1 || second.getValue() > 10) {
            throw new IllegalArgumentException("Invalid input: invalid number");
        }
    }

    public String evaluate() {
        int resultValue;
        switch (operator) {
            case "+" -> {
                resultValue = first.getValue() + second.getValue();
            }
            case "-" -> {
                resultValue = first.getValue() - second.getValue();
            }
            case "*" -> {
                resultValue = first.getValue() * second.getValue();
            }
            case "/" -> {
                resultValue = first.getValue() / second.getValue();
            }
            default -> throw new IllegalArgumentException("Invalid input: unknown operator");
        }
        return AbstractNumber.getNumberObject(first.getType(), resultValue).toOriginal();
    }
}
