/**
 * A class that represents a Dog. 
 *
 * <p>Purdue University -- CS18000 -- Fall 2020</p>
 *
 * @author Purdue CS 
 * @version August 24, 2020
 */
public class Dog implements Animal {
    @Override
    public String getSound() {
        return "woof";
    }

    @Override
    public boolean isFriendly() {
        return true;
    }
}
