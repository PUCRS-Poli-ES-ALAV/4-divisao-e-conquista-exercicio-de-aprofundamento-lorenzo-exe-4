package br.pucrs;

import java.util.Arrays;
import java.util.Random;

public class App 
{
    static int counter = 0;
    static int convFactor = 1000000;

    public static void main( String[] args )
    { 
        float t1 = mergeSortTest1(generateIntArray(10, 10));
        float t2 = mergeSortTest1(generateIntArray(100, 100));
        float t3 = mergeSortTest1(generateIntArray(1000, 1000));
        
        float t4 = maxVal1Test1(generateLongArray(1000, 10000));
        float t5 = maxVal1Test1(generateLongArray(100000, 100000));
        float t6 = maxVal1Test1(generateLongArray(10000000, 1000000));

        float t7 = maxVal2Test1(generateLongArray(1000, 10000));
        float t8 = maxVal2Test1(generateLongArray(100000, 100000));
        float t9 = maxVal2Test1(generateLongArray(10000000, 1000000));

        float t10 = multiplyTest1(10, 8, 4);
        float t11 = multiplyTest1(28120, 31243, 16);
        float t12 = multiplyTest1(1909551616, 1709551616, 64);
        
        System.out.println("\t\t\ttam1\t\ttam2\t\ttam3");
        System.out.printf("mergeSort\t%f\t%f\t%f\n", t1, t2, t3);
        System.out.printf("maxVal1\t\t%f\t%f\t%f\n", t4, t5, t6);
        System.out.printf("maxVal2\t\t%f\t%f\t%f\n", t7, t8, t9);
        System.out.printf("multiply\t%f\t%f\t%f\n\n", t10, t11, t12);
    }
    
    static Integer[] generateIntArray(int n, int maxN) {
        Integer[] list = new Integer[n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list[i] = random.nextInt(1000);
        }
        
       return list;
    }
    
    static long[] generateLongArray(int n, long maxN) {
        long[] list = new long[n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list[i] = random.nextLong(maxN);
        }
        
       return list;
    }

    static float mergeSortTest1(Integer[] v) {
        System.out.print("\nArray size: ");
        System.out.print(v.length);

        counter = 0;

        long startTime = System.nanoTime();

        v = mergeSort(v); 
        
        long stopTime = System.nanoTime(); 

        System.out.print("\nTotal repetitions: ");
        System.out.print(counter);      

        System.out.print("\nTotal time: ");
        float time = (float)(stopTime - startTime) / convFactor;
        System.out.print(time);
        System.out.println(" ms\n");

        counter = 0;
        
        return time;
    }

    static float maxVal1Test1(long[] v) {
        System.out.print("\nArray size: ");
        System.out.print(v.length);

        counter = 0;

        System.out.print("\nMax value is: ");

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
        
        return time; 
    }

    static float maxVal2Test1(long[] v) {
        System.out.print("\nArray size: ");
        System.out.print(v.length);

        counter = 0;

        System.out.print("\nMax value is: ");
        
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
        
        return time; 
    }
    
    static float multiplyTest1(long x, long y, long n) {
        counter = 0;

        System.out.printf("\nResult of %d * %d, with %d bits: ", x, y, n);

        long startTime = System.nanoTime();
        
        System.out.print(multiply(x, y, n));
        
        long stopTime = System.nanoTime(); 

        System.out.print("\nTotal repetitions: ");
        System.out.print(counter);      

        System.out.print("\nTotal time: ");
        float time = (float)(stopTime - startTime) / convFactor;
        System.out.print(time);
        System.out.println(" ms\n");

        counter = 0; 
        
        return time;
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
    
    static long multiply(long x, long y, long n) {
        counter++;
        
        if (n == 1)
            return x * y;
        
        long m = n / 2;
        long k = (long) Math.pow(2, m);
        
        long a = x / k;
        long b = x % k;
        long c = y / k;
        long d = y % k;
        
        long e = multiply(a, c, m);
        long f = multiply(b, d, m);
        long g = multiply(b, c, m);
        long h = multiply(a, d, m);
        
        return ((long) Math.pow(2, 2 * m) * e) + (k * (g + h) + f);
    }
}
