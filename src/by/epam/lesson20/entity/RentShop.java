package by.epam.lesson20.entity;

import java.util.ArrayList;
import java.util.List;

public class RentShop {
	private List<Product> bikeProductList = new ArrayList<Product>();
	private List<Product> navigatorProductList = new ArrayList<Product>();
	private List<Product> accessoryProductList = new ArrayList<Product>();

	public List<Product> getBikeProductList() {
		return bikeProductList;
	}

	public void setBikeProductList(List<Product> bikeProductList) {
		this.bikeProductList = bikeProductList;
	}

	public List<Product> getNavigatorProductList() {
		return navigatorProductList;
	}

	public void setNavigatorProductList(List<Product> navigatorProductList) {
		this.navigatorProductList = navigatorProductList;
	}

	public List<Product> getAccessoryProductList() {
		return accessoryProductList;
	}

	public void setAccessoryProductList(List<Product> accessoryProductList) {
		this.accessoryProductList = accessoryProductList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessoryProductList == null) ? 0 : accessoryProductList.hashCode());
		result = prime * result + ((bikeProductList == null) ? 0 : bikeProductList.hashCode());
		result = prime * result + ((navigatorProductList == null) ? 0 : navigatorProductList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentShop other = (RentShop) obj;
		if (accessoryProductList == null) {
			if (other.accessoryProductList != null)
				return false;
		} else if (!accessoryProductList.equals(other.accessoryProductList))
			return false;
		if (bikeProductList == null) {
			if (other.bikeProductList != null)
				return false;
		} else if (!bikeProductList.equals(other.bikeProductList))
			return false;
		if (navigatorProductList == null) {
			if (other.navigatorProductList != null)
				return false;
		} else if (!navigatorProductList.equals(other.navigatorProductList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("bikeProductList  = < ");
		sb.append(this.getBikeProductList() + " >, ");
		sb.append("navigatorProductList = < ");
		sb.append(this.getNavigatorProductList() + " >, ");
		sb.append("accessoryProductList = < ");
		sb.append(this.accessoryProductList + " >. ");
		return sb.toString();

	}

}
