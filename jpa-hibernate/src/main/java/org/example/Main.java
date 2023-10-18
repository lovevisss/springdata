package org.example;

import org.example.pojo.Gender;
import org.example.pojo.Person;

import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

//        List<Person> females = new ArrayList<>();
//
//        for (Person person:people){
//            if(person.getGender().equals(Gender.FEMALE)){
//                females.add(person);
//            }
//        }
//
//        females.forEach(System.out::println);

//        filter
        people.stream().filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList()).forEach(System.out::println);
//sort
        System.out.println("sort");
        people.stream().sorted((p1,p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList()).forEach(System.out::println);
//        all match
        System.out.println("all match");
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);
//        any match
        System.out.println("any match");
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 8);
        System.out.println(anyMatch);
//        none match
        System.out.println("none match");
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Alina Smith"));
        System.out.println(noneMatch);
//        max
        System.out.println("max");
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(person -> {System.out.println(person);});
//        min
        System.out.println("min");
        people.stream().min((p1,p2) -> p1.getAge() > p2.getAge() ? 1 : -1).ifPresent(System.out::println);
//        group
        Map<Gender, List<Person>> group = people.stream().collect(Collectors.groupingBy(Person::getGender));
        group.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));
    }


    private static List<Person> getPeople(){
        return
                Arrays.asList(

                        new Person("James Bond", 20, Gender.MALE),
                        new Person("Alina Smith", 33 , Gender.FEMALE),
                        new Person("Helen White", 57, Gender.FEMALE),
                        new Person("Alex Boz", 14, Gender.MALE),
                        new Person("Jamie Goa", 99, Gender.MALE),
                        new Person("Anna Cook", 7, Gender.FEMALE)
                );
    }
}