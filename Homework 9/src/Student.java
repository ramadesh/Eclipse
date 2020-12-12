/**
 * A class that represents a Student. 
 *
 * <p>Purdue University -- CS18000 -- Fall 2020</p>
 *
 * @author Purdue CS 
 * @version August 24, 2020
 */
public class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}