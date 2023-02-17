import java.util.HashMap;
import java.util.Scanner;

public class ObjectsLanguageTranslationMap {

	public static void main(String[] args) {

		HashMap<String, String> dictionary = new HashMap<>();
		Scanner input = new Scanner(System.in);

		String eng = "";
		String fin = "";

		System.out.println("=== Creating an English-Finnish dictionary (ok ends) ===");

		while (!eng.equals("ok")) {

			System.out.print("Enter an English word: ");
			eng = input.nextLine();

			if (eng.equals("ok")) {
				break;

			} else {
				System.out.print("Enter a Finnish word: ");
				fin = input.nextLine();
			}

			System.out.println();
			dictionary.put(eng, fin);
		}

		System.out.println();
		System.out.println("=== English-Finnish translation service (quit ends) ===");

		boolean found = false;
		String result = "";

		while (found == false) {

			System.out.print("Enter an English word: ");
			String wordToSearch = input.nextLine();

			if (wordToSearch.equals("quit")) {

				found = true;
				result = "Bye!";

			}
			for (int i = 0; i < dictionary.size(); i++) {

				if (dictionary.containsKey(wordToSearch)) {

					result = dictionary.get(wordToSearch);
					break;

				}

				if (found == false) {

					result = "Unknown word";

				}

			}

			System.out.println(result);
			System.out.println();
		}

		input.close();

	}
}
