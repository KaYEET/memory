package memorypackage.model;

import java.io.*;

import java.util.Scanner;
/**
 * This class is responsible for saving the highscores to the highscores textfile.
 * @author Niels Verstrepen, Kai Ekkart
 * @version 1.0
 * @version JDK 11.08
 * @since 25 March 2022
 */
public class HighscoresModel {
    private static final File FILE = new File("resources/highscores.txt");

    public HighscoresModel() {
    }

    /**
     * This method writes the scores to a separate text file using a buffer.
     * @param textToSave A string containing the text to save in the text file.
     * @exception IOException This error occurs when there was an error saving the text to the file.
     */
    public void saveToFile(String textToSave) {
        try (Scanner scan = new Scanner(FILE)) {
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE));
            String line = fileReader.readLine();
            StringBuilder oldHighscores = new StringBuilder();
            while (line != null) {
                oldHighscores.append(line).append("\n");
                line = fileReader.readLine();
            }
            fileReader.close();
            oldHighscores.append(textToSave);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.format(oldHighscores.toString());
            printWriter.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
