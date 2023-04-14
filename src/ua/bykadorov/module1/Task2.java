package ua.bykadorov.module1;

public class Task2 {
    public static void main(String[] args) {

        System.out.println(horse(1, 1, 3, 2));

    }

    public static boolean horse(int x_start, int y_start, int x_check, int y_check) {
        boolean possible = false;

        if (x_start < 0 || x_start > 7 || y_start < 0 || y_start > 7 ||
                x_check < 0 || x_check > 7 || y_check < 0 || y_check > 7) {
            System.out.println("Your coordinate is incorrect!");
            possible = false;
        }

        if (x_start >= 0 && x_start <= 8 && y_start >= 0 && y_start <= 8) {
            if (x_check == (x_start + 2) && y_check == (y_start + 1) ||
                    x_check == (x_start + 1) && y_check == (y_start + 2)) {
                possible = true;
            }
            if (x_check == (x_start - 2) && y_check == (y_start - 1) ||
                    x_check == (x_start - 1) && y_check == (y_start - 2))
                possible = true;
            if (x_check == (x_start - 2) && y_check == (y_start + 1) ||
                    x_check == (x_start - 1) && y_check == (y_start + 2))
                possible = true;
        }
        return possible;
    }
}

