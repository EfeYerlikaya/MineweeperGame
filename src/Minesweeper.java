import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    int rowNumber ;
        int collNumber ;

        int size;

        int [][] map;
        int [][] board;
        boolean game = true;
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        public Minesweeper(int rowNumber , int collNumber) {

            this.rowNumber = rowNumber;
            this.collNumber = collNumber;
            this.map = new int[rowNumber][collNumber];
            this.board = new int[rowNumber][collNumber];
            this.size = rowNumber * collNumber;

        }

        public void run(){
            int row, col, success = 0;
            preapareGame();
            print(map);
            System.out.println("The game has begun.");
            while (game) {

                print(board);
                System.out.print("Row :"  );
                row = sc .nextInt();
                System.out.print("Col :");
                col = sc.nextInt();
                if (row <= 0 || row >= rowNumber  ){

                    System.out.println("İnvalid cordinate .");
                    continue;
                }
                if (col <= 0 || col >= collNumber  ){

                    System.out.println("İnvalid cordinate .");
                    continue;
                }

                if (map[row][col] != -1) {

                    checkMine(row, col);
                    success++;
                    if (success == (size - (size/4))){
                        System.out.println("You did it.You can not touch any mine.");
                        break;
                    }
                } else {

                    game = false;
                    System.out.println("Game over !");
                }

            }

        }

        public void checkMine (int r , int c) {

            if (board[r][c] == 0) {

                if ( (c < collNumber -1 ) && map[r][c + 1] == -1) {
                    board[r][c]++;
                }
                if ((r < rowNumber - 3) && map[r + 1][c] == -1) {
                    board[r][c]++;
                }
                if ((r > 0 ) && map[r - 1][c] == -1) {
                    board[r][c]++;
                }
                if ((c > 0) && map[r][c - 1] == -1) {
                    board[r][c]++;

                }

                if (board[r ][c] == 0){

                    board[r][c] = -2;
                }
            }
        }

        public  void  preapareGame(){
            int randRow , randCol,count = 0;
           while (count != (size / 4)) {

                randRow = random.nextInt(rowNumber);
                randCol = random.nextInt(collNumber);

                if (map[randRow ][randCol] != -1){
                    map[randRow][randCol] = -1;
                    count++;
                }
            }

        }

        public void print(int [][] arr){
            for(int i = 0 ; i < arr.length ; i++){

                for (int j = 0 ; j < arr[0].length ; j++){
                    if (arr[i][j] <= 0){

                        System.out.print(" ");
                        System.out.print(arr[i][j]+ " ");
                    }


                }
                System.out.println();
            }

        }

    }
