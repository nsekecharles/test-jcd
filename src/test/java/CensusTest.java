import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class CensusTest {

    private Census sut = new Census();

    @Test
    public void should_sort_given_list_in_decrease_order() throws Exception {

        // given
        List<String> stringsToSort = asList("thelastelement", "firstelement", "secondelement");

        // when
        List<String> sortedStrings = sut.sort(stringsToSort);

        // Assert
        List<String> expectedSortedStrings = asList("firstelement", "secondelement", "thelastelement");
        assertThat(sortedStrings).containsExactlyElementsOf(expectedSortedStrings);
    }

    @Test
    public void should_sort_given_list_in_decrease_order_ignoring_order() throws Exception {

        // given
        List<String> stringsToSort = asList("TheLastElement", "firstelement", "Secondelement");

        // when
        List<String> sortedStrings = sut.sort(stringsToSort);

        // Assert
        List<String> expectedSortedStrings = asList("firstelement", "Secondelement", "TheLastElement");
        assertThat(sortedStrings).containsExactlyElementsOf(expectedSortedStrings);
    }

    @Test
    public void should_return_filled_list() throws Exception {

        final List<Person> persons = sut.tourVersMars(Arrays.asList("une femme",
                "hum un homm",
                "Ahh une femme"));

        assertThat(persons)
                .extracting(Person::getGender)
                .containsExactly(Gender.FEMALE, Gender.HOMME, Gender.FEMALE);

    }
}