/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Al Hadi
 */
public class ChessPanel extends JPanel {

    ArrayList<ImageIcon> pieces = new ArrayList<>();
    public static int selectedRow = -1;
    public static int selectedCol = -1;
    private Timer timer;

    ChessPanel() {
        setPreferredSize(new Dimension(650, 650));

        JLabel label = new JLabel("..");
        add(label);

        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnBlack.png")));// Pawn Black all Stored in array list by me(HD) ; ; 

        pieces.add(new ImageIcon(getClass().getResource("Image/rookBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/knightBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/bishopBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/queenBlack.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/kingBlack.png")));// Black images Stored ;  ;

        pieces.add(new ImageIcon(getClass().getResource("Image/bishopBlack.png")));// Bishop Black stored 
        pieces.add(new ImageIcon(getClass().getResource("Image/knightBlack.png")));

        pieces.add(new ImageIcon(getClass().getResource("Image/rookBlack.png")));// Rook Black stored 
        // Knight Black stored 

        // start white 
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/pawnWhite.png")));

// Pawn White all Stored in array list by me(HD) ; ; 
        pieces.add(new ImageIcon(getClass().getResource("Image/rookWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/knightWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/bishopWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/queenWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/kingWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/bishopWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/knightWhite.png")));
        pieces.add(new ImageIcon(getClass().getResource("Image/rookWhite.png")));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //  System.out.println("value of X" + e.getX() / 80);
                //System.out.println("value of Y" + e.getY() / 80);

                if (Indicator.firstPersonIndicator) {
                    Indicator.secondPersonIndicator = false;
                    int col = e.getX() / 80;
                    int row = e.getY() / 80;

                    Point target = new Point(col * 80, row * 80);
                    if (LoopingSystem.isPlayerPositioned(target) && LoopingSystem.isPlayerIndex(target) <= 15) {
                        // System.out.println("hello World!");
                        if (row == selectedRow && col == selectedCol) {
                            selectedRow = -1;
                            selectedCol = -1;
                        } else {
                            // Select new square
                            selectedRow = row;
                            selectedCol = col;
                        }
                        repaint();
                    } else {
                        if (selectedRow != -1 && selectedCol != -1) {
                            int pastIndex = LoopingSystem.isPlayerIndex(new Point(selectedCol * 80, selectedRow * 80));
                            int presentIndex = LoopingSystem.isPlayerIndex(new Point(col * 80, row * 80));

                            System.out.println("Past index" + pastIndex);
                            System.out.println("present index" + presentIndex);
                            // 0 to 7 ok remember it hadi ;
                            if (pastIndex >= 0 && pastIndex <= 7 && MovingElement.ValidPawnMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
// Write that code function . because Black Pawn could move // and last check king 
                                System.out.println("Black Pawn");
                                Animation.PawnOfBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                // is it well
                            } else if ((pastIndex == 15 || pastIndex == 8) && MovingElement.ValidRookMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("All rook " + allPoints.Positions[pastIndex]);

                                Animation.RookOfBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                 //Hope it well
                            } else if ((pastIndex == 9 || pastIndex == 14) && MovingElement.ValidKnightMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("Knight is running");
                                Animation.KnightOfBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                //Hope it well
                            } else if ((pastIndex == 10 || pastIndex == 13) && MovingElement.ValidBishopMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("bishop is running");
                                Animation.BishopofBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                //Hope it well
                            }// write next;
                            else if ((pastIndex == 11) && MovingElement.ValidQueenMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("Queen is moving");
                                Animation.QueenOfBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                //Hope it well
                            } else if (pastIndex == 12 && MovingElement.ValidKingMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("king is moving");
                                Animation.KingOfBlack(ChessPanel.this, new Point(selectedCol, selectedRow), new Point(col, row), pastIndex);
                                //Hope it well
                            }

                        }

                    }
                    // will be mood change ;

                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(1));
        int cell = 80;

        // 1️⃣ Draw board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    //g2D.setColor(Color.BLUE);//WHITE
                    //g2D.setColor(Color.WHITE);
                    g2D.setColor(Color.decode("#F0D9B5"));
                } else {
                    //    g2D.setColor(Color.GREEN);//GRAY
                    //  g2D.setColor(Color.GRAY);
                    g2D.setColor(Color.decode("#B58863"));

                }
                if (row == selectedRow && col == selectedCol) {
                    g2D.setColor(Color.YELLOW); // highlight color
                }
                g2D.fillRect(col * cell, row * cell, cell, cell); // col=x, row=y
            }
        }

        for (int i = 0; i < 32; i++) {
            if (allPoints.Positions[i] != null) {
                g2D.drawImage(
                        pieces.get(i).getImage(),
                        allPoints.Positions[i].x,
                        allPoints.Positions[i].y,
                        80, 80, this
                );
            }
        }
        System.out.println(pieces.size());

    }

    public void animateMove(int index, Point start, Point end, Runnable callback) {

        // Set initial position
        allPoints.Positions[index] = new Point(start.x, start.y);

        int speed = 8;

        Timer timer = new Timer(2, e -> {
            Point current = allPoints.Positions[index];
            int x = current.x;
            int y = current.y;

            // Move toward target
            if (x < end.x) {
                x += speed;
            }
            if (x > end.x) {
                x -= speed;
            }

            if (y < end.y) {
                y += speed;
            }
            if (y > end.y) {
                y -= speed;
            }

            allPoints.Positions[index] = new Point(x, y);
            repaint();

            // Stop condition
            if (Math.abs(x - end.x) <= speed && Math.abs(y - end.y) <= speed) {
                allPoints.Positions[index] = new Point(end.x, end.y);
                ((Timer) e.getSource()).stop(); // stop this timer
                if (callback != null) {
                    callback.run();
                }
            }
        });

        timer.start();
        System.out.println(allPoints.Positions[index]);
    }

}
