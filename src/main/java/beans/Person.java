package beans;

/**
 * Created by nsekecharles on 19/09/2018.
 */
public abstract class Person {

    private String firstName;
    private String lastName;
    private int qi;

    public Person(String firstName, int qi) {
        this.firstName = firstName;
        this.qi = qi;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getQi() {
        return qi;
    }

    public abstract Gender getGender();
}
