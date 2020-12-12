/**
 * [CS18000] Practice Midterm 2 Solution
 *
 * @author kedarabhyankar
 * @version 10/31/2020
 */
public class RacecarSimulator {

    public static void main(String[] args) {
        Nascar nascarCar = new Nascar("Chevrolet", "Dale Earnhardt Sr.", 195.8, 3.1);
        FormulaOne formulaOneCar = new FormulaOne("McLaren", "Aryton Senna", 186.3, 5.0);
        nascarCar.start();
        formulaOneCar.start();
    }
}
