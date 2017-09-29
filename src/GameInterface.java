import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameInterface extends JFrame {

    static JButton[] jb = new JButton[16];

    static public int[] getAllJbNum() {
        int[] numbs = new int[16];
        for (int i = 0; i < 16; i++) {
            if (jb[i].getText()==null || jb[i].getText()==""){
                numbs[i] = 0;
            }else {
                numbs[i] = Integer.parseInt(jb[i].getText().trim());
            }
        }
        return numbs;
    }

    static public void setJb(int numb, int position) {
        if (numb ==0){
            jb[position].setText("");
            jb[position].setBackground(new Color(200,200,200));
        }else if(numb == 2) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(150,200,100));
        }else if(numb == 4) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(200,100,100));
        }else if(numb == 8) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,100,100));
        }else if(numb == 16) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,150,100));
        }else if(numb == 32) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,200,100));
        }else if(numb == 64) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,250,100));
        }else if(numb == 128) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(100,250,100));
        }else if(numb == 256) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(100,100,250));
        }else if(numb == 512) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(70,250,250));
        }else if(numb == 1024) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,70,100));
        }else if(numb == 2048) {
            jb[position].setText(Integer.toString(numb));
            jb[position].setBackground(new Color(250,200,200));
        }
    }

    public GameInterface() {
        JFrame jFrame = new JFrame("2048");
        JPanel jPanel = new JPanel();

        for(int i=0; i<16; i++){
            jb[i] = new JButton();
            jb[i].setFont(new Font("Arial", Font.BOLD, 24));
            jPanel.add(jb[i]);
            jb[i].setBackground(new Color(200,200,200));
        }

        jPanel.setLayout(new GridLayout(4,4));
        jPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    try {
                        Logic.moveUp();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("up pressed");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    try {
                        Logic.moveDown();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("down pressed");
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    try {
                        Logic.moveLeft();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("left pressed");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    try {
                        Logic.moveRight();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("right pressed");
                }
            }
        });

        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(500,500);

        jPanel.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                jPanel.requestFocus();
            }
        });
        jPanel.setFocusable(true);
    }

    public static void victory() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            jb[i].setBackground(new Color(200,100,200));
            jb[i].setText("");
        }
        jb[4].setText("Y");
        jb[5].setText("O");
        jb[6].setText("U");
        jb[8].setText("W");
        jb[9].setText("I");
        jb[10].setText("N");
        Thread.sleep(4000);

        for (int i = 0; i < 16; i++) {
            jb[i].setText("");
            jb[i].setBackground(new Color(200,200,200));
        }
        Logic.addNewNumbs();
    }
}
