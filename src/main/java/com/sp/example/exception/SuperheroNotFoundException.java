package com.sp.example.exception;

public class SuperheroNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SuperheroNotFoundException(Long id) {
        super("Could not find Superhero " + id);
    }

}
