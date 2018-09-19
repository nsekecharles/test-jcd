import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class Census {


    public static List<String> sort(List<String> stringsToSort) {

        List<String> sortedList = stringsToSort.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(toList());

        return sortedList;
    }
}
