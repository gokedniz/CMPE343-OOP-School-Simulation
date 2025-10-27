import java.util.Arrays;
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
            System.out.println(COLOR_YELLOW); // Magenta
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║     Press Choose an option and start !     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);

            System.out.println("[A] Primary School");
            System.out.println("[B] Secondary School");
            System.out.println("[C] High School");
            System.out.println("[D] University");
            System.out.println("[E] Exit");
            String menuChoice = inputGame.next().trim().toLowerCase();

            switch (menuChoice) {
                case "a":
                    clearScreen();
                    System.out.println("=== A: Primary School Menu ===");
                    PrimarySchoolMenu();
                    break;


                case "b":
                    clearScreen();
                    System.out.println("=== B: Secondary School Menu ===");
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
                    System.out.println("Invalid input! Please press any key to try again.");
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
// … and so on


    public static void displayWelcomeMessage() {
        System.out.println(COLOR_RED + " _    _      _                             _           _____      _                 _    _____ _                 _       _             \n" +
                "| |  | |    | |                           | |         /  ___|    | |               | |  /  ___(_)               | |     | |            \n" +
                "| |  | | ___| | ___ ___  _ __ ___   ___   | |_ ___    \\ `--.  ___| |__   ___   ___ | |  \\ `--. _ _ __ ___  _   _| | __ _| |_ ___  _ __ \n" +
                "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\  | __/ _ \\    `--. \\/ __| '_ \\ / _ \\ / _ \\| |   `--. \\ | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\n" +
                "\\  /\\  /  __/ | (_| (_) | | | | | |  __/  | || (_) |  /\\__/ / (__| | | | (_) | (_) | |  /\\__/ / | | | | | | |_| | | (_| | || (_) | |   \n" +
                " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|   \\__\\___/   \\____/ \\___|_| |_|\\___/ \\___/|_|  \\____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n" +
                "                                                                                                                                       \n" +
                "                                                                                                                                       \n" + COLOR_RESET);
    }

    public static void universityMenu(){
        Scanner input = new Scanner(System.in);
        String choiceOfGameMode;

        System.out.println("=== D: University Menu ===");

        char[][] table = chooseTableSize(input);
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
            System.out.println("Please select your choice of table size:");
            System.out.println("A-) 5x4");
            System.out.println("B-) 6x5");
            System.out.println("C-) 7x6");
            choiceOfTableSize = input.next();
            if((!choiceOfTableSize.equalsIgnoreCase("a")) &&
                    !(choiceOfTableSize.equalsIgnoreCase("b")) &&
                    !(choiceOfTableSize.equalsIgnoreCase("c")))
                System.out.println("Invalid input. Please try again.");
        }while((!choiceOfTableSize.equalsIgnoreCase("a")) &&
                !(choiceOfTableSize.equalsIgnoreCase("b")) &&
                !(choiceOfTableSize.equalsIgnoreCase("c")));

        choiceOfTableSize = choiceOfTableSize.trim().toLowerCase();

        switch (choiceOfTableSize){
            case "a":
                table = new char[4][5];
                break;
            case "b":
                table = new char[5][6];
                break;
            case "c":
                table = new char[6][7];
                break;
        }
        return table;
    }

    public static String chooseGameMode(Scanner input){
        String choiceOfGameMode;
        do{
            System.out.println("Single Player or Multiplayer (s/m)?");
            choiceOfGameMode = input.next();
            if(!choiceOfGameMode.equalsIgnoreCase("s") &&
                    !choiceOfGameMode.equalsIgnoreCase("m"))
                System.out.println("Invalid input. Please try again.");
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
                        System.out.println("Invalid input! Please enter a number between 1 and " + table[0].length + ".");
                        System.out.println("Enter '0' if you want to quit the game.");
                        input.nextLine();
                    }
                }

                dropDisc(table, choiceOfColumn, currentPlayer);
            }
            else{
                byte computersMove;
                do {
                    computersMove = (byte) (random.nextInt(table[0].length) + 1);
                } while (!isColumnValid(table, computersMove));
                System.out.println("Computer chooses column " + computersMove + ".");
                dropDisc(table, computersMove, currentPlayer);
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
                    System.out.println("Invalid input! Please enter a number between 1 and " + table[0].length + ".");
                    System.out.println("Enter '0' if you want to quit the game.");
                    input.nextLine();
                }
            }

            dropDisc(table, choiceOfColumn, currentPlayer);

            if(determineWinner(table, currentPlayer)){
                clearScreen();
                printTable(table);
                System.out.println("Player " + currentPlayer + " has won the game.");
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
            System.out.println("Q-) Quit the University Menu.");
            System.out.println("Please enter your choice: ");
            selection = input.next().trim().toLowerCase();

            if(!selection.equals("r") && !selection.equals("m") &&  !selection.equals("q")){
                clearScreen();
                System.out.println("Invalid input. Please try again.");
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

    public static void dropDisc(char[][] table, byte colNum, char player){
        int colIndex = (int)colNum-1;
        for(int rowIndex = table.length-1; rowIndex >= 0; rowIndex--){
            if(table[rowIndex][colIndex] == '*'){
                table[rowIndex][colIndex] = player;
                return;
            }
        }
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

    ////GÜLFEM
    
    public static void PrimarySchoolMenu() {
                    boolean subMenu = true;
                    while (subMenu) {
                        //clearScreen();  //Alt menü başında ekranı temizle
                        
                        System.out.println("\nDo you want to select:");
                        System.out.println("[1] Age and Zodiac");
                        System.out.println("[2] Reverse Words");
                        System.out.println("[3] Back to Main Menu");
                        System.out.print("Enter choice: ");
                        String choice = input.nextLine().trim();

                        switch (choice) {
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
                                clearScreen(); 
                                System.out.println("Invalid choice.");
                                System.out.println("Press Enter to continue...");
                                input.nextLine();
                                break;
                        }
                    }
                        }
    ///* Option A: Zodiac and Sign kısmı

    /* Öncelikle kullanıcıdan doğum gününün tarihini ve saatini almam gerekiyor,
    ardından bu bilgilere göre yaş ve burç hesaplaması yapacağım.
    */ 
    public static void ageAndZodiacDetection() {

        System.out.println("Age and Zodiac Sign Detection");

        //Öncelikle kullanıcıdan doğum tarihini aldım.
         System.out.print("Enter your birth 'day' (1-31):");
         int birthDay = input.nextInt();
        System.out.print("Enter your birth 'month' (1-12):");
        int birthMonth = input.nextInt();
        System.out.print("Enter your birth 'year':");
        int birthYear = input.nextInt();

        //Bu kısımda girdiği doğum günü tarihlerinin geçerli olup olmadığını kontrol ettim.
        if (!isValidDate(birthDay, birthMonth, birthYear)) {
            System.out.println("Invalid birth date.");  
            return;
        }

        System.out.println("Your birthday: " + birthDay + "/" + birthMonth + "/" + birthYear);

        //Sonrasında ise mevcut tarihi aldım.
        System.out.print("Enter the current 'day' (1-31):");
        int currentDay = input.nextInt();
        System.out.print("Enter the current 'month' (1-12):");
        int currentMonth = input.nextInt();
        System.out.print("Enter the current 'year':");
        int currentYear = input.nextInt();  


        //Bu kısımda da girdiği 'currentDay, currentMonth ve currentYear' kısımlarıının geçerli olup olmadığını kontrol ettim.
        if (!isValidDate(currentDay, currentMonth, currentYear)) {
            System.out.println("Invalid current date.");   
            return;
        }

        System.out.println("Current date: " + currentDay + "/" + currentMonth + "/" + currentYear);

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
        if (age < 0) {
            System.out.println("Invalid birth and current date. Birth date is in the future.");
            return;
        }

        System.out.println("Your age is: " + age);

        // ----------- BURÇ HESAPLAMA
        String zodiac = calculateZodiac(birthDay, birthMonth);
        System.out.println("Your Zodiac Sign is: " + zodiac);
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
    if (month == 2 && day > 28) { 
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
        System.out.println("Reverse the Words");

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
            if (c == ' ' || c == ',' || c == '.' || c == '!' || c == '?' || c == ';' || c == ':' || c == '"') {

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

        System.out.println("\nReversed sentence:");
        System.out.println(result);
    }

    public static String reverseWord(String word) {
        if (word.length() <= 1) return word;
        return word.charAt(word.length() - 1) + reverseWord(word.substring(0, word.length() - 1));
    }

   

    //KEREM IRFANOGLU 
    //Checking the input is integer or not:
    public static boolean isInt(String input) {
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
    public static boolean isValidMenu(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= 1 && number <= 3;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void mainMenu(){

        System.out.println("");
        System.out.println("[1] Prime Numbers");
        System.out.println("[2] Step-by-step Evaluation of Expression");
        System.out.println("[3] Return to Main Menu\n");

        while (true) {
            System.out.print("Enter your choice (1-3): "); 
            String input = scanner.nextLine();

            //If the input is integer or not?
            if (!isInt(input)) {
                System.out.println("\nInvalid input! ");
                continue;
            }

            //If the input is between 1-3?
            if(!isValidMenu(input)){
                System.out.println("\nInvalid input! ");
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

    public static void sieveOfEratosthenes(int intNum) {
        
        System.out.println("\nSieve of Eratosthenes:");

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

        for (int i = 2; i <= intNum; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nExecution time: " + executionTime + " ms");
    }
    
    public static void sieveOfSundaram(int intNum){
        
        System.out.println("\nSieve of Sundaram:");

        int nNew = (intNum - 1)/2;
        boolean[] marked = new boolean[nNew +1];

        //start time
        long startTime = System.nanoTime();

        for (int i = 1; i <= nNew; i++){
            for (int j = i; i+j+2*i*j <= nNew; j++){
                marked[i+j+2*i*j] = true;
            }
        }

        //end time
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);

        //printing "2" separately because 2 is even and not included to the algorithm.
        if(intNum > 2){
            System.out.print("2 ");
        }
        //printing all the false values
        for (int i = 1; i <= nNew; i++){
            if(marked[i] == false){
                System.out.print(2*i+1 + " ");
            }
        }
        System.out.println("\nExecution time: " + executionTime + " ms");
    }

    public static void sieveOfAtkin(int intNum){

        System.out.println("\nSieve of Atkin:");

        boolean[] prime = new boolean[intNum + 1];
        
        int sqrt = (int) Math.sqrt(intNum);

        for(int i = 1; i <= sqrt; i++){
            for(int j=1; j<= sqrt; j++){
                
            }
        }

    }
    
    public static void primeNumbers() {

        int intNum;

        while (true) {
            System.out.print("Please enter an integer (n >= 12): ");
            String num = scanner.nextLine().trim();
    
            if (!isInt(num)) {
                System.out.println("");
                System.out.println("Invalid input! ");
                continue;
            }
    
            intNum = Integer.parseInt(num);

            if (intNum < 12) {
                System.out.println("");
                System.out.println("Invalid input! ");
                continue;
            }
            break;
        }

        sieveOfEratosthenes(intNum);
        System.out.println("");
        sieveOfSundaram(intNum);
        System.out.println("");
        sieveOfAtkin(intNum);
    }
    
    public static void evaluation() {
        System.out.println("=== MATH MENU ===");
    }

    // Taha's methods

    public static void HighSchoolMenu(){
        while (true) {
            // Menu
            System.out.println("=== C: High School Menu ===");
            System.out.println("1) Statistical Information about an Array");
            System.out.println("2) Distance between Two Arrays");
            System.out.println("3) Return to Main Menu");
            System.out.print("Please choose your operation (1-3): ");

            int choice = readIntInRange(1, 3);
            switch (choice) {
                case 1:
                    statisticalInformation();
                    promptEnterToContinue();
                    break;
                case 2:
                    distanceBetweenTwoArrays();
                    promptEnterToContinue();
                    break;
                case 3:
                    System.out.println("Returnin to previous menu...");
                    return;
                default:
                    // unreachable due to readIntInRange
                    break;
            }
        }        
    }

    // Menu selection 1
     private static void statisticalInformation() {
        System.out.println("--- Statistical Information about an Array ---");
        int n;
        while (true) {
            System.out.print("Enter the length of your array: ");
            n = readPositiveInt();
            if (n <= 0) {
                System.out.println("Length must be positive integer. Please try again: ");
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
        System.out.println("\n--- Results ---");
        System.out.printf("Sorted array: %s%n", Arrays.toString(arr));
        System.out.printf("Median: %s%n", formatDoubleOrMsg(median, ""));
        System.out.printf("Arithmetic Mean: %s%n", formatDoubleOrMsg(arithmeticMean, ""));
        if (geometricMean == null) {
            System.out.println("Geometric Mean: Undefined (One of the members in this array is <= 0)");
        } else {
            System.out.printf("Geometric Mean: %s%n", formatDoubleOrMsg(geometricMean, ""));
        }
        if (harmonicMean == null) {
            System.out.println("Harmonic Mean: Undefined (One of the members in this array is <= 0)");
        } else {
            System.out.printf("Harmonic Mean: %s%n", formatDoubleOrMsg(harmonicMean, ""));
        }
    }

    // Menu selection 2
    private static void distanceBetweenTwoArrays() {
        System.out.println("--- Distance between Two Arrays ---");
        int dim;
        while (true) {
            System.out.print("Enter the length of your array: ");
            dim = readPositiveInt();
            if (dim <= 0) {
                System.out.println("Legnth must be positive integer. Please try again.");
            } else {
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
        System.out.println("\n--- Results ---");
        System.out.printf("First Array: %s%n", Arrays.toString(a));
        System.out.printf("Second Array: %s%n", Arrays.toString(b));
        System.out.printf("Manhattan Distance: %s%n", formatDoubleOrMsg(manhattan, ""));
        System.out.printf("Euclidean Distance: %s%n", formatDoubleOrMsg(euclidean, ""));
        if (cosine == null) {
            System.out.println("Cosine Similarity: Undefined (The array has a norm of 0).");
        } else {
            System.out.printf("Cosine Similarity: %s%n", formatDoubleOrMsg(cosine, ""));
        }
    }

    /* -------------------- Calculation Methods -------------------- */
    private static double computeMedian(double[] sortedArr) {
        int n = sortedArr.length;
        if (n % 2 == 1) {
            return sortedArr[n / 2];
        } else {
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
            if (v <= 0.0) return null;
        }
        double logSum = 0.0;
        for (double v : arr) {
            logSum += Math.log(v);
        }
        return Math.exp(logSum / arr.length);
    }

    private static Double computeHarmonicMeanRecursive(double[] arr) {
        for (double v : arr) {
            if (v == 0.0) return null;
        }
        double reciprocalSum = sumReciprocalRecursive(arr, 0);
        return arr.length / reciprocalSum;
    }
    // Recursive Methods
    private static double sumReciprocalRecursive(double[] arr, int idx) {
        if (idx >= arr.length) return 0.0;
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
        if (normA == 0.0 || normB == 0.0) return null;
        return dot / (normA * normB);
    }

    // Input and output validation

    private static int readIntInRange(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < min || val > max) {
                    System.out.printf("Please enter an integer between %d and %d.", min, max);
                    continue;
                }
                return val;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input, please try again: ");
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
                    System.out.printf("Invalid input. Please enter an integer between %d and %d.%n", min, max);
                    continue;
                }
                return val;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again: ");
            }
        }
    }

    private static int readPositiveInt() {
        while (true) {
            try {
                String line = sc.nextLine().trim();
                int v = Integer.parseInt(line);
                if (v <= 0) {
                    System.out.print("Enter an positive integer: ");
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input, please try again: ");
            }
        }
    }

    private static double readDoubleWithPrompt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim().replace(',', '.'); // Replace comma with a dot
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again: ");
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