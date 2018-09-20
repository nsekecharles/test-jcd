package beans;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public class Man extends Person {


    public Man(String firstName, int qi) {
        super(firstName, qi);
    }

    @Override
    public final Gender getGender() {
        return Gender.MALE;
    }
}
