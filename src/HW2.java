/*
Name: Antony Lin
Programming Language: Java
IDE / Editor: IntelliJ IDEA
*/


public class HW2 {


    public static void main(String[] args) {


        int[] originalArray = {
                64, 12, 89, 37, 5, 72,
                26, 91, 43, 18, 55, 30
        };




        System.out.println("Original Array:");
        printArray(originalArray);
        System.out.println();




        // Bubble Sort


        int[] bubbleArray = originalArray.clone();


        bubbleSort(bubbleArray);


        System.out.println("Bubble Sort Result:");
        printArray(bubbleArray);
        System.out.println();




        // Merge Sort


        int[] mergeArray = originalArray.clone();


        mergeSort(mergeArray, 0, mergeArray.length - 1);


        System.out.println("Merge Sort Result:");
        printArray(mergeArray);
        System.out.println();




        // Linear Search


        System.out.println("Linear Search");


        int target1 = 12;
        int result1 = linearSearch(originalArray, target1);


        System.out.println("Searching for: " + target1);


        if (result1 != -1) {
            System.out.println("Target found at index " + result1);
        } else {
            System.out.println("Target not found.");
        }


        System.out.println();




        int target2 = 55;
        int result2 = linearSearch(originalArray, target2);


        System.out.println("Searching for: " + target2);


        if (result2 != -1) {
            System.out.println("Target found at index " + result2);
        } else {
            System.out.println("Target not found.");
        }


        System.out.println();




        int target3 = 500;
        int result3 = linearSearch(originalArray, target3);


        System.out.println("Searching for: " + target3);


        if (result3 != -1) {
            System.out.println("Target found at index " + result3);
        } else {
            System.out.println("Target not found.");
        }


        System.out.println();




        // Binary Search


        System.out.println("Binary Search");


        int binaryTarget1 = 5;
        int binaryResult1 = binarySearch(bubbleArray, binaryTarget1);


        System.out.println("Searching for: " + binaryTarget1);


        if (binaryResult1 != -1) {
            System.out.println("Target found at index " + binaryResult1);
        } else {
            System.out.println("Target not found.");
        }


        System.out.println();




        int binaryTarget2 = 89;
        int binaryResult2 = binarySearch(bubbleArray, binaryTarget2);


        System.out.println("Searching for: " + binaryTarget2);


        if (binaryResult2 != -1) {
            System.out.println("Target found at index " + binaryResult2);
        } else {
            System.out.println("Target not found.");
        }


        System.out.println();




        int binaryTarget3 = 500;
        int binaryResult3 = binarySearch(bubbleArray, binaryTarget3);


        System.out.println("Searching for: " + binaryTarget3);


        if (binaryResult3 != -1) {
            System.out.println("Target found at index " + binaryResult3);
        } else {
            System.out.println("Target not found.");
        }
    }




    public static void printArray(int[] array) {


        for (int number : array) {
            System.out.print(number + " ");
        }


        System.out.println();
    }




    // Bubble Sort


    public static void bubbleSort(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {


            for (int j = 0; j < array.length - 1 - i; j++) {


                if (array[j] > array[j + 1]) {


                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }




    // Merge Sort


    public static void mergeSort(int[] array, int left, int right) {


        if (left < right) {


            int middle = (left + right) / 2;


            mergeSort(array, left, middle);


            mergeSort(array, middle + 1, right);


            merge(array, left, middle, right);
        }
    }




    public static void merge(int[] array, int left, int middle, int right) {


        int leftSize = middle - left + 1;
        int rightSize = right - middle;


        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];


        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }


        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middle + 1 + j];
        }


        int i = 0;
        int j = 0;
        int k = left;


        while (i < leftSize && j < rightSize) {


            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }


            k++;
        }


        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }


        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }




    // Linear Search


    public static int linearSearch(int[] array, int target) {


        for (int i = 0; i < array.length; i++) {


            if (array[i] == target) {
                return i;
            }
        }


        return -1;
    }




    // Binary Search


    public static int binarySearch(int[] array, int target) {


        int left = 0;
        int right = array.length - 1;


        while (left <= right) {


            int middle = (left + right) / 2;


            if (array[middle] == target) {
                return middle;
            }


            if (array[middle] < target) {
                left = middle + 1;
            }


            else {
                right = middle - 1;
            }
        }


        return -1;
    }
}


/*
Name: Your Name
Programming Language: Java
IDE / Editor: IntelliJ IDEA


Part 4 — Bubble Sort Big O
Answer the following questions in your submission.
Question 1
What is the worst-case Big O time complexity of Bubble Sort?
Bubble Sort has the worst-case time complexity of O(n²).


Question 2
Why does Bubble Sort have this time complexity?
Your explanation should mention the repeated comparisons or nested loops.
Bubble sort compares 2 neighboring items and swaps them if they are in the wrong order. This algorithm passes
through the array repeatedly which results in nested loops and a worst case comparison of n × n.


Question 3
If Bubble Sort processes 10 elements, approximately how many comparisons could be required compared with 1,000 elements?
You do not need to calculate the exact number.
Explain the difference using the idea of: O(n²)
Since Bubble Sort is O(n²), the amount of comparisons will grow quadratically. 10 elements could require
dozens of comparisons while 1,000 elements could require hundreds of thousands of comparisons.


Question 4
What is the Big O time complexity of Merge Sort?
Merge Sort has a time complexity of O(n log n).


Question 5
Which algorithm generally performs better when the amount of data becomes very large?
Merge Sort because of it has a time complexity of O(n log n) which grows more slowly than Bubble Sorts O(n²).


Question 6
Complete the following:


Bubble Sort = O(n²)


Merge Sort = O(n log n)


Question 7
What is the Big O time complexity of Linear Search?
It has the worst-case time complexity of O(n). It may need to go through every element before determining
if the element exist or not.


Question 8
What is the Big O time complexity of Binary Search?
Binary Search has a time complexity of O(log n). Each comparison gets rid of half of the elements remaining.


Question 9
Why does Binary Search require sorted data?
Binary Search requires sorted data so it can determine which side of the array to eliminate. It uses the
middle to determine what each side of the array contains.


Question 10
Which search would you use if the data were not sorted?
If the data was not sorted I would use the Linear Search because it searches through each element.


Question 11
Which search would generally be better for a very large sorted array?
Binary Search would generally be better for a very large sorted array because it eliminates half of the elements
each time it passes.


Algorithm           Purpose                Big O
Bubble Sort         Sorting                O(n²)
Merge Sort          Sorting             O(n log n)
Linear Search       Searching           O(n)
Binary Search       Searching           O(log n)




*/
