package Vip;
/***********************************************************************
 * Module:  VIPC.java
 * Author:  WZBC
 * Purpose: Defines the Class VIPC
 ***********************************************************************/

import java.util.*;

import User.Play;

/** @pdOid e25b22db-f915-4c0e-8872-4a6303a9210f */
public class VIPC extends Discount {
   /** @param ticket
    * @pdOid 4ac668fc-ee5b-4e92-825f-57d197d2bd70 */
   public String count(String tic_price) {
      // TODO: implement
	   return Double.toString((Double.parseDouble(tic_price)*0.5));
   }

}