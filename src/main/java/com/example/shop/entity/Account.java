package com.example.shop.entity;


import com.example.shop.model.CurrentAccount;

public class Account extends AbstractEntity<Integer> implements CurrentAccount {
	private static final long serialVersionUID = 2972461657153284688L;
	private String name;
	private String email;

	public Account() {
		super();
	}

	public Account(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, name=%s, email=%s]", getId(), name, email);
	}

	@Override
	public String getDescription() {
		return name + "("+email+")";
	}
}
