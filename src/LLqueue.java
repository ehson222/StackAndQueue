/*
 * This class is for back-ordered customers
 * CUSTOMER
 */

public class LLqueue 
{
   private LLnode first, last;
   private int size;
   
   public int getSize()
   {
      return size;
   }
   
   public LLqueue()
   {
      first = last = null;
      size = 0;
   }
   
   public void enQ(LLobject data)
   {
      //make a new node, it is not part of linked list yet
      LLnode newNode = new LLnode(data);
      ++size;
      //if empty linked list, make this new node the first node
      if(last == null)
         //first and last point to newNode
         first = last = newNode;
      //if linked list exists
      else 
      {
         //point to our newNode, which is at the end of the list
         last.setNext(newNode);
         last = newNode;
      }
   }
   
   public LLobject deQ() 
   {
      //return the data value we are removing
      LLnode current = first;
      //check if linked list is empty
      if(first != null)
      {
         //remove reference from current first and
         //make whatever first was pointing to as the new first
         first = first.getNext();
         --size;
      }
      else
         throw new IllegalArgumentException("the list is empty");
     
      return current.getData();
   }
   
   //same as a peek method or poll (but this throws exception)
   public LLobject element() 
   {
      //check if linked list is empty
      if(first == null)
         throw new IllegalArgumentException("the list is empty"); 
      
      LLnode dummy = new LLnode();
      dummy = first;
      return dummy.getData();
   }
   
   public boolean isEmpty()
   {
      //faster than, if(top == null), return null;
      return first == null;
   }
   
  /* public String toString()
   {
      LLnode start = first;
      String output = "";
      if(start == null)
         //we could throw an exception
         System.out.println("||--> NULL, list is empty");  
      else
      {
         while(start != null)
         {
         output += "";
         output += start.getData();
         output += "--> ";
         start = start.getNext();
         }
      }
      return output;
   }*/
   
}
