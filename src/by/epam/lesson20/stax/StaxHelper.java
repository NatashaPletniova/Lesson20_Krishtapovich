package by.epam.lesson20.stax;

import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.lesson20.entity.Product;
import by.epam.lesson20.entity.RentShop;
import by.epam.lesson20.entity.RentShopTagName;

public class StaxHelper {
	public static RentShop process(XMLStreamReader reader) throws XMLStreamException {
		RentShop rentShop = new RentShop();
		Product product = null;
		RentShopTagName elementName = null;
		List<Product> currentList = null;

		while (reader.hasNext()) {

			int type = reader.next();

			switch (type) {

			case XMLStreamConstants.START_ELEMENT:
				elementName = RentShopTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
				product = startElement(elementName, reader, currentList, rentShop, product);
				currentList = setCurrentList(elementName, currentList, rentShop);
				break;

			case XMLStreamConstants.CHARACTERS:
				addText(elementName, reader, product);
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = RentShopTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
				endElement(elementName, currentList, product);
			}
		}
		return rentShop;
	}

	private static Product startElement(RentShopTagName elementName, XMLStreamReader reader, List<Product> currentList,
			RentShop rentShop, Product product) {

		if (elementName == RentShopTagName.PRODUCT) {
			product = new Product();
			product.setId(reader.getAttributeValue(null, "id"));
		}
		return product;
	}

	private static List<Product> setCurrentList(RentShopTagName elementName, List<Product> currentList,
			RentShop rentShop) {
		if (elementName == RentShopTagName.BIKE_PRODUCTS) {
			currentList = rentShop.getBikeProductList();
		} else {
			if (elementName == RentShopTagName.NAVIGATOR_PRODUCTS) {
				currentList = rentShop.getNavigatorProductList();
			} else {
				if (elementName == RentShopTagName.ACCESSORIES) {
					currentList = rentShop.getAccessoryProductList();
				}
			}
		}
		return currentList;

	}

	private static void addText(RentShopTagName elementName, XMLStreamReader reader, Product product) {
		String text = reader.getText().trim();
		if (text.isEmpty()) {
			return;
		}
		switch (elementName) {
		case PRODUCTNAME:
			product.setProductName(text.toString());
			break;
		case BASEPRICE:
			product.setBasePrice(Integer.parseInt(text.toString()));
			break;
		case NOTE:
			product.setNote(text.toString());
			break;
		case MANUFACTURINGYEAR:
			product.setManufacturingYear(Integer.parseInt(text.toString()));
			break;
		case WEARRATE:
			product.setWearRate(Integer.parseInt(text.toString()));
			break;
		case STATUS:
			product.setStatus(Integer.parseInt(text.toString()));
			break;

		}
	}

	private static void endElement(RentShopTagName elementName, List<Product> currentList, Product product) {
		switch (elementName) {
		case PRODUCT:
			currentList.add(product);
			product = null;
			break;
		default:
			break;
		}
	}
}
