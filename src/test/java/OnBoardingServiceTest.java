import beans.Person;
import org.junit.Test;
import services.OnBoardingService;
import services.PersonFactory;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class OnBoardingServiceTest {

    private OnBoardingService sut = new OnBoardingService();

    public static final String ORNELA = "Ornela";
    public static final String THOMAS = "Thomas";
    public static final String WILLIAM = "William";
    public static final String ODILE = "Odile";
    public static final String ILDA = "ilda";

    private static final Map<String, Person> personTestData = Collections.unmodifiableMap(
            new HashMap<String,Person>() {
                {
                    put(ORNELA, PersonFactory.makeAPerson(ORNELA, 123));
                    put(THOMAS,  PersonFactory.makeAPerson(THOMAS, 123));
                    put(WILLIAM, PersonFactory.makeAPerson(WILLIAM, 140));
                    put(ODILE,  PersonFactory.makeAPerson(ODILE, 130));
                    put(ILDA, PersonFactory.makeAPerson(ILDA, 130));
                }
            });

    @Test
    public void should_return_empty_onboarding_list_given_an_empty_person_list() throws Exception {

        // Given
        List<Person> empty = Collections.EMPTY_LIST;

        // When
        List<Person> persons = sut.computeEligiblePassengers(empty);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_empty_onboarding_list_given_a_list_with_one_person() throws Exception {

        // Given
        List<Person> personListWithOnePerson = new ArrayList<>();
        personListWithOnePerson.add(personTestData.get(ORNELA));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListWithOnePerson);

        // Assert
        assertThat(persons).isEmpty();

    }


    @Test
    public void should_return_empty_onboarding_list_given_a_list_without_women() throws Exception {

        // Given
        List<Person> personListContainingOnlyMen = new ArrayList<>();
        personListContainingOnlyMen.add(personTestData.get(THOMAS));
        personListContainingOnlyMen.add(personTestData.get(WILLIAM));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListContainingOnlyMen);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_empty_onboarding_list_given_a_list_without_men() throws Exception {

        // Given
        List<Person> personListContainingOnlyWomen = new ArrayList<>();
        personListContainingOnlyWomen.add(personTestData.get(ODILE));
        personListContainingOnlyWomen.add(personTestData.get(ORNELA));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListContainingOnlyWomen);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        personListContainingAManAndAWoman.add(personTestData.get(ODILE));
        personListContainingAManAndAWoman.add(personTestData.get(THOMAS));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(personTestData.get(ODILE), personTestData.get(THOMAS));
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman_given_three_persons() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        personListContainingAManAndAWoman.add(personTestData.get(ODILE));
        personListContainingAManAndAWoman.add(personTestData.get(THOMAS));
        personListContainingAManAndAWoman.add(personTestData.get(WILLIAM));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(personTestData.get(ODILE), personTestData.get(WILLIAM));
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman_given_four_persons() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        personListContainingAManAndAWoman.add(personTestData.get(ODILE));
        personListContainingAManAndAWoman.add(personTestData.get(THOMAS));
        personListContainingAManAndAWoman.add(personTestData.get(WILLIAM));
        personListContainingAManAndAWoman.add(personTestData.get(ILDA));

        // When
        List<Person> persons = sut.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(personTestData.get(ODILE),
                personTestData.get(THOMAS),
                personTestData.get(WILLIAM),
                personTestData.get(ILDA));
    }
}
