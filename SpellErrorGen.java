// Shawnkoon

// If you are using this code.
// Please leave trace to my Github page.
// Thanks!
// Shawn's Github Page : https://github.com/shawnkoon


// Error Generator
// Due before April 11th.

import java.util.*;
public class SpellErrorGen
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      int choice = showMenu(kb);
      
      // Menu
      while (choice != 2)
      {
         if (choice == 1)
         {
            errorGen(kb);
         }         
         choice = showMenu(kb);
      }
      System.out.println("\nBYE");
   }
   
   //Show menu method
   private static int showMenu(Scanner kb)
   {
      int choice = 0;      
      while (choice < 1 || choice > 2)
      {
         System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n###################################################################");
         System.out.println("########### Welcome to Shawn's Spelling Error Generator ###########");
         System.out.println("###################################################################\n");
         System.out.println("\tPlease choose One of the following option.\n");
         System.out.println("   1. Generate Spelling Error.");
         System.out.println("   2. Quit.\n");
         System.out.print("   Your choice : ");
         
         // Incase of typing non int
         try
         {
            choice = kb.nextInt();
         }
         catch (Exception e)
         {
            System.out.println("\n\n ******ERROR : Please Type a number. ******");
            choice = 0;
         }
         kb.nextLine();
         
         // If still not one of those choice
         if (choice < 1 || choice > 2)
         {
            System.out.println(" ******ERROR : Please choose between 1 or 2 ******\n");
         }
      }
      return choice;
   } // End of show menu
   
   // Error gen method
   private static void errorGen(Scanner kb)
   {
      char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'},
                           {'a','s','d','f','g','h','j','k','l',},
                           {'z','x','c','v','b','n','m'}
                          };
      String s = null;
      while (s == null)
      {
         System.out.print("\nPlese Enter the CORRECT SENTENCE: ");
         
         try
         {
            s = kb.nextLine();
         }
         catch (Exception e)
         {
            System.out.println("\n\n ******ERROR : Please Type sentence ******");
            s = null;
         }
      }
      
      String[] sentence = s.split(" ");
      System.out.println("");
      switchLetter(sentence);
      doubleLetter(sentence);
      misstpLetter(sentence, keyboard);
      System.out.print("\nPress Enter to continue...");
      kb.nextLine();                                      
   }
   
   //Misstyping letter case
   private static void misstpLetter(String[] s, char[][] kb)
   {
      String[] sentence = new String[s.length];
      for(int i = 0 ; i < s.length ; i++)
      {
         sentence[i] = s[i];
      }
      int size = sentence.length;
      Random dice = new Random();
      
      int c1 = dice.nextInt(size); // index of rand word
      while (sentence[c1].length()== 1)
      {
         c1 = dice.nextInt(size);
      }
      char[] word = sentence[c1].toCharArray();
      int s1 = word.length; // length of that word
      
      int first = dice.nextInt(s1);
      
      boolean goOn = false; // Checking for letter validation
      int row =0;
      int col =0;
      while(goOn == false)
      {
         for (int i=0; i < kb.length ; i++)
         {
            for(int j=0; j < kb[i].length ; j++)
            {
               if(kb[i][j] == Character.toLowerCase(word[first]))
               {
                  goOn = true;
                  row = i;
                  col = j;
               }
            }
         }
         if(goOn == false)
         {
            first = dice.nextInt(s1);
         }
      }
      
      char second = '\0';
      if(col == 0)
      {
         second = kb[row][col+1];
      }
      else if(col == kb[row].length -1)
      {
         second = kb[row][col-1];
      }
      else
      {
         int ch = dice.nextInt(2);
         
         if(ch == 0)
         {
            second = kb[row][col+1];
         }
         else
         {
            second = kb[row][col-1];
         }
      }
      
      word[first] = second;
      String newWord = new String(word);
      sentence[c1] = newWord;
      
      System.out.print("The possible errored sentence: ");
      for( int i =0; i < sentence.length ; i ++)
      {
         System.out.print(sentence[i] + " ");
      }
      System.out.println("");
   }// End of misstype method
   
   //Switching letter case
   private static void switchLetter(String[] s)
   {
      String[] sentence = new String[s.length];
      for(int i = 0 ; i < s.length ; i++)
      {
         sentence[i] = s[i];
      }
      
      int size = sentence.length;
      Random dice = new Random();
      
      int c1 = dice.nextInt(size); // index of rand word
      while (sentence[c1].length()== 1)
      {
         c1 = dice.nextInt(size);
      }
      char[] word = sentence[c1].toCharArray();
      int s1 = word.length; // length of that word
      
      int first = dice.nextInt(s1);
      int second = 0;
      
      if (first == 0)  // If it pick first let
      {
         second = first +1;
      }
      else if (first == word.length -1) // if it pick last let
      {
         second = first -1;
      }
      else if (first != 0 && first != word.length -1) // if in middle
      {
         second = dice.nextInt(2); 
      
         if (second == 0)
         {
            second = first +1;
         }
         else if (second == 1)
         {
            second = first -1;
         }
      }
         
      char temp = word[first];
      word[first] = word[second];
      word[second] = temp;
      String newWord = new String(word);
      sentence[c1] = newWord;
      
      System.out.print("The possible errored sentence: ");
      for( int i =0; i < sentence.length ; i ++)
      {
         System.out.print(sentence[i] + " ");
      }
      System.out.println("");
   } // End of SwitchLet
   
   //Double letter case
   private static void doubleLetter(String[] s)
   {
      String[] sentence = new String[s.length];
      for(int i = 0 ; i < s.length ; i++)
      {
         sentence[i] = s[i];
      }
      int size = sentence.length;
      Random dice = new Random();
      
      int c1 = dice.nextInt(size); // index of rand word
      while (sentence[c1].length()== 1)
      {
         c1 = dice.nextInt(size);
      }
      char[] word = sentence[c1].toCharArray();
      int s1 = word.length; // length of that word
      
      int first = dice.nextInt(s1);
      int second = first + 1;

      char[] word2 = new char[word.length+1];
      
      for(int i=0; i < second; i++)
      {
         word2[i] = word[i];
      }
      word2[second] = word[first];
      for(int i = second + 1 ; i < word2.length ; i++)
      {
         word2[i] = word[i-1];
      } 
         
      String newWord = new String(word2);
      sentence[c1] = newWord;
      
      System.out.print("The possible errored sentence: ");
      for( int i =0; i < sentence.length ; i ++)
      {
         System.out.print(sentence[i] + " ");
      }
      System.out.println("");
   } // End of doubleLet
}