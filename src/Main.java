import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
int row , column;
        System.out.println("Welcome to Minesweeper.");
        System.out.println("Please enter the size do you want to play");
        System.out.println("Row number :");
        row = sc.nextInt();
        System.out.println(" Column number :");
        System.out.println();
        column = sc.nextInt();

        Minesweeper minesweeper = new Minesweeper(row,column);
        minesweeper.run();





    }
}