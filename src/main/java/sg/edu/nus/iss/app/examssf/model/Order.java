package sg.edu.nus.iss.app.examssf.model;

import java.io.Serializable;
import java.util.Random;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Order implements Serializable 
{
    private String dId;

    @Size(min = 3, message = "Name mininum 3 characters.")
    private String oName;

    @NotNull 
    private String oAddress;

    @Size(min = 8, max = 8, message = "Phone number must be 8 digit.")
    private String oPhone;
    private boolean oRush;
    private String oComments;
    private String pizzaType;
    private String pizzaSize;
    private String pizzaQty;
    private String oId;
    
    public String getPizzaType() {
        return pizzaType;
    }
    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }
    public String getPizzaSize() {
        return pizzaSize;
    }
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    public String getPizzaQty() {
        return pizzaQty;
    }
    public void setPizzaQty(String pizzaQty) {
        this.pizzaQty = pizzaQty;
    }
    public String getoId() {
        return oId;
    }
    public void setdId(String oId) {
        this.oId = oId;
    }
    public String getoName() {
        return oName;
    }
    public void setoName(String oName) {
        this.oName = oName;
    }
    public String getoAddress() {
        return oAddress;
    }
    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }
    public String getoPhone() {
        return oPhone;
    }
    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }
    public boolean isoRush() {
        return oRush;
    }
    public void setdRush(boolean oRush) {
        this.oRush = oRush;
    }
    public String getoComments() {
        return oComments;
    }
    public void setoComments(String oComments) {
        this.oComments = oComments;
    }

    public Order() {
        this.oId = this.generateId(8);
        System.out.println("==========================="+this.getoId());
    }

    private synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numChars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numChars);
    }
    
    public Float pricePizza()
    {
        Float pizzaCost = 0f;
        Float typeCost = 0f;
        Float totalPizza = 0f;
        float rushCost = 0f;
        pizzaType = "spianatacalabrese";
        pizzaSize ="lg";
        pizzaQty = "10";
        switch(pizzaType)
        {
            case "bella":
            case "marinara":
            case "spianatacalabrese":
                pizzaCost = 30f;
            break;

            case "margheritta":
                pizzaCost = 22f;
            break;

            case "trioformaggio":
                pizzaCost = 25f;
            break;
        }

        switch(pizzaSize)
        {
            case "sm":
                typeCost = 1f;
            break;

            case "md":
                typeCost = 1.2f;
            break;

            case "lg":
                typeCost = 1.5f;
            break;
        }
        if(this.isoRush())
        {
            rushCost = 2f;
        }

        totalPizza = (pizzaCost * typeCost * Float.valueOf(pizzaQty)) + rushCost;
        System.out.println("==========DELIVERY DETAILS============");
        System.out.printf("Order Number: %s\n",this.getoId());
        System.out.printf("Your order will be delivered to: %s\n",this.getoAddress());
        System.out.printf("Pizza cost: %s\n",pizzaCost);
        System.out.printf("type: %s\n",typeCost);
        System.out.printf("type: %s\n",isoRush());
        System.out.printf("Total Cost: %s\n",totalPizza);
        return totalPizza;
    }
}
