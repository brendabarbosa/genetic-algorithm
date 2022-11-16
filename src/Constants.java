import java.util.Map;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }
    public static final Map<Integer, String> BINARYMAP =  Map.of(
            0, "000",
            1, "001",
            2, "010",
            3, "011",
            4, "100",
            5, "101",
            6, "110",
            7, "111"
    );

    public static final Integer POPULATIONCUTOFF = 4;
    public static final Integer GENECUTOFF = 4;
}