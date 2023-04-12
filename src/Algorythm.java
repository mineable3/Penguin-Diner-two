import java.awt.*;
import java.awt.event.InputEvent;
import java.security.Timestamp;
import java.util.ArrayList;

public class Algorythm {

    //top left of the screen is (0,0)
    //bottom right of the screen is (1365, 767)
    //total area is 1,046,955 pixels

    //The carpet is at x=279 and y=424
    //The carpet's RBG is r=145,g=141,b=175

    //top left x=489,y=314;
        //left seat at x=402,y=394--------r=169,g=205,b=208
        //right seat at x=582,y=338--------r=173,g=208,b=210
    //top right x=804,y=314
        //left seat at x=712,y=373--------r=171,g=207,b=209
        //right seat at x=899,y=370--------r=170,g=207,b=209
    //mid x=627,y=426
        //left seat at x=520,y=471--------r=145,g=190,b=193
        //right seat at x=721,y=442--------r=145,g=190,b=193
    //bottom right x=748,y=520
        //left seat at x=652,y=561--------r=145,g=190,b=193
        //right seat at x=841,y=563--------r=145,g=190,b=193
    //bottom left x=426,y=518
        //left seat at x=329,y=565--------r=145,g=190,b=193
        //right seat at x=521,y=571--------r=145,g=190,b=193


    //start next day x=426,y=597
    //catalog x=744,y=597
    //location where the first order will show up x=308,y=689
    //location where the second order will show up x=367,y=689
    //location where the third order will show up x=425,y=689
    //Resume game button is at x=569,y=386



    public static boolean playing = true;

    private static int timesLooped;



    public final static Color carpetColor = new Color(145, 141, 175);

    public final static Table topLeft = new Table(489, 344);
    public final static Table topRight = new Table(804, 344);
    public final static Table mid = new Table(627, 456);
    public final static Table bottomRight = new Table(748, 550);
    public final static Table bottomLeft = new Table(426, 548);

    public static Color LTL = new Color(169, 205, 208); //Left seat at the top left table
    public static Color RTL = new Color(173, 208, 210); //Right seat at the top left table
    public static Color LTR = new Color(171, 207, 209); //Left seat at the top right table
    public static Color RTR = new Color(170, 207, 209); //Right seat at the top right table
    public static Color LM = new Color(145, 190, 193); //Left seat at the mid table
    public static Color RM = new Color(145, 190, 193); //Right seat at the mid table
    public static Color LBR = new Color(145, 190, 193); //Left seat at the bottom right table
    public static Color RBR = new Color(145, 190, 193); //Right seat at the bottom right table
    public static Color LBL = new Color(145, 190, 193); //Left seat at the bottom left table
    public static Color RBL = new Color(145, 190, 193); //Right seat at the bottom left table

    public static ArrayList<Penguin> customers = new ArrayList<Penguin>();



//=========================DO NOT TOUCH============================
    public static void setUp() {
        try{

            //letting you switch to the tab your playing on
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {}

            Robot robot = new Robot();

            //moving to the top of the screen
            robot.mouseWheel(-100);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {}

            //scrolling to the preset position
            robot.mouseWheel(3);
            clickOnLocation(569, 386);
        } catch (AWTException e) {}
    }





    /**
     *a simple method to make the current thread go to sleep
     * @param timeToSleep
     * the amount of time to have the current Thread sleep in milliseconds
     */
    public static void sleep(int timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException np) {}
    }



    //
    public static void clickOnLocation(int x, int y) {
        try {
            Robot robot = new Robot();
            sleep(100);
            robot.mouseMove(x, y);
            sleep(50);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Algorythm.sleep(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e){}
    }




    public static void clickCarpet() {
            clickOnLocation(279, 424);
            //System.out.println("Done clicking on the carpet!");
    }





    public static void seat() {

        sleep(100);

        clickCarpet();

        sleep(100);


        //checking which tables are empty and clicking on the first empty table
        if (!topLeft.getHasCostumer() && !topLeft.getHasTwins()) {
            topLeft.clickTable();
            topLeft.setHasCostumer(true);
            Penguin tl = new Penguin(System.currentTimeMillis(), topLeft);
            customers.add(tl);

        } else if (!topRight.getHasCostumer() && !topRight.getHasTwins()) {
            topRight.clickTable();
            topRight.setHasCostumer(true);
            Penguin tr = new Penguin(System.currentTimeMillis(), topRight);
            customers.add(tr);

        } else if (!mid.getHasCostumer() && !mid.getHasTwins()) {
            mid.clickTable();
            mid.setHasCostumer(true);
            Penguin m = new Penguin(System.currentTimeMillis(), mid);
            customers.add(m);

        } else if (!bottomRight.getHasCostumer() && !bottomRight.getHasTwins()) {
            bottomRight.clickTable();
            bottomRight.setHasCostumer(true);
            Penguin br = new Penguin(System.currentTimeMillis(), bottomRight);
            customers.add(br);

        } else if (!bottomLeft.getHasCostumer() && !bottomLeft.getHasTwins()) {
            bottomLeft.clickTable();
            bottomLeft.setHasCostumer(true);
            Penguin bl = new Penguin(System.currentTimeMillis(), bottomLeft);
            customers.add(bl);

        } else {
            System.out.println("All tables are full!");
        }
    }


    public static Robot robot() {
        try {
            Robot robot = new Robot();
            return robot;
        } catch (AWTException e) {}
        return null;
    }

    public static boolean uThere(int xLocation) {
        boolean hasCostumer = true;
        switch (xLocation) {
            case 489:
                //topleft
                System.out.println(489);
                if((robot().getPixelColor(402, 394) != LTL) || (robot().getPixelColor(582, 338) != RTL)) {
                    hasCostumer = true;
                } else {
                    hasCostumer = false;
                }
                break;

            case 804:
                //topright
                System.out.println(804);
                if((robot().getPixelColor(712, 373) != LTR) || (robot().getPixelColor(899, 370) != RTR)) {
                    hasCostumer = true;
                } else {
                    hasCostumer = false;
                }
                break;

            case 627:
                //mid
                System.out.println(627);
                System.out.println(robot().getPixelColor(520, 471) + "  " + robot().getPixelColor(721, 442));
                if((robot().getPixelColor(520, 471) == LM) && (robot().getPixelColor(721, 442) == RM)) {
                    hasCostumer = false;
                    System.out.println("truee");
                } else {
                    hasCostumer = true;
                }
                break;

            case 748:
                //bottomright
                System.out.println(748);
                if((robot().getPixelColor(652, 561) != LBR) || (robot().getPixelColor(841, 563) != RBR)) {
                    hasCostumer = true;
                } else {
                    hasCostumer = false;
                }
                break;

            case 426:
                //bottomleft
                System.out.println(426);
                if((robot().getPixelColor(329, 565) != LBL) || (robot().getPixelColor(521, 571) != RBL)) {
                    hasCostumer = true;
                } else {
                    hasCostumer = false;
                }
                break;

            default:
                break;
        }
        return false;//it never worked.
                    //Literally not a single time so I'm giving up and making it always return false
    }

    public static void removeCostumers(Penguin costumer) {
        if(!uThere(costumer.getTable().getxLocation())) {
            if (costumer.getNeedsToGo()) {
                customers.remove(costumer);
            }
        }
    }






    public static boolean checkForCustomer() {
        try {
            Robot robot = new Robot();

            if (carpetColor.equals(robot.getPixelColor(279, 424))) {
                return false;
            }
        } catch (AWTException e) {}
        
        return true;
    }




    public static boolean mouseMoved(Point p) {
        try {
            Robot robot = new Robot();
            Point newP = MouseInfo.getPointerInfo().getLocation();
            if (Math.round(p.getY() + p.getX()) == Math.round(newP.getY() + newP.getX())) {
                return false;
            }
        } catch (AWTException e) {}
        
        return true;
    }






    public static void main(String[] args){
        setUp();
        System.out.println("Done setting up!");
        sleep(1000);



        //what will actually run during a day
        for (int i = 0; (i < 1000) && playing; i++) {

            sleep(500);
            if(checkForCustomer()) {
                seat();
                System.out.println("Just seated a new customer!");
            } else {
                System.out.println("No customer found :(");
            }

            for (int o = (customers.size()); o > 0; o--) {
                removeCostumers(customers.get(o - 1));
                try{
                    customers.get(o - 1).checkForNeeds();
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("We made it throught the day!");
                    System.out.println("Hurray!");
                    playing = false;
                    break;
                }
                System.out.println();
            }

            Point p = MouseInfo.getPointerInfo().getLocation();
            sleep(100);
            if(mouseMoved(p)) {
                playing = false;
                System.out.println("MOUSE MOVED----SHUTTING DOWN PROGRAM");
            }

            System.out.println("\n\n");

            if(i == 999){
                System.out.println("LOOP OVERRUN-----------");
            }
            timesLooped = i;
        }

        System.out.println("ESCAPED THE LOOP SOME WAY OR ANOTHER");
        System.out.println("the loop ran for " + timesLooped + " iterations");
    }
}
