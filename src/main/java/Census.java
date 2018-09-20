import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class Census {


    public List<String> sort(List<String> stringsToSort) {

        List<String> sortedList = stringsToSort.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(toList());

        return sortedList;
    }

    public List<Person> tourVersMars(List<String> firstNames) {
        return firstNames.stream()
                .map(name -> getPerson(name))
                .collect(Collectors.toList());
    }

    private Person getPerson(String name) {
        Person person;
        if(FirstNameService.isMan(name)) {
            person = new Man("Lucien", 122);
        } else if(FirstNameService.isWoman(name)) {
            person = new Woman("Emilie", 123);
        } else {
            throw new UnqualifiableNameException(name);
        }

        return person;
    }
}
