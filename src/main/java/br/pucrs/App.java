package br.pucrs;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        Integer[] v = new Integer[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

        System.out.print("Array before mergeSort: ");

        for (Integer el : v) {
            System.out.print(el);
            System.out.print(" ");
        }

        System.out.println();

        System.out.print("Array after mergeSort: ");

        for (Integer el : mergeSort(v)) {
            System.out.print(el);
            System.out.print(" ");
        }
    }

    static Integer[] mergeSort(Integer[] list) {
        if (list.length <= 1) return list;

        Integer[] left = mergeSort(Arrays.copyOfRange(list, 0, list.length / 2));
        Integer[] right = mergeSort(Arrays.copyOfRange(list, list.length / 2, list.length));

        return merge(left, right);
    }

    static Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] result = new Integer[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
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
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }
}
