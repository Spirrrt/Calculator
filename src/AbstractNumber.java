public abstract class AbstractNumber implements Number{

    protected final NumberType type;
    protected final int value;

    public AbstractNumber (NumberType type, int value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public NumberType getType() {
        return type;
    }

    @Override
    public abstract String toOriginal();

    public static Number getNumberObject(String input) {
        NumberType type = discoverType(input);
        try {
            return switch (type) {
                case ARABIC -> new ArabicNumber(NumberType.ARABIC, ArabicNumber.toInt(input));
                case ROMAN -> new RomanNumber(NumberType.ROMAN, RomanNumber.toInt(input));
            };
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: invalid number");
        }
    }

    public static Number getNumberObject(NumberType type, int value) {
        return switch (type) {
            case ARABIC -> new ArabicNumber(NumberType.ARABIC, value);
            case ROMAN -> new RomanNumber(NumberType.ROMAN, value);
        };
    }

    private static NumberType discoverType(String input){
        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return NumberType.ARABIC;
        } else {
            return NumberType.ROMAN;
        }
    }
}
