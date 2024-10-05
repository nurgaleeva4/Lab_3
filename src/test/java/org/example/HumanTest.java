package org.example;
import java.util.*;

class HumanTest {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", 30),
                new Human("Jane", "Smith", 25),
                new Human("Alice", "Johnson", 35),
                new Human("Mike", "Doe", 40)
        );

        System.out.println("a) HashSet:");
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println(hashSet);

        System.out.println("b) LinkedHashSet:");
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println(linkedHashSet);

        System.out.println("c) TreeSet:");
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println(treeSet);

        System.out.println("d) TreeSet using a last name comparator:");
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println(treeSetByLastName);

        System.out.println("e) TreeSet using an anonymous age comparator:");
        TreeSet<Human> treeSetByAge = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        treeSetByAge.addAll(humans);
        System.out.println(treeSetByAge);

    }
}