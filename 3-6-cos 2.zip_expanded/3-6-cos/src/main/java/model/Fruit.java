package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Fruit {
	@NotNull(message="상품번호를 입력하세요.")
	private Integer item_id;
	@NotEmpty(message="상품이름을 입력하세요.")
	private String item_name;
	@NotNull
	@Min(0)
	@Max(1000000)
	@Range(min=0,max=1000000,message="{min}보다 크고 {max}보다 작아야합니다.")
	private Integer price;
	@NotEmpty
	@Size(min=10,max=100,message="{min}보다 크고 {max}보다 작아야합니다.")
	private String description;
	private String picture_url;
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
}
