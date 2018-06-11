package guessingnumber;
import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {

	public static void main(String[] args) {
		start();
	}

	public static void start() {

		final short maxValueInclusive = 10;
		final int randomValue =  new Random() 
				.nextInt(maxValueInclusive + 1);

		// Einführungstext
		System.out.print("You have 5 attempts. \n");
		System.out.print("Try to guess my number in the range between 0 and 10: ");
		final Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		
		// wenn man größer 10 eingibt = Fehler
		if (value > maxValueInclusive) { 
			System.out.println("Error. Programm closed.");
		}
		// wenn man kleiner 0 eingibt = Fehler
		else if (value < 0) { 
			System.out.println("Error. Programm closed.");
		}
		else { // ansonsten führt es das Programm aus
			for (int attempts = 4; attempts > 0; attempts--) // die Versuche werden um 1 abgezogen
			{
				// wenn Randomzahl erraten wird
				if (value == randomValue) {
					System.out.println("Congratulations! You won a cookie!");

					System.out.println("Try again?");
					String option = scan.next();

					if (option.equals("yes")) {
						start();
					} else if (option.equals("no")) {
						System.out.println("Bye!");
						System.exit(0);
					} else {
						scan.next();
					} scan.close();
				}
				//				System.out.println("Testzahl: " + randomValue); 			// random Nummer anzeigen

				// wenn Value niedriger als Randomzahl ist
				if (value < randomValue) {
					System.out.print("Value is too low. \n");
					System.out.printf("You have %d attempts. \n", attempts);
					System.out.println("Input your new guess:");
				}
				// wenn Value höher als Randomzahl ist
				else {
					System.out.println("Number is too high.");
					System.out.printf("You have %d attempts. \n", attempts);
					System.out.println("Input your new guess:");
				}
				value = scan.nextInt();
			}
			// wenn 5 Versuche (attempts) aufgebraucht wurden
			System.out.println("Game over, try another run?");
			String option = scan.next();

			if (option.equals("yes")) {
				start();
			} else if (option.equals("no")) {
				System.out.println("Bye!");
				System.exit(0);
			} else {
				scan.next();
			} scan.close();
		}

	}
}