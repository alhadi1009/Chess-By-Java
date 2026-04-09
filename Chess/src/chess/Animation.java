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
        allPoints.Positions[index] = present;
        if (TracSystem.IsMyKingSafe(index)) {
            // Convert board coordinates to pixels
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("Rook move completed!");
                MovingElement.IsVanished(index, allPoints.Positions[index]);
                 if(index>15)
                  {
                      
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }
                
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

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
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = past;
        }
    }

    public static void KnightOfBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = present;

        if (TracSystem.IsMyKingSafe(index)) {
            // Convert board coordinates to pixels
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("Knight move completed!");
                
                                MovingElement.IsVanished(index, allPoints.Positions[index]);

                 if(index>15)
                  {
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }
                
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

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
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = past;
        }
    }

    public static void BishopofBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = present;

        if (TracSystem.IsMyKingSafe(index)) {
            // Convert board coordinates to pixels
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("Bishop move completed!");
                                MovingElement.IsVanished(index, allPoints.Positions[index]);

                
                 if(index>15)
                  {
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }
                 
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

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
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = past;
        }
    }

    public static void QueenOfBlack(ChessPanel panel, Point past, Point present, int index) {
        allPoints.Positions[index] = present;

        if (TracSystem.IsMyKingSafe(index)) {
            // Convert board coordinates to pixels
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("Queen move completed!");
                                MovingElement.IsVanished(index, allPoints.Positions[index]);

                  if(index>15)
                  {
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }

                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidQueenMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = past;
        }
    }

    public static void KingOfBlack(ChessPanel panel, Point past, Point present, int index) {
        if (TracSystem.IsMyKingSafeByOwn(index, present)) {

            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("King move completed!");
                                MovingElement.IsVanished(index, allPoints.Positions[index]);

                 if(index>15)
                  {
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

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
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        }
    }
    public static void PawnOfBlack(ChessPanel panel, Point past, Point present, int index)
    {
         allPoints.Positions[index] = present;

        if (TracSystem.IsMyKingSafe(index)) {
            // Convert board coordinates to pixels
            past.x *= 80;
            past.y *= 80;
            present.x *= 80;
            present.y *= 80;
            System.out.println("hello");
            // Animate move with callback
            panel.animateMove(index, past, present, () -> {
                // Callback runs after animation finishes
                System.out.println("Pawn move completed!");
                                MovingElement.IsVanished(index, allPoints.Positions[index]);

                 if(index>15)
                  {
                      Indicator.firstPersonIndicator=true;
                      Indicator.secondPersonIndicator=false;
                  }else 
                  {
                      Indicator.firstPersonIndicator=false;
                      Indicator.secondPersonIndicator=true;
                  }
                 
                 
                past.x = allPoints.Positions[index].x / 80;
                past.y = allPoints.Positions[index].y / 80;
                if (index > 15) {
                    present.x = allPoints.Positions[13].x / 80;
                    present.y = allPoints.Positions[13].y / 80;

                } else {
                    present.x = allPoints.Positions[28].x / 80;
                    present.y = allPoints.Positions[28].y / 80;
                }

                if (MovingElement.ValidPawnMoveBlack(past, present, index)) {
                    if (index > 15) {
                        Indicator.isBlackKingUnderAttack = true;
                    } else {
                        Indicator.isWhiteKingUnderAttack = true;
                    }
                }

            });
            ChessPanel.selectedCol = -1;
            ChessPanel.selectedRow = -1;
        } else {
            allPoints.Positions[index] = past;
        }
    }

}
