package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N = 10;
        Random random = new Random();
        Integer[] array = new Integer[N];

        //a)
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("a) Array: " + Arrays.toString(array));
        //b)
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) List: " + list);

        //c)
        Collections.sort(list);
        System.out.println("c) Sorted list: " + list);

        //d)
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("d) The sheet is sorted in reverse order: " + list);

        //e).
        Collections.shuffle(list);
        System.out.println("e) Shuffled List: " + list);

        // f)
        Collections.rotate(list, 1);
        System.out.println("f) Shifted List: " + list);

        // g)
        List<Integer> uniqueList = new ArrayList<>(new HashSet<>(list));
        System.out.println("g) Unique elements: " + uniqueList);

        // h)
        List<Integer> duplicatesList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Integer num : list) {
            if (!set.add(num)) {
                duplicatesList.add(num);
            }
        }
        System.out.println("h) Duplicate elements: " + duplicatesList);

        // i)
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("i) Array from the list: " + Arrays.toString(resultArray));

        // j)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : resultArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("j) Frequency of occurrence: " + frequencyMap);
    }
}

    class PrimesGenerator implements Iterable<Integer> {
        private final int count;

        public PrimesGenerator(int count) {
            this.count = count;
        }

        private boolean isPrime(int number) {
            if (number <= 1) return false;
            for (int i = 2; i < Math.sqrt(number) + 1; i++) {
                if (number % i == 0) return false;
            }
            return true;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int current = 2;
                private int primesFound = 0;

                @Override
                public boolean hasNext() {
                    return primesFound < count;
                }

                @Override
                public Integer next() {
                    while (!isPrime(current)) {
                        current++;
                    }
                    primesFound++;
                    return current++;
                }
            };
        }
    }

    class Human implements Comparable<Human> {
        private String firstName;
        private String lastName;
        private int age;

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Human o) {
            return this.firstName.compareTo(o.firstName);
        }

        @Override
        public String toString() {
            return "Human{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    class HumanComparatorByLastName implements Comparator<Human> {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }

    class WordFrequency {

        public static void main(String[] args) {
            String text = "This is a sample text with several words. This text is just a sample.";
            String[] words = text.toLowerCase().split("\\W+");

            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String word : words) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            System.out.println("Frequency of words: " + frequencyMap);
        }
    }

    class MapInverter {

        public static <K, V> Map<V, K> invert(Map<K, V> inputMap) {
            Map<V, K> invertedMap = new HashMap<>();
            for (Map.Entry<K, V> entry : inputMap.entrySet()) {
                invertedMap.put(entry.getValue(), entry.getKey());
            }
            return invertedMap;
        }

        public static void main(String[] args) {
            Map<String, Integer> originalMap = new HashMap<>();
            originalMap.put("one", 1);
            originalMap.put("two", 2);
            originalMap.put("three", 3);
            Map<Integer, String> invertedMap = invert(originalMap);
            System.out.println("The original map: " + originalMap);
            System.out.println("The inverted card: " + invertedMap);
        }
    }