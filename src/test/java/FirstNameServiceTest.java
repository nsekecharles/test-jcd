import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class FirstNameServiceTest {


    @Test
    public void an_uppercase_firstname_starting_and_ending_with_a_vowel_should_be_a_woman() throws Exception {

        final String firstName = "AZERTY";

        assertThat(FirstNameService.isWoman(firstName)).isTrue();
    }

    @Test
    public void an_uppercase_firstname_starting_and_ending_with_a_consonant_should_be_a_man() throws Exception {

        final String firstName = "QWERTYP";

        assertThat(FirstNameService.isMan(firstName)).isTrue();
    }

    @Test
    public void a_lowercase_firstname_starting_and_ending_with_a_vowel_should_be_a_woman() throws Exception {

        final String firstName = "AZERTY";

        assertThat(FirstNameService.isWoman(firstName)).isTrue();
    }

    @Test
    public void a_lowercase_firstname_starting_and_ending_with_a_consonant_should_be_a_man() throws Exception {

        final String firstName = "qwertyp";

        assertThat(FirstNameService.isMan(firstName)).isTrue();
    }

    @Test
    public void a_firstname_starting_with_a_vowel_should_not_be_a_woman() throws Exception {

        final String firstName = "AZERT";

        assertThat(FirstNameService.isWoman(firstName)).isFalse();
    }

    @Test
    public void a_firstname_starting_with_a_consonant_should_not_be_a_man() throws Exception {

        final String firstName = "pEEEE";

        assertThat(FirstNameService.isMan(firstName)).isFalse();
    }

    @Test
    public void a_firstname_ending_with_a_vowel_should_not_be_a_woman() throws Exception {

        final String firstName = "sAZERTy";

        assertThat(FirstNameService.isWoman(firstName)).isFalse();
    }

    @Test
    public void a_firstname_ending_with_a_consonant_should_not_be_a_man() throws Exception {

        final String firstName = "eeeeep";

        assertThat(FirstNameService.isMan(firstName)).isFalse();
    }
}