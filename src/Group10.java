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
        universityMenu();
    }

    public static void universityMenu(){
        Scanner input = new Scanner(System.in);
        String choiceOfGameMode;

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

        input.close();
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
                            System.out.println("Player " + currentPlayer + ", has quit the game.");
                            return;
                        }
                        if (!isColumnValid(table, choiceOfColumn)) {
                            System.out.println("Invalid move. Please try again.");
                        } else {
                            validInput = true;
                        }
                    } catch (Exception a) {
                        System.out.println("Invalid input! Please enter a number between 1 and " + table[0].length + ".");
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
                        System.out.println("Player " + currentPlayer + ", has quit the game.");
                        return;
                    }
                    if (!isColumnValid(table, choiceOfColumn)) {
                        System.out.println("Invalid move. Please try again.");
                    } else {
                        validInput = true;
                    }
                } catch (Exception a) {
                    System.out.println("Invalid input! Please enter a number between 1 and " + table[0].length + ".");
                    input.nextLine();
                }
            }

            dropDisc(table, choiceOfColumn, currentPlayer);

            if(determineWinner(table, currentPlayer)){
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
 //* Option A: Zodiac and Sign kısmı

    /* Öncelikle kullanıcıdan doğum gününün tarihini ve saatini almam gerekiyor,
    ardından bu bilgilere göre yaş ve burç hesaplaması yapacağım.
    */

    public static void ageAndZodiacDetection(){
        Scanner input = new Scanner(System.in);

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

        //Girilen ayın kontrolü
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

        /*Artık yıl kontrolünü burada yapmam gerekiyor
        ama 29 şubatta doğan kişiler genelde 28 şubat veya 1 mart
        tarihleri arasında yazdırıldığı için eklemiyorum ama sonrasında ekleyeceğim.
        */

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
        else    zodiac = "Invalid";

        return zodiac;


    }

}



