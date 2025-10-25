import java.util.Arrays;
import java.util.Scanner;

/*
Methods that needed to be written
1. if the chosen column is valid. OK
2. drop disc OK
3. is board full OK
3. determine the winner. OK
4. single player game. OK
5. multiplayer game.
 */
// deneme
public class Group10 {
    public static void main(String[] args) {
        Scanner inputSize = new Scanner(System.in);
        Scanner inputGameMode = new Scanner(System.in);
        Scanner inputMove = new Scanner(System.in);
        String choiceOfTableSize;
        String choiceOfGameMode;
        char[][] table = new char[0][0];
        do{
            System.out.println("Please select your choice of table size:");
            System.out.println("A-) 5x4");
            System.out.println("B-) 6x5");
            System.out.println("C-) 7x6");
            choiceOfTableSize = inputSize.next();
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

        do{
            System.out.println("Single Player or Multiplayer (s/y)?");
            choiceOfGameMode = inputGameMode.next();
            if(!choiceOfGameMode.equalsIgnoreCase("s") &&
                !choiceOfGameMode.equalsIgnoreCase("y"))
                System.out.println("Invalid input. Please try again.");
        }while(!choiceOfGameMode.equalsIgnoreCase("s") &&
               !choiceOfGameMode.equalsIgnoreCase("y"));

        choiceOfGameMode = choiceOfGameMode.trim().toLowerCase();

        /* NOW WE ARE JUST PLAYING THIS WITH THE MULTIPLAYER
        switch (choiceOfGameMode){
            case "s":
                // start the single player mode
                break;
            case "m":
                // start the multiplayer mode
                break;
        }
         */
        fillTableWithAsterisk(table);

        char currentPlayer = '1';
        boolean gameContinues = true;

        while(gameContinues){
            printTable(table);
            System.out.println("Player number " + currentPlayer + "please make your move.");
            System.out.println("Please enter a valid column number between 1 - " + table[0].length + ": ");

            byte choiceOfColumn = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    choiceOfColumn = inputMove.nextByte();
                    if (!isColumnValid(table, choiceOfColumn)) {
                        System.out.println("Invalid move. Please try again.");
                    } else {
                        validInput = true;
                    }
                } catch (Exception a) {
                    System.out.println("Invalid input! Please enter a number between 1 and " + table[0].length + ".");
                    inputMove.nextLine();
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
        System.out.println("You can not drop the disc there.");
        System.out.println("Try again.");
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

    public static void printTable(char[][] table){
        for (char[] chars : table) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.print("\n");
        }
    }
}
