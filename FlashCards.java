package flashcards;

import java.util.*;

public class FlashCards {


    public static void main(String[] args) {

        implementApplication();
    }

    private static void implementApplication() {
        char ch = '"';
        System.out.println("Input the number of cards: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfCards = scanner.nextInt();
        String[] cards = new String[numberOfCards];
        String[] definitions = new String[numberOfCards];

        for (int i = 0; i < numberOfCards; i++) {

            System.out.println("The card #" + (i + 1) + ": ");


            if (i == 0) {
                String string = scanner.nextLine();
            }

            String inputCard = scanner.nextLine();
            System.out.println("The definition of the card #" + (i + 1) + ": ");

            String inputDefinition = scanner.nextLine();
            System.out.println(inputCard + "<><>");

            cards[i] = inputCard;
            definitions[i] = inputDefinition;
        }


        for (int j = 0; j < numberOfCards; j++) {
            System.out.println("Print the definition of " + ch + cards[j] + ch);
            String answer = scanner.nextLine();
            if (definitions[j].equals(answer)) {
                System.out.println("Correct answer.");
            } else {
                System.out.println("Wrong answer." + "(The correct one is " + ch + definitions[j] + ch + ".)");
            }

        }


    }
}