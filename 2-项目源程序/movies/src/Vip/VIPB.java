package Vip;
/***********************************************************************
 * Module:  VIPB.java
 * Author:  WZBC
 * Purpose: Defines the Class VIPB
 ***********************************************************************/

import java.util.*;

import User.Play;

/** @pdOid 920db692-bf6f-4274-ae34-3955d305b947 */
public class VIPB extends Discount {
   /** @param ticket
    * @pdOid b150a981-1ad0-45a7-ab4a-465520e25f04 */
   public String count(String tic_price) {
      // TODO: implement
	   return Double.toString((Double.parseDouble(tic_price)*0.7));
   }

}