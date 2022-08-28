import java.awt.*;

import java.awt.Shape;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 512;
    final int PANEL_HEIGHT = 288;
    Image p1;
    Image p2;
    Image train1;
    Image train2;
    Image ball1;
    Image ball2;
    Image backgroundImage;
    Image p1box;
    Image p2box;
    Image txtbox;
    Image cursor;
    Image arena1;
    Image arena2;
    Timer timer;
    boolean flickering;
    int flickerCount;
    static String left1String = "Gary challenged you to a Pokemon battle!";
    static String left2String = "";
    static String right1String = "";
    static String right2String = "";
    static String pok1String = "";
    static String pok2String1 = "";
    static String pok2String2 = "";
    static String typeString = "";
    static Color thecolor1 = Color.GREEN;
    static Color thecolor2 = Color.GREEN;
    static float pok1_health = 96;
    static float pok2_health = 96;
    int x_pok1 = -300;
    int y_pok1 = 0;
    int x_pok2 = -300;
    int y_pok2 = 0;
    int x_train1 = 85;
    int x_train1_vel = -10;
    int x_train2 = 300;
    int x_train2_vel = 10;
    int x_ball1 = 60;
    int x_ball1_vel = 6;
    int y_ball1 = -145;
    int y_ball1_vel = -20;
    int x_ball2 = 420;
    int x_ball2_vel = -3;
    int y_ball2 = -400;
    int y_ball2_vel = -20;
    static int x_cursor = 20;
    static int y_cursor = 2100;


    MyPanel(){
        Random rand = new Random();
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        int r = rand.nextInt(8);
        switch (r) {
            case 0:
                p1 = new ImageIcon("groudback2.gif").getImage();
                y_pok1 = 90;
                break;
            case 1:
                p1 = new ImageIcon("blaziken2.gif").getImage();
                y_pok1 = 90;
                break;
            case 2:
                p1 = new ImageIcon("emboar2.gif").getImage();
                y_pok1 = 70;
                break;
            case 3:
                p1 = new ImageIcon("metagross2.gif").getImage();
                y_pok1 = 90;
                break;
            case 4:
                p1 = new ImageIcon("carracosta2.gif").getImage();
                y_pok1 = 80;
                break;
            case 5:
                p1 = new ImageIcon("garchomp2.gif").getImage();
                y_pok1 = 60;
                break;
            case 6:
                p1 = new ImageIcon("krookadile2.gif").getImage();
                y_pok1 = 55;
                break;
            case 7:
                p1 = new ImageIcon("torterra2.gif").getImage();
                y_pok1 = 45;
                break;
            default:
                p1 = new ImageIcon("groudback2").getImage();
                y_pok1 = 90;
                break;
        }
        int b = rand.nextInt(8);
        switch (b) {
            case 0:
                //HUGE make smaller
                p2 = new ImageIcon("bidoof1002.gif").getImage();
                y_pok2 = 15;
                break;
            case 1:
                p2 = new ImageIcon("ludicolo2.gif").getImage();
                y_pok2 = 0;
                break;
            case 2:
                p2 = new ImageIcon("bidoofS.gif").getImage();
                y_pok2 = 15;
                break;
            case 3:
                p2 = new ImageIcon("shuckle.gif").getImage();
                y_pok2 = 25;
                break;
            case 4:
                p2 = new ImageIcon("excadrill.gif").getImage();
                y_pok2 = 10;
                break;
            case 5:
                p2 = new ImageIcon("tyranitar.gif").getImage();
                y_pok2 = 5;
                break;
            case 6:
                p2 = new ImageIcon("ferrothorn.gif").getImage();
                y_pok2 = 0;
                break;
            case 7:
                p2 = new ImageIcon("rayquaza.gif").getImage();
                y_pok2 = 0;
                break;
            default:
                p2 = new ImageIcon("ball_00_open.png").getImage();
                y_pok2 = 0;
                break;
        }
        p1box = new ImageIcon("databox_normal.png").getImage();
        p2box = new ImageIcon("databox_normal_foe.png").getImage();
        txtbox = new ImageIcon("overlay_fight.png").getImage();
        cursor = new ImageIcon("cursor_fight.png").getImage();
        ball1 = new ImageIcon("ball_00.png").getImage();
        ball2 = new ImageIcon("ball_00.png").getImage();
        arena1 = new ImageIcon("playerbaseChampion.png").getImage();
        arena2 = new ImageIcon("enemybaseChampion.png").getImage();
        train1 = new ImageIcon("trainer000.png").getImage();
        train2 = new ImageIcon("trainer004.png").getImage();
        backgroundImage = new ImageIcon("battlebgField.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0,null);
        g2D.drawImage(arena1, -20, 145,null);
        g2D.drawImage(arena2, 245, 30,null);
        g2D.drawImage(p1, x_pok1, y_pok1, null);
        g2D.drawImage(p2, x_pok2, y_pok2, null);
        g2D.drawImage(train1, x_train1, 75, null);
        g2D.drawImage(train2, x_train2, -5, null);
        g2D.drawImage(txtbox, 15, 200, null);
        g2D.drawImage(p1box, 250, 120, null);
        g2D.drawImage(p2box, 0, 20, null);
        g2D.drawImage(cursor, x_cursor, y_cursor, null);
        g2D.drawString(left1String, 70, 232);
        g2D.drawString(right1String, 230, 232);
        g2D.drawString(left2String, 70, 260);
        g2D.drawString(right2String, 230, 260);
        g2D.drawString("Geoph                 Lv 100", 340, 150);
        g2D.drawString("Gary's mon                 Lv 100", 45, 55);
        g2D.drawString(pok1String, 340, 180);
        g2D.drawString(pok2String1, 30, 65);
        g2D.drawString(pok2String2, 30, 75);
        g2D.drawString(typeString, 415, 270);
        g2D.setColor(thecolor1);
        g2D.fillRect(398, 160, Math.round(pok1_health), 4);
        g2D.setColor(thecolor2);
        g2D.fillRect(100, 66, Math.round(pok2_health), 4);
        g2D.drawImage(ball1, x_ball1, y_ball1, null);
        g2D.drawImage(ball2, x_ball2, y_ball2, null);

    }

    //use as main method i guess??
    @Override
    public void actionPerformed(ActionEvent e) {

//        if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
//            xVelocity = xVelocity * -1;
//        }

        x_train1 += x_train1_vel;
        x_train2 += x_train2_vel;

        if (x_train1 == -35) {
            y_ball1 = 145;
            y_ball2 = 50;
        }

        if (y_ball1 >= 146) {
            y_ball1_vel = 0;
            y_ball1 = 2000;
        }
        else if (y_ball1 != -145) {
            y_ball1 += y_ball1_vel;
            y_ball1_vel += 2;
            x_ball1 += x_ball1_vel;
        }

        if (y_ball2 >= 52) {
            y_ball2_vel = 0;
            y_ball2 = 2000;
        }
        else if (y_ball2 != -400) {
            y_ball2 += y_ball2_vel;
            y_ball2_vel += 2;
            x_ball2 += x_ball2_vel;
        }

        if (y_ball1 == 2000) {
            x_pok1 = 100;
            x_pok2 = 300;
        }

        //while flashing is true

        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //use boolean variable for flashing pokemon
        repaint();

    }

    public Dimension getPreferredSize() {
            if (backgroundImage == null) {
                return new Dimension(100,100);
            } else {
                return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
            }
        }
}
