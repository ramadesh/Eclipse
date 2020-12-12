public class ArrayMath {
  /**
   * This method should return the sum of all the entries in an array
   *
   * @param arr the array of which the sum of all the elements needs to be taken.
   *
   * @return double the sum of all the elements in the array parameter.
   */
   public double entriesSum(double[][] arr) 
   {
     double sum = 0;
     for (int i = 0; i < arr.length; i++) 
     {
    	 for(int j = 0; j < arr[i].length; j++)
    	 {
    		 sum = sum + arr[i][j];
    	 }
     }
     return sum;
   } 
   
   //entriesSum
    /**
     * This method should return an array with the sum of elements at the same position in two arrays.
     * Ex. array1 = [1, 2, 3, 4], array2 = [5, 6, 7, 8].
     * vectorAddition(array1, array2) = [6, 8, 10, 12] (1 + 5 = 6, 2 + 6 = 8, 3 + 7 = 10, 4 + 8 = 12)
     * You can assume that both the arrays will be of the same size.
     *
     * @param array1 the first array parameter that needs to be added.
     * @param array2 the second array parameter that needs to be added.
     *
     * @return int[] the vector sum of the 2 parameters.
     */
     public int[] vectorAddition(int[] array1, int[] array2) {
       int[] sum = new int [array1.length];
       for (int i = 0; i < array1.length; i++) 
       {
         for (int j = 0; j < array2.length; j++) 
         {
        	 sum[i] = array1[i] + array2[i];
         }
       }
        return sum;
      } //vectorAddition

      /**
      * This method should return a string formed by the character array
      *
      * @param string the char[] that needs to be converted into a string.
      *
      * @return String the string that's formed by the character array.
      */
      public String stringFromCharacters(char[] string) {
        String returnString = "";
        for (int i = 0; i < string.length; i++) 
        {
          returnString = returnString + string[i];
        }
        return returnString;
      } //stringFromCharacters
}
