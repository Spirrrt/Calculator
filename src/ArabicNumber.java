public class ArabicNumber extends AbstractNumber{

    public ArabicNumber(NumberType type, int value) {
        super(type, value);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    @Override
    public String toOriginal() {
        return Integer.toString(value);
    }
}
