/*
 * Copyright 2016 Kevin Raoofi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.frostburg.compclub.gitsampleproject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This project will give an example for how to contribute code to a simple
 * project that can be ran.
 *
 * @author Kevin Raoofi
 */
public class CompClubIntroduction {

    /**
     * Apply this annotation to a method to make it be ran
     */
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hello {
    }

    /**
     * Looks through all the methods in the file and runs the ones with the
     *
     * @Hello annotation
     *
     * @param args
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void main(String... args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        CompClubIntroduction instance = new CompClubIntroduction();

        for (Method m : CompClubIntroduction.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Hello.class)) {
                m.invoke(instance, new Object[]{});
            }
        }
    }

    @Hello
    public void instructions() {
        System.out.println("---- Instructions ----");
        System.out.println("This is an example of a method that is run. ");
        System.out.println("Write a method with the annotation with @Hello "
                + "before it to have it be run.");
        System.out.println(
                "1. Write a method called \"helloYourName\" at the bottom");
        System.out.println(
                "2. Make the method display a short introduction for yourself");
        System.out.println(
                "3. Put the annotation, \"@Hello\" right before the method");
        System.out.println(
                "4. Run the code (Shift+F6 in Netbeans) to make sure it works");
        System.out.println(
                "5. Go to git, add it to the staging area, and then commit it"
                + "with a commit message");
        System.out.println("6. Push it to your repo on Github");
        System.out.println("---- End Instructions ----");
        System.out.println();
    }
}
