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

/**
 *
 * @author Al Hadi
 */
public class ChessPanel extends JPanel {

    ArrayList<ImageIcon> pieces = new ArrayList<>();
    private int selectedRow = -1;
    private int selectedCol = -1;

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
                            } else if ((pastIndex == 15 || pastIndex == 8) && MovingElement.ValidRookMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("All rook ");
                            } else if ((pastIndex == 9 || pastIndex == 14) && MovingElement.ValidKnightMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("Knight is running");
                            } else if ((pastIndex == 10 || pastIndex == 13) && MovingElement.ValidBishopMoveBlack(new Point(selectedCol, selectedRow), new Point(col, row), pastIndex)) {
                                System.out.println("bishop is running");
                            }// write next;

                        }

                    }

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
        System.out.println(pieces.size());

        g2D.drawImage(pieces.get(0).getImage(), 0, 480, 80, 80, this);
        g2D.drawImage(pieces.get(1).getImage(), 80, 480, 80, 80, this);
        g2D.drawImage(pieces.get(2).getImage(), 160, 480, 80, 80, this);
        g2D.drawImage(pieces.get(3).getImage(), 240, 480, 80, 80, this);
        g2D.drawImage(pieces.get(4).getImage(), 320, 480, 80, 80, this);
        g2D.drawImage(pieces.get(5).getImage(), 400, 480, 80, 80, this);
        g2D.drawImage(pieces.get(6).getImage(), 480, 480, 80, 80, this);
        g2D.drawImage(pieces.get(7).getImage(), 560, 480, 80, 80, this);// Add all pawns in the board 
        g2D.drawImage(pieces.get(8).getImage(), 0, 560, 80, 80, this);
        g2D.drawImage(pieces.get(9).getImage(), 80, 560, 80, 80, this);

        g2D.drawImage(pieces.get(10).getImage(), 160, 560, 80, 80, this);
        g2D.drawImage(pieces.get(11).getImage(), 240, 560, 80, 80, this);
        g2D.drawImage(pieces.get(12).getImage(), 320, 560, 80, 80, this);
        g2D.drawImage(pieces.get(13).getImage(), 400, 560, 80, 80, this);
        g2D.drawImage(pieces.get(14).getImage(), 480, 560, 80, 80, this);
        g2D.drawImage(pieces.get(15).getImage(), 560, 560, 80, 80, this);

        // g2D.drawImage(pieces.get(15).getImage(), 0, 0, 80, 80, this);
        g2D.drawImage(pieces.get(16).getImage(), 0, 80, 80, 80, this);
        g2D.drawImage(pieces.get(17).getImage(), 80, 80, 80, 80, this);
        g2D.drawImage(pieces.get(18).getImage(), 160, 80, 80, 80, this);
        g2D.drawImage(pieces.get(19).getImage(), 240, 80, 80, 80, this);

        g2D.drawImage(pieces.get(20).getImage(), 320, 80, 80, 80, this);
        g2D.drawImage(pieces.get(21).getImage(), 400, 80, 80, 80, this);
        g2D.drawImage(pieces.get(22).getImage(), 480, 80, 80, 80, this);
        g2D.drawImage(pieces.get(23).getImage(), 560, 80, 80, 80, this);
        // Draw all White pawn; 
        // g2D.drawImage(pieces.get(16).getImage(), 80, 320, 80, 80, this);

        g2D.drawImage(pieces.get(24).getImage(), 0, 0, 80, 80, this);
        g2D.drawImage(pieces.get(25).getImage(), 80, 0, 80, 80, this);
        g2D.drawImage(pieces.get(26).getImage(), 160, 0, 80, 80, this);
        g2D.drawImage(pieces.get(27).getImage(), 240, 0, 80, 80, this);

        g2D.drawImage(pieces.get(28).getImage(), 320, 0, 80, 80, this);
        g2D.drawImage(pieces.get(29).getImage(), 400, 0, 80, 80, this);
        g2D.drawImage(pieces.get(30).getImage(), 480, 0, 80, 80, this);
        g2D.drawImage(pieces.get(31).getImage(), 560, 0, 80, 80, this);

    }
}
