import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class OnBoardingService {

    public static List<Person> computeEligiblePassengers(List<Person> persons) {

        if(persons.isEmpty() ||
                persons.size() == 1 ||
                persons.stream().noneMatch(p->p.getGender() == Gender.FEMALE) ||
                persons.stream().noneMatch(p->p.getGender() == Gender.HOMME)) {
            return Collections.emptyList();
        }

        if(persons.size() == 2) {
            return persons;
        } else {
            List<Person> men = persons.stream()
                    .filter(p -> p.getGender() == Gender.HOMME)
                    .sorted((p1, p2) -> p2.getQi() - p1.getQi())
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

    }

    private static List<Person> makeOnbording(List<Person> firstPersonList, List<Person> secondPersonList) {

        List<Person> personsWhoWillTravelToMars = new ArrayList<>();

        for(int i = 0; i < firstPersonList.size(); i++) {
            personsWhoWillTravelToMars.add(firstPersonList.get(i));
            personsWhoWillTravelToMars.add(secondPersonList.get(i));
        }

        return personsWhoWillTravelToMars;
    }
}
