package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[L..M]
    // Second subarray is arr[M+1..R]
    static void merge(int[] arr, int L, int M, int R) {
        // Find sizes of two subarrays to be merged
        int n1 = M - L + 1;
        int n2 = R - M;

        PriorityQueue<Integer> queue=new PriorityQueue<>();

        // Create temp arrays
        int[] LeftTemp = new int[n1];
        int[] RightTemp = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, L, LeftTemp, 0, n1);
        for (int j = 0; j < n2; ++j)
            RightTemp[j] = arr[M + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = L;
        while (i < n1 && j < n2) {
            if (LeftTemp[i] <= RightTemp[j]) {
                arr[k] = LeftTemp[i];
                i++;
            } else {
                arr[k] = RightTemp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of LeftTemp[] if any
        while (i < n1) {
            arr[k] = LeftTemp[i];
            i++;
            k++;
        }

        // Copy remaining elements of RightTemp[] if any
        while (j < n2) {
            arr[k] = RightTemp[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int[] arr, int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
