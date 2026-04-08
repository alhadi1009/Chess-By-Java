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
        if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
            int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
            System.out.println("1");
            if ((check <= 0 && check > 15 && index > 15) || (check <= 15 && index <= 15)) {
                return false;
            }
            if ((index > 15 && check == 12) || (index <= 15 && check == 28)) {
                return false;
            }
        }

        if (Math.abs(present.x - past.x) > 1 || Math.abs(present.y - past.y) > 2) {
            return false;
        }
        if (index < 8) {
            if (present.x == past.x && past.y - present.y == 2 && BlackPawn.get(index)) {
                BlackPawn.set(index, false);
                return true;
            }
            if (present.x == past.x && past.y - present.y == 1 && !(LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80)))) {
                BlackPawn.set(index, false);
                return true;
            }
            if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
                int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
                if (Math.abs(present.x - past.x) == 1 && past.y - present.y == 1 && check >= 16) {
                    return true;
                }

            }
        } else { // int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
            if (present.x == past.x && present.y - past.y == 2 && WhitePawn.get(index)) {
                WhitePawn.set(index, false);
                return true;
            }
            if (present.x == past.x && present.y - past.y == 1 && (!LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80)))) {
                WhitePawn.set(index, false);
                return true;
            }
            if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
                int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
                if (Math.abs(present.x - past.x) == 1 && present.y - past.y == 1 && check < 16) {
                    return true;
                }

            }

        }
        return false;
    }

    // THIS PART IS COMPLETE ; OK 
    public static boolean ValidRookMoveBlack(Point past, Point present, int index) {

        System.out.println("past.x" + past.x + "past.y" + past.y + "present.x" + present.x + "present.y" + present.y);
        if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
            int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
            System.out.println("1");
            if ((check <= 0 && check > 15 && index > 15) || (check <= 15 && index <= 15)) {
                return false;
            }
            if ((index > 15 && check == 12) || (index <= 15 && check == 28)) {
                return false;
            }
        }
        if (past.x == present.x) {
            if (past.y > present.y) {
                for (int i = 1; i < past.y - present.y; i++) {
                    if (LoopingSystem.isPlayerPositioned(new Point(past.x * 80, (past.y - i) * 80))) {
                        return false;
                    }
                }
                return true;
            } else if (past.y < present.y) {
                for (int i = 1; i < present.y - past.y; i++) {
                    if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, (present.y - i) * 80))) {
                        return false;
                    }
                    //  System.out.println("one{}"+present.x * 80+"  "+ (present.y-i) * 80);
                }
                return true;
            }
        } else if (past.y == present.y) {
            if (past.x > present.x) {
                for (int i = 1; i < past.x - present.x; i++) {
                    if (LoopingSystem.isPlayerPositioned(new Point((past.x - i) * 80, past.y * 80))) {
                        return false;
                    }
                }
                return true;
            } else if (past.x < present.x) {
                for (int i = 1; i < present.x - past.x; i++) {
                    if (LoopingSystem.isPlayerPositioned(new Point((present.x - i) * 80, present.y * 80))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean ValidKnightMoveBlack(Point past, Point present, int index) {
        if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
            int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
            System.out.println("1");
            if ((check <= 0 && check > 15 && index > 15) || (check <= 15 && index <= 15)) {
                return false;
            }
            if ((index > 15 && check == 12) || (index <= 15 && check == 28)) {
                return false;
            }
        }
        int X1 = Math.abs(present.x - past.x);
        int Y1 = Math.abs(present.y - past.y);
        if ((X1 == 1 && Y1 == 2) || (X1 == 2 && Y1 == 1)) {
            return true;
        }

        return false;
    }

    public static boolean ValidBishopMoveBlack(Point past, Point present, int index) {
        if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
            int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
            if ((check <= 0 && check > 15 && index > 15) || (check <= 15 && index <= 15)) {
                return false;
            }
            if ((index > 15 && check == 12) || (index <= 15 && check == 28)) {
                return false;
            }
        }

        int X1 = Math.abs(present.x - past.x);
        int Y1 = Math.abs(present.y - past.y);
        if (X1 != Y1) {
            return false;
        }
        if (present.x > past.x && present.y > past.y) {
            for (int i = 1; i < X1; i++) {
                if (LoopingSystem.isPlayerPositioned(new Point((past.x + i) * 80, (past.y + i) * 80))) {
                    return false;
                }
            }
            return true;
        } else if (present.x < past.x && present.y < past.y) {
            for (int i = 1; i < X1; i++) {
                if (LoopingSystem.isPlayerPositioned(new Point((past.x - i) * 80, (past.y - i) * 80))) {
                    return false;
                }
            }
            return true;
        } else if (present.x < past.x && present.y > past.y) {
            for (int i = 1; i < X1; i++) {
                if (LoopingSystem.isPlayerPositioned(new Point((past.x - i) * 80, (past.y + i) * 80))) {
                    return false;
                }
            }
            return true;
        } else if (present.x > past.x && present.y < past.y) {
            for (int i = 1; i < X1; i++) {
                if (LoopingSystem.isPlayerPositioned(new Point((past.x + i) * 80, (past.y - i) * 80))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean ValidQueenMoveBlack(Point past, Point present, int index) {

        return (ValidBishopMoveBlack(past, present, index) | ValidRookMoveBlack(past, present, index));
    }

    public static boolean ValidKingMoveBlack(Point past, Point present, int index) {
        int X1 = Math.abs(past.x - present.x);
        int Y1 = Math.abs(past.y - present.y);
        if (X1 <= 1 && Y1 <= 1) {
            if (LoopingSystem.isPlayerPositioned(new Point(present.x * 80, present.y * 80))) {
                int check = LoopingSystem.isPlayerIndex(new Point(present.x * 80, present.y * 80));
                System.out.println("1");
                if ((check <= 0 && check > 15 && index > 15) || (check <= 15 && index <= 15)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
