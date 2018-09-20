package services;

import beans.Gender;
import beans.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class OnBoardingService {

    public List<Person> computeEligiblePassengers(List<Person> persons) {

        if(nobodyCanGoToMars(persons)) {
            return Collections.emptyList();
        }

        List<Person> men = persons.stream()
                .filter(p -> p.getGender() == Gender.MALE)
                .sorted((p1, p2) -> p2.getQi() - p1.getQi()) // TODO à QI égaux il faudrait définir une règle pour comparer deux personnes
                .collect(Collectors.toList());

        List<Person> women = persons.stream()
                .filter(p -> p.getGender() == Gender.FEMALE)
                .sorted((p1, p2) -> p1.getQi() - p1.getQi())
                .collect(Collectors.toList());

        if(men.size() > women.size()) {
            return makeOnbording(women, men);
        } else {
            return makeOnbording(men, women);
        }
    }

    private boolean nobodyCanGoToMars(List<Person> persons) {

        final boolean thereAreNoMen = persons.stream().noneMatch(p -> p.getGender() == Gender.FEMALE);
        final boolean thereAreNoWomen = persons.stream().noneMatch(p -> p.getGender() == Gender.MALE);

        return thereAreNoMen || thereAreNoWomen;
    }

    private List<Person> makeOnbording(List<Person> firstPersonList, List<Person> secondPersonList) {

        List<Person> personsWhoWillTravelToMars = new ArrayList<>();

        for(int i = 0; i < firstPersonList.size(); i++) {
            personsWhoWillTravelToMars.add(firstPersonList.get(i));
            personsWhoWillTravelToMars.add(secondPersonList.get(i));
        }

        return personsWhoWillTravelToMars;
    }
}
