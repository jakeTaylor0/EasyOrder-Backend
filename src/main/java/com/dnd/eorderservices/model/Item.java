package com.dnd.eorderservices.model;

public class Item {

	private String item;
	
	private String quanity;
	
	private String note;

	public Item() {
		super();
	}

	public Item(String item, String quanity, String note) {
		super();
		this.item = item;
		this.quanity = quanity;
		this.note = note;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuanity() {
		return quanity;
	}

	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + ", quanity=" + quanity + ", note=" + note + "]";
	}
}
