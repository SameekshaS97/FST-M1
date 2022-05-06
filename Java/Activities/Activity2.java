package activities;

import javax.swing.*;

public class Activity2 {
        public static void main(String[] agrs) {
            int[] a = {10, 77, 10, 54, -11, 10};
            int b = 10;
            int sum = 30;
            System.out.println("Result is "+result(a,b,sum));
        }
            public static boolean result(int[] a,int b, int sum) {
            int temp = 0;
                int eLength = a.length;
                for (int x = 0; x<=eLength-1; x++) {
                    if (a[x] == b) {
                        temp += b;
                    }
                }
                return temp == sum;
                }
            }




