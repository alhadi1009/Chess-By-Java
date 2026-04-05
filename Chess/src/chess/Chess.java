package chess;

import javax.swing.*;
import java.awt.*;

public class Chess extends JFrame {

    Chess() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

   setLayout(new BorderLayout());

JPanel wrapper = new JPanel(); 
wrapper.add(new ChessPanel());

add(wrapper, BorderLayout.NORTH); 

        setVisible(true);
    }

    public static void main(String[] args) {
        new Chess();
    }
}