import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleWord {
    private String word; //represents the random word the user is supposed to guess
    //stored as all uppercase letters

    private ArrayList<String> guesses; //represents all the letters that the user has guessed.
    //If the user has guessed the letters r, s, t and e, then
    //guesses would refer to the String "RSTE"

    private int MAX_WORDS = 45402; //represents how many words are in words.txt

    private ArrayList<String> wordList = new ArrayList<String>();
    public WordleWord() {
        //loading text from a file using the Scanner (not on AP exam)
        word = pickRandomWord("C:\\Users\\non3c\\IdeaProjects\\Hangman\\src\\words.txt");
        guesses = new ArrayList<>(6);
    }



    private String pickRandomWord(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.length() == 5) {
                    wordList.add(line);
                }
            }

            String output = wordList.get((int) (Math.random() * wordList.size()));
            scanner.close();
            return output.toUpperCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean makeGuess(String guess) {
        guess = guess.toUpperCase();
//        if (guess.length() == 5) {
        if (wordList.contains(guess.toLowerCase())) {
            if (guess.equals(word)) guesses.add(guess);
            else guesses.add(guess);
        }
        else {System.out.println("Try another word..."); return true;}
        return word.equals(guess);
    }


    public void show() {
        System.out.println("=================================");
        System.out.println("W O R D L E,  B U T   W O R S E !");
        System.out.println("================================= \n");
        for (String s: guesses) {
            System.out.print("\033[0;1m" + "\033[38:5:15m");

            ArrayList<Character> myWord = new ArrayList<Character>();
                myWord.add(word.charAt(0));
                myWord.add(word.charAt(1));
                myWord.add(word.charAt(2));
                myWord.add(word.charAt(3));
                myWord.add(word.charAt(4));

            ArrayList<Character> myGuess = new ArrayList<Character>();
                myGuess.add(s.charAt(0));
                myGuess.add(s.charAt(1));
                myGuess.add(s.charAt(2));
                myGuess.add(s.charAt(3));
                myGuess.add(s.charAt(4));

            String[][] outcome = {{"\033[48:5:244m", " " + myGuess.get(0) + " "},
                                  {"\033[48:5:244m", " " + myGuess.get(1) + " "},
                                  {"\033[48:5:244m", " " + myGuess.get(2) + " "},
                                  {"\033[48:5:244m", " " + myGuess.get(3) + " "},
                                  {"\033[48:5:244m", " " + myGuess.get(4) + " "}};

            for (int i = 0; i < 5; i++) {
                if (myGuess.get(i) == myWord.get(i)) {
                    outcome[i][0] = "\033[48:5:71m"; //Green
                    myWord.set(i, ' ');
                }
            }

            for (int i = 0; i < 5; i++) {
                if (myWord.contains(myGuess.get(i))) {
                    if (outcome[i][0] != "\033[48:5:71m") outcome[i][0] = "\033[48:5:221m";//Yellow
                    myWord.set(myWord.indexOf(myGuess.get(i)), ' ');
                }
            }


            for (String[] o : outcome) for (String p : o) System.out.print(p);

            System.out.print("\033[0;1m");
            System.out.println("");

            }



    }








    //Return true or false if the word has been guessed or not (ie: all of the letters in
    //word are also in guesses.
    public boolean isUnsolved() {
        return (!guesses.contains(word));
    }

    //returns word;
    public String getWord() {
        return word;
    }
}
