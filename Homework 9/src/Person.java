/**
 * A class that represents a Person.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020</p>
 *
 * @author Purdue CS 
 * @version August 24, 2020
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}