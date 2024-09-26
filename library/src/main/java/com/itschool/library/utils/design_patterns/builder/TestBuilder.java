package com.itschool.library.utils.design_patterns.builder;

public class TestBuilder {

    public static void main(String[] args) {
        Meal meal = new Meal.Builder()
                .mainCourse("test main course")
                .drink("some drink")
                .side("some side dish")
                .build();
    }
}
