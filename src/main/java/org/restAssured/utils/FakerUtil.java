package org.restAssured.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    private static Faker faker;
    public static String getFirstName(){
        faker = new Faker();
        return faker.name().firstName();
    }
    public static String getLastName(){
        faker = new Faker();
        return faker.name().lastName();
    }
}
