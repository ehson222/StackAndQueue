/*
 * This class is only for canned beans
 * INVENTORY
 * Transaction class
 */

public class LLstack 
{
   private LLnode top;
   private int size;
 
   public int getSize()
   {
      return size;
   }
    
   public LLstack()
   {
      top = null;
      size = 0;
   }

   public void push(LLobject d)
   {
      //make a new node, it is not part of linked list yet
      LLnode newNode = new LLnode(d);
      ++size; //just added a new node
      //if empty linked list, make this new node the top node
      if(top == null)
         //top points to new node a.k.a. assign newNode as top
         top = newNode;
      //if linked list exists
      else
      {
         //this newNode is "positioned" in front of count top node
         newNode.setNext(top);
         //assign newNode as top
         top = newNode;
      }
   }
   
   public LLobject pop() 
   {
      //return the data value we are removing
      LLnode temp = top;
      //check if linked list is empty
      if(top != null) 
      {
         //remove reference from count top and
         //make whatever top was pointing to as the new top
         top = top.getNext();
         --size; //just removed count top node
      }
      else
         throw new IllegalArgumentException("the list is empty");
      
     /*  String msg = //"|" + temp.getLabel() + 
                  "|" + temp.getCanBeanAmount() + "," 
                   + temp.getPrice() + "| got popped from stack.";*/
      return temp.getData();
   }
   
   public LLobject peek() 
   {
      LLnode dummy = new LLnode(); 
      //check if linked list is empty
      if(top == null)
         throw new IllegalArgumentException("the list is empty"); 
      else
         //point dummy to top node
         dummy = top;
         //return (extract) the data
      return dummy.getData();                
   }
   
   public boolean isEmpty()
   {
      //faster than, if(top == null), return null;
      return top == null;
   }
   
   /*
    * Starting from the top of the list,
    * this method tells you position of item on list
    * # = found, -1 = not found
    */
 /*  public int search(int key)
   {
      int place = 0;
      LLnode temp = top;
      if(top == null)
         throw new IllegalArgumentException("the list is empty"); 
      else
      {
         temp = top;
         while(temp != null)
         {
            if(temp.getData() == (key))
               return place;
            
            temp = temp.getNext();
            ++place;
         }
      }
      System.out.print("Item not on list: ");
      return -1;
   } */
   
   /*public String toString()
   {
      LLnode start = top;
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
   }

  /* public void compareTo(int i) {
      if(top.getCanBeanAmount() > 0) {
         
      }
     
   }
   */
}
