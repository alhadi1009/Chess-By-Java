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
public class TracSystem {
    public static boolean IsMyKingSafe(int index)
    {
        
        if(index>15)
        {
            for(int i=0;i<16;i++)
            {
                if(i<8 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
                if((i==8 || i==15)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
                if((i==9 || i== 14) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
                if((i==10 || i== 13) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
                if(i==11 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i)) return false;
                if(i==12 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
                
            }
            Indicator.isWhiteKingUnderAttack=false;
            return true;
        }
        else 
        {
            for(int i=16;i<32;i++)
            {
               // if(i<24 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], allPoints.Positions[13], i))return false;
                if((i==24 || i==31)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
                if((i==25 || i== 30) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
                if((i==26 || i== 29) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
                if(i==27 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i)) return false;
                if(i==28 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
            }
            Indicator.isBlackKingUnderAttack=false;
            return true;
        }
        
    }
    public static boolean IsMyKingSafeByOwn(int index,Point pnt)
    {
        
        if(index>15)
        {
            for(int i=0;i<16;i++)
            {
                if(i<8 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i],pnt, i))return false;
                if((i==8 || i==15)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if((i==9 || i== 14) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if((i==10 || i== 13) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if(i==11 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], pnt, i)) return false;
                if(i==12 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], pnt, i))return false;
                
            }
            Indicator.isWhiteKingUnderAttack=false;
            return true;
        }
        else 
        {
            for(int i=16;i<32;i++)
            {
               // if(i<24 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], allPoints.Positions[13], i))return false;
                if((i==24 || i==31)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if((i==25 || i== 30) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if((i==26 || i== 29) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], pnt, i))return false;
                if(i==27 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], pnt, i)) return false;
                if(i==28 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], pnt, i))return false;
            }
            Indicator.isBlackKingUnderAttack=false;
            return true;
        }
        
    }
    
}
