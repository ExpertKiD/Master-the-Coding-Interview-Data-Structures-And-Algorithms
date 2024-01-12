package section_07_data_structures_hash_tables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Google Question
 * Given an array = [2,5,1,2,3,5,1,2,4]:
 * It should return 2
 * <p>
 * Given an array = [2,1,1,2,3,5,1,2,4]:
 * It should return 1
 * <p>
 * Given an array = [2,3,4,5]:
 * It should return undefined
 * <p>
 * <p>
 * function firstRecurringCharacter(input)
 * }
 * <p>
 * Bonus... What if we had this:
 * [2,5,5,2,3,5,1,2,4]
 * return 5 because the pairs are before 2,2
 */
public class FirstRecurringCharacter {
    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
        int[] array2 = new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4};
        int[] array3 = new int[]{2, 3, 4, 5};

        System.out.printf("First Reoccurring Character: %-5d Array: %s\n",
                firstRecurringCharacter(array1), Arrays.toString(array1));
        System.out.printf("First Reoccurring Character: %-5d Array: %s\n",
                firstRecurringCharacter(array2), Arrays.toString(array2));
        System.out.printf("First Reoccurring Character: %-5d Array: %s\n",
                firstRecurringCharacter(array3), Arrays.toString(array3));
    }

    public static Integer firstRecurringCharacter(int[] array) {
        Set<Integer> elements = new HashSet<>();

        for (int item : array) {
            if (elements.contains(item)) {
                return item;
            }

            elements.add(item);
        }

        return null;
    }
}
