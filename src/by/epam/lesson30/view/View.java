package by.epam.lesson30.view;

import by.epam.lesson20.entity.Product;
import by.epam.lesson20.entity.RentShop;
import by.epam.lesson20.parser.helper.StringConstants;

public class View {
	public static void displayRentShop(RentShop rentShop) {
		System.out.println(StringConstants.bikeProducts);
		System.out.println();
		for (Product product : rentShop.getBikeProductList()) {
			System.out.println(product.toString());
		}

		System.out.println(StringConstants.navigatorProducts);
		System.out.println();
		for (Product product : rentShop.getNavigatorProductList()) {
			System.out.println(product.toString());
		}
		System.out.println(StringConstants.accessories);
		System.out.println();
		for (Product product : rentShop.getAccessoryProductList()) {
			System.out.println(product.toString());
		}
	}
}
