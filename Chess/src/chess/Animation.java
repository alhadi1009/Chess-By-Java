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
public class Animation {

    public static void RookOfBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = new Point(present.x * 80, present.y * 80);

        if (TracSystem.IsMyKingSafe(index)) {

            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;

            panel.animateMove(index, past, present, () -> {

                MovingElement.IsVanished(index, allPoints.Positions[index]);
                if (index > 15) {

                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[12].x / 80;
                    present.y = allPoints.Positions[12].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidRookMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                } panel.repaint();

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = new Point(past.x * 80, past.y * 80);
        }
    }

    public static void KnightOfBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = new Point(present.x * 80, present.y * 80);

        if (TracSystem.IsMyKingSafe(index)) {

            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
           

            panel.animateMove(index, past, present, () -> {
                MovingElement.IsVanished(index, allPoints.Positions[index]);

                if (index > 15) {
                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[12].x / 80;
                    present.y = allPoints.Positions[12].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidKnightMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                } panel.repaint();

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = new Point(past.x * 80, past.y * 80);
        }
    }

    public static void BishopofBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = new Point(present.x * 80, present.y * 80);

        if (TracSystem.IsMyKingSafe(index)) {

            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
         
            panel.animateMove(index, past, present, () -> {

                MovingElement.IsVanished(index, allPoints.Positions[index]);

                if (index > 15) {
                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[12].x / 80;
                    present.y = allPoints.Positions[12].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidBishopMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                } panel.repaint();

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = new Point(past.x * 80, past.y * 80);
        }
    }

    public static void QueenOfBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = new Point(present.x * 80, present.y * 80);

        if (TracSystem.IsMyKingSafe(index)) {
            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }

            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;

            panel.animateMove(index, past, present, () -> {
                MovingElement.IsVanished(index, allPoints.Positions[index]);

                if (index > 15) {
                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[12].x / 80;
                    present.y = allPoints.Positions[12].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidQueenMoveBlack(past, present, index)) {
                    if (index > 15) {
                        System.out.println("Queen must check black");
                        Indicator.isBlackKingUnderAttack = true;
                    } else { System.out.println("Queen must check White");
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                }
               panel.repaint();

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = new Point(past.x * 80, past.y * 80);
        }
    }

    public static void KingOfBlack(ChessPanel panel, Point past, Point present, int index) {
System.out.println("this is the index of king "+ index);
System.out.println("TracSystem.IsMyKingSafeByOwn(index, present)"+TracSystem.IsMyKingSafeByOwn(index, present));
System.out.println(present);
        if (TracSystem.IsMyKingSafeByOwn(index, present)) {
            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;

            panel.animateMove(index, past, present, () -> {

                MovingElement.IsVanished(index, allPoints.Positions[index]);

                if (index > 15) {
                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[12].x / 80;
                    present.y = allPoints.Positions[12].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidKingMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                } panel.repaint();

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        }
    }

    public static void PawnOfBlack(ChessPanel panel, Point past, Point present, int index) {

        allPoints.Positions[index] = new Point(present.x * 80, present.y * 80);

        if (TracSystem.IsMyKingSafe(index)) {
            if (index <= 15) {
                Indicator.isBlackKingUnderAttack = false;
            } else {
                Indicator.isWhiteKingUnderAttack = false;
            }

            Point Pst = new Point(past.x * 80, past.y * 80);
            Point Psnt = new Point(present.x * 80, present.y * 80);

            panel.animateMove(index, Pst, Psnt, () -> {

                MovingElement.IsVanished(index, allPoints.Positions[index]);

                if (index > 15) {
                    Indicator.firstPersonIndicator = true;
                    Indicator.secondPersonIndicator = false;
                } else {
                    Indicator.firstPersonIndicator = false;
                    Indicator.secondPersonIndicator = true;
                }
                GameLogic.CheckGameOver();

                Pst.x = allPoints.Positions[index].x / 80;
                Pst.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    Psnt.x = allPoints.Positions[12].x / 80;
                    Psnt.y = allPoints.Positions[12].y / 80;

                } else {
                    Psnt.x = allPoints.Positions[28].x / 80;
                    Psnt.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidPawnMoveBlack(Pst, Psnt, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                } panel.repaint();
                

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = new Point(past.x * 80, past.y * 80);
        }
    }

}
