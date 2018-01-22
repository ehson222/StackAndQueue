//This object class is the actual data inside our nodes
//OBJECT INSIDE NODE
public class LLobject 
{
   
   private int canBeanAmount;
   private double price;
   
   /*//for customer shipment, LLqueue
   public LLobject(int cba)
   {
      if (cba < 0)
         throw new IllegalArgumentException("Nullpointer exception... joking,"
               + "canBeanAmount is less than 0.");
      canBeanAmount = cba;
   } */
   //for BBW shipment, LLstack
   public LLobject(int cba, double p)
   {
      if (cba < 0 || p < 0)
         throw new IllegalArgumentException("Nullpointer exception... joking,"
               + "canBeanAmount or Price is less than 0.");
      canBeanAmount = cba;
      price = p;
   }
   
   public int getCanBeanAmount()
   {
      return canBeanAmount;
   }
   public void setCanBeanAmount(int cba)
   {
      if (cba<0)
         throw new IllegalArgumentException("Nullpointer exception... joking,"
               + "canBeanAmount is less than 0.");
      canBeanAmount = cba;
   }
   public double getPrice() {
      return price;
   }
   public void setPrice(double p)
   {
      if (p<0)
         throw new IllegalArgumentException("Nullpointer exception... joking,"
               + "Price is less than 0.");
      price = p;
   }
   
   public static void costumerReceipt(int custAmount, double custPrice) 
   {
      double InvPrice = custAmount * Math.round(custPrice*100.0)/100.0;
      //Math.round(customerPrice*100.0)/100.0)
      System.out.println("S |" + custAmount + " cans, " + " $" + custPrice*100.0 + "| at $"
            + InvPrice);// Math.round(InvPrice*100.0)/100.0);
  }
   
   public static void bookKeepersRecords(int bookAmount, double bookPrice) 
   {
      // total InvPrice
      double InvPrice = bookAmount * Math.round(bookPrice*100.0)/100.0;
      //Math.round(customerPrice*100.0)/100.0)
      System.out.println("R |" + bookAmount + " cans, " + " $" + bookPrice + "| at $"
            + InvPrice);// Math.round(InvPrice*100.0)/100.0);
  }
   
   //bootcamp
   public String toString()
   {
      String s = "|" + canBeanAmount + " cans, " + " $" + price + "|";
      return s;
   }
   
}
