package com.example.shop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "\"order\"")
public class Order extends AbstractEntity<Long> {

	private static final long serialVersionUID = 7420059776062452730L;
	@Id
	@SequenceGenerator(name = "order_seq_generator", sequenceName = "order_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_generator")
	private Long id;
	@Column(name = "id_account")
	private Integer idAccount;
	@Transient
	private List<OrderItem> items;
	private Timestamp created;

	public Order() {

	}

	public Order(Integer idAccount, Timestamp created) {
		super();
		this.idAccount = idAccount;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public BigDecimal getTotalCost() {
		BigDecimal cost = BigDecimal.ZERO;
		if (items != null) {
			for (OrderItem item : items) {
				cost = cost.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getCount())));
			}
		}
		return cost;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s, idAccount=%s, items=%s, created=%s]", getId(), idAccount, items, created);
	}
}
