package com.dnd.eorderservices.model;

public class Item {

	private String item;
	
	private String quantity;
	
	private String note;

	public Item() {
		super();
	}

	public Item(String item, String quantity, String note) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.note = note;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuanity(String quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + ", quantity=" + quantity + ", note=" + note + "]";
	}
}
