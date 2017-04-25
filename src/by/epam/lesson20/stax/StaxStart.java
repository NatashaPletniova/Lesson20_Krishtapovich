package by.epam.lesson20.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.lesson20.entity.RentShop;
import by.epam.lesson20.parser.helper.StringConstants;
import by.epam.lesson30.view.View;

public class StaxStart {

	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream input = new FileInputStream(StringConstants.resources);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			RentShop rentShop = StaxHelper.process(reader);
			View.displayRentShop(rentShop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

}
