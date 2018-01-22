/*
 * handles... transactions (^_^)
 */
public class LLTransactions 
{

   public static void Transactions(LLstack inventory, LLqueue order, LLobject currentorder) {
      //if not null
      if(inventory.peek()!= null) 
      {
      LLobject bookKeepPrintout, custPrintOut;   
         
      //a Queue for backorders
      LLqueue cusBackOrderQue = new LLqueue();
      //take out LLstack item and make LLobject var point to it,
      //so we can manipulate the data inside the LLstack
      LLobject BBW = inventory.pop();
      
      //for bookkeeper's record
      int InvCanBeanAmount = BBW.getCanBeanAmount();
      //for bookkeeper 
      double InvPrice = BBW.getPrice();

      //for customer receipt
      int CustAmountReceipt = 0;
      int CustShipAmount = currentorder.getCanBeanAmount();
      //for customer backorders
      int CustBackOrderAmount = CustShipAmount;
      
       // while we have more customer orders to complete
      while (CustShipAmount > 0) 
      {
          //if we have more inventory then customer orders
          if (InvCanBeanAmount > CustShipAmount) 
          {
              //subtract inven - cust and update LLobject BBW
              BBW.setCanBeanAmount(InvCanBeanAmount - CustShipAmount);
              //now push that modified data back onto the stack
              inventory.push(BBW);
              CustAmountReceipt = CustShipAmount;
              //for bookkeeper's receipt
              LLobject.bookKeepersRecords(CustShipAmount, InvPrice);
              //otherwise... big problem (oo loop)
              break;
          }
          else
          {
             //customer orders - inven, we might have no inventory
             CustShipAmount = CustShipAmount - InvCanBeanAmount;
             //update
             currentorder.setCanBeanAmount(CustShipAmount);
             //backorders
             CustAmountReceipt = CustAmountReceipt + InvCanBeanAmount;
            // CustBackOrderAmount = InvCanBeanAmount + CustBackOrderAmount;
            // bookKeepPrintout(InvCanBeanAmount, InvPrice);//.toString();
              // print out book keeping and receipt
              LLobject.bookKeepersRecords(InvCanBeanAmount, InvPrice);
            //  custPrintOut(CustBackOrderAmount, currentorder.getPrice());
              LLobject.costumerReceipt(CustAmountReceipt, currentorder.getPrice());
              //CustAmountReceipt
              //LLobject.costumerReceipt(CustBackOrderAmount, currentorder.getPrice());
              //if inventory on stock is empty but we have customer orders
              if (inventory.isEmpty()) 
              {
                 //put the orders on the queue
                 cusBackOrderQue.enQ(currentorder);
                 //repeat until all orders on queue
                  while (!order.isEmpty()) 
                  {
                      if(order.element()!= null)
                      cusBackOrderQue.enQ(order.deQ());
                      order = cusBackOrderQue;
                      break;
                  }
              }
              else 
              {  
                  //for customer orders
                  CustShipAmount = currentorder.getCanBeanAmount();
                  //we have inventory stock, so get its data
                  BBW = inventory.pop();
                  //get price
                  InvPrice = BBW.getPrice();
                  //get amount
                  InvCanBeanAmount = BBW.getCanBeanAmount();
              }
          }
      }
     }
   }
 
}
