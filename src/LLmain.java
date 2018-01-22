import java.io.File; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * this class reads from a file, takes in inventory.
 * Each line taken from warehouse: #ofCans, Price per can.
 * Each line is a separate box of cans and separate price.
 * Each line taken from customer: #ofCans ordered.
 * Each line is a separate order list from a unique customer.
 * Customers are charged 40% mark-up and
 * customer price paid receipt, cost to warehouse receipt is printed.
 * If #ofCans in warehouse < #ofCans ordered.
 * Customer #ofCans amount is put into a Queue list.
 * Once we read new lines from warehouse,
 * then we can sell to queue list customers in LIFO basis
 * @ehson assani
 */
public class LLmain {

   public static void main(String[] args) throws IOException 
   {
      
   
      //reads from command line
      Scanner console = new Scanner(System.in);
      /*
       * Inputfile giving error message, could not find fix
       * so we are just entering the name of the file beforehand
       * then printwriter doesn't write to file, could not find fix
       */
      // System.out.print("Input file: ");
      //puts the entered text into String variable
     // String inputFileName = console.next();
     // System.out.print("Output file: ");
    //  String outputFileName = console.next();
      
      //opens the String variable text contents, to read from
      File inputFile = new File("transactions.txt");
      //reads the entire text contents within the file
      Scanner in = new Scanner(inputFile);

    // PrintWriter out = new PrintWriter(outputFileName);
      
     // this newline delimiter did not work at all
     // scan.useDelimiter("[\\\\r\\\\n]+");
     // Printing the delimiter used
     // System.out.println("The delimiter use is "+scan.delimiter());
     // Printing the tokenized Strings
     // Also, set String and char variables to null.
     String now = "";
     int canbean = 0;
     double price = 0,customerPrice = 0; 
     LLstack inventory = new LLstack();
     LLqueue backorder = new LLqueue();
     //LLTransactions BBW = new LLTransactions();

     LLobject dataStore, dataCustomer;

     //try scan.hasNextLine() and line.split(" ", if our delimiter gives problems
     //scan the next line, treat as token until eof.
     while(in.hasNextLine())
     {
        //assign now to scanned char, letter from String line
        now = in.next();
        //There is not nextChar in Scanner class
        if(now.charAt(0) == 'R')
        {   
           canbean = in.nextInt();
           price = in.nextDouble();
           //always 'special' price for customer(s) (^_^)
           customerPrice = price * 1.40; //40% mark-up, need math.round or get 5.99999999
           //dataStore is a LLobject, as defined before
           dataStore = new LLobject (canbean,price);
           //put data in BBW inventory, LLstack
           inventory.push(dataStore);       
              //System.out.println("Inventory: " + now + " " + canbean + " " + price);
              //System.out.println("Invalid line, cannot interpret");
        }
        else if (now.charAt(0) == 'S')
        {
           canbean = in.nextInt();
           dataCustomer = new LLobject(canbean,customerPrice);
           /*
            * we have cannedbeans in inventory, therefore we can take customer orders
            */
           if(!inventory.isEmpty())
              LLTransactions.Transactions(inventory, backorder, dataCustomer);
           /*
            * no cannedbeans in inventory, put customer on waitlist
            */
           else
              backorder.enQ(dataCustomer);
        
           //  System.out.println("Customer: " + now + " " + canbean + " " + Math.round(customerPrice*100.0)/100.0);
           // System.out.println("Invalid line, cannot interpret");
        }
        /*
         * While we have backorders and inventory stock, run this method
         * if Stack/inventory not empty, if Queue/backorder are not empty  repeat 
         */
        while( !inventory.isEmpty() && !backorder.isEmpty() )
        {
           //the 1st backorder customer goes first
           if(backorder.element() != null)
           {
           LLobject dataCustBackOrder = backorder.deQ();
           // LLstack var, LLqueue var , backorder.deQ var
           LLTransactions.Transactions(inventory, backorder, dataCustBackOrder);
           }
        }

        //close File read (File)
         //  in.close();
        // close File writer (printWriter)
       // out.close();
     }
   }


}
