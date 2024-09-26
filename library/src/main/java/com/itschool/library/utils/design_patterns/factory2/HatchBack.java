package com.itschool.library.utils.design_patterns.factory2;

public class HatchBack implements Car {

    @Override
    public void assemble() {
        System.out.println("Assembling hatchback car");
    }
}
