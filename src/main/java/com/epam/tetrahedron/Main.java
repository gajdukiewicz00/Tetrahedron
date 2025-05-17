package com.epam.tetrahedron;

import com.epam.tetrahedron.service.ApplicationRunner;

public class Main {
    public static void main(String[] args) {
        new ApplicationRunner().run("resources/input.txt");
    }
}
