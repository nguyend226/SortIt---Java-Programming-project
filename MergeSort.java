/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortit;

public class MergeSort {

    // Sort the array  - recursive function 
    public int[] sort(int inpArray[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Get center 
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // Sort left half 
            sort(inpArray, leftIndex, middleIndex);
            // Sort right half 
            sort(inpArray, middleIndex + 1, rightIndex);

            // Merge sorted arrays 
            merge(inpArray, leftIndex, middleIndex, rightIndex);
        }

        return inpArray;
    }

    // Merge two sub arrays
    public void merge(int inpArray[], int leftIndex, int middleIndex, int rightIndex) {
        // Get left and right array sizes 
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        // Create left array 
        int leftArray[] = new int[middleIndex - leftIndex + 1];
        // Create right array 
        int rightArray[] = new int[rightIndex - middleIndex];

        // Initiate left array with values 
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = inpArray[leftIndex + i];
        }
        // Initiate right array with values
        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = inpArray[middleIndex + 1 + j];
        }

        int lIndex = 0;
        int rIndex = 0;
        int inpIndex = leftIndex;

        // Check for bounding conditions 
        while (lIndex < leftArraySize && rIndex < rightArraySize) {
            // If right side value is greater 
            if (leftArray[lIndex] <= rightArray[rIndex]) {
                inpArray[inpIndex] = leftArray[lIndex];
                lIndex++;
            } else {
                inpArray[inpIndex] = rightArray[rIndex];
                rIndex++;
            }
            inpIndex++;
        }

        // Insert remaining elements in left array
        while (lIndex < leftArraySize) {
            inpArray[inpIndex] = leftArray[lIndex];
            lIndex++;
            inpIndex++;
        }

        // Insert remaining elements in right array
        while (rIndex < rightArraySize) {
            inpArray[inpIndex] = rightArray[rIndex];
            rIndex++;
            inpIndex++;
        }
    }

}
