/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Al Hadi
 */
public class MovingElement {

    private static ArrayList<Boolean> BlackPawn = new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true, true));
    private static ArrayList<Boolean> WhitePawn = new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true, true));

    public static boolean ValidPawnMoveBlack(Point past, Point present, int index) {
        //  System.out.println("Points"+present.x+present.y+past.x+past.y);

        if (past.y - present.y > 2) {
            //System.out.println("Position="+past.x*80+"  " +(past.y) *80 );

            return false;
        }

        if (BlackPawn.get(index) && past.y - present.y == 2 && present.x == past.x) {
            for (int i = 1; i < 3; i++) {
                if (LoopingSystem.isPlayerPositioned(new Point(past.x * 80, (past.y - i) * 80))) {
                    // System.out.println("Position="+past.x*80+"  " +(past.y-i) *80 );
                    return false;
                }
            }
            return true;
        }
        if (past.y - present.y == 1 && present.x == past.x) {                   //  System.out.println("Position="+past.x*80+"  " +(past.y) *80 );

            if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, (present.y - 1) * 80))) {
                return false;
            } else {
                return true;
            }
        }
        if (past.y - present.y == 1 && past.x - present.x == 1) {
            int Oposite = LoopingSystem.isPlayerIndex(new Point(present.y * 80, present.x * 80));
            if (Oposite > 15) {
                return true;
            }

        }

        //System.out.println("Hello hi bye" );
        return false;
    }

    public static boolean ValidRookMoveBlack(Point past, Point present, int index) {
        if (past.x == present.x) {
            if (past.y > present.y) {
                for (int i = past.y - 1; i>= present.y; i--) {
                    if (LoopingSystem.isPlayerPositioned(new Point(past.x * 80, (past.y - i) * 80))) {
                        // System.out.println("Position="+past.x*80+"  " +(past.y-i) *80 );
                        return false;
                    }
                }
            }else if(past.y<present.y)
            {
               for (int i = past.y + 1; i<= present.y; i++) {
                    if (LoopingSystem.isPlayerPositioned(new Point(past.x * 80, (past.y + i) * 80))) {
                        // System.out.println("Position="+past.x*80+"  " +(past.y-i) *80 );
                        return false;
                    }
                } 
            }
          
            return true;
        } else if (past.y == present.y) {
            if(past.x>present.x)
            {
                for(int i=past.x-1;i>=present.x;i--)
                {
                  if (LoopingSystem.isPlayerPositioned(new Point((past.x-i )* 80, past.y  * 80))) {
                        // System.out.println("Position="+past.x*80+"  " +(past.y-i) *80 );
                        return false;
                    }  
                }
            }
            else if (past.x<present.x)
            {
                for(int i=past.x+1;i<=present.x;i++)
                {
                   if (LoopingSystem.isPlayerPositioned(new Point((past.x+i )* 80, past.y  * 80))) {
                        // System.out.println("Position="+past.x*80+"  " +(past.y-i) *80 );
                        return false;
                    }  
                }
                return true;
            }

        }
        return false;
    }

}
