
public class RacecarSimulator {

	public static void main(String[] args) {
		Nascar nascar = new Nascar("Chevrolet", "Dale Earnhardt Sr.", 195.8, 3.1);
		FormulaOne formula1 = new FormulaOne("Aryton Senna", "McLaren", 186.3, 5.0);
		nascar.start();
		formula1.start();

	}

}
