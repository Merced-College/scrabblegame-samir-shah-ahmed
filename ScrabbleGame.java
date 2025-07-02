import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScrabbleGame {
    private ArrayList<Word> dictionary;
    private ArrayList<Character> playerLetters;
    private ArrayList<Character> computerLetters;
    private int playerScore;
    private int computerScore;
    private Random random;

    public ScrabbleGame() {
        this.dictionary = new ArrayList<>();
        this.playerLetters = new ArrayList<>();
        this.computerLetters = new ArrayList<>();
        this.random = new Random();
        this.playerScore = 0;
        this.computerScore = 0;
        //read file and populate dictionary
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
    // Check if the word can be formed with the letters in hand
    private boolean isValidWord(String word, ArrayList<Character> hand) {
        ArrayList<Character> tempHand = new ArrayList<>(hand);
        for (char c : word.toCharArray()) {
            if (tempHand.contains(c)) {
                tempHand.remove(Character.valueOf(c));
            } else {
                return false;
            }
        }
        return true;
    }

    public void play() {
        generatePlayerLetters();
        generateComputerLetters();
        Scanner userInput = new Scanner(System.in);
        //user input and computer input  
        while (true) {
            System.out.println("\n--------------------");
            System.out.println("Your letters are: " + this.playerLetters);
            System.out.println("Your Score: " + this.playerScore + " | Computer Score: " + this.computerScore);
            System.out.println("Enter a word (if you wish to exit say 'exit', if you wish to generate new letters say 'new'): ");

            String userWord = userInput.nextLine().toLowerCase();
            //escape conditions for the game
            if (userWord.equals("exit")) {
                break;
            }
            // If the user wants to generate new letters
            // this will generate new letters for the player and computer
            if (userWord.equals("new")) {
                generatePlayerLetters();
                System.out.println("New letters generated: " + this.playerLetters);
                computerTurn();
                continue;
            }
            // Check if the word is valid
            if (!isValidWord(userWord, this.playerLetters)) {
                System.out.println("Invalid word: You do not have the letters to form that word.");
            } else {
                Word foundWord = binarySearch(userWord);
                if (foundWord != null) {
                    int points = foundWord.getScore();
                    this.playerScore += points;
                    System.out.println("Success! You scored " + points + " points.");
                    generatePlayerLetters();
                } else {
                    System.out.println("Sorry, that is not in the dictionary.");
                }
                computerTurn();
            }
        }
        userInput.close();
        System.out.println("\n--- FINAL SCORE ---");
        System.out.println("You: " + this.playerScore + " | Computer: " + this.computerScore);
    }

    private void computerTurn() {
        System.out.println("--- Computer's Turn ---");
        System.out.println("Computer's letters: " + this.computerLetters);
        Word bestWord = null;
        int bestScore = -1;

        for (Word word : dictionary) {
            if (isValidWord(word.getWordText(), this.computerLetters)) {
                if (word.getScore() > bestScore) {
                    bestScore = word.getScore();
                    bestWord = word;
                }
            }
        }

        if (bestWord != null) {
            this.computerScore += bestWord.getScore();
            System.out.println("Computer plays '" + bestWord.getWordText() + "' for " + bestWord.getScore() + " points.");
        } else {
            System.out.println("Computer could not find a word.");
        }
        generateComputerLetters();
    }
// Binary search to find the word in the dictionary
    private Word binarySearch(String wordToFind) {
        int low = 0;
        int high = dictionary.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Ensure mid is within bounds
            Word middleWord = dictionary.get(mid);
            int comparison = middleWord.getWordText().compareTo(wordToFind);
            // Compare the middle with the word to find
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
    // Generate random letters for the player and computer make sure they follow the same rules of 4 characters
    // and are lowercase letters
    private void generatePlayerLetters() {
        playerLetters.clear();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randomIndex);
            this.playerLetters.add(randomChar);
        }
    }

    private void generateComputerLetters() {
        computerLetters.clear();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randomIndex);
            this.computerLetters.add(randomChar);
        }
    }

    public static void main(String[] args) {
        ScrabbleGame game = new ScrabbleGame();
        game.play();
    }
}