
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScrabbleGame {
    private ArrayList<Word> dictionary;
    private ArrayList<Character> playerLetters;
    private Random random;

    public ScrabbleGame() {
        this.dictionary = new ArrayList<>();
        this.playerLetters = new ArrayList<>();
        this.random = new Random();
        try {
            Scanner scanner = new Scanner(new File("CollinsScarbbleWords_2019.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                Word wordObject = new Word(line);
                dictionary.add(wordObject);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: file could not be found");
            e.printStackTrace();
        }
    }

    public void play() {
        generatePlayerLetters();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("\nLetters are: " + this.playerLetters);
            System.out.println("Enter a word (if you wish to exit say 'exit')");

            String userWord = userInput.nextLine().toLowerCase();

            if (userWord.equals("exit")) {
                break;
            }

            Word foundWord = binarySearch(userWord);
            if (foundWord != null) {
                System.out.println("Success! valid word. :) ");
            } else {
                System.out.println("Sorry, not a valid word. :( ");
            }
        }
        userInput.close();
    }

    private Word binarySearch(String wordToFind) {
        int low = 0;
        int high = dictionary.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Word middleWord = dictionary.get(mid);
            int comparison = middleWord.getWordText().compareTo(wordToFind);

            if (comparison == 0) {
                return middleWord;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    private void generatePlayerLetters() {
        playerLetters.clear();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randomIndex);
            this.playerLetters.add(randomChar);
        }
    }
}