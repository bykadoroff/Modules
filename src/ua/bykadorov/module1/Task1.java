package ua.bykadorov.module1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        int[] array = fillAndCreateArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println("Unique numbers: " + uniqueElements(array));
    }

    public static int uniqueElements(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean unique = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                count++;
            }
        }
        return count;
    }

    public static int[] fillAndCreateArray(int size) {
        int mass[] = new int[size];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = ThreadLocalRandom.current().nextInt(0, 11);

        }
        return mass;
    }

}


