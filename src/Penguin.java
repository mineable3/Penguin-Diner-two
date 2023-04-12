import java.util.ArrayList;

public class Penguin {


    private boolean orderTaken = false, foodDelivered = false, needsToGo = false;

    private long timeOfSeating,
        whenOrderTaken,
        whenFoodDelivered,
        timeToOrder = 8000,//time from sitting down to wanting to order
        timeForFoodToBeMade = 9000,//time from taking order to the food being made
        timeToEat = 12000;//time from getting food until leaving a tip

    private Table table;
    private static ArrayList<Integer> orders = new ArrayList<Integer>();


    public Penguin(long timeOfSeating, Table table) {
        this.timeOfSeating = timeOfSeating;
        this.table = table;
    }

    private static void placeOrder() {
        //orders.
    }

    public void checkForNeeds() {

        System.out.println("=====CHECKING FOR NEEDS=====");



        //checking if they're ready to order
        if(!orderTaken && ((timeOfSeating + timeToOrder) <= System.currentTimeMillis())) {
            table.clickTable();
            whenOrderTaken = System.currentTimeMillis();
            orderTaken = true;
            placeOrder();
            System.out.println("---------------------1-----------");
        }



        //delivering food once it's ready
        if(!foodDelivered && (orderTaken && ((whenOrderTaken + timeForFoodToBeMade) <= System.currentTimeMillis()))) {
            Algorythm.clickOnLocation(308, 689);//where the food will appear
            Algorythm.clickOnLocation(367, 689);//where the food will appear
            Algorythm.clickOnLocation(425, 689);//where the food will appear
            System.out.println("collecting food");
            table.clickTable();
            whenFoodDelivered = System.currentTimeMillis();
            foodDelivered = true;
            System.out.println("---------------------2-----------");
        }



        //collecting the tip when the customer is done eating
        if((foodDelivered && ((whenFoodDelivered + timeToEat) <= System.currentTimeMillis()))) {
            table.clickTable();
            if(!Algorythm.uThere(table.getxLocation())) {
                table.setHasCostumer(false);
                needsToGo = true;
                System.out.println("---------------------3-----------");
            }
        }
    }




    public boolean getNeedsToGo() {
        return needsToGo;
    }

    public Table getTable() {
        return table;
    }
}
