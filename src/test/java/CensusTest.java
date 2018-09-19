import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class CensusTest {

    @Test
    public void should_sort_given_list_in_decrease_order() throws Exception {

        // given
        List<String> stringsToSort = Arrays.asList("thelastelement", "firstelement", "secondelement");


        // when
        List<String> sortedStrings = Census.sort(stringsToSort);

        // Assert
        List<String> expectedSortedStrings = Arrays.asList("firstelement", "secondelement", "thelastelement");
        assertThat(sortedStrings).containsExactlyElementsOf(expectedSortedStrings);
    }

    @Test
    public void should_sort_given_list_in_decrease_order_ignoring_order() throws Exception {

        // given
        List<String> stringsToSort = Arrays.asList("TheLastElement", "firstelement", "Secondelement");


        // when
        List<String> sortedStrings = Census.sort(stringsToSort);

        // Assert
        List<String> expectedSortedStrings = Arrays.asList("firstelement", "Secondelement", "TheLastElement");
        assertThat(sortedStrings).containsExactlyElementsOf(expectedSortedStrings);
    }
}