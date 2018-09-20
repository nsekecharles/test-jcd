package services;

/**
 * Created by nsekecharles on 20/09/2018.
 */
public class UnqualifiableNameException extends RuntimeException {

    public UnqualifiableNameException(String name) {
        super("unable to evaluate : " + name);
    }
}
