import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class OnBoardingServiceTest {

    @Test
    public void should_return_empty_onboarding_list_given_an_empty_person_list() throws Exception {

        // Given
        List<Person> empty = Collections.EMPTY_LIST;

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(empty);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_empty_onboarding_list_given_a_list_with_one_person() throws Exception {

        // Given
        List<Person> personListWithOnePerson = new ArrayList<>();
        Person person = new Woman("Ornela", 123);
        personListWithOnePerson.add(person);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListWithOnePerson);

        // Assert
        assertThat(persons).isEmpty();

    }


    @Test
    public void should_return_empty_onboarding_list_given_a_list_without_women() throws Exception {

        // Given
        List<Person> personListContainingOnlyMen = new ArrayList<>();
        Person person1 = new Man("Thomas", 123);
        Person person2 = new Man("William", 123);

        personListContainingOnlyMen.add(person1);
        personListContainingOnlyMen.add(person2);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListContainingOnlyMen);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_empty_onboarding_list_given_a_list_without_men() throws Exception {

        // Given
        List<Person> personListContainingOnlyWomen = new ArrayList<>();
        Person person1 = new Woman("Odile", 130);
        Person person2 = new Woman("Ornela", 123);
        personListContainingOnlyWomen.add(person1);
        personListContainingOnlyWomen.add(person2);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListContainingOnlyWomen);

        // Assert
        assertThat(persons).isEmpty();
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        Person person1 = new Woman("Odile", 130);
        Person person2 = new Man("Thomas", 123);
        personListContainingAManAndAWoman.add(person1);
        personListContainingAManAndAWoman.add(person2);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(person1, person2);
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman_given_three_persons() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        Person person1 = new Woman("Odile", 130);
        Person person2 = new Man("Thomas", 123);
        Person person3 = new Man("William", 130);
        personListContainingAManAndAWoman.add(person1);
        personListContainingAManAndAWoman.add(person2);
        personListContainingAManAndAWoman.add(person3);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(person1, person3);
    }

    @Test
    public void should_return_onboarding_list_with_one_man_and_one_woman_given_four_persons() throws Exception {

        // Given
        List<Person> personListContainingAManAndAWoman = new ArrayList<>();
        Person person1 = new Woman("Odile", 130);
        Person person2 = new Man("Thomas", 123);
        Person person3 = new Man("William", 130);
        Person person4 = new Woman("ilda", 130);
        personListContainingAManAndAWoman.add(person1);
        personListContainingAManAndAWoman.add(person2);
        personListContainingAManAndAWoman.add(person3);
        personListContainingAManAndAWoman.add(person4);

        // When
        List<Person> persons = OnBoardingService.computeEligiblePassengers(personListContainingAManAndAWoman);

        // Assert
        assertThat(persons).containsOnly(person1, person2, person3, person4);
    }
}
