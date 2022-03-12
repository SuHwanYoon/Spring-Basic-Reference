package model;

public class ItemSet {
	private Fruit item;//상품객체
	private Integer quantity;//갯수
	public ItemSet(Fruit item,Integer quantity) {
		this.item = item; 
		this.quantity = quantity;
	}
	public void addQuantity(Integer addQuantity) {
		int num = addQuantity.intValue();//갯수를 정수로 변환
		int existNum = this.getQuantity();//기존의 갯수
		this.setQuantity(num + existNum);//기존갯수+추가 갯수
	}
	public Fruit getItem() {
		return item;
	}
	public void setItem(Fruit item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
