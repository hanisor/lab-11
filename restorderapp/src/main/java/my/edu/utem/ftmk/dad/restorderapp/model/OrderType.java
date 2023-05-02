package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ordertype")
public class OrderType {	// class for type of order

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="orderTypeId")
	private int orderTypeId;
	@Column (name="code")
	private String code;
	@Column (name="name")
	private String name;
	
	public int getOrderTypeId() {
		return orderTypeId;
	}
	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
