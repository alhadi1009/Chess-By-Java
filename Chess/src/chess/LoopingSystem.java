/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.Point;

/**
 *
 * @author Al Hadi
 */
public class LoopingSystem {
   public static boolean isPlayerPositioned(Point target)
   {
       for(int i=0;i<32;i++)
       {
           if(allPoints.Positions[i] != null && allPoints.Positions[i].equals(target))
           {
               return true;
           }
       }
      return false; 
   }
   public static int isPlayerIndex(Point target)
   {
       for(int i=0;i<32;i++)
       {
           if(allPoints.Positions[i] != null && allPoints.Positions[i].equals(target))
           {
               return i;
           }
       }
      return -1; 
   }
    
}
