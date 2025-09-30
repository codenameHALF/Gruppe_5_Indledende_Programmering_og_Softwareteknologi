import java.util.*;


public class Opgave4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grid size: ");
        int n = input.nextInt();
        input.close();

        int x = 0;

        int y = 0;

        for (int i = 0; i <= n; i++){

            while (x <= n || y <= n){
                x += 1;
                y += 1;

                System.out.println("Position = ("+ x + "," + y +")" );
            }

            System.out.println("Number of steps: " + i);
        }


    }
}



    





/* StdDraw.setXscale(-1, 1);
    StdDraw.setYscale(-1, 1);
    StdDraw.setPenRadius(2.0/1000);
    int n = 100;

    for (int i = 0; i < n*2*Math.PI; i++) {
        StdDraw.point(Math.cos(i/(double) n), Math.sin(i/(double) n));
    } */