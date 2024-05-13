package labs;

import java.time.LocalDate;
import java.util.Arrays;

public class Invoice {

	private int invno;
	private String customername;
	private double invamout;
	private LocalDate orderdate;
	private OrderStatus orderStatus;
	private LineItem [] lineItems;
	public Invoice() {
		// TODO Auto-generated constructor stub
		orderdate = LocalDate.now();
		orderStatus = OrderStatus.ORDERED;
	}
	public Invoice(int invno, String customername, LineItem[] lineItems) {
		super();
		this.invno = invno;
		this.customername = customername;
		this.lineItems = lineItems;
		this.orderStatus = OrderStatus.ORDERED;
		orderdate = LocalDate.now();
	}
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public double getInvamout() {
		return invamout;
	}
	public void setInvamout(double invamout) {
		this.invamout = invamout;
	}
	public LineItem[] getLineItems() {
		return lineItems;
	}
	public void setLineItems(LineItem[] lineItems) {
		this.lineItems = lineItems;
	}
	public void caclculate() {
		double total = 0;
		for(LineItem item:lineItems) {
			total += item.getQuantity() * item.getPrice();
		}
		invamout = total;
	}
	@Override
	public String toString() {
		return "Invoice [invno=" + invno + ", customername=" + customername + ", invamout=" + invamout + ", orderdate="
				+ orderdate + ", orderStatus=" + orderStatus + ", lineItems=" + Arrays.toString(lineItems) + "]";
	}
	
	
	
}
