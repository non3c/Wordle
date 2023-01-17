public class Wordle {
        private int numWrongGuesses;

        //Constructor - intializes numWrongGuesses to zero
        public Wordle() {
            numWrongGuesses = 0;
        }

        //increments numWrongGuesses by one
        public void dieSomeMore() {
            numWrongGuesses ++;
        }

        //returns true if numWrongGuesses is 6, false othewise
        public boolean isntDead() {
            return !(numWrongGuesses == 6);
        }

        //prints to the console the String stored in the HangmanImage array
        //at the index equal to numWrongGuess
        public void show() {

        }




}
