/*              ALL STUDENTS COMPLETE THESE SECTIONS
 * Title:            Array Utilities
 * Files:            None
 * Semester:         Spring 2022
 * 
 * Author:           Wilson Seet | wilson.seet@colorado.edu
 * 
 * Description:		 We are creating a code that satisfies all of the method listed in the HW using arrays and testing it each time to see if it works. 
 * 
 * Written:       	 1/23/22
 * 
 * Credits:          My former high school CS teacher helped me and we talked through the steps using Discord. 
 * 					 She had me read every single method and we've talked about what we need or don't need.
 * 					 She clarified the instructions so that I can understand some methods better.
 *                   
 *                   https://www.freecodecamp.org/news/java-array-methods-how-to-print-an-array-in-java/
 **************************************************************************** */

import java.util.Random;
import java.util.Arrays;

	/**
	 * 
	 * This will be the Array Utils class where in the bottom, it includes tests and methods.
	 *
	 * <p>Bugs: (a list of bugs and other problems) - None.
	 *
	 * @author Wilson Seet
	 */

public class ArrayUtils {
	

	/**         
     * On the bottom here, we will be generating random numbers and we are working with 10 items to test each methods to see if it'll work.
     *
     * @param args (Describe expected command-line arguments (if any) here; 
     * 			   if none expected, write "No command-line arguments expected")
     */
    public static void main(String[] args) {
    	Random randGenerator = new Random();
    	//Random randGenerator = new Random(4); // switch this line with the line above if you want to
												// ensure you generate an array with duplicates
    	
    	int[] intArray = new int[10];
    	
    	//Generate 10 random numbers in the range [1, 100] and store them in the intArray
    	for (int i = 0; i < 10; ++i) {
    		intArray[i] = randGenerator.nextInt(100) + 1;
    	} 
    	
    	System.out.println("The array is:");
    	printArrayContents(intArray);
    	System.out.println();
    	
    	
    	
    	//See if the value 42 is in the array, if not, set index 7 to be 42
    	System.out.println("Checking if 42 was in the array.");
    	int index = arrayIndexOf(42, intArray);
    	if (index == -1) {
    		System.out.println("42 wasn't in the array!");
    		System.out.println("Setting index 7 to be 42");
    		arraySet(42, 7, intArray);
    		System.out.println("Now the array is:");
    		printArrayContents(intArray);
    	}
    	else {
    		System.out.println("Found 42 at index " + index);
    	}
    	System.out.println();
    
    	
    
    	//Append an eleventh value (also randomly generated) to the array
    	int newValue = randGenerator.nextInt(100)+1;
    	System.out.println("Appending " + newValue + " to the end of the array.");
    	intArray = arrayAppend(newValue, intArray);
    	System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();
	
    	
    	
    	//Insert another new value at the second position
		newValue = randGenerator.nextInt(100)+1;
		System.out.println("Inserting " + newValue + " in index 2.");
    	intArray = arrayInsert(newValue, 2, intArray);
    	System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();
		
		
    	
		//Remove the value at the fifth position (i.e., in index 4)
		int indexToRemove = 4;
		System.out.println("Removing value " + intArray[indexToRemove] + " from index " + indexToRemove);
		intArray = removeIndex(indexToRemove, intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();
		
		
    	
		//Check if the array had any duplicate values
		System.out.println("Checking if the array had any duplicate values.");
		if (arrayContainsDuplicates(intArray)) {
			System.out.println("The array contained duplicates!");
		}
		else {
			System.out.println("The array did not contain any duplicates!");
		}
		System.out.println();
	
		

		//Swap the first and last values in the array
		int index1 = 0;
		int index2 = intArray.length - 1;
		System.out.println("Swapping the values in index " + index1 + " and index " + index2);
		arraySwap(index1, index2, intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);
		System.out.println();
		
    	
		//Sort the array using BubbleSort
		System.out.println("Sorting array");
		bubbleSort(intArray);
		System.out.println("Now the array is:");
		printArrayContents(intArray);

    }


	// We are going to print all array contents. In this case, it's all integers. 
    public static void printArrayContents(int[] intArray) {
		//TODO: write this method
    	System.out.println(Arrays.toString(intArray));
    	
    	
	}
	
    // I used a for loop here to go through each items in the array to see if there is an occurrence.
    // If yes, then it will determine which index has the first occurrence.
    // If there is none, it should return -1. 
	public static int arrayIndexOf(int target, int[] intArray) {
		// TODO: Write this method
		for(int i = 0; i < intArray.length; i++)
		{
			if(intArray[i] == target)
			{
				return i;
			}
		}
		
		return -1;
	}
    
	// This method takes a certain value. There are restrictions: index > 0 and less than the length
	// of the array. If it is in that range, then it should set the contents of the array at the index to the value.
	// intArray of the index and set it to the value.
    public static void arraySet(int value, int index, int[] intArray) {
		// TODO: Write this method
    	if (index > 0 && index < intArray.length)
        {
          intArray[index] = value;
        } 
	}
	
	//Here we are adding a value to the end.
    //Create a newArray with integers.
    //Use for loops to go through each element
    //Simply adding and setting the value at the end.
    //Finally, return the array with a new number at the end.
	public static int[] arrayAppend(int value, int[] intArray) {
		// TODO: Write this method
		int[] newArray = new int[intArray.length+1];
	    for(int i = 0; i < intArray.length; i++)
	    {
	      newArray[i] = intArray[i];
	    }
	    newArray[newArray.length-1] = value;
		return newArray;
	}
	
	//This is similar to the previous method.
	//We still use the same for loop, but we are adding a new one.
	//1st loop: copying over the values from the original array into a new array to the index.
	public static int[] arrayInsert(int newValue, int index, int[] intArray) {
		// TODO: Write this method
		int[] newArray = new int[intArray.length+1];

	    for(int i = 0; i < index; i++)
	    {
	      newArray[i] = intArray[i];
	    }
	    //Then putting new value in the new array at the specific index.
	    newArray[index] = newValue;
	    //Picks up where I left off in the 1st loop, looping from index+1 to the end while
	    //copying the rest of the old values over.
	    for(int i = index; i < intArray.length; i++)
	    {
	      newArray[i+1] = intArray[i];
	    }
		return newArray;
	}
	
		//This method takes a certain value. There are restrictions: index > 0 and less than the length
		//of the array.
		//Takes in an index and it will give us a new array with a specified index removed. If not return 
		//the original array.
	public static int[] removeIndex(int indexToRemove, int[] intArray) {
		// TODO: Write this method
		if (indexToRemove > 0 && indexToRemove < intArray.length )
	    {
		  //new array variable.
	      int[] newArray = new int[intArray.length-1];
	      //For loop that goes through the array to see which index to remove.
	      for(int i = 0; i < indexToRemove; i++)
	      {
	        newArray[i] = intArray[i];
	      }
	      //By then, it already gave us a specific index in which to remove a number
	      //we remove the specific index and return a new array.
	      for(int i = indexToRemove+1; i < intArray.length; i++)
	      {
	        newArray[i-1] = intArray[i];
	      }
	      return newArray;
	      } 
		  //index not valid: return original array
		  else
		  {
		     return intArray;
		  }
	}
	
		//Used nested for loop to go through the whole array to see if there are repeated numbers.
		//The second for loop is like where we left off.
		//If we see a duplicate: intArray[i] EQUALS intArray[j], print true.
		//Otherwise, false.
	public static boolean arrayContainsDuplicates(int[] intArray) {
		// TODO: Write this method
		 for(int i = 0; i < intArray.length; i++)
		 {
		   for(int j = i+1; j < intArray.length; j++)
		   {
		     if(intArray[i] == intArray[j])
		     {
		       return true;
		     }
		  }
		}
		return false;
	}

		//This method takes a certain index value. There are restrictions: index1 > 0 and less than the length & index2 > 0, less than the length.
		//If the both restrictions are good, we use the swap method:
		//temp = a
		//a = b
		//b = temp
	public static void arraySwap(int index1, int index2, int[] intArray) {
		// TODO: Write this method
		if((index1 > 0 && index1 < intArray.length) && (index2 > 0 && index2 < intArray.length))
	     {
	       int temp = intArray[index1];
	       intArray[index1] = intArray[index2];
	       intArray[index2] = temp;
	     }
	}


	//Set default swapOccured to true.
	//Use while loop of swapOccured. (while it is true)
	//set swapOccured = false
	//iterate through array
	//if currElement < prevElement, swap elements and set
	//swapOccured to true
	//Use the swap method again:
	//temp = a
	//a = b
	//b = temp
	public static void bubbleSort(int[] data) {
		// TODO: Write this method
		 boolean swapOccured = true;
		   
	      while (swapOccured)
	      {
	         swapOccured = false;
				   for(int i = 1; i < data.length; i++)
	         {   
	           //if currElement < prevElement, swap elements and set
	           if (data[i] < data[i-1])
	           {
	        	   swapOccured = true;
			   
	              int temp = data[i];
	              data[i] = data[i-1];
	              data[i-1] = temp;
	           }
	         }
	      }
		}
	 }
