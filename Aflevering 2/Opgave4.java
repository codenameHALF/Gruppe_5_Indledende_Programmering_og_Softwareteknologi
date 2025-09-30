import java.util.*;


public class Opgave4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String prompt = "Enter grid size: ";
        int n = getInt(input, prompt);
     
        if (n < 0){
            throw new IllegalArgumentException("Negative integer, Can't compute");
        }

        int x = 0;
        int y = 0;
        int steps = 0;

        StdDraw.setXscale(-n-0.5, n+0.5);
        StdDraw.setYscale(-n-0.5, n+0.5);
        StdDraw.setPenRadius(1.0/(n*2+1));

        //System.out.println("Position = ("+ x + "," + y +")" );

        while (Math.abs(x) <= n && Math.abs(y) <= n){

            StdDraw.point(x, y);

            int move = rand.nextInt(4);

            if(move == 0){
                x++;
            } else if(move == 1){
                x--;
            } else if(move == 2){
                y++;
            } else if(move == 3) {
                y--;
            }

            steps++;

            //System.out.println("Position = ("+ x + "," + y +")" );
        }
        
        System.out.println("Number of steps: " + steps);
    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }

        return input.nextInt();
    }
    
}



    





