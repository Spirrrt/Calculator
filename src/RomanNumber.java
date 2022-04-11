import java.util.TreeMap;

public class RomanNumber extends AbstractNumber{

    public RomanNumber(NumberType type, int value) {
        super(type, value);
        if (value < 1) {
            throw new IllegalArgumentException("Invalid input: allowed Roman number not exceeding 1");
        }
    }

    public static int toInt(String input) {
        switch (input) {
            case "I" -> {
                return 1;
            }
            case "II" -> {
                return 2;
            }
            case "III" -> {
                return 3;
            }
            case "IV" -> {
                return 4;
            }
            case "V" -> {
                return 5;
            }
            case "VI" -> {
                return 6;
            }
            case "VII" -> {
                return 7;
            }
            case "VIII" -> {
                return 8;
            }
            case "IX" -> {
                return 9;
            }
            case "X" -> {
                return 10;
            }
            default -> throw new IllegalArgumentException("Invalid input: invalid number");
        }
    }

    @Override
    public String toOriginal() {
        final TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        return toRoman(value, map);
    }

    private static String toRoman(int number, TreeMap<Integer, String> map) {
        int l =  map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l, map);
    }
}
