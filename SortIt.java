/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortit;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class SortIt {

    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);
        // Create MergeSort object 
        MergeSort mergeSort = new MergeSort();
        InsertionSort inSort = new InsertionSort();

        int size;// size of the array 

        String filename;
        // Loop until input is correct 

        System.out.print("Enter the file name : ");

        filename = scanner.next();

        int arr[] = readFile(filename);
        int arr2[] = readFile(filename);

        // Starting time of merge sort 
        Instant start = Instant.now();
        // Sort array 
        int[] a = mergeSort.sort(arr, 0, arr.length - 1);

        // Finish time 
        Instant finish = Instant.now();

        // Calculate time taken for sort 
        long timeElapsed = Duration.between(start, finish).toMillis();

        // Starting time of insertion sort 
        start = Instant.now();

        // Sort array 
        inSort.sort(arr2);

        // Finish time 
        finish = Instant.now();

        System.out.println("***** Sorted Array ***** ");
        
        // Print array 
        Util.print(a);
        System.out.println("Merge Sort Time Elapsed : " + timeElapsed + " ms");

        // Calculate time taken for sort 
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Insertion Sort Time Elapsed : " + timeElapsed + " ms");

    }

    // Read file and generate Integer array 
    public static int[] readFile(String filename) {

        String strArray[] = null;
        int numbers[];
        
        try {
            // Create file object 
            File file = new File(filename);
            // Create scanner object using file 
            Scanner scanner = new Scanner(file);
            // read file 
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                // Split data by ','
                strArray = data.split(",");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        numbers = new int[strArray.length];
        // Convert to integer array 
        for (int i = 0; i < strArray.length; i++) {
            numbers[i] = Integer.parseInt(strArray[i]);
        }

        return numbers;
    }

}
