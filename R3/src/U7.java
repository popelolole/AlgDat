import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class U7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose grey square coordinates (row,col): ");
        String input = scan.nextLine();
        String[] sarr = input.split(",");
        int row = Integer.parseInt(sarr[0]);
        int col = Integer.parseInt(sarr[1]);

        System.out.println(puzzle(row, col));
        System.out.println("hej");
    }

    public static int puzzle(int row, int col){
        Queue<Tillstand> q = new LinkedList<>();
        char[][] grid = {{' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' '}};
        grid[row - 1][col - 1] = '*';

        Tillstand t = new Tillstand(grid, 0, 0, 1);
        q.offer(t);

        //System.out.println(Arrays.deepToString(grid));

        int count = 0;
        while(!q.isEmpty()){

            t = q.poll();

            while(t.col > 4){
                if(t.row != 3) {
                    t.row++;
                    t.col = 0;
                    for(int i = 0;i < 5;i++){
                        if(t.grid[t.row - 1][i] == ' '){
                            if(!q.isEmpty()) {
                                t = q.poll();
                                break;
                            }
                            else
                                return count;
                        }
                    }
                }
                else{
                    if(t.isSolved()) {
                        count++;
                        print(t.grid);
                    }
                    if(!q.isEmpty())
                        t = q.poll();
                    else
                        return count;
                }
            }
            if (t.grid[t.row][t.col] == ' ' && t.grid[t.row + 1][t.col] == ' ') {
                char[][] copyGrid;
                if (t.col > 0) {
                    if (t.grid[t.row + 1][t.col - 1] == ' ') {
                        copyGrid = copy(t.grid);
                        copyGrid[t.row][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col - 1] = Integer.toString(t.pieceNr).charAt(0);
                        q.offer(new Tillstand(copyGrid, t.row, t.col + 1, t.pieceNr + 1));
                    }
                    if (t.grid[t.row][t.col - 1] == ' ') {
                        copyGrid = copy(t.grid);
                        copyGrid[t.row][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row][t.col - 1] = Integer.toString(t.pieceNr).charAt(0);
                        q.offer(new Tillstand(copyGrid, t.row, t.col + 1, t.pieceNr + 1));
                    }
                }
                if (t.col < 4) {
                    if (t.grid[t.row + 1][t.col + 1] == ' ') {
                        copyGrid = copy(t.grid);
                        copyGrid[t.row][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col + 1] = Integer.toString(t.pieceNr).charAt(0);
                        q.offer(new Tillstand(copyGrid, t.row, t.col + 1, t.pieceNr + 1));
                    }
                    if (t.grid[t.row][t.col + 1] == ' ') {
                        copyGrid = copy(t.grid);
                        copyGrid[t.row][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row + 1][t.col] = Integer.toString(t.pieceNr).charAt(0);
                        copyGrid[t.row][t.col + 1] = Integer.toString(t.pieceNr).charAt(0);
                        q.offer(new Tillstand(copyGrid, t.row, t.col + 1, t.pieceNr + 1));
                    }
                }
            }
            q.offer(new Tillstand(copy(t.grid), t.row, t.col + 1, t.pieceNr));
            System.out.println(Arrays.deepToString(t.grid));
        }

        return count;
    }

    private static void print(char[][] a){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                sb.append(a[i][j]);
                if(j != 4)
                    sb.append(", ");
            }
            sb.append("]\n");
            if(i != 4)
                sb.append("[");
        }
        System.out.println(sb);
    }

    private static char[][] copy(char[][] a){
        char[][] copy = new char[5][5];
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                copy[i][j] = a[i][j];
            }
        }
        return copy;
    }

    private static class Tillstand{
        char[][] grid;
        int row;
        int col;
        int pieceNr;

        public Tillstand(char[][] grid, int row, int col, int pieceNr){
            this.grid = grid;
            this.row = row;
            this.col = col;
            this.pieceNr = pieceNr;
        }

        private boolean isSolved(){
            for(int i = 0;i < 5;i++){
                for(int j = 0;j < 5;j++){
                    if(grid[i][j] == ' ')
                        return false;
                }
            }
            return true;
        }
    }
}
