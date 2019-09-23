package flashcards;

import java.util.*;

public class FlashCards {
    public static void main(String[] args) {
        implementApplication();
    }

    private static Map<String, String> cardToDefinition = new LinkedHashMap<>();
    private static Map<String, String> definitionToCard = new LinkedHashMap<>();

    private static String inputNewCardName = "";
    private static String inputNewDefinition = "";

    private static Scanner scannerInteger = new Scanner(System.in);
    private static Scanner scannerString = new Scanner(System.in);

    private static boolean definitionAndCardBoolean;

    private static boolean checkcardExistence(String cardName) {
        definitionAndCardBoolean = true;
        for (String value : definitionToCard.values()) {
            if (value.equals(cardName)) {
                definitionAndCardBoolean = false;
                break;
            }
        }
        return definitionAndCardBoolean;
    }

    private static boolean checkDefinitionExistence(String definition) {
        definitionAndCardBoolean = true;
        for (String value : cardToDefinition.values()) {
            if (value.equals(definition)) {
                definitionAndCardBoolean = false;
                break;
            }
        }
        return definitionAndCardBoolean;
    }

    private static void additionalCardControl(String wordThatexists) {
        boolean cardBoolean;
        System.out.println("The card " + '"' + wordThatexists + '"' + " already exists. Try again:");
        while (true) {
            inputNewCardName = scannerString.nextLine();
            cardBoolean = checkcardExistence(inputNewCardName);
            if (!cardBoolean) {
                System.out.println("The card " + '"' + inputNewCardName + '"' + " already exists. Try again:");
            } else {
                break;
            }
        }
    }

    private static void additionalDefinitionControl(String definitionThatexists) {
        boolean definitionBoolean;
        System.out.println("The definition " + '"' + definitionThatexists + '"' + " already exists. Try again:");
        while (true) {
            inputNewDefinition = scannerString.nextLine();
            definitionBoolean = checkDefinitionExistence(inputNewDefinition);
            if (!definitionBoolean) {
                System.out.println("The definition " + '"' + inputNewDefinition + '"' + " already exists. Try again:");
            } else {
                break;
            }
        }
    }

    private static void implementApplication() {

        boolean nameOfCardBoolean, nameOfDefinitionBoolean;

        System.out.println("Input the number of cards: ");
        int numberOfCards = scannerInteger.nextInt();

        for (int i = 0; i < numberOfCards; i++) {

            System.out.println("The card #" + (i + 1) + ": ");
            String inputCard = scannerString.nextLine();
            nameOfCardBoolean = checkcardExistence(inputCard);
            if (!nameOfCardBoolean) {
                additionalCardControl(inputCard);
                inputCard = inputNewCardName;
            }

            System.out.println("The definition of the card #" + (i + 1) + ": ");
            String inputDefinition = scannerString.nextLine();
            nameOfDefinitionBoolean = checkDefinitionExistence(inputDefinition);
            if (!nameOfDefinitionBoolean) {
                additionalDefinitionControl(inputDefinition);
                inputDefinition = inputNewDefinition;
            }

            cardToDefinition.put(inputCard, inputDefinition);
            definitionToCard.put(inputDefinition, inputCard);
        }

        for (String card : definitionToCard.values()) {
            System.out.println("Print the definition of " + '"' + card + '"' + ":");
            String definition = scannerString.nextLine();

            if (definition.equals(cardToDefinition.get(card))) {
                System.out.println("Correct answer.");
            } else {

                if (definitionToCard.get(definition) == null) {
                    System.out.println("Wrong answer , " + "(The correct one is " + '"' + cardToDefinition.get(card) + '"' + " ," + ".)");
                } else {
                    System.out.println("Wrong answer , " + "(The correct one is " + '"' + cardToDefinition.get(card) + '"' + " ," + " you've just written the definition of " + '"' + definitionToCard.get(definition) + '"');
                }
            }

        }

    }

}
