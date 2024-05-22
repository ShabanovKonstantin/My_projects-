package org.example.twitterspring.exceptions.user;

public class InvalidLoginException extends Exception {

    public InvalidLoginException(String message) {
        super(message);
    }

}
