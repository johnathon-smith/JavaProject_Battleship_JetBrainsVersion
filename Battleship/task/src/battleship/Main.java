package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create two-dimensional array to represent field of play
        //Create a field for both player 1 and 2. Each player will also need a fogOfWar field
        String[][] playerOneField = new String[][]{
                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
        };

        //Create another array for the fog of war effect
        String[][] playerOneFogOfWar = new String[][]{
                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
        };

        String[][] playerTwoField = new String[][]{
                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
        };

        //Create another array for the fog of war effect
        String[][] playerTwoFogOfWar = new String[][]{
                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
        };

        // Create variables to store the number of ships, the names of the ships, and their sizes
        String[] shipNames = new String[] {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
        int[] shipSizes = new int[] {5, 4, 3, 3, 2};
        int numShips = 5;

        //Now loop through the previous arrays and create the Ship objects. Store them in a Ship array
        Ship[] playerOneShips = new Ship[numShips];
        Ship[] playerTwoShips = new Ship[numShips];

        //Create scanner to receive user input
        Scanner scanner = new Scanner(System.in);

        //Allow player 1 to place their ships
        System.out.println("Player 1, place your ships on the game field\n");
        printPlayField(playerOneField);

        for (int i = 0; i < numShips; i++) {
            playerOneShips[i] = new Ship(shipNames[i], shipSizes[i]);

            //Now use a while loop to get user input and position the current ship
            boolean shipPlaced = false;
            while (!shipPlaced) {
                System.out.printf("\nEnter the coordinates of the %s (%d cells):\n\n", shipNames[i], shipSizes[i]);
                //Don't forget to add the carrot to indicate user input
                System.out.print("> ");
                String firstCoordinate = scanner.next();
                String secondCoordinate = scanner.next();

                //Validate user input.
                if (isUserInputValid(firstCoordinate) && isUserInputValid(secondCoordinate)) {
                    //If user input was valid, place coordinates in order from smallest to largest.
                    //Order by row
                    if (firstCoordinate.charAt(0) > secondCoordinate.charAt(0)) {
                        String tempCoordinate = firstCoordinate;
                        firstCoordinate = secondCoordinate;
                        secondCoordinate = tempCoordinate;
                    }
                    //Order by column
                    if (convertStringToInt(firstCoordinate.substring(1)) > convertStringToInt(secondCoordinate.substring(1))) {
                        String tempCoordinate = firstCoordinate;
                        firstCoordinate = secondCoordinate;
                        secondCoordinate = tempCoordinate;
                    }

                    //Validate ship's position. Update ship's coordinates and playField if all is okay
                    if (playerOneShips[i].isPositionValid(firstCoordinate, secondCoordinate, playerOneField)) {
                        //update ship's coordinates
                        playerOneShips[i].setCoordinates(firstCoordinate, secondCoordinate);
                        //update playField
                        addShip(firstCoordinate, secondCoordinate, playerOneField);
                        //print updated playField
                        System.out.println();
                        printPlayField(playerOneField);
                        shipPlaced = true;
                    }
                }

            }
        }

        //Pass the turn to player 2
        System.out.println("\nPress Enter and pass the move to another player");
        System.out.println("...");
        pressEnterToContinue(scanner);

        //Allow player 2 to place their ships
        System.out.println("Player 2, place your ships on the game field\n");
        printPlayField(playerTwoField);

        for (int i = 0; i < numShips; i++) {
            playerTwoShips[i] = new Ship(shipNames[i], shipSizes[i]);

            //Now use a while loop to get user input and position the current ship
            boolean shipPlaced = false;
            while (!shipPlaced) {
                System.out.printf("\nEnter the coordinates of the %s (%d cells):\n\n", shipNames[i], shipSizes[i]);
                //Don't forget to add the carrot to indicate user input
                System.out.print("> ");
                String firstCoordinate = scanner.next();
                String secondCoordinate = scanner.next();

                //Validate user input.
                if (isUserInputValid(firstCoordinate) && isUserInputValid(secondCoordinate)) {
                    //If user input was valid, place coordinates in order from smallest to largest.
                    //Order by row
                    if (firstCoordinate.charAt(0) > secondCoordinate.charAt(0)) {
                        String tempCoordinate = firstCoordinate;
                        firstCoordinate = secondCoordinate;
                        secondCoordinate = tempCoordinate;
                    }
                    //Order by column
                    if (convertStringToInt(firstCoordinate.substring(1)) > convertStringToInt(secondCoordinate.substring(1))) {
                        String tempCoordinate = firstCoordinate;
                        firstCoordinate = secondCoordinate;
                        secondCoordinate = tempCoordinate;
                    }

                    //Validate ship's position. Update ship's coordinates and playField if all is okay
                    if (playerTwoShips[i].isPositionValid(firstCoordinate, secondCoordinate, playerTwoField)) {
                        //update ship's coordinates
                        playerTwoShips[i].setCoordinates(firstCoordinate, secondCoordinate);
                        //update playField
                        addShip(firstCoordinate, secondCoordinate, playerTwoField);
                        //print updated playField
                        System.out.println();
                        printPlayField(playerTwoField);
                        shipPlaced = true;
                    }
                }

            }
        }

        //Pass the turn to player 1 to start the game
        System.out.println("\nPress Enter and pass the move to another player");
        System.out.println("...");
        pressEnterToContinue(scanner);

        //Allow the player to enter coordinates to begin attacking ships
        boolean allShipsSunk = false;

        while (!allShipsSunk) {
            //Print player 1 game board and leave player 1 message
            printPlayField(playerOneFogOfWar);
            System.out.println("---------------------");
            printPlayField(playerOneField);
            //print the player start message
            System.out.println("\nPlayer 1, it's your turn:\n");

            //Let player 1 take their turn
            allShipsSunk = takePlayerTurn(scanner, playerOneFogOfWar, playerTwoField, playerTwoShips);

            //If player 1 did not sink all player 2 ships, print player 2 game board and message, and let player 2 take their turn
            if (!allShipsSunk) {
                //print the game board
                printPlayField(playerTwoFogOfWar);
                System.out.println("---------------------");
                printPlayField(playerTwoField);
                //print the player start message
                System.out.println("\nPlayer 2, it's your turn:\n");
                allShipsSunk = takePlayerTurn(scanner, playerTwoFogOfWar, playerOneField, playerOneShips);
            }
        }

    }

    private static void pressEnterToContinue(Scanner scanner)
    {
        try
        {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception e)
        {}
    }

    public static boolean takePlayerTurn(Scanner scanner, String[][] playerFogOfWar, String[][] enemyField, Ship[] enemyShips) {
        //Create a flag for when a ship gets hit
        boolean shipWasHit = false;

        String targetCoordinate;
        do {
            //Get user input. Don't forget the carrot symbol
            System.out.print("> ");
            targetCoordinate = scanner.next();

        } while (!isUserInputValid(targetCoordinate));


        char row = targetCoordinate.charAt(0);
        int column = Main.convertStringToInt(targetCoordinate.substring(1));
        int rowIndex = row - 'A' + 1;

        //check if the targeted spot has already been hit
        if (playerFogOfWar[rowIndex][column].equals("X")) {
            System.out.println("\nYou hit a ship!");
            System.out.println("Press Enter and pass the move to another player");
            System.out.println("...\n");
            pressEnterToContinue(scanner);
            //Since this spot has already been hit, and the game is still going, we know that at least one ship still survives. Return false
            return false;
        } else if (playerFogOfWar[rowIndex][column].equals("M")) {
            System.out.println("\nYou missed!");
            System.out.println("Press Enter and pass the move to another player");
            System.out.println("...\n");
            pressEnterToContinue(scanner);
            return false;
        }

        //loop through each ship and check the targetCoordinate against the ship coordinates
        for (int i = 0; i < enemyShips.length; i++) {
            for (int j = 0; j < enemyShips[i].getSize(); j++) {
                if (enemyShips[i].getCoordinates()[j][0] == rowIndex && enemyShips[i].getCoordinates()[j][1] == column) {

                    //damage ship's health
                    enemyShips[i].damageShip();

                    //update playerFogOfWar and enemyField
                    playerFogOfWar[rowIndex][column] = "X";
                    enemyField[rowIndex][column] = "X";

                    //check if sunk. if so, give message and break from this loop
                    if (enemyShips[i].isSunk()) {
                        //check if all ships have been sunk. If so, leave a game over message and update allShipsSunk
                        if (checkIfAllShipsAreSunk(enemyShips)) {
                            System.out.println("\nYou sank the last ship. You won. Congratulations!\n");
                            //Since all ships are sunk, return true
                            return true;
                        } else {
                            //this ship was sunk, but others are still alive. Leave the standard message
                            System.out.println("\nYou sank a ship!");
                            System.out.println("Press Enter and pass the move to another player");
                            System.out.println("...");
                            pressEnterToContinue(scanner);
                            return false;
                        }
                    }
                    //Ship was hit, but not sunk
                    System.out.println("\nYou hit a ship!");
                    System.out.println("Press Enter and pass the move to another player");
                    System.out.println("...");
                    pressEnterToContinue(scanner);
                    return false;
                }
            }
        }

        //Ship was not hit. Update playerFogOfWar and enemyField
        playerFogOfWar[rowIndex][column] = "M";
        enemyField[rowIndex][column] = "M";
        System.out.println("\nYou missed!");
        System.out.println("Press Enter and pass the move to another player");
        System.out.println("...\n");
        pressEnterToContinue(scanner);
        return false;
    }

    public static void printPlayField(String[][] playField) {
        //print the field of play
        for (int i = 0; i < playField[0].length; i++) {
            for (int j = 0; j < playField[i].length; j++) {
                System.out.print(playField[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean checkIfAllShipsAreSunk(Ship[] playerShips) {
        for (int i = 0; i < playerShips.length; i++) {
            if (!playerShips[i].isSunk()) {
                return false;
            }
        }

        //all ships are sunk
        return true;
    }

    public static boolean isUserInputValid(String coordinate){
        try {
            char Row = coordinate.charAt(0);
            int Column = convertStringToInt(coordinate.substring(1));

            if (coordinate.length() == 1 || coordinate.length() > 3) {
                System.out.println("Error! Invalid input. Please try again.");
                return false;
            } else if (Character.isDigit(coordinate.charAt(0))) {
                System.out.println("Error! Invalid input. Please try again.");
                return false;
            } else if (Character.isLetter(coordinate.charAt(1))) {
                System.out.println("Error! Invalid input. Please try again.");
                return false;
            } else if (coordinate.length() == 3 && Character.isLetter(coordinate.charAt(2))) {
                System.out.println("Error! Invalid input. Please try again.");
                return false;
            } else if (Row < 'A' || Row > 'J') {
                System.out.println("Error! Coordinate row is not valid. Please try again.");
                return false;
            } else if (Column < 1 || Column > 10) {
                System.out.println("Error! Coordinate column is not valid. Please try again.");
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Error! Invalid input. Please try again.");
            return false;
        }
    }

    public static int convertStringToInt(String str) {
        int val = 0;
        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return val;
        }
        return val;
    }

    public static void addShip(String firstCoordinate, String secondCoordinate, String[][] playField) {
        //Split the coordinates up into useful parts
        char firstRow = firstCoordinate.charAt(0);
        int firstColumn = convertStringToInt(firstCoordinate.substring(1));
        char secondRow = secondCoordinate.charAt(0);
        int secondColumn = convertStringToInt(secondCoordinate.substring(1));

        //Check if the coordinates are in the same row
        if (firstRow == secondRow && firstColumn != secondColumn) {
            //Update the playField with the column numbers given
            for (int i = 0; i < playField[0].length; i++) {
                if (playField[i][0].charAt(0) == firstRow) {
                    for (int j = firstColumn; j <= secondColumn; j++) {
                        playField[i][j] = "O";
                    }
                    break;
                }
            }
        } else if (firstRow != secondRow && firstColumn == secondColumn) {
            for (char letter = firstRow; letter <= secondRow; letter++) {
                for (int i = 0; i < playField[0].length; i++) {
                    if (playField[i][0].charAt(0) == letter) {
                        playField[i][firstColumn] = "O";
                        break;
                    }
                }
            }
        }
    }
}
