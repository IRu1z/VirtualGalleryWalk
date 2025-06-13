import java.util.Random;
import java.util.Scanner;

public class PassGen 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int length = 0; 

        while (length <= 4) 
        { 
            System.out.println("Please enter password length(Greater than 4)");

          
            if (scanner.hasNextInt()) 
            {
                length = scanner.nextInt();

               
                if (length <= 4) 
                {
                    System.out.println("Length must be greater than 4");
                }
            } 
            else 
            {
               
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }

        
      String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{};:,.<>?/";

        String allChars = upperCase + lowerCase + digits + specialChars;
        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upperCase.charAt(rand.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(rand.nextInt(lowerCase.length())));
        password.append(digits.charAt(rand.nextInt(digits.length())));
        password.append(specialChars.charAt(rand.nextInt(specialChars.length())));

        for (int i = 4; i < length; i++)   
        {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        String finalPassword = shuffleString(password.toString());

        System.out.println("Generated Password: " + finalPassword);

        scanner.close(); 
    }

    public static String shuffleString(String input)
     {
        char[] characters = input.toCharArray();
        Random rand = new Random();
        for (int i = 0; i < characters.length; i++)
         {
            int j = rand.nextInt(characters.length);
            
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
 
    }
}
