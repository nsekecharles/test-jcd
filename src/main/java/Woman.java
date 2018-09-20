/**
 * Created by nsekecharles on 19/09/2018.
 */
public class Woman extends Person {

    public Woman(String firstName, int qi) {
        super(firstName, qi);
    }

    @Override
    public Gender getGender() {
        return Gender.FEMALE;
    }
}
