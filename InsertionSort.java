/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortit;

public class InsertionSort {

    public void sort(int inpArray[])
    {

        for (int i = 1; i < inpArray.length; i++) {

            int key = inpArray[i];
            int j = i - 1;

            while (j >= 0 && inpArray[j] > key) {
                inpArray[j + 1] = inpArray[j];
                j = j - 1;
            }
            
            inpArray[j + 1] = key;
        }
    }
}
