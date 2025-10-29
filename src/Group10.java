import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/*
Methods that needed to be written
1. if the chosen column is valid. OK
2. drop disc OK
3. is board full OK
3. determine the winner. OK
4. single player game. OK
5. multiplayer game.
 */

public class Group10 {
    public static void main(String[] args) {
        Scanner inputGame = new Scanner(System.in);
        boolean menuContinues = true;

        while (menuContinues) {
            clearScreen();
            displayWelcomeMessage();
            System.out.println(COLOR_YELLOW); // Yellow.
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║    Please choose an option and start !     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_LIGHT_CYAN);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║     [A] Primary School                     ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [B] Secondary School                   ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [C] High School                        ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [D] University                         ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [E] Exit                               ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.print("Your choice: ");
            String menuChoice = inputGame.next().trim().toLowerCase();

            switch (menuChoice) {
                case "a":
                    clearScreen();
                    PrimarySchoolMenu();
                    break;


                case "b":
                    clearScreen();
                    secondarySchool();
                    break;

                case "c":
                    clearScreen();
                    HighSchoolMenu();
                    break;

                case "d":
                    clearScreen();
                    universityMenu();
                    break;

                case "e":
                    System.out.println("Exiting program... Goodbye!");
                    menuContinues = false;
                    break;

                default:
                    System.out.println(COLOR_RED);
                    System.out.println("Invalid input! Please press any key to try again.");
                    System.out.println(COLOR_RESET);
                    // Clean leftover '\n' from buffer
                    inputGame.nextLine();
                    // Wait for user to press Enter
                    inputGame.nextLine();
                    break;
            }
        }
    }

    // C: High School Menu Scanner (Taha's scanner) 
    static Scanner sc = new Scanner(System.in);
    // Gülfem's scanner
    static Scanner input = new Scanner(System.in);
    // Kerem's scanner
    static Scanner scanner = new Scanner(System.in);

    // Gokdeniz's methods

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_RED   = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW= "\u001B[33m";
    public static final String COLOR_BLUE  = "\u001B[34m";
    public static final String COLOR_LIGHT_RED   = "\u001B[91m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_LIGHT_YELLOW= "\u001B[38;5;229m";
    public static final String COLOR_LIGHT_BLUE  = "\u001B[94m";
    public static final String COLOR_LIGHT_MAGENTA = "\u001B[95m";
    public static final String COLOR_LIGHT_CYAN  = "\u001B[96m";
    public static final String COLOR_DARK_BLUE  = "\u001B[38;2;0;45;114m";
    public static final String COLOR_ROSE = "\u001B[38;2;255;0;128m";
    public static final String COLOR_LILAC = "\u001B[38;2;200;162;200m";
    public static final String COLOR_LIGHT_LILAC = "\u001B[38;2;225;200;225m";
// … and so on


    public static void displayWelcomeMessage() {
        System.out.println(COLOR_ROSE + " _    _      _                             _           _____      _                 _    _____ _                 _       _             \n" +
                "| |  | |    | |                           | |         /  ___|    | |               | |  /  ___(_)               | |     | |            \n" +
                "| |  | | ___| | ___ ___  _ __ ___   ___   | |_ ___    \\ `--.  ___| |__   ___   ___ | |  \\ `--. _ _ __ ___  _   _| | __ _| |_ ___  _ __ \n" +
                "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\  | __/ _ \\    `--. \\/ __| '_ \\ / _ \\ / _ \\| |   `--. \\ | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\n" +
                "\\  /\\  /  __/ | (_| (_) | | | | | |  __/  | || (_) |  /\\__/ / (__| | | | (_) | (_) | |  /\\__/ / | | | | | | |_| | | (_| | || (_) | |   \n" +
                " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|   \\__\\___/   \\____/ \\___|_| |_|\\___/ \\___/|_|  \\____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n"+
                COLOR_RESET);
    }

    public static void universityMenu(){
        Scanner input = new Scanner(System.in);
        String choiceOfGameMode;

        System.out.println(COLOR_LIGHT_CYAN);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         === D: University Menu ===         ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);

        char[][] table = chooseTableSize(input);
        if (table == null) {
            return;
        }
        fillTableWithAsterisk(table);

        choiceOfGameMode = chooseGameMode(input);

        switch (choiceOfGameMode){
            case "s":
                playSingleplayer(table, input);
                break;
            case "m":
                playMultiplayer(table, input);
                break;
        }
    }

    public static char[][] chooseTableSize(Scanner input){
        String choiceOfTableSize;
        char[][] table = new char[0][0];
        do{
            System.out.print(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║  Please select your choice of table size:  ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     1-) 5x4                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     2-) 6x5                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     3-) 7x6                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     4-) Return to main menu.     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Your choice: ");
            choiceOfTableSize = input.next();
            if((!choiceOfTableSize.equalsIgnoreCase("1")) &&
                    !(choiceOfTableSize.equalsIgnoreCase("2")) &&
                    !(choiceOfTableSize.equalsIgnoreCase("3")) &&
                    !(choiceOfTableSize.equalsIgnoreCase("4"))){
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input. Please try again." + COLOR_RESET);
            }
        }while((!choiceOfTableSize.equalsIgnoreCase("1")) &&
                !(choiceOfTableSize.equalsIgnoreCase("2")) &&
                !(choiceOfTableSize.equalsIgnoreCase("3")) &&
                !(choiceOfTableSize.equalsIgnoreCase("4")));

        choiceOfTableSize = choiceOfTableSize.trim().toLowerCase();

        switch (choiceOfTableSize){
            case "1":
                table = new char[4][5];
                break;
            case "2":
                table = new char[5][6];
                break;
            case "3":
                table = new char[6][7];
                break;
            case "4":
                System.out.println("Returning to main menu...");
                return null;
        }
        return table;
    }

    public static String chooseGameMode(Scanner input){
        String choiceOfGameMode;
        do{
            clearScreen();
            System.out.println(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║    Single Player or Multiplayer (s/m)?     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            choiceOfGameMode = input.next();
            if(!choiceOfGameMode.equalsIgnoreCase("s") &&
                    !choiceOfGameMode.equalsIgnoreCase("m"))
                System.out.println(COLOR_RED + "ınvalid input. Please try again." + COLOR_RESET);
        }while(!choiceOfGameMode.equalsIgnoreCase("s") &&
                !choiceOfGameMode.equalsIgnoreCase("m"));

        choiceOfGameMode = choiceOfGameMode.trim().toLowerCase();
        return choiceOfGameMode;
    }

    public static void playSingleplayer(char[][] table, Scanner input){
        char currentPlayer = '1';
        boolean gameContinues = true;
        Random random = new Random();

        while(gameContinues){
            clearScreen();
            printTable(table);

            if(currentPlayer == '1'){
                System.out.println("Player number " + currentPlayer + ", please make your move.");
                System.out.println("Please enter a valid column number between 1 - " + table[0].length + ": ");
                System.out.println("Enter '0' if you want to quit the game.");

                byte choiceOfColumn = -1;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        choiceOfColumn = input.nextByte();
                        if (choiceOfColumn == 0){
                            clearScreen();
                            System.out.println("Player " + currentPlayer + ", has quit the game.");
                            universityMenu();
                            return;
                        }
                        if (!isColumnValid(table, choiceOfColumn)) {
                            clearScreen();
                            printTable(table);
                            System.out.println("The column you entered is not valid. Please enter a number between 1 and " + table[0].length + ".");
                            System.out.println("Enter '0' if you want to quit the game.");
                        } else {
                            validInput = true;
                        }
                    } catch (Exception a) {
                        System.out.println(COLOR_RED + "Invalid input! Please enter a number between 1 and " + table[0].length + "." +COLOR_RESET);
                        System.out.println("Enter '0' if you want to quit the game.");
                        input.nextLine();
                    }
                }

                try {
                    dropDiscAnimated(table, choiceOfColumn, currentPlayer);
                } catch (InterruptedException e) {
                    System.out.println("Animation interrupted unexpectedly. Returning to University Menu");
                    universityMenu();
                }
            }
            else{
                byte computersMove;
                do {
                    computersMove = (byte) (random.nextInt(table[0].length) + 1);
                } while (!isColumnValid(table, computersMove));
                System.out.println("Computer chooses column " + computersMove + ".");
                try {
                    dropDiscAnimated(table, computersMove, currentPlayer);
                } catch (InterruptedException e) {
                    System.out.println("Animation interrupted unexpectedly. Returning to University Menu");
                    universityMenu();
                }
            }


            if(determineWinner(table, currentPlayer)){
                clearScreen();
                printTable(table);
                if(currentPlayer == '1'){
                    System.out.println("Congratulations! You won the game!");
                }
                else{
                    System.out.println("The computer wins!");
                }
                gameContinues = false;
            }
            else if (isTableFull(table)){
                printTable(table);
                System.out.println("It's a draw!");
                gameContinues = false;
            }
            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }
        String nextAction = postGameMenu(input);
        switch(nextAction){
            case"r":
                fillTableWithAsterisk(table);
                playSingleplayer(table, input);
                return;
            case"m":
                clearScreen();
                universityMenu();
                return;
            case "q":
                System.out.println("Returning to Main Menu...");
                return;
        }
    }

    public static void playMultiplayer(char[][] table, Scanner input){
        char currentPlayer = '1';
        boolean gameContinues = true;

        while(gameContinues){
            clearScreen();
            printTable(table);
            System.out.println("Player number " + currentPlayer + ", please make your move.");
            System.out.println("Please enter a valid column number between 1 - " + table[0].length + ": ");
            System.out.println("Enter '0' if you want to quit the game.");

            byte choiceOfColumn = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    choiceOfColumn = input.nextByte();
                    if (choiceOfColumn == 0){
                        clearScreen();
                        System.out.println("Player " + currentPlayer + ", has quit the game.");
                        universityMenu();
                        return;
                    }
                    if (!isColumnValid(table, choiceOfColumn)) {
                        clearScreen();
                        printTable(table);
                        System.out.println("The column you entered is not valid. Please enter a number between 1 and " + table[0].length + ".");
                        System.out.println("Enter '0' if you want to quit the game.");
                    } else {
                        validInput = true;
                    }
                } catch (Exception a) {
                    System.out.println(COLOR_RED + "Invalid input! Please enter a number between 1 and " + table[0].length + "."  + COLOR_RESET);
                    System.out.println("Enter '0' if you want to quit the game.");
                    input.nextLine();
                }
            }

            try {
                dropDiscAnimated(table, choiceOfColumn, currentPlayer);
            } catch (InterruptedException e) {
                System.out.println(COLOR_RED + "Animation interrupted unexpectedly. Returning to University Menu" + COLOR_RESET);
                universityMenu();
            }

            if(determineWinner(table, currentPlayer)){
                clearScreen();
                printTable(table);
                System.out.println(COLOR_LIGHT_GREEN + "Player " + currentPlayer + " has won the game." + COLOR_RESET);
                gameContinues = false;
            }
            else if (isTableFull(table)){
                printTable(table);
                System.out.println("It's a draw!");
                gameContinues = false;
            }
            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }
        String nextAction = postGameMenu(input);
        switch(nextAction){
            case"r":
                fillTableWithAsterisk(table);
                playMultiplayer(table, input);
                return;
            case"m":
                clearScreen();
                universityMenu();
                return;
            case "q":
                System.out.println("Returning to Main Menu...");
                return;
        }
    }

    public static String postGameMenu(Scanner input){
        String selection;

        do{
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("R-) Restart the game with the same settings.");
            System.out.println("M-) Return to University Menu.");
            System.out.println("Q-) Quit and return to main menu.");
            System.out.println("Please enter your choice: ");
            selection = input.next().trim().toLowerCase();

            if(!selection.equals("r") && !selection.equals("m") &&  !selection.equals("q")){
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input. Please try again." + COLOR_RESET);
            }

        }while(!selection.equals("r") && !selection.equals("m") &&  !selection.equals("q"));

        return selection;
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean isColumnValid(char[][] table, byte colNum){
        if(colNum <= 0 || colNum > table[0].length)
            return false;

        if(table[0][colNum-1] != '*')
            return false;

        return true;
    }

    public static boolean isTableFull(char[][] table){
        for (char[] chars : table) {
            for (char ch : chars) {
                if(ch == '*')
                    return false;
            }
        }
        return true;
    }



    public static boolean determineWinner(char[][] table, char player) {
        // Horizontal check
        for (int rowIndex = 0; rowIndex < table.length; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex][colIndex + 1] == player &&
                        table[rowIndex][colIndex + 2] == player &&
                        table[rowIndex][colIndex + 3] == player)
                    return true;
            }
        }
        // Vertical check
        for (int rowIndex = 0; rowIndex < table.length - 3; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex + 1][colIndex] == player &&
                        table[rowIndex + 2][colIndex] == player &&
                        table[rowIndex + 3][colIndex] == player)
                    return true;
            }
        }
        // Upward diagonal check
        for (int rowIndex = 3; rowIndex < table.length; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex - 1][colIndex + 1] == player &&
                        table[rowIndex - 2][colIndex + 2] == player &&
                        table[rowIndex - 3][colIndex + 3] == player) {
                    return true;
                }
            }
        }
        // Downward diagonal check
        for (int rowIndex = 0; rowIndex < table.length - 3; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex + 1][colIndex + 1] == player &&
                        table[rowIndex + 2][colIndex + 2] == player &&
                        table[rowIndex + 3][colIndex + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void fillTableWithAsterisk(char[][] table){
        for (char[] chars : table) {
            Arrays.fill(chars, '*');
        }
    }

    public static void printTable(char[][] table) {
        int rows = table.length;
        int cols = table[0].length;

        // Top border
        System.out.print("╔");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══╦");
        }
        System.out.println("═══╗");

        // Draw each row
        for (int r = 0; r < rows; r++) {
            System.out.print("║");
            for (int c = 0; c < cols; c++) {
                char cell = table[r][c];

                // Color setup
                if (cell == '1') {
                    System.out.print(" \u001B[31m" + cell + "\u001B[0m ║"); // Red for Player 1
                } else if (cell == '2') {
                    System.out.print(" \u001B[33m" + cell + "\u001B[0m ║"); // Yellow for Player 2
                } else {
                    System.out.print(" " + cell + " ║"); // Normal for empty
                }
            }
            System.out.println();

            // Middle separators between rows
            if (r != rows - 1) {
                System.out.print("╠");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══╬");
                }
                System.out.println("═══╣");
            }
        }

        // Bottom border
        System.out.print("╚");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══╩");
        }
        System.out.println("═══╝");

        // Column numbers
        System.out.print("  ");
        for (int c = 1; c <= cols; c++) {
            System.out.print(" " + c + "  ");
        }
        System.out.println();
    }
    public static void dropDiscAnimated(char[][] table, byte colNum, char player) throws InterruptedException {
        int colIndex = (int)colNum - 1;

        // find the correct position that the disk is goingto land
        int targetRow = -1;
        for(int rowIndex = table.length-1; rowIndex >= 0; rowIndex--){
            if(table[rowIndex][colIndex] == '*'){
                targetRow = rowIndex;
                break;
            }
        }

        // animation of row falling
        for (int rowIndex = 0; rowIndex <= targetRow; rowIndex++) {
            table[rowIndex][colIndex] = player;    // put the disk into this row
            clearScreen();                  // clear the screen
            printTable(table);              // print the table again
            Thread.sleep(300);              // 300 miliseconds of waiting
            if (rowIndex != targetRow) {           // clear the current row before the disk reaches the next rox
                table[rowIndex][colIndex] = '*';
            }
        }
    }

    ////GÜLFEM
    
    public static void PrimarySchoolMenu() {
                    boolean subMenu = true;
                    while (subMenu) {
                        clearScreen();  //Alt menü başında ekranı temizle
                        System.out.println(COLOR_LIGHT_CYAN);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║        === Primary School Menu ===         ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println(COLOR_LIGHT_BLUE);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║Please select your choice:                  ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println(COLOR_RESET);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[1] Age and Zodiac                          ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[2] Reverse Words                           ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[3] Back to Main Menu                       ║");
                        System.out.println("╚════════════════════════════════════════════╝");

                        System.out.print("Enter choice: "); // Bu satır çerçeve dışında kalmalı
                        String Choice = input.nextLine().trim();

                        switch (Choice) {
                            case "1":
                                clearScreen(); // Age and Zodiac başlamadan önce ekranı temizle
                                ageAndZodiacDetection();
                                System.out.println("\nPress Enter to return to Primary School Menu...");
                                input.nextLine();
                                break;
                            case "2":
                                clearScreen(); // Reverse Words başlamadan önce ekranı temizle
                                reverseTheWords();
                                System.out.println("\nPress Enter to return to Primary School Menu...");
                                input.nextLine();
                                break;
                            case "3":
                                subMenu = false;
                                break;
                            default:
                                System.out.println(COLOR_RED);
                                System.out.println("Invalid choice! Try again.");
                                System.out.println(COLOR_RESET);
                                System.out.println("Press Enter to continue...");
                                input.nextLine();
                                break;
                        }
                    }
                        }
    //* Option A: Zodiac and Sign kısmı

    /* Öncelikle kullanıcıdan doğum gününün tarihini ve saatini almam gerekiyor,
    ardından bu bilgilere göre yaş ve burç hesaplaması yapacağım.
    */
    public static int receiveInputDate(String inputString) {
        while (true) {
            System.out.println(inputString);
            // Makes sure that the input is INT
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println(COLOR_RED);
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║Invalid input! Please enter an integer.     ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println(COLOR_RESET);
                input.next();

            }
        }
    }
    public static void ageAndZodiacDetection() {
        System.out.println(COLOR_ROSE);
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║ Age and Zodiac Sign Detection ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println(COLOR_RESET);
        //Öncelikle kullanıcıdan doğum tarihini aldım.


        //Öncelikle kullanıcıdan doğum tarihini aldım.
        int birthDay = receiveInputDate("Enter your birth 'day' (1-31):");
        input.nextLine();
        int birthMonth = receiveInputDate("Enter your birth 'month' (1-12):");
        input.nextLine();
        int birthYear = receiveInputDate("Enter your birth 'year':");
        input.nextLine();



        //Bu kısımda girdiği doğum günü tarihlerinin geçerli olup olmadığını kontrol ettim.
        if (!isValidDate(birthDay, birthMonth, birthYear)) {
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid birth date.                         ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }

        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔══════════════╗");
        System.out.println("║Your birthday:║ " + birthDay + "/" + birthMonth + "/" + birthYear + "    ");
        System.out.println("╚══════════════╝");
        System.out.println(COLOR_RESET);
        //Sonrasında ise mevcut tarihi aldım.
        int currentDay = receiveInputDate("Enter the current 'day' (1-31):");
        input.nextLine();
        int currentMonth = receiveInputDate("Enter the current 'month' (1-12):");
        input.nextLine();
        int currentYear = receiveInputDate("Enter the current 'year':");

        //Bu kısımda da girdiği 'currentDay, currentMonth ve currentYear' kısımlarıının geçerli olup olmadığını kontrol ettim.
        if (!isValidDate(currentDay, currentMonth, currentYear)) {
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid current date.                       ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }

        clearScreen();
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔══════════════╗");
        System.out.println("║Your birthday:║ " + birthDay + "/" + birthMonth + "/" + birthYear + "    ");
        System.out.println("╚══════════════╝");
        System.out.println("╔══════════════╗");
        System.out.println("║Current date: ║ "  + currentDay + "/" + currentMonth + "/" + currentYear + "                     ");
        System.out.println("╚══════════════╝");
        System.out.println(COLOR_RESET);
        // ---------- YAŞ HESAPLAMA

        // Yaş hesaplama kısmını ilk başta yazdığımda negatif değerler çıkabileceğini fark etmemiştim.
        //Negatif değerler çıkmasını istemediğim için düzeltip alttaki şekile çevirdim.
        int age = currentYear - birthYear;

        // Kullanıcının girdiği yılda yaş gününü geçmediyse yaşını 1 azalttım.
        // Çünkü o yılki yaşını henüz doldurmadı.
        if (currentMonth < birthMonth ||
                (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        //Eğer yaş negatif hesaplanıyorsa kullanıcımız şimdiki zamana kıyasla doğum tarihinden önceki bir yılı girmiştir.
        //Girdiği tarihte henüz doğmamış olacağını gördüğüm için aşağıdaki mesajı verdim.

        input.nextLine();
        if (age < 0) {
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid birth and current date. Birth date  ║");
            System.out.println("║is in the future.                           ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════╗");
        System.out.println("║Your age is: ║  " + age + "     ");
        System.out.println("╚═════════════╝");

        // ----------- BURÇ HESAPLAMA
        String zodiac = calculateZodiac(birthDay, birthMonth);

        System.out.println("╔═════════════════════╗");
        System.out.println("║Your Zodiac Sign is: ║  " + zodiac + "       ");
        System.out.println("╚═════════════════════╝");
        System.out.println(COLOR_RESET);



    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        //Girilen günün o aydaki gün sayısının doğruluğunun kontrolü
        if (day < 1) {
            return false;
        }

        if (month == 1 && day > 31) {
            return false;
        }
        if (month == 2){
            if(day > 29)
                return false;
            if(day == 29 && year % 4 != 0)
                return false;
        }
        if (month == 3 && day > 31) {
            return false;
        }
        if (month == 4 && day > 30) {
            return false;
        }
        if (month == 5 && day > 31) {
            return false;
        }
        if (month == 6 && day > 30) {
            return false;
        }
        if (month == 7 && day > 31) {
            return false;
        }
        if (month == 8 && day > 31) {
            return false;
        }
        if (month == 9 && day > 30) {
            return false;
        }
        if (month == 10 && day > 31) {
            return false;
        }
        if (month == 11 && day > 30) {
            return false;
        }
        if (month == 12 && day > 31) {
            return false;
        }
        if (month == 2 && day ==29) {
            if (year % 4 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String calculateZodiac(int day, int month) {
        String zodiac = "";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) zodiac = "Aquarius";
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) zodiac = "Pisces";
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) zodiac = "Aries";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) zodiac = "Taurus";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) zodiac = "Gemini";
        else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) zodiac = "Cancer";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) zodiac = "Leo";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) zodiac = "Virgo";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) zodiac = "Libra";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) zodiac = "Scorpio";
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) zodiac = "Sagittarius";
        else if ((month == 12 && day >=22) || (month ==1 && day <=19)) zodiac = "Capricorn";
        else zodiac = "Invalid";
        return zodiac;
    }

    // * Option A: Reverse the Words kısmı
    // Bu kısımda kullanıcıdan aldığım cümledeki kelimeleri tek tek ters çevireceğim.
    public static void reverseTheWords() {
        System.out.println(COLOR_ROSE);
        System.out.println("╔═══════════════════╗");
        System.out.println("║ Reverse the Words ║");
        System.out.println("╚═══════════════════╝");
        System.out.println(COLOR_RESET);

        // Kullanıcıdan bir cümle alıyorum.
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        // Sonucu saklayacağım değişken
        String result = "";

        // Geçici olarak bir kelimeyi tutmak için
        String word = "";

        // Cümlenin her harfini tek tek kontrol edeceğim
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i); // sıradaki karakteri al
            if (c == ' ' || c == ',' || c == '.' || c == '!' || c == '?' || c == ';' || c == ':' || c == '"' || c == '\'' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '-' || c == '_'
                    || c == '*' || c == '+' || c == '=' || c == '/' || c == '\\' || c == '|' || c == '<' || c == '>' || c == '~' || c == '`' || c == '@') {

                int letterCount = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (Character.isLetter(word.charAt(j))) letterCount++;
                }

                if (letterCount >= 2) word = reverseWord(word);

                result += word + c;
                word = "";
            } else {
                word += c;
            }
        }

        if (word.length() > 0) {
            int letterCount = 0;
            for (int j = 0; j < word.length(); j++) {
                if (Character.isLetter(word.charAt(j))) letterCount++;
            }

            if (letterCount >= 2) word = reverseWord(word);
            result += word;
        }
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("\n╔════════════════════╗");
        System.out.println("║ Reversed sentence: ║");
        System.out.println("╚════════════════════╝");
        System.out.println(COLOR_RESET);
        System.out.println(result);

    }

    public static String reverseWord(String word) {
        if (word.length() <= 1) return word;
        return word.charAt(word.length() - 1) + reverseWord(word.substring(0, word.length() - 1));
    }

   

        //...deneme2
        //================KEREM IRFANOGLU================ ...
    //====================Secondary School====================
    public static void secondarySchool(){

        clearScreen();
        System.out.println(COLOR_LIGHT_CYAN);
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║        === Secondary School Menu ===           ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(COLOR_LIGHT_BLUE);
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          Please select your choice:            ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   [1] Prime Number                             ║");
        System.out.println("║════════════════════════════════════════════════║");
        System.out.println("║   [2] Step-by-step Evaluation of Expression    ║");
        System.out.println("║════════════════════════════════════════════════║");
        System.out.println("║   [3] Return to Main Menu                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        while (true) {
            System.out.print("Enter your choice (1-3): "); 
            String input = scanner.nextLine();
            //If the input is integer or not?
            if (!isInt(input)) {
                System.out.println();
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! ");
                System.out.print(COLOR_RESET);
                continue;
            }
            //If the input is between 1-3?
            if(!isValidMenu(input)){
                System.out.println();
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }
            //string to integer
            int choice = Integer.parseInt(input);

            //Sending to choosen choice
            switch (choice) {
                case 1 -> primeNumbers();
                case 2 -> evaluation();
                case 3 -> System.out.println("Returning to main menu...");
            }
            break;
        }
    }
    //Checking the input is integer or not:
    private static boolean isInt(String input) {
        try {
            //use Integer.parseInt(input);
            Integer.valueOf(input);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
    //Checking the input is between 1-3:
    private static boolean isValidMenu(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= 1 && number <= 3;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean repeat(String message){
        String answer;
        while(true) {
            System.out.print(message);
            answer = scanner.nextLine().trim().toUpperCase();
            switch (answer) {
                case "1" -> {
                    return true;
                }
                case "2" -> {
                    return false;
                }
                default -> {
                    clearScreen(); 
                    System.out.println();System.out.println(COLOR_RED);
                    System.out.println("Please enter '1' or '2'!");
                    System.out.println(COLOR_RESET);
                }
            }
        }
    }

    public static void sieveOfEratosthenes(int intNum) {
        
        System.out.println();
        System.out.print(COLOR_LIGHT_YELLOW);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║          Sieve of Eratosthenes          ║");
        System.out.println("╚═════════════════════════════════════════╝");

        boolean[] isPrime = new boolean[intNum+1];

        //Assuming all integers are prime (true)
        for (int i = 2; i <= intNum; i++) {
            isPrime[i] = true;
        }

        //start time
        long startTime = System.nanoTime();

        //If i is not prime, make it false
        for (int i = 2; i * i <= intNum; i++) {
            if (isPrime[i]) {
                
                for (int j = i * i; j <= intNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        //end time
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;
        //scanning the array last to first to find the last two primes.
        for(int i = intNum; i>=2; i--){
            if(isPrime[i]){
                //assigning to "last" if the integer is prime.
                if(last == -1){
                    last = i;   //
                }
                //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                else if(secondLast == -1){
                    secondLast = i;
                    break;
                }
            }
        }
        //printing the Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + executionTime + " ns");
        System.out.print(COLOR_RESET);
    }
    
    public static void sieveOfSundaram(int intNum){
        
        System.out.println();
        System.out.print(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            Sieve of Sundaram            ║");
        System.out.println("╚═════════════════════════════════════════╝");

        int nNew = (intNum - 1)/2;
        boolean[] marked = new boolean[nNew +1];

        //start time
        long startTime = System.nanoTime();

        //switching not primes to true, then primes will remain false.
        for (int i = 1; i <= nNew; i++){
            for (int j = i; i+j+2*i*j <= nNew; j++){
                marked[i+j+2*i*j] = true;
            }
        }

        //end time
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;

        //scanning the array last to first to find the last two primes.
        for (int i = nNew; i >= 2; i--){
            if(!marked[i]){
                //turning i into prime numbers.
                int prime = 2*i + 1;
                //assigning to "last" if the integer is prime.
                if(prime <= intNum){
                    if(last == -1){
                        last = prime;
                    }
                    //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                    else if(secondLast == -1){
                        secondLast = prime;
                        break;
                    }
                }
            }
        }
        //printing the Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + executionTime + " ns");
        System.out.print(COLOR_RESET);
    }

    public static void sieveOfAtkin(int intNum){

        System.out.println();
        System.out.print(COLOR_LIGHT_BLUE);
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║             Sieve of Atkin             ║");
        System.out.println("╚════════════════════════════════════════╝");

        boolean[] prime = new boolean[intNum + 1];
        //start time
        long startTime = System.nanoTime();

        //we get the squareroot of the input
        int sqrt = (int) Math.sqrt(intNum);

        for(int i = 1; i <= sqrt; i++){
            for(int j=1; j<= sqrt; j++){
                int n = 4*i*i + j*j;
                if (n <= intNum && (n%12 == 1 || n%12 == 5)){
                    prime[n] = !prime[n];
                }
                n = 3*i*i + j*j;
                if (n <= intNum && n%12 == 7){
                    prime[n] = !prime[n];
                }
                n = 3*i*i - j*j;
                if (i>j && n <= intNum && n%12 == 11){
                    prime[n] = !prime[n];
                }
            }
        }

        for(int i = 5; i<=sqrt; i++){
            if(prime[i]){
                int k = i*i;
                for(int j=k; j<= intNum; j+=k){
                    prime[j]= false;
                }
            }
        }
        //end time
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;

        for(int i=intNum; i >= 2; i--){
            if(prime[i]){
                //assigning to "last" if the integer is prime.
                if(last == -1){
                    last = i;
                }
                //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                else if(secondLast == -1){
                    secondLast = i;
                    break;
                }
            }
        }
        //printing Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + executionTime + " ns");
        System.out.print(COLOR_RESET);
    }
    
    public static void primeNumbers() {
        int intNum;
        clearScreen();
        System.out.println(COLOR_ROSE);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║          === Prime Numbers ===          ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);
        while (true) {
            System.out.print("Please enter an integer (n >= 12): ");
            String num = scanner.nextLine().trim();
    
            if (!isInt(num)) {
                clearScreen();
                System.out.println("");
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }
    
            intNum = Integer.parseInt(num);

            if (intNum < 12) {
                clearScreen();
                System.out.println("");
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }
            break;
        }

        clearScreen();
        System.out.println("Results for integer: " + intNum);

        sieveOfEratosthenes(intNum);
        sieveOfSundaram(intNum);
        sieveOfAtkin(intNum);
        System.out.println();

        if(repeat("[1] Try again.\n[2] Return to secondary school menu.\nYour choice: ")){
            primeNumbers();
        }
        else{
            secondarySchool();
        }
    }
    
    //====================Step by Step Evaluation====================
    public static void evaluation() {
        clearScreen();
        System.out.println(COLOR_ROSE);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║     === Step by Step Evaluation ===     ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);
        while(true){
            System.out.print("Enter a mathematical expression: ");
            String input = scanner.nextLine();

            clearScreen();

            String expr = normalize(input);
            
            if(!isValidExpression(expr)){
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! " + COLOR_RESET); 
                continue;
            }

            List<String> tokens = tokenize(expr);
            System.out.println(renderForOutput(tokens));

            try {
                evaluateStepByStep(tokens);
                break;
            } 
            catch (ArithmeticException error) {
            System.out.println("Division by zero. Please enter a valid mathematical expression!");
            }
        }

        System.out.println("════════════════════════════════════");
        if(repeat("[1] Try again.\n[2] Return to secondary school menu.\nYour choice: ")){
            evaluation();
        }
        else{
            secondarySchool();
        }
    } 
    
    static String normalize(String s) {
        s = s.replace("×", "*");
        s = s.replace("x", "*");
        s = s.replace("X", "*");
        s = s.replace(":", "/");
        s = s.replace("−", "-");
        s = s.replace(" ", "");
    return s;
    }
    
    static boolean isValidExpression(String s) {
        if(s == null || s.isEmpty()) return false;

        //for paranthesis balance
        int balance = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //if char is not acceptable, return false.
            if(!(Character.isDigit(c) || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')){
                return false;
            }

            if (c =='('){
                balance++;
            }
            else if(c == ')'){
                balance--;
                if(balance < 0) return false;
            } 
        }
        //if parantheses are not balanced, return false.
        if (balance !=0) return false;

        final int START=0, NUM=1, OP=2, OPEN=3, CLOSE=4;
        //creating a prev to check if the next char is acceptable.
        int prev = START;

        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) i++;
                prev=NUM;
            }
            else if(c == '('){
                //NUM or CLOSE cannot be before OPEN
                if (prev == NUM || prev == CLOSE) return false;
                prev=OPEN;
            }
            else if(c == ')'){
                //Only NUM or CLOSE can be before CLOSE
                if (!(prev == NUM || prev == CLOSE)) return false;
                if (i+1 < s.length()) {
                    char next = s.charAt(i+1);
                    if(Character.isDigit(next) || next == '(') return false;
                }
                prev=CLOSE;
            }
            else if(c == '+' || c == '*' || c == '/'){
                //Only NUM or CLOSE can be before OP
                if (!(prev == NUM || prev == CLOSE)) return false;
                prev=OP;
            }
            else if(c == '-'){
                //"-" can be after three places: at START, OPEN or OP(negative sign).
                boolean negative = (prev == START || prev == OPEN || prev == OP);
                if(negative){
                    //next char must be a digit or else it is not a negative sign.
                    if(i+1 >= s.length() || !Character.isDigit(s.charAt(i+1))) return false;

                    //if defined negative number has more than 1 digit, it includes the remaining digits.
                    int j = i+1;
                    while(j+1 < s.length() && Character.isDigit(s.charAt(j+1)))j++;
                    i = j;
                    prev = NUM;
                }
                else{
                    // Operator "-" just can be after NUM or CLOSE
                    if(!(prev==NUM || prev==CLOSE)) return false;
                    prev = OP;
                }
            }
        }
        //Expression must end either with a NUM or CLOSE
        return (prev == NUM || prev == CLOSE);
    }
    //to separate the strings to tokens
    static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int start = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                tokens.add(s.substring(start, i + 1));
                i++;
            } 
            else if (c == '(' || c == ')' || c == '*' || c == '/' || c == '+') {
                tokens.add(String.valueOf(c));
                i++;
            } 
            else if (c == '-') {
                //checks if the '-' is at the start
                boolean atStart = tokens.isEmpty();
                //checks if '-' comes after an operator.
                boolean afterOpOrOpen = !tokens.isEmpty() && isOpOrOpen(tokens.get(tokens.size() - 1));
                //checks if there is a digit after '-'
                boolean hasNextDigit = (i + 1 < s.length()) && Character.isDigit(s.charAt(i + 1));

                if ((atStart || afterOpOrOpen) && hasNextDigit) {
                    int start = i;
                    i++;
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                    tokens.add(s.substring(start, i + 1));
                    i++;
                } else {
                    tokens.add("-");
                    i++;
                }
            } 
            else {
                i++;
            }
        }
        return tokens;
    }
    //if the last token is an operator or open paranthesis, then given '-' may be negative sign.
    static boolean isOpOrOpen(String lastToken) {
        if (lastToken == null || lastToken.isEmpty()) return false;
        return lastToken.equals("+") || lastToken.equals("-")
            || lastToken.equals("*") || lastToken.equals("/")
            || lastToken.equals("(");
    }
    // It reduces and writes one operation at a time until it reduces the entire expression to a single number.
    static void evaluateStepByStep(List<String> tokens) {

        // The expression is reduced to a single number
        if (tokens.size() == 1 && isNumberToken(tokens.get(0))) return;

        // find the innermost paranthesis
        int open = findInnermostOpenParen(tokens);
        int close = (open != -1) ? findMatchingCloseParen(tokens, open) : -1;
        int start = (open == -1) ? 0 : open + 1;
        int endEx = (open == -1) ? tokens.size() : close;

        boolean reduced = reduceOnce(tokens, start, endEx); 

        if (open != -1) {
            // after reduceOnce, because of index may have shifted, finding close again
            int close2 = findMatchingCloseParen(tokens, open);
            boolean removed = removeParen(tokens, open, close2);
            reduced = reduced || removed;
        }

        //if there are no reduction, remove the paranthesis
        if (!reduced && open != -1) {
            reduced = removeParen(tokens, open, close);
        }

        // if any action happened, print the result and call it again.
        if (reduced) {
            System.out.println("= " + renderForOutput(tokens)); 
            
            //call the method again to continue reducing the expression.
            evaluateStepByStep(tokens); 
        }
        // if reduced==false, that means there are no reduction left, so print out the result.
    }

    static boolean reduceOnce(List<String> tokens, int start, int endEx) {
        // look for '*' or '/'
        for (int i = start; i < endEx; i++) {
            //increase i from first token until last one.
            String tk = tokens.get(i);
            if (tk.equals("*") || tk.equals("/")) {
                //we assing a op to i. That means i-1 and i+1 must be a number
                if (i - 1 < start || i + 1 >= endEx) return false;
                //we assign i-1 to left side of the op. And i+1 to right side of the op.
                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                if (!(isNumberToken(lhs) && isNumberToken(rhs))) return false;

                long a = parseLongSafe(lhs);
                long b = parseLongSafe(rhs);
                long res; //result
                if (tk.equals("*")) {
                    res = a * b;
                } else {
                    if (b == 0)throw new ArithmeticException("division by zero");
                    res = a / b;
                }

                // replace i-1, i, i+1 with the result
                tokens.subList(i - 1, i + 2).clear();
                tokens.add(i - 1, Long.toString(res));
                return true;
            }
        }

            // look for '+' or '-'(operator '-', not negativa sign)
        for (int i = start; i < endEx; i++) {
            String tk = tokens.get(i);
            if (tk.equals("+") || tk.equals("-")) {
                //we assing a op to i. That means i-1 and i+1 must be a number
                if (i - 1 < start || i + 1 >= endEx) return false;
                //we assign i-1 to left side of the op. And i+1 to right side of the op.
                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                if (!(isNumberToken(lhs) && isNumberToken(rhs))) return false;

                long a = parseLongSafe(lhs);
                long b = parseLongSafe(rhs);
                long res = tk.equals("+") ? (a + b) : (a - b); //result

                // replace i-1, i, i+1 with the result
                tokens.subList(i - 1, i + 2).clear();
                tokens.add(i - 1, Long.toString(res));
                return true;
            }
        }

            return false;
    }

    static int findInnermostOpenParen(List<String> tokens) {
        //checking right to left to find the innermost paranthesis
        for (int i = tokens.size() - 1; i >= 0; i--) {
            if (tokens.get(i).equals("(")) {
                return i; //innermost paranthesis has found
            }
        }
        return -1; //if there are no parantheses
    }
    //Finds the matching paranthesis for the given ')'
    static int findMatchingCloseParen(List<String> tokens, int openIdx) {
        int bal = 0;
        for (int i = openIdx; i < tokens.size(); i++) {
            if (tokens.get(i).equals("(")) bal++;
            else if (tokens.get(i).equals(")")) {
                bal--;
                if (bal == 0) return i;
            }
        }
        return -1;
    }
    //if there is just a number inside the paranthesis, removes the paranthesis.
    static boolean removeParen(List<String> tokens, int open, int close) {
        if (close - open == 2 && isNumberToken(tokens.get(open + 1))) {
            String val = tokens.get(open + 1);
            tokens.subList(open, close + 1).clear();
            tokens.add(open, val);
            return true;
        }
        return false;
    }
    //Combines the tokens to print out and switches '*' to 'x' and '/' to ':'.
    static String renderForOutput(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        for (String tk : tokens) {
            switch (tk) {
                case "*" -> sb.append('x');
                case "/" -> sb.append(':');
                default -> sb.append(tk);
            }
        }
        return sb.toString();
    }
    //checks if the both lhs and rhs tokens are number.
    static boolean isNumberToken(String tk) {
        if (tk == null || tk.isEmpty()) return false;
        int i = 0;
        if (tk.charAt(0) == '-') {
            if (tk.length() == 1) return false; //it can't just '-' to be a number.
            i = 1; //if it is a negative number, skips the sign
        }
        for (; i < tk.length(); i++) {
            char c = tk.charAt(i);
            if (c < '0' || c > '9') return false; //if it is not a number, false.
        }
        return true;
    }

    static long parseLongSafe(String tk) {
        //transform the string token to long
        return Long.parseLong(tk);
    }

    // -------------  Taha's methods ----------------
    public static void HighSchoolMenu(){
        while (true) {
            clearScreen();
            // Menu . ...........
            System.out.println(COLOR_LIGHT_CYAN);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║            === High School Menu ===            ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║           Please select your choice:           ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [1] Statistical information about an Array   ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [2] Distance between two Arrays              ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [3] Return to Main Menu                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Please choose your operation (1-3): ");

            int choice = readIntInRange(1, 3);
            switch (choice) {
                case 1:
                    clearScreen();
                    statisticalInformation();
                    promptEnterToContinue();
                    break;
                case 2:
                    clearScreen();
                    distanceBetweenTwoArrays();
                    promptEnterToContinue();
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    return;
                default:
                    // unreachable due to readIntInRange
                    break;
            }
        }        
    }

    // Menu selection 1
     private static void statisticalInformation() {
         System.out.println(COLOR_ROSE);
         System.out.println("╔════════════════════════════════════════════════╗");
         System.out.println("║     Statistical information about an Array     ║");
         System.out.println("╚════════════════════════════════════════════════╝");
         System.out.println(COLOR_RESET);
        int n;
        while (true) {
            System.out.print("Enter the length of your array: ");
            n = readPositiveInt();
            if (n <= 0) {
                System.out.println("COLOR_RED + \"Length must be a positive integer. Please try again: \" + COLOR_RESET");
            } 
            else {
                break;
            }
        }
        // Populating the array
        double[] arr = new double[n];
        System.out.println("Enter the members of your array:");
        for (int i = 0; i < n; i++) {
            arr[i] = readDoubleWithPrompt("Member " + (i + 1) + ": ");
        }

        Arrays.sort(arr); // Sorting for the median

        // Calculations
        double median = computeMedian(arr);
        double arithmeticMean = computeArithmeticMean(arr);
        Double geometricMean = computeGeometricMean(arr); 
        Double harmonicMean = computeHarmonicMeanRecursive(arr); 
        // Printing the calculations
         System.out.println(COLOR_LIGHT_GREEN);
         System.out.println("╔═════════════════╗");
         System.out.println("║     Results     ║");
         System.out.println("╚═════════════════╝");
        System.out.printf("Sorted array: %s%n", Arrays.toString(arr));
        System.out.printf("Median: %s%n", formatDoubleOrMsg(median, ""));
        System.out.printf("Arithmetic Mean: %s%n", formatDoubleOrMsg(arithmeticMean, ""));
        if (geometricMean == null) {
            System.out.println("Geometric Mean: Undefined (One of the members in this array is <= 0)");
        } 
        else {
            System.out.printf("Geometric Mean: %s%n", formatDoubleOrMsg(geometricMean, ""));
        }
        if (harmonicMean == null) {
            System.out.println("Harmonic Mean: Undefined (One of the members in this array is <= 0)");
        } 
        else {
            System.out.printf("Harmonic Mean: %s%n", formatDoubleOrMsg(harmonicMean, ""));
        }
         System.out.println(COLOR_RESET);
    }

    // Menu selection 2
    private static void distanceBetweenTwoArrays() {
        System.out.println(COLOR_ROSE);
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           Distance between two arrays          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);
        int dim;
        while (true) {
            System.out.print("Enter the length of your array: ");
            dim = readPositiveInt();
            if (dim <= 0) {
                System.out.println("COLOR_RED + \"Length must be positive integer. Please try again.\" + COLOR_RESET");
            } 
            else {
                break;
            }
        }

        System.out.println("Enter memmbers of the first array (Must be 0-9 integer):");
        int[] a = new int[dim];
        for (int i = 0; i < dim; i++) {
            a[i] = readIntInRangeWithPrompt(0, 9, "a[" + i + "]: ");
        }

        System.out.println("Enter memmbers of the second array (Must be 0-9 integer):");
        int[] b = new int[dim];
        for (int i = 0; i < dim; i++) {
            b[i] = readIntInRangeWithPrompt(0, 9, "b[" + i + "]: ");
        }
        // Calculations
        double manhattan = computeManhattan(a, b);
        double euclidean = computeEuclidean(a, b);
        Double cosine = computeCosineSimilarity(a, b);
        // Printing the Results
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════════╗");
        System.out.println("║     Results     ║");
        System.out.println("╚═════════════════╝");
        System.out.printf("First Array: %s%n", Arrays.toString(a));
        System.out.printf("Second Array: %s%n", Arrays.toString(b));
        System.out.printf("Manhattan Distance: %s%n", formatDoubleOrMsg(manhattan, ""));
        System.out.printf("Euclidean Distance: %s%n", formatDoubleOrMsg(euclidean, ""));
        if (cosine == null) {
            System.out.println("Cosine Similarity: Undefined (The array has a norm of 0).");
        } 
        else {
            System.out.printf("Cosine Similarity: %s%n", formatDoubleOrMsg(cosine, ""));
        }
        System.out.println(COLOR_RESET);
    }

    // Calculation Methods
    private static double computeMedian(double[] sortedArr) {
        int n = sortedArr.length;
        if (n % 2 == 1) {
            return sortedArr[n / 2];
        } 
        else {
            // even: average of two middle elements
            return (sortedArr[n / 2 - 1] + sortedArr[n / 2]) / 2.0;
        }
    }

    private static double computeArithmeticMean(double[] arr) {
        double sum = 0.0;
        for (double v : arr) sum += v;
        return sum / arr.length;
    }

    private static Double computeGeometricMean(double[] arr) {
        for (double v : arr) {
            if (v <= 0.0){
                return null;
            }
        }
        double logSum = 0.0;
        for (double v : arr) {
            logSum += Math.log(v);
        }
        return Math.exp(logSum / arr.length);
    }

    private static Double computeHarmonicMeanRecursive(double[] arr) {
        for (double v : arr) {
            if (v == 0.0){
                return null;
            }
        }
        double reciprocalSum = sumReciprocalRecursive(arr, 0);
        return arr.length / reciprocalSum;
    }
    // Recursive Methods
    private static double sumReciprocalRecursive(double[] arr, int idx) {
        if (idx >= arr.length){
            return 0.0;
        }
        return (1.0 / arr[idx]) + sumReciprocalRecursive(arr, idx + 1);
    }

    private static double computeManhattan(int[] a, int[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    private static double computeEuclidean(int[] a, int[] b) {
        double sumsq = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i] - b[i];
            sumsq += d * d;
        }
        return Math.sqrt(sumsq);
    }

    private static Double computeCosineSimilarity(int[] a, int[] b) {
        double dot = 0.0;
        double na = 0.0;
        double nb = 0.0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            na += a[i] * a[i];
            nb += b[i] * b[i];
        }
        double normA = Math.sqrt(na);
        double normB = Math.sqrt(nb);
        if (normA == 0.0 || normB == 0.0){
            return null;
        }
        return dot / (normA * normB);
    }

    // Input and output validation
    private static int readIntInRange(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < min || val > max) {
                    System.out.printf(COLOR_RED + "Input out of range. Please enter an integer between %d and %d." + COLOR_RESET, min, max);
                    continue;
                }
                return val;
            } 
            catch (NumberFormatException ex) {
                System.out.print(COLOR_RED + "Invalid input, please try again: " + COLOR_RESET);
            }
        }
    }

    private static int readIntInRangeWithPrompt(int min, int max, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                int val = Integer.parseInt(line);
                if (val < min || val > max) {
                    System.out.printf(COLOR_RED + "Invalid input. Please enter an integer between %d and %d.%n" + COLOR_RESET, min, max);
                    continue;
                }
                return val;
            } 
            catch (NumberFormatException ex) {
                System.out.println(COLOR_RED + "Invalid input please try again: " + COLOR_RESET);
            }
        }
    }

    private static int readPositiveInt() {
        while (true) {
            try {
                String line = sc.nextLine().trim();
                int v = Integer.parseInt(line);
                if (v <= 0) {
                    System.out.print("Enter a positive integer: ");
                    continue;
                }
                return v;
            } 
            catch (NumberFormatException ex) {
                System.out.print(COLOR_RED + "Invalid input, please enter a positive integer: " + COLOR_RESET);
            }
        }
    }

    private static double readDoubleWithPrompt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim().replace(',', '.'); // Replace comma with a dot
                return Double.parseDouble(line);
            } 
            catch (NumberFormatException ex) {
                System.out.println(COLOR_RED + "Invalid input, please enter the values in double data type: " + COLOR_RESET);
            }
        }
    }

    private static String formatDoubleOrMsg(double d, String unused) {
        return String.format("%.6f", d);
    }

    private static void promptEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

}