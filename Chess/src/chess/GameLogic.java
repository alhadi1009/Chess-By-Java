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
public class GameLogic {
    
    public static boolean KingHasMove(int kingIndex)
{
    Point kingPos = allPoints.Positions[kingIndex];

    int x = kingPos.x / 80;
    int y = kingPos.y / 80;

    for(int dx = -1; dx <= 1; dx++)
    {
        for(int dy = -1; dy <= 1; dy++)
        {
            if(dx == 0 && dy == 0) continue;

            int nx = x + dx;
            int ny = y + dy;

            if(nx >= 0 && nx < 8 && ny >= 0 && ny < 8)
            {
                Point newPos = new Point(nx, ny);

                if(MovingElement.ValidKingMoveBlack(
                        new Point(x, y), newPos, kingIndex))
                {
                    if(TracSystem.IsMyKingSafeByOwn(kingIndex, newPos))
                    {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}
    
    
 public static boolean HasAnyMove(boolean isBlack)
{
    int start = isBlack ? 0 : 16;
    int end   = isBlack ? 16 : 32;

    for(int i = start; i < end; i++)
    {
        if(allPoints.Positions[i] == null) continue;

        Point past = new Point(
            allPoints.Positions[i].x / 80,
            allPoints.Positions[i].y / 80
        );

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                Point present = new Point(x, y);

                boolean valid = false;

                if(i < 8 || (i >= 16 && i < 24))
                    valid = MovingElement.ValidPawnMoveBlack(past, present, i);
                else if(i == 8 || i == 15 || i == 24 || i == 31)
                    valid = MovingElement.ValidRookMoveBlack(past, present, i);
                else if(i == 9 || i == 14 || i == 25 || i == 30)
                    valid = MovingElement.ValidKnightMoveBlack(past, present, i);
                else if(i == 10 || i == 13 || i == 26 || i == 29)
                    valid = MovingElement.ValidBishopMoveBlack(past, present, i);
                else if(i == 11 || i == 27)
                    valid = MovingElement.ValidQueenMoveBlack(past, present, i);
                else if(i == 12 || i == 28)
                    valid = MovingElement.ValidKingMoveBlack(past, present, i);

                if(valid)
                {
                    if(TracSystem.IsMyKingSafeByOwn(i, present))
                    {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}   
    
    public static void CheckGameOver()
{
    // Black turn ended → check white
    if(Indicator.firstPersonIndicator)
    {
        boolean kingSafe = TracSystem.IsMyKingSafe(28);

        if(!HasAnyMove(false)) // white has no move
        {
            if(!kingSafe)
            {
                System.out.println("CHECKMATE! BLACK WINS");
            }
            else
            {
                System.out.println("STALEMATE!");
            }
        }
    }

    // White turn ended → check black
    else
    {
        boolean kingSafe = TracSystem.IsMyKingSafe(12);

        if(!HasAnyMove(true)) // black has no move
        {
            if(!kingSafe)
            {
                System.out.println("CHECKMATE! WHITE WINS");
                
            }
            else
            {
                System.out.println("STALEMATE!");
            }
        }
    }
}
    
    
    
}
