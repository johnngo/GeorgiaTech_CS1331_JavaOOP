    /* a) First, declare and initialize two variables, an integer type (byte, short, int, or long) and a floating point value (float or double). 
          The names and values can be whatever you like, for this step and all others. Make sure that the numbers you choose can be stored within 
          the respective primitive type you choose. Print each of these values out on their own line using `System.out.println()`.
       b) Multiply these variables together, and assign the outcome to a `new` variable, ensuring that no data is lost. For example, if I 
          multiply 5 and 3.5, the answer should be 17.5. Print out this new value.
       c) Use casting to convert the integer from the first step to a floating point value and store that in another `new` variable. Print out the value.
       d) Use casting to convert the floating point value from the first step to an integer type and store that in a `new` variable.  Print out the value.
       e) Shifting focus, declare a `char` variable, and assign an uppercase letter to it. Print out this value.
       f) Using a *numerical operation*, change the letter to the same letter, but in lowercase. Use a numerical operation - do not reassign the variable. 
          You may want to review a [table of ASCII values](https://ascii.cl/) as you're working on this section. Print out the new `char` value.
          **Hint:** you'll likely have to use casting to get this to work.
    */

    public class PrimitiveOperations {
    
        //TODO: Start your code after this line
     public static void main (String[] args) {
         int age = 22;
         double yoe = 7.4;
         System.out.println(age);
         System.out.println(yoe);
         double work = age * yoe;
         System.out.println(work);
         float myFloat = (float) age;
         System.out.println(myFloat);
         int myInt = (int) yoe;
         System.out.println(myInt);
         char uppercaseJ = 'J';
         System.out.println(uppercaseJ);
         char lowercaseJ = 'J' + 32;
         System.out.println(lowercaseJ);
     }
 }
 