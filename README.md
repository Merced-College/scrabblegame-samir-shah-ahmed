[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19861083)
# scrabbleGame

Scrabble Game 

For this assignment use your OOD and ArrayList skills and binary search algorithm to make a simple Scrabble-like game.  This game will give the user 4 random letters.  

* Create a Word object class and a ScrabbleGame class to read in the Word objects into a sorted ArrayList of Words. Read in the words and make the Word objects using the text file called "CollinsScarbbleWords_2019.txt".
* Have your game then choose 4 random characters, and output these to the user.
* Ask the user for a word made form those 4 letters.
* Use binary search to search for that word in the Words ArrayList to see if the word is valid. Output it if it is a valid word.
* Then make at least one improvement to the game.  Write your improvement as comments at the top of your game, and also comment the code that you inserted into the game to make this improvement.  It should be at least 20 lines of quality code. Some examples of an improvement would be:

* Give the user different amounts of points for different size words.
* Allow the user to exchange one of their letters.
* Have 2 players competing for the biggest word.
* Any other improvement.
* Use the given list of words to make your Word objects for the Arraylist and verify that the user typed in a real word.

** Add comments throughout your code, especially where you made changes or additions. If you're working in a group, ensure that your comments clearly indicate the sections you personally contributed to.

Turn in a copy of your code and the reflection response.

TODO Turn in: Turn in your 2 files (The Word and ScrabbleGame java files) to the github classroom assignment.

TODO: Each student must respond to the reflection question individually, providing a unique answer. This part of the assignment should not be done collaboratively. Submit your reflection as a document either on Canvas or in the GitHub repository.

Reflect on your personal problem-solving process. How did your understanding of object-oriented programming (e.g., classes, constructors, and data structures like ArrayLists) evolve as you worked on this task? What challenges did you encounter and how did you go about fixing them? Explain which LLM, your prompts, or internet help and how debugged your code?

###Reflection###

The way I handled the project was by breaking down the scrabble game and then trying to see how to write it in java. So first I thought about how implementing the word.java should look like and then gave it a go and I used gemini to help guide me in the right direction by giving it my ideas on how to implement and then seeing how it either corrected me or improved on my ideas. This method became extremely useful when it came time to implement the binary search algorithm in the game logic where I used gemini as a buddy to bounce ideas off of and tested my idea of a binary search in java and making sure i was on the right track. It helped me make sure I understood what I was doing conceptually and then I made sure my code also represented this. I ran into issues with adding a computer opponent figuring out how to implement rules and gemini was very helpful in giving me ideas and starter code to implement. Overall using AI made the project more fun becuase I could test ideas and felt less like I was banging my head on the wall trying to see if what I was doing could work. This method improved my problem solving ability by reducing my time spent verifying if ideas were possible and improved my understanding of implementing algorithms from theory to actuality. I also used gemini for debugging. 

### note on comments ###
For my comments in the code my code should be fairly self explanatory but I made sure to be as clear as possible in areas which i felt could be confusing and I wanted to avoid
over commenting 