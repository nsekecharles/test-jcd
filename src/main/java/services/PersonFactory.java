package services;

import beans.Man;
import beans.Person;
import beans.Woman;
import commons.PersonHelpers;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class PersonFactory {

    public static Person makeAPerson(String firstName, int qi) {
        if(PersonHelpers.isMan(firstName)) {
            return new Man(firstName, qi);
        } else if(PersonHelpers.isWoman(firstName)) {
            return new Woman(firstName, qi);
        }

        throw new UnqualifiableNameException(firstName);
    }
}
