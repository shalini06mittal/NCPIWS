package labs;

public class LineItem {
	private int lineitemid;
	private String itemname;
	private double price;
	private int quantity;
	private int invno;
	
	public LineItem() {
		// TODO Auto-generated constructor stub
	}

	public LineItem(int lineitemid, String itemname, double price, int quantity, int invno) {
		super();
		this.lineitemid = lineitemid;
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
		this.invno = invno;
	}

	public int getLineitemid() {
		return lineitemid;
	}

	public void setLineitemid(int lineitemid) {
		this.lineitemid = lineitemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInvno() {
		return invno;
	}

	public void setInvno(int invno) {
		this.invno = invno;
	}

	@Override
	public String toString() {
		return "LineItem [lineitemid=" + lineitemid + ", itemname=" + itemname + ", price=" + price + ", quantity="
				+ quantity + ", invno=" + invno + "]";
	}
	
	

}
