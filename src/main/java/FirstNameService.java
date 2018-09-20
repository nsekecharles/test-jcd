/**
 * Created by nsekecharles on 19/09/2018.
 */
public class FirstNameService {

    private static final String MAN_FIRSTNAME_REGEX = "^[^AEIOUY].*.[^AEIOUY]$";
    private static final String WOMAN_FIRSTNAME_REGEXP = "^[AEIOUY].*.[AEIOUY]$";

    public static boolean isMan(String firstName) {
        return firstName.toUpperCase().matches(MAN_FIRSTNAME_REGEX);
    }

    public static boolean isWoman(String firstName) {
        return firstName.toUpperCase().matches(WOMAN_FIRSTNAME_REGEXP);
    }
}
