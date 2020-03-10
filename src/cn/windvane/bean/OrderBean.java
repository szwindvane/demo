package cn.windvane.bean;
import java.util.Date;

public class OrderBean {
	
	private String ID;
	private String goodsname;
	private int price;
	private int quantity;
	private int amount;
	private String username;
	private Date createtime;
	
	public OrderBean(String iD, String goodsname, int price, int quantity, int amount, String username, Date createtime) {
		super();
		ID = iD;
		this.goodsname = goodsname;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.username = username;
		this.createtime = createtime;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String toString() {
		return "OrderBean [ID=" + ID + ", goodsname=" + goodsname + ", price=" + price + ", quantity=" + quantity
				+ ", amount=" + amount + ", username=" + username + ", createtime=" + createtime + "]";
	}
	
	
}
