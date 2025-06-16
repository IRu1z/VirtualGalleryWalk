import java.util.Random; // This imports the random class
import java.util.Scanner; // This imports the scanner for input

public class PassGen // This class generates a secure random password of user-defined length
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in); // Scanner to read input
        int length = 0; // Starts here until a length is added

        while (length <= 4)  // This lets the user know they need to enter a password length
        { 
            System.out.println("Please enter password length(Greater than 4)");

          
            if (scanner.hasNextInt()) // This checks if the next input is an integer
            {
                length = scanner.nextInt(); // Checks input for integer

               
                if (length <= 4) // This stops the user from entering a number less than or equal to 4
                {
                    System.out.println("Length must be greater than 4");
                }
            } 
            else 
            {
               
                System.out.println("Invalid input. Please enter a number."); // This tells the user the input needs to be a number 
                scanner.next(); // This waits for the next input
            }
        }

        
      String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // These strings are what the passwords will be composed of
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{};:,.<>?/";

        String allChars = upperCase + lowerCase + digits + specialChars; // This combines all characters 
        Random rand = new Random(); // This is for random numbers
        StringBuilder password = new StringBuilder(); // This stringbuilder allows for the password to be created

        password.append(upperCase.charAt(rand.nextInt(upperCase.length()))); // These appends make sure you can get a character from each string (lowercase, uppercase, etc)
        password.append(lowerCase.charAt(rand.nextInt(lowerCase.length())));
        password.append(digits.charAt(rand.nextInt(digits.length())));
        password.append(specialChars.charAt(rand.nextInt(specialChars.length())));

        for (int i = 4; i < length; i++)   // This fills the rest of the characters past 4
        {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        String finalPassword = shuffleString(password.toString()); // This shuffles the password

        System.out.println("Generated Password: " + finalPassword); // This prints the password

        scanner.close(); 
    }

    public static String shuffleString(String input)
     {
        char[] characters = input.toCharArray(); // This converts the string into an array
        Random rand = new Random();
        for (int i = 0; i < characters.length; i++) 
         {
            int j = rand.nextInt(characters.length);
            
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters); // This shuffles the characters and returns them as a new string
 
    }
}
