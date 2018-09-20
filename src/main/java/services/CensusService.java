package services;

import beans.Person;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class CensusService {


    private static final int DEFAULT_QI = 123;

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
        return PersonFactory.makeAPerson(name, DEFAULT_QI);
    }
}
