import org.junit.Test;
import commons.PersonHelpers;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class PersonHelpersTest {


    @Test
    public void an_uppercase_firstname_starting_and_ending_with_a_vowel_should_be_a_woman() throws Exception {

        final String firstName = "AZERTY";

        assertThat(PersonHelpers.isWoman(firstName)).isTrue();
    }

    @Test
    public void an_uppercase_firstname_starting_and_ending_with_a_consonant_should_be_a_man() throws Exception {

        final String firstName = "QWERTYP";

        assertThat(PersonHelpers.isMan(firstName)).isTrue();
    }

    @Test
    public void a_lowercase_firstname_starting_and_ending_with_a_vowel_should_be_a_woman() throws Exception {

        final String firstName = "AZERTY";

        assertThat(PersonHelpers.isWoman(firstName)).isTrue();
    }

    @Test
    public void a_lowercase_firstname_starting_and_ending_with_a_consonant_should_be_a_man() throws Exception {

        final String firstName = "qwertyp";

        assertThat(PersonHelpers.isMan(firstName)).isTrue();
    }

    @Test
    public void a_firstname_starting_with_a_vowel_should_not_be_a_woman() throws Exception {

        final String firstName = "AZERT";

        assertThat(PersonHelpers.isWoman(firstName)).isFalse();
    }

    @Test
    public void a_firstname_starting_with_a_consonant_should_not_be_a_man() throws Exception {

        final String firstName = "pEEEE";

        assertThat(PersonHelpers.isMan(firstName)).isFalse();
    }

    @Test
    public void a_firstname_ending_with_a_vowel_should_not_be_a_woman() throws Exception {

        final String firstName = "sAZERTy";

        assertThat(PersonHelpers.isWoman(firstName)).isFalse();
    }

    @Test
    public void a_firstname_ending_with_a_consonant_should_not_be_a_man() throws Exception {

        final String firstName = "eeeeep";

        assertThat(PersonHelpers.isMan(firstName)).isFalse();
    }
}