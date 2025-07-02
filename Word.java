
//implements tells java that a comparable WILL be in the class
public class Word implements Comparable<Word> {
    private String wordText;
    private int score;

    public Word(String wordText) {
        this.wordText = wordText;
        this.score = calculateScore(wordText);
    }

    public String getWordText() {
        return this.wordText;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Word other) {
        return this.wordText.compareTo(other.wordText);
    }

    private int calculateScore(String word) {
        return word.length() - 1; // Base score for the word length
    }
}