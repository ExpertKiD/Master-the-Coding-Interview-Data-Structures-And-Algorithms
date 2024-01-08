package section_06_data_structures_arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] sortedArray1 = new int[]{0, 3, 4, 31};
        int[] sortedArray2 = new int[]{4, 6, 30};

        int[] mergedArray = mergeSortedArrays(sortedArray1, sortedArray2);

        System.out.println("Merged array: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {

        if (array1.length == 0) {
            return array2;
        }

        if (array2.length == 0) {
            return array1;
        }

        int[] mergedArray = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;


        for (int mergedIndex = 0; mergedIndex < mergedArray.length; mergedIndex++) {
            if (index1 >= array1.length) {
                mergedArray[mergedIndex] = array2[index2];
                index2++;
            } else if (index2 >= array2.length) {
                mergedArray[mergedIndex] = array1[index1];
                index1++;
            } else if (array1[index1] < array2[index2]) {
                mergedArray[mergedIndex] = array1[index1];
                index1++;
            } else {
                mergedArray[mergedIndex] = array2[index2];
                index2++;
            }
        }

        return mergedArray;
    }
}
