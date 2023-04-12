import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Testing extends JFrame{


    //The carpet is at x=279 and y=424
    //The carpet's RBG is r=145,g=141,b=175
    //top left x=489,y=314;
    //top right x=804,y=314
    //mid x=627,y=426
    //bottom right x=748,y=520
    //bottom left x=426,y=518
    //start next day x=426,y=597
    //catalog x=744,y=597
    //location where the first order will show up x=308,y=689
    //location where the second order will show up x=367,y=689
    //location where the third order will show up x=425,y=689

    private static JFrame f = new JFrame();
    private static JTextArea ta = new JTextArea();
    private static Point p = MouseInfo.getPointerInfo().getLocation();

    private static boolean down = false;
    public static void main(String[] args) {


        ta.setEditable(false);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 400);
        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 75));
        f.add(scrollPane);
        f.setAlwaysOnTop(true);
        f.setResizable(true);
        f.setLocation(1165, 0);

        f.setVisible(true);
        System.out.println("=====1=======");
        ta.append(p.toString() + "\n");
        ta.append(p.toString() + "\n");
        f.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                down = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                down = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });

        System.out.println("======2=====");

        


        
        Table topLeft = new Table(489, 314);
        Table topRight = new Table(804, 314);
        Table mid = new Table(627, 426);
        Table bottomRight = new Table(748, 520);
        Table bottomLeft = new Table(426, 518);

        Algorythm.setUp();
        //mid.clickTable();

        //just getting coordinates and rbg values
        try {

            Robot robot = new Robot();
            
            //Algorythm.clickOnLocation(308, 689);//where the food will appear

            Algorythm.sleep(1000);

            ta.append(robot.getPixelColor(402, 394).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(582, 338).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(712, 373).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(899, 370).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(520, 471).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(721, 442).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(652, 561).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(841, 563).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(329, 565).toString() + "\n");
            Algorythm.sleep(500);
            ta.append(robot.getPixelColor(521, 571).toString() + "\n");
            Algorythm.sleep(500);

            for(int i = 1; i < 3; i++) {
                Point p = MouseInfo.getPointerInfo().getLocation();

                //System.out.println(p);
                //System.out.println(System.currentTimeMillis());
                //System.out.println(robot.getPixelColor((int)p.getX(), (int)p.getY()));
                
                //System.out.println(java.awt.event.KeyEvent.getKeyText(i));
                //ta.append(p.toString() + "\n");
                
                //System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    System.out.println("The program was interupted");
                }
            }
        } catch (AWTException e) {}
    }
}
