package br.pucrs;

import java.util.Arrays;

public class App 
{
    static int counter = 0;
    static int convFactor = 1000000;

    public static void main( String[] args )
    { 
        mergeSortTest1();

        maxVal1Test1();

        maxVal2Test1();
    }

    static void mergeSortTest1() {
        Integer[] v = new Integer[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

        System.out.print("\nArray before mergeSort: ");

        for (Integer el : v) {
            System.out.print(el);
            System.out.print(" ");
        }

        System.out.print("\nArray after mergeSort: ");

        counter = 0;

        long startTime = System.nanoTime();

        v = mergeSort(v); 
        
        long stopTime = System.nanoTime(); 

        for (Integer el : v) {
            System.out.print(el);
            System.out.print(" ");
        }

        System.out.print("\nTotal repetitions: ");
        System.out.print(counter);      

        System.out.print("\nTotal time: ");
        float time = (float)(stopTime - startTime) / convFactor;
        System.out.print(time);
        System.out.println(" ms\n");

        counter = 0; 
    }

    static void maxVal1Test1() {
        long[] v = new long[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

        System.out.print("\nArray: ");

        for (long el : v) {
            System.out.print(el);
            System.out.print(" ");
        }

        System.out.print("\nHighest value in array: ");

        counter = 0;

        long startTime = System.nanoTime();

        System.out.print(maxVal1(v, v.length));
        
        long stopTime = System.nanoTime(); 

        System.out.print("\nTotal repetitions: ");
        System.out.print(counter);      

        System.out.print("\nTotal time: ");
        float time = (float)(stopTime - startTime) / convFactor;
        System.out.print(time);
        System.out.println(" ms\n");

        counter = 0; 
    }

    static void maxVal2Test1() {
        long[] v = new long[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

        System.out.print("\nArray: ");

        for (long el : v) {
            System.out.print(el);
            System.out.print(" ");
        }

        System.out.print("\nHighest value in array: ");

        counter = 0;

        long startTime = System.nanoTime();

        System.out.print(maxVal2(v, 0, v.length - 1));
        
        long stopTime = System.nanoTime(); 

        System.out.print("\nTotal repetitions: ");
        System.out.print(counter);      

        System.out.print("\nTotal time: ");
        float time = (float)(stopTime - startTime) / convFactor;
        System.out.print(time);
        System.out.println(" ms\n");

        counter = 0; 
    }

    static Integer[] mergeSort(Integer[] list) {
        counter++;

        if (list.length <= 1) return list;

        Integer[] left = mergeSort(Arrays.copyOfRange(list, 0, list.length / 2));
        Integer[] right = mergeSort(Arrays.copyOfRange(list, list.length / 2, list.length));

        return merge(left, right);
    }

    static Integer[] merge(Integer[] left, Integer[] right) {
        counter++;

        Integer[] result = new Integer[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            counter++;
            if (right[j] < left[i]) {
                result[k] = right[j];
                j++;
            } else {
                result[k] = left[i];
                i++;
            }
            k++;
        }

        while (i < left.length) {
            counter++;
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            counter++;
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

    static long maxVal1(long A[], int n) {  
        counter++;
        long max = A[0];
        
        for (int i = 1; i < n; i++) { 
            counter++; 
            if( A[i] > max ) 
               max = A[i];
        }

        return max;
    }

    static long maxVal2(long[] A, int init, int end) {
        counter++;

        if (end - init <= 1)
            return Math.max(A[init], A[end]);  

        int m = (init + end)/2;

        return Math.max(maxVal2(A, init, m), maxVal2(A, m + 1, end));
    }
}
