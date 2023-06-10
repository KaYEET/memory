package memorypackage.model;

import java.util.Random;
/**
 * This class is responsible for randomizing the board and comparing two cards.
 * @author Niels Verstrepen, Kai Ekkart
 * @version 1.0
 * @version JDK 11.08
 * @since 25 March 2022
 */
public class BoardModel {
    private final int xValue;
    private final int yValue;
    private int[][] numberCard;
    private String[][] guessedCard;
    private String playerName;

    //default constructor

    /**
     * This constructor is responsible for randomizing the board each time a new game is started.
     * @param xValue Width value
     * @param yValue Length value
     */
    public BoardModel(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;

        Random random = new Random();

        numberCard = new int[yValue][xValue];
        guessedCard = new String[yValue][xValue];
        //hier vullen we de array in met int's van 1 tem 20
        int counter = 1;
        for (int i = 0; i < xValue; i++) {
            for (int j = 0; j < yValue; j++) {
                numberCard[j][i] = counter;
                guessedCard[j][i] = "x";
                counter++;
            }
        }

        //hier zorgen we ervoor dat de waardes van 1-20 geshuffled worden
        for (int i = 0; i < numberCard.length; i++) {
            for (int j = 0; j < numberCard[i].length; j++) {
                //randomizers gelijk zetten aan random getallen<"length"
                int randomizerI = (random.nextInt(numberCard.length));
                int randomizerJ = (random.nextInt(numberCard[i].length));

                //temporary = het getal van de nummerkaart[i][j] positie
                int temporary = numberCard[i][j];
                //hier veranderen we de oorspronkelijke waarde in nummerKaart[i][j] naar de randomizers
                numberCard[i][j] = numberCard[randomizerI][randomizerJ];
                //hier veranderen we de randomizers met de oorspronkelijke waarde
                numberCard[randomizerI][randomizerJ] = temporary;
            }
        }
    }

    /**
     * This method compares the value of the first-clicked button and the value of the second-clicked button.
     * @param buttonNumberOne Value of card number one
     * @param buttonNumberTwo Value of card number two
     * @return true if the value is '-10' or '10' and false if not.
     */
    public boolean CompareButtonOneWithButtonTwo(int buttonNumberOne, int buttonNumberTwo) {
        int result = buttonNumberOne - buttonNumberTwo;
        if (result == -10 || result == 10) {
            return true;
        } else {
            return false;
        }
    }

    public int[][] getNumberCard() {
        return numberCard;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
