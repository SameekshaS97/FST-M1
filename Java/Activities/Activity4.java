package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] a = {5, 2, 7, 3, 1, 6, 9, 4, 8};
        System.out.println("Array before sorting is:" + Arrays.toString(a));
        System.out.println("Array after sorting is:");
        ascendingorder(a);
    }
        public static void ascendingorder(int b[]){
            for (int i = 1; i < b.length; i++) {
                int temp = b[i];
                int j = i;
                while (j > 0 && b[j - 1] > temp) {
                    b[j] = b[j - 1];
                    --j;
                }
                b[j] = temp;

            }
            System.out.println(Arrays.toString(b));

        }


    }




