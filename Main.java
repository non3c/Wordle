 import java.util.*;

public class Main {

        public static void main (String[] args) {
            Scanner scanner = new Scanner(System.in);
            Wordle wordle = new Wordle();
            WordleWord wWords = new WordleWord();

            while (wWords.isUnsolved() && wordle.isntDead()) {
                wordle.show();
                wWords.show();
                //System.out.println(wWords.getWord());
                System.out.print("\nMake your guess: ");

                String guess = scanner.nextLine();
                if (!wWords.makeGuess(guess)) {
                    wordle.dieSomeMore();
                }
                clearScreen();
            }
            wWords.show();
            if (wordle.isntDead()) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose! The Word was " + wWords.getWord());
            }
        }

        public static void clearScreen() {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.flush();
        }
}
