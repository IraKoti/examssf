package sg.edu.nus.iss.app.examssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.examssf.model.Order;
import sg.edu.nus.iss.app.examssf.model.Pizza;


@Controller
public class PizzaController {

    @GetMapping(path = "/")
    public String pizzaForm(Model model)
    {
        Pizza p = new Pizza();
        model.addAttribute("pizza", p);
        return "pizza";
    }

    @PostMapping("/pizza")
    public String savePizza(@Valid Pizza pizza, BindingResult result, 
                Model model, HttpServletResponse response){
        if(result.hasErrors()){
            return "pizza";
        }
        // ctcRedisSvc.save(contact);
        // model.addAttribute( "contact", contact);
        // response.setStatus(HttpServletResponse.SC_CREATED);
        System.out.printf("====================%s,%s,%s==============\n",pizza.getPizzaType(),pizza.getPizzaSize(),pizza.getPizzaQty());
        Order d = new Order();
        model.addAttribute("order",d);
        return "order";
    }


    @PostMapping("/pizza/order")
    public String saveOrder(@Valid Order order, BindingResult result,
                Model model, HttpServletResponse response){
        if(result.hasErrors()){
            
            return "order";
        }
        //ctcRedisSvc.save(contact);
        // model.addAttribute( "contact", contact);
        // response.setStatus(HttpServletResponse.SC_CREATED);
        // float price = 0f;
        // System.out.printf("Deliver===%s,%s,%s====\n",order.getPizzaType(),order.getPizzaSize(),order.getPizzaQty());
        //Pizza p = new Pizza();
        //price = p.pricePizza();
        //System.out.println(price);
        

        return "showOrder";
    }
    
    // @GetMapping(path="/order/{orderId}")
    // public String getContactInfoById(Model model, 
    // @PathVariable(value="orderId") String orderId)
    // {
    //     Order ord = ctcRedisSvc.findById(orderId);
    //     ord.setId(orderId);
    //     model.addAttribute("order", ord);
    //     return "showOrder";
    // }

    
}
