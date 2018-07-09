package Vip;
/***********************************************************************
 * Module:  VIPA.java
 * Author:  WZBC
 * Purpose: Defines the Class VIPA
 ***********************************************************************/

import java.util.*;

import User.Play;

/** @pdOid b08b752a-1e78-46e5-be86-6a9a54c853a4 */
public class VIPA extends Discount {
   /** @param ticket
    * @pdOid f0d3b364-b155-49b8-821a-a360c848127c */
   public String count(String tic_price) {
      // TODO: implement	   
	   return Double.toString((Double.parseDouble(tic_price)*0.9));
   }

}