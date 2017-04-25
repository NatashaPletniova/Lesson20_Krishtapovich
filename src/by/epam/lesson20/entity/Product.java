package by.epam.lesson20.entity;

public class Product {
	private String id;
	private String productName;
	private int basePrice;
	private String note;
	private int manufacturingYear;
	private int wearRate;
	private int status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public int getWearRate() {
		return wearRate;
	}

	public void setWearRate(int wearRate) {
		this.wearRate = wearRate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basePrice;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + manufacturingYear;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + status;
		result = prime * result + wearRate;
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
		Product other = (Product) obj;
		if (basePrice != other.basePrice)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturingYear != other.manufacturingYear)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (status != other.status)
			return false;
		if (wearRate != other.wearRate)
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(":");
		sb.append("id = < ");
		sb.append(this.getId() + " >, ");
		sb.append("productName = < ");
		sb.append(this.getProductName() + " >, ");
		sb.append(" basePrice = < ");
		sb.append(this.getBasePrice() + " >, ");
		sb.append("note = < ");
		sb.append(this.getNote() + " >, ");
		sb.append("manufacturingYear = < ");
		sb.append(this.getManufacturingYear() + " >, ");
		sb.append("wearRate  = < ");
		sb.append(this.getWearRate() + " >, ");
		sb.append("status = < ");
		sb.append(this.getStatus() + " >.");
		return sb.toString();

	}

}
