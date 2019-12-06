package nievasj.com;

import java.util.Date;

public class Product {

	private String itemKey;
	private String section;
	private String nArt;
	private Double price;
	private Date date;
	private String imported;
	private String pOrig;
	
	public Product(String itemKey, String section, String nArt, double price, Date date, String imported, String pOrig) {
		this.itemKey = itemKey;
		this.section = section;
		this.nArt = nArt;
		this.price = price;
		this.date = date;
		this.imported = imported;
		this.pOrig = pOrig;
	}

	public String getitemKey() {
		return itemKey;
	}

	public void setitemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getnArt() {
		return nArt;
	}

	public void setnArt(String nArt) {
		this.nArt = nArt;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImported() {
		return imported;
	}

	public void setImported(String imported) {
		this.imported = imported;
	}

	public String getpOrig() {
		return pOrig;
	}


	public void setpOrig(String pOrig) {
		this.pOrig = pOrig;
	}
	
	@Override
	public String toString() {
		return "products [itemKey=" + itemKey + ", section=" + section + ", nArt=" + nArt + ", price=" + price + ", date="
				+ date + ", imported=" + imported + ", pOrig=" + pOrig + "]";
	}
	
	
	
	
}
