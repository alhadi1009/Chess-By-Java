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

    public static boolean IsMyKingSafe(int index) {
        for (int i = 0; i < 16; i++) {
            System.out.print(allPoints.Positions[i]);
        }
        System.out.println("Black done ");
        for (int i = 16; i < 32; i++) {
            System.out.print(allPoints.Positions[i]);
        }
        System.out.println("White done ");

        if (index > 15) {

            for (int i = 0; i < 16; i++) {
                if (allPoints.Positions[index].equals(allPoints.Positions[i])) {
                    continue;
                }
                Point from = new Point(
                        allPoints.Positions[i].x / 80,
                        allPoints.Positions[i].y / 80
                );

                Point king = new Point(
                        allPoints.Positions[28].x / 80,
                        allPoints.Positions[28].y / 80
                );

                // System.out.println("king "+ king+"  From"+ from );
                if (i < 8 && MovingElement.ValidPawnMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 8 || i == 15) && MovingElement.ValidRookMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 9 || i == 14) && MovingElement.ValidKnightMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 10 || i == 13) && MovingElement.ValidBishopMoveBlack(from, king, i)) {
                    return false;
                }

                if (i == 11 && MovingElement.ValidQueenMoveBlack(from, king, i)) {
                    return false;
                }

                if (i == 12 && MovingElement.ValidKingMoveBlack(from, king, i)) {
                    return false;
                }

//
//
//
//if(i<8 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
//                if((i==8 || i==15)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
//                if((i==9 || i== 14) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
//                if((i==10 || i== 13) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
//                if(i==11 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i)) return false;
//                if(i==12 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], allPoints.Positions[28], i))return false;
//                
            }
            Indicator.isWhiteKingUnderAttack = false;
            return true;
        } else {
            for (int i = 16; i < 32; i++) {
                if (allPoints.Positions[index].equals(allPoints.Positions[i])) {
                    continue;
                }
                Point from = new Point(
                        allPoints.Positions[i].x / 80,
                        allPoints.Positions[i].y / 80
                );

                Point king = new Point(
                        allPoints.Positions[12].x / 80,
                        allPoints.Positions[12].y / 80
                );

                if (i < 24 && MovingElement.ValidPawnMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 24 || i == 31) && MovingElement.ValidRookMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 25 || i == 30) && MovingElement.ValidKnightMoveBlack(from, king, i)) {
                    return false;
                }

                if ((i == 26 || i == 29) && MovingElement.ValidBishopMoveBlack(from, king, i)) {
                    return false;
                }

                if (i == 27 && MovingElement.ValidQueenMoveBlack(from, king, i)) {
                    return false;
                }

                if (i == 28 && MovingElement.ValidKingMoveBlack(from, king, i)) {
                    return false;
                }

//                if(i<24 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], allPoints.Positions[13], i))return false;
//                if((i==24 || i==31)&&  MovingElement.ValidRookMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
//                if((i==25 || i== 30) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
//                if((i==26 || i== 29) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
//                if(i==27 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i)) return false;
//                if(i==28 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], allPoints.Positions[12], i))return false;
//            
            }
            Indicator.isBlackKingUnderAttack = false;
            return true;
        }

    }

    public static boolean IsMyKingSafeByOwn(int index, Point pnt) {

        if (index > 15) {
            for (int i = 0; i < 16; i++) {
                if (allPoints.Positions[index].equals(allPoints.Positions[i])) {
                    continue;
                }
                Point from = new Point(
                        allPoints.Positions[i].x / 80,
                        allPoints.Positions[i].y / 80
                );

                Point to = new Point(
                        pnt.x / 80,
                        pnt.y / 80
                );

                if (i < 8 && MovingElement.ValidPawnMoveBlack(from, to, i)) {
                    return false;
                }
                if ((i == 8 || i == 15) && MovingElement.ValidRookMoveBlack(from, to, i)) {
                    return false;
                }
                if ((i == 9 || i == 14) && MovingElement.ValidKnightMoveBlack(from, to, i)) {
                    return false;
                }
                if ((i == 10 || i == 13) && MovingElement.ValidBishopMoveBlack(from, to, i)) {
                    return false;
                }
                if (i == 11 && MovingElement.ValidQueenMoveBlack(from, to, i)) {
                    return false;
                }
                if (i == 12 && MovingElement.ValidKingMoveBlack(from, to, i)) {
                    return false;
                }

//                if (i < 8 && MovingElement.ValidPawnMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
//                if ((i == 8 || i == 15) && MovingElement.ValidRookMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
//                if ((i == 9 || i == 14) && MovingElement.ValidKnightMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
//                if ((i == 10 || i == 13) && MovingElement.ValidBishopMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
//                if (i == 11 && MovingElement.ValidQueenMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
//                if (i == 12 && MovingElement.ValidKingMoveBlack(allPoints.Positions[i], pnt, i)) {
//                    return false;
//                }
            }
            Indicator.isWhiteKingUnderAttack = false;
            return true;
        } else {
            for (int i = 16; i < 32; i++) {
 if (allPoints.Positions[index].equals(allPoints.Positions[i])) {
                    continue;
                }
 
  Point from = new Point(
                        allPoints.Positions[i].x / 80,
                        allPoints.Positions[i].y / 80
                );

                Point to = new Point(
                        pnt.x / 80,
                        pnt.y / 80
                );
 
 
 
 
                if (i < 24 && MovingElement.ValidPawnMoveBlack(from,to, i)) {
                    return false;
                }
                if ((i == 24 || i == 31) && MovingElement.ValidRookMoveBlack(from,to, i)) {
                    return false;
                }
                if ((i == 25 || i == 30) && MovingElement.ValidKnightMoveBlack(from,to, i)) {
                    return false;
                }
                if ((i == 26 || i == 29) && MovingElement.ValidBishopMoveBlack(from,to, i)) {
                    return false;
                }
                if (i == 27 && MovingElement.ValidQueenMoveBlack(from,to, i)) {
                    return false;
                }
                if (i == 28 && MovingElement.ValidKingMoveBlack(from,to, i)) {
                    return false;
                }
            }
            Indicator.isBlackKingUnderAttack = false;
            return true;
        }

    }

}
