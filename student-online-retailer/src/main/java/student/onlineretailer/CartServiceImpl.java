package student.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
//    @Autowired
//    @Qualifier("catalog")
    private Map<Integer, Item> catalog;

//    @Autowired
//    @Qualifier("cartRepositoryImpl")
    private CartRepository cartRepoImpl;

    @Autowired
    public CartServiceImpl(@Qualifier("cartRepositoryImpl") CartRepository cart,@Qualifier("catalog") Map<Integer, Item> catalog){
        this.cartRepoImpl = cart;
        this.catalog = catalog;
    }

    public void addItemToCart(int id, int quantity) {
        if(catalog.containsKey(id)) {
            cartRepoImpl.add(id, quantity);
        }
    }
    public void removeItemFromCart(int id) {
        cartRepoImpl.remove(id);
    }
    public Map<Integer, Integer> getAllItemsInCart() {
        return cartRepoImpl.getAll();
    }
    public double calculateCartCost() {
        double finalPrice =0;
        Map<Integer, Integer> allItems = cartRepoImpl.getAll();

        for (Integer id : allItems.keySet()) {
            int qty = allItems.get(id);
            double price = catalog.get(id).getPrice();
            finalPrice += price * qty;
        }
        return finalPrice;
    }
}
