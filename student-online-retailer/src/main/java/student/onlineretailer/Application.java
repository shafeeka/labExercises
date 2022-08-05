package student.onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CartServiceImpl cartService = ctx.getBean(CartServiceImpl.class);
		cartService.addItemToCart(1,1);
		cartService.addItemToCart(2,1);
		cartService.addItemToCart(3,2);
		System.out.println(cartService.getAllItemsInCart().size());

		cartService.removeItemFromCart(3);
		System.out.println(cartService.getAllItemsInCart());

		System.out.println("total cost " + cartService.calculateCartCost());

		System.out.println(cartService.contactEmail);

		System.setProperty("spring.config.name", "application");
		ResourcesBean rBean = ctx.getBean(ResourcesBean.class);
		System.out.println(rBean);

	}

	@Bean
	public Map<Integer, Item> catalog() {
		Map<Integer, Item> itemCatalog = new HashMap<>();
		itemCatalog.put(1, new Item(1, "shirt", 300));
		itemCatalog.put(2, new Item(2, "wallet", 10));
		itemCatalog.put(3, new Item(3, "bag", 5000));
		itemCatalog.put(4, new Item(4, "sweets", 0.10));

		return itemCatalog;
	}



}
