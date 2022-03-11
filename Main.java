package com.company.PerepisNaseleniya;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long stream = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(stream);

        List<String> stream1 = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(stream1);

        List <Person> stream2 = persons.stream()
                .filter(x -> (x.getAge() <= 60 && x.getAge()>18 && x.getSex().equals(Sex.WOMAN) ||
                        x.getAge()<=65 && x.getAge()>18 && x.getSex().equals(Sex.MAN)))
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(stream2);


    }
}
