
//implements tells java that a comparable WILL be in the class
public class Word implements Comparable<Word>{
    
    private String wordText;
    
    public Word(String wordText){
        this.wordText=wordText;
    }
    //comparable
    @Override
    public int compareTo(Word otherWord){
        return this.wordText.compareTo(otherWord.wordText);
    }
    //getter 
    public String getWordText(){
        return this.wordText;
    }
}