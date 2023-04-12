import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Table {
    
    boolean hasCostumer = false,
    hasTwins = false,
    hasOrder = false,
    isEating = false,
    hasTip = false;

    private int xLocation, yLocation, order;

    


    /**
     * @param inXCoord
     * the X coordinate of the pixel on the table to click
     * @param inYCoord
     * the Y coordinate of the pixel on the table to click
     */
    public Table(int inXCoord, int inYCoord) {
        xLocation = inXCoord;
        yLocation = inYCoord;
    }


    public void clickTable() {
        try {
            Robot robot = new Robot();

            Algorythm.sleep(100);
            robot.mouseMove(xLocation, yLocation);
            Algorythm.sleep(100);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Algorythm.sleep(100);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            System.out.println("Clicked on table at (" + xLocation + ", " + yLocation + ")");
        } catch (AWTException e) {
            System.out.println("It seems the program is restricted, please change your permissions and try again");
        }
    }


    


//====================Getters and setters==========================


    public boolean getHasCostumer() {
        return hasCostumer;
    }


    public void setHasCostumer(boolean hasCostumer) {
        this.hasCostumer = hasCostumer;
    }


    public boolean getHasTwins() {
        return hasTwins;
    }


    public void setHasTwins(boolean hasTwins) {
        this.hasTwins = hasTwins;
    }


    public boolean getHasOrder() {
        return hasOrder;
    }


    public void setHasOrder(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }


    public boolean getEating() {
        return isEating;
    }


    public void setEating(boolean isEating) {
        this.isEating = isEating;
    }


    public boolean getHasTip() {
        return hasTip;
    }


    public void setHasTip(boolean hasTip) {
        this.hasTip = hasTip;
    }


    public int getxLocation() {
        return xLocation;
    }


    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }


    public int getyLocation() {
        return yLocation;
    }


    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }


    public int getOrder() {
        return order;
    }


    public void setOrder(int order) {
        this.order = order;
    }

    
}
