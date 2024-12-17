import java.util.Scanner;

/**
 * The Question class represents a single trivia question with four possible answers.
 */
class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;

    /**
     * Constructs a Question object with the specified question and possible answers.
     * @param question The trivia question text.
     * @param answer1 First possible answer.
     * @param answer2 Second possible answer.
     * @param answer3 Third possible answer.
     * @param answer4 Fourth possible answer.
     * @param correctAnswer The correct answer (1-4).
     */
    public Question(String question, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    // Accessor methods
    public String getQuestion() { return question; }
    public String getAnswer1() { return answer1; }
    public String getAnswer2() { return answer2; }
    public String getAnswer3() { return answer3; }
    public String getAnswer4() { return answer4; }
    public int getCorrectAnswer() { return correctAnswer; }

    /**
     * Checks if the given answer is correct.
     * @param playerAnswer The player's chosen answer.
     * @return True if the answer is correct; false otherwise.
     */
    public boolean isCorrect(int playerAnswer) {
        return playerAnswer == correctAnswer;
    }
}

/**
 * The TriviaGame class handles the game logic for a two-player trivia game.
 */
public class TriviaGame {
    private Question[] questions;
    private int player1Score;
    private int player2Score;

    /**
     * Constructs the TriviaGame and initializes the questions and player scores.
     */
    public TriviaGame() {
        questions = new Question[10];
        initializeQuestions();
        player1Score = 0;
        player2Score = 0;
    }

    /**
     * Initializes an array of 10 trivia questions with possible answers.
     */
    private void initializeQuestions() {
        questions[0] = new Question("What is the capital of France?", "1. Paris", "2. Rome", "3. Berlin", "4. Madrid", 1);
        questions[1] = new Question("What planet is known as the Red Planet?", "1. Earth", "2. Mars", "3. Venus", "4. Jupiter", 2);
        questions[2] = new Question("What is the tallest mountain in the world?", "1. K2", "2. Everest", "3. Kilimanjaro", "4. Denali", 2);
        questions[3] = new Question("Which element has the chemical symbol O?", "1. Gold", "2. Oxygen", "3. Osmium", "4. Nickel", 2);
        questions[4] = new Question("In which year did the Titanic sink?", "1. 1902", "2. 1912", "3. 1922", "4. 1932", 2);
        questions[5] = new Question("What is the largest mammal?", "1. Elephant", "2. Blue Whale", "3. Giraffe", "4. Shark", 2);
        questions[6] = new Question("How many continents are there?", "1. 5", "2. 6", "3. 7", "4. 8", 3);
        questions[7] = new Question("What is the currency of Japan?", "1. Dollar", "2. Won", "3. Peso", "4. Yen", 4);
        questions[8] = new Question("Who wrote 'Romeo and Juliet'?", "1. Dickens", "2. Shakespeare", "3. Twain", "4. Tolstoy", 2);
        questions[9] = new Question("What is the boiling point of water in Celsius?", "1. 90", "2. 80", "3. 100", "4. 120", 3);
    }

    /**
     * Runs the game, allowing each player to take turns answering 5 questions.
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        // Player 1's turn
        System.out.println("Player 1's turn:");
        for (int i = 0; i < 5; i++) {
            askQuestion(i, scanner, 1);
        }

        // Player 2's turn
        System.out.println("\nPlayer 2's turn:");
        for (int i = 5; i < 10; i++) {
            askQuestion(i, scanner, 2);
        }

        // Display results and determine winner
        displayResults();
        scanner.close();
    }

    /**
     * Prompts a player with a question and checks if their answer is correct.
     * Displays the player's current score if the answer is correct.
     * @param questionIndex The index of the question in the array.
     * @param scanner Scanner object for input.
     * @param playerNumber The player number (1 or 2).
     */
    private void askQuestion(int questionIndex, Scanner scanner, int playerNumber) {
        Question question = questions[questionIndex];
        System.out.println(question.getQuestion());
        System.out.println(question.getAnswer1());
        System.out.println(question.getAnswer2());
        System.out.println(question.getAnswer3());
        System.out.println(question.getAnswer4());
        System.out.print("Your answer (1-4): ");
        int answer = scanner.nextInt();

        if (question.isCorrect(answer)) {
            System.out.println("Correct!\n");
            if (playerNumber == 1) {
                player1Score++;
                System.out.println("Player 1's current score: " + player1Score);
            } else {
                player2Score++;
                System.out.println("Player 2's current score: " + player2Score);
            }
        } else {
            System.out.println("Wrong! The correct answer was " + question.getCorrectAnswer() + ".\n");
        }
    }

    /**
     * Displays the final results and declares the winner.
     */
    private void displayResults() {
        System.out.println("Player 1 scored: " + player1Score + " points.");
        System.out.println("Player 2 scored: " + player2Score + " points.");

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    /**
     * Main method to start the trivia game.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        TriviaGame game = new TriviaGame();
        game.playGame();
    }
}
