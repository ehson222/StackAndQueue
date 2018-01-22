/*
 * LLstack and LLqueue will share this class
 */

//node holds the data from widget class
//node also holds what it points to next
//node can change what it points next
//node cannot change whats in data
//that is all node does
//stack and queue class only uses node next value
//stack and queue class cannot change data
//data only changed by widget class

public class LLnode 
{

   //our LLobject holds (int canBeanAmount and double price)
   protected LLobject data;
   protected LLnode next;
   
   public LLnode()
   {
      data = null;
      next = null;
   }
   
   public LLnode(LLobject d)
   {
      data = d;
      next = null;
   }

   public LLobject getData()
   {
      return data;
   }
   public void setData(LLobject d)
   {
      data = d;
   }
   public LLnode getNext()
   {
     return next;
   }
   public void setNext(LLnode next)
   {
      this.next = next;
   }
   
}
