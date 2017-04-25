package by.epam.lesson20.sax;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.lesson20.entity.Product;
import by.epam.lesson20.entity.RentShop;
import by.epam.lesson20.entity.RentShopTagName;
import by.epam.lesson20.parser.helper.StringConstants;

public class RentShopSaxHandler extends DefaultHandler {
	private RentShop rentShop = new RentShop();
	private Product product;
	private List<Product> currentList;
	private StringBuilder text;

	public RentShop getRentShop() {
		return rentShop;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();

		if (localName.equals(StringConstants.bikeProducts)) {
			currentList = rentShop.getBikeProductList();
		} else {
			if (localName.equals(StringConstants.navigatorProducts)) {
				currentList = rentShop.getNavigatorProductList();
			} else {
				if (localName.equals(StringConstants.accessories)) {
					currentList = rentShop.getAccessoryProductList();
				}
			}
		}

		if (localName.equals(StringConstants.productStr)) {
			product = new Product();
			product.setId(attributes.getValue(StringConstants.id));
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		RentShopTagName tagName = RentShopTagName.valueOf(localName.toUpperCase().replace("-", "_"));

		switch (tagName) {
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
		case PRODUCT:
			currentList.add(product);
			product = null;
			break;
		default:
			break;
		}
	}

}
