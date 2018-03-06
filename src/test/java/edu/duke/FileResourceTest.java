package edu.duke;

import org.junit.Test;

public class FileResourceTest {

    @Test
    public void filerResourceTest() {

        ClassLoader loader = FileResourceTest.class.getClassLoader();
        System.out.println(loader.getResource("edu/duke/FileResourceTest.class"));

    }

}
