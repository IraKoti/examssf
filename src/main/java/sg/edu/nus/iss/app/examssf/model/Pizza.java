package sg.edu.nus.iss.app.examssf.model;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Pizza implements Serializable
{
    @NotNull(message = "Select one of the Pizza.")
    private String pizzaType;

    private String pizzaSize;

    @Min(value = 1, message = "Minimal 1 Pizza.")
    @Max(value = 10, message = "Maximal 10 Pizza.")
    private String pizzaQty;

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

    public Float pricePizza()
    {
        Float pizzaCost = 0f;
        Float typeCost = 0f;
        Float totalPizza = 0f;
        switch(this.getPizzaType())
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

        switch(this.getPizzaSize())
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

        totalPizza = pizzaCost * typeCost * Float.valueOf(pizzaQty);

        return totalPizza;
    }
}
