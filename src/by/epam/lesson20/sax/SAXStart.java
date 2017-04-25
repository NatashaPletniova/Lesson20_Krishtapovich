package by.epam.lesson20.sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.lesson20.entity.RentShop;
import by.epam.lesson20.parser.helper.StringConstants;
import by.epam.lesson30.view.View;

public class SAXStart {
	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			RentShopSaxHandler handler = new RentShopSaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(StringConstants.resources));
			RentShop rentShop = handler.getRentShop();
			View.displayRentShop(rentShop);
		} catch (SAXException e) {
			System.out.println("Sorry something went wrong. Please chech your XML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sorry something went wrong. Please chech the location of your XML file");
			e.printStackTrace();
		}

	}

}
