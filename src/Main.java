import java.io.*;
import java.util.Random;
import java.util.Scanner;
/*
New stuff (improved functions)
1. when replay, shows menu to select level, so that they dont have to end game to play other levels
2. Added ability to return to menu during game so that they don't have to win or exit program to get there again.
 */
public class Main {
    // main method runs the actual game
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String user; // this is the user input throughout the program
        boolean restart = true; // status to tell program whether to redo (iterate) a level, originally set to true so that the levels can run for the first time.
        boolean menu = false;
        String[] wordList = readFile("WordList");
        greetingMessage();
        skipForward();
        while (restart) {
            greetingPTwo();
            user = scanner.nextLine();
            // checks for correct format until correct. either 1, 2, 3, 4, or 5.
            while (!user.equals("1") && !user.equals("2") && !user.equals("3") && !user.equals("4") && !user.equals("5")) { // keeps prompting for correct format
                System.out.println("Please enter in the correct format (1, 2, 3, 4, or 5): ");
                user = scanner.nextLine();
            }
            // below are the different paths for the different levels
            if (user.equals("1")) { // level 1 running
                    restart = false; // set back to false so that it will end if user enters "n"
                    menu = false;
                    String answer = randomWord(wordList);
                    String problem = levelOne(answer, "sk");
                    System.out.println("De-Gibber this: " + problem);
                    user = scanner.nextLine();
                    while (!user.equals(answer)) { // loop that keeps prompting user input if not correct
                        if (user.equals("01")) { // can quit game any time they want by entering 01 and quitting whole program
                            System.exit(0);
                        }
                        if (user.equals("00")) { // can return to the main menu (level selection) by entering 00
                            menu = true;
                            break;
                        }
                        System.out.println("Try again! Word: " + problem);
                        user = scanner.nextLine();
                    }
                    if (!menu) {
                        // passed the while loop above = everything below is for after success
                        writeToFile("level1.txt", "√");
                        System.out.println("Great! You got it correct!");
                        System.out.println("Continue playing? (y or n)");
                        user = scanner.nextLine();
                        while (!user.equals("y") && !user.equals("n")) { // loop that keeps asking until gets correct answer
                            System.out.println("Please enter in the correct format (y or n): ");
                            user = scanner.nextLine();
                        }
                        if (user.equals("y")) { // if yes, change restart to yes (update status) then end the iteration
                            restart = true;
                        }
                    } else {
                        restart = true;
                    }


            } else if (user.equals("2")) { // level 2 running
                    restart = false;
                    menu = false;
                    String answer = randomWord(wordList);
                    String problem = levelTwo(answer, "wp", "ng");
                    System.out.println("De-Gibber this: " + problem);
                    user = scanner.nextLine();
                    while (!user.equals(answer)) { // loop that keeps prompting user input if not correct
                        if (user.equals("01")) { // can quit game any time they want by entering 01 and quitting whole program
                            System.exit(0);
                        }
                        if (user.equals("00")) {
                            menu = true;
                            break;
                        }
                        System.out.println("Try again! Word: " + problem);
                        user = scanner.nextLine();
                    }
                    if (!menu) {
                        writeToFile("level2.txt", "√");
                        System.out.println("Great! You got it correct!");
                        System.out.println("Continue playing? (y or n)");
                        user = scanner.nextLine();
                        while (!user.equals("y") && !user.equals("n")) { // loop that keeps asking until gets correct answer
                            System.out.println("Please enter in the correct format (y or n): ");
                            user = scanner.nextLine();
                        }
                        if (user.equals("y")) { // if yes, change restart to yes (update status) then end the loop
                            restart = true;
                        }
                    } else {
                        restart = true;
                    }

            } else if (user.equals("3")) { // level 3 running
                    restart = false;
                    menu = false;
                    String answer = randomWord(wordList);
                    String problem = levelThree(answer);
                    System.out.println("De-Gibber this: " + problem);
                    user = scanner.nextLine();
                    while (!user.equals(answer)) { // loop that keeps prompting user input if not correct
                        if (user.equals("01")) { // can quit game any time they want by entering 01 and quitting whole program
                            System.exit(0);
                        }
                        if (user.equals("00")) {
                            menu = true;
                            break;
                        }
                        System.out.println("Try again! Word: " + problem);
                        user = scanner.nextLine();
                    }
                    if (!menu) {
                        writeToFile("level3.txt", "√");
                        System.out.println("Great! You got it correct!");
                        System.out.println("Continue playing? (y or n)");
                        user = scanner.nextLine();
                        while (!user.equals("y") && !user.equals("n")) { // loop that keeps asking until gets correct answer
                            System.out.println("Please enter in the correct format (y or n): ");
                            user = scanner.nextLine();
                        }
                        if (user.equals("y")) { // if yes, change restart to yes (update status) then end the loop
                            restart = true;
                        }
                    } else {
                        restart = true;
                    }

            } else if (user.equals("4")){ // level 4 running
                restart = false;
                menu = false;
                String[] ansArrForm = readFile("level4sent.txt");
                String answer = "";
                // below is the process of adding each individual word to the answer/problem variable
                int countOne = 0;
                for (int i = 0; i < ansArrForm.length; i++) { // loop to add each element (word) to the answer String
                    if (countOne < ansArrForm.length - 1) {
                        answer = answer + ansArrForm[i] + " ";
                        countOne++;
                    } else {
                        answer = answer + ansArrForm[i];
                    }
                }
                String problem = "";
                int countTwo = 0;
                for (int i = 0; i < ansArrForm.length; i++) { // loop to add each altered element (word) to the problem String
                    if (countTwo < ansArrForm.length - 1) {
                        problem = problem + levelThree(ansArrForm[i]) + " ";
                        countTwo++;
                    } else {
                        problem = problem + levelThree(ansArrForm[i]);
                    }
                }
                System.out.println("De-Gibber this: " + problem);
                user = scanner.nextLine();
                while (!user.equals(answer)) { // loop that keeps prompting user input if not correct
                    if (user.equals("0")) { // can quit game any time they want by entering 0 and quitting whole program
                        System.exit(0);
                    }
                    if (user.equals("00")) {
                        menu = true;
                        break;
                    }
                    System.out.println("Try again! Word: " + problem);
                    user = scanner.nextLine();
                }
                if (!menu) {
                    writeToFile("level4.txt", "√");
                    System.out.println("Great! You got it correct!");
                    System.out.println("Continue playing? (y or n)");
                    user = scanner.nextLine();
                    while (!user.equals("y") && !user.equals("n")) { // loop that keeps asking until gets correct answer
                        System.out.println("Please enter in the correct format (y or n): ");
                        user = scanner.nextLine();
                    }
                    if (user.equals("y")) { // if yes, change restart to yes (update status) then end the loop
                        restart = true;
                    }
                } else {
                    restart = true;
                }
            } else {
                clearData();
            }
        }
    }

    private static String[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }
    public static String randomWord(String[] arr) {
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
    public static char getRandomLetter() {
        Random random = new Random();
        int randomInt = random.nextInt(26); // Generates a random integer between 0 and 25 (inclusive)
        char randomLetter = (char) ('a' + randomInt); // uses character code here, 'a' char code is added with random btwn 0 - 25
        return randomLetter;
    }

    public static String levelOne(String word, String syllable) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                index = i;
                break;
            }
        }
        if (index == word.length()-1){
            return word + syllable;
        } else {
            String front = word.substring(0, index + 1);
            String back = word.substring(index + 1);
            return front + syllable + back;
        }
    }
    public static String levelTwo(String word, String first, String second) {
        StringBuilder str = new StringBuilder();
        int firstCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                if (firstCount >= 1) {
                    str.append(word.charAt(i));
                    str.append(second);
                } else {
                    str.append(word.charAt(i));
                    str.append(first);
                    firstCount++;
                }
            } else {
                str.append(word.charAt(i));
            }
        }
        return str.toString();
    }
    public static String levelThree(String word) {
        String first = "" + getRandomLetter() + getRandomLetter(); // concatenates into ex. "ij"
        String second = "" + getRandomLetter() + getRandomLetter(); // order matters with "" front or "" back, cuz concatenation will become numbers if "" at the end
        return levelTwo(word, first, second);
    }

    public static boolean isVowel(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ) {
            return true;
        }
        return false;
    }

    public static void writeToFile(String filename, String message) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(message);
        fileWriter.close();
    }
    public static void skipForward() {
        Scanner console = new Scanner(System.in);
        console.nextLine();
    }
    public static String printArray(String[] a) {
        String output = "";
        for (int i = 0; i < a.length; i++) {
            output += a[i];
        }
        return output;
    }
    public static void greetingMessage() throws FileNotFoundException {
        System.out.println("Welcome to Gibberish! Press enter to continue.");
        skipForward();
        System.out.println("In this game, you'll be given a word or sentence that has some annoying letters stuffed into them.");
        skipForward();
        System.out.println("Your job is to guess the correct word or sentence in their original form and enter it in the console.");
        skipForward();
        System.out.println("You'll have unlimited time and a total of 4 levels to go through, figure out the patterns of each level yourself:");
        skipForward();
        System.out.println("Good Luck ;)");
        skipForward();
        System.out.println("You can type " + "\"" + "00" + "\"" + " to return to the main menu at any time during a game");
        skipForward();
        System.out.println("You can type " + "\"" + "01" + "\"" + " to the console at any time during a game to exit the game");
    }

    public static void greetingPTwo() throws FileNotFoundException {
        System.out.println("Enter the level number (1-4) to start your level (Difficulty in increasing order)");
        System.out.println("Level 1 (" + printArray(readFile("level1.txt")) + ")");
        System.out.println("Level 2 (" + printArray(readFile("level2.txt")) + ")");
        System.out.println("Level 3 (" + printArray(readFile("level3.txt")) + ")");
        System.out.println("Level 4 (" + printArray(readFile("level4.txt")) + ")");
        System.out.println("To clear history, enter " + "\"" + "5" + "\"");
    }

    // writes "x"s into the four completion status files so that it looks like the completion history has been cleared
    public static void clearData() throws IOException {
        writeToFile("level1.txt", "x");
        writeToFile("level2.txt", "x");
        writeToFile("level3.txt", "x");
        writeToFile("level4.txt", "x");
    }
}
