package com.example.homework4;

public class Bird {
    public String birdName;
    public int zipcode;
    public String personName;

    public Bird() {
        // Firebase creates empty object using this constructor, then populates it
    }

    public Bird(String birdNameIn, int zipcodeIn, String personNameIn) {
        // when we create a Bird, we will use this constructor and give it the parameters
        birdName = birdNameIn;
        zipcode = zipcodeIn;
        personName = personNameIn;
    }
}
