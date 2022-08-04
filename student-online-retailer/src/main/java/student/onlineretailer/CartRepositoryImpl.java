package student.onlineretailer;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private Map<Integer, Integer> shoppingCart = new HashMap<>();

    public void add(int itemId, int quantity) {
        if(shoppingCart.containsKey(itemId)) {
            int newQty = shoppingCart.get(itemId) + quantity;
            shoppingCart.put(itemId, newQty);
        } else {
            shoppingCart.put(itemId, quantity);
        }
    }

    public void remove(int itemId) {
        shoppingCart.remove(itemId);
    }

    public Map<Integer, Integer> getAll() {
        return shoppingCart;
    }
}
