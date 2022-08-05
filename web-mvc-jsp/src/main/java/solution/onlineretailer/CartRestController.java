package solution.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CartRestController {
    @Autowired
    private Map<Integer,Item> catalog;

    @Autowired
    private CartService cartService;

    @GetMapping(value="/items", produces={"application/json","application/xml"})
    public List<Item> getAllItem(){
        List<Item> toReturn = new ArrayList<>();
        Map<Integer,Integer> allCart = cartService.getAllItemsInCart();
        for(int id: allCart.keySet()) {
            Item item = catalog.get(id);
            toReturn.add(item);
        }
        return toReturn;
    }

    @GetMapping(value="/cartCost", produces={"application/json","application/xml"})
    public double getCartCost() {
        return cartService.calculateCartCost();
    }

    @GetMapping(value="/quantityForItem/{itemId}", produces={"application/json","application/xml"})
    public int getQuantityForItem(@PathVariable int itemId) {
        Map<Integer,Integer> allCart = cartService.getAllItemsInCart();
        if(allCart.containsKey(itemId)) {
            return allCart.get(itemId);
        }

        return 0;
    }

    @GetMapping(value="/addItem", produces={"application/json","application/xml"})
    public void addItemToCart(@RequestParam int id, @RequestParam int qty) {
        cartService.addItemToCart(id, qty);
    }

    @ModelAttribute("email")
    public String populateContacts() {
        return "Contact us at abc@help.com for assistance! :)";
    }


    @GetMapping(value="/help", produces={"application/json","application/xml"})
    public List<String> getHelp(ModelMap model) {
        ArrayList<String> list=new ArrayList();
        list.add((String) model.get("email"));
        return list;
    }
    
}
