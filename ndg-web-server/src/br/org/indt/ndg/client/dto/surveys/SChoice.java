package br.org.indt.ndg.client.dto.surveys;

import java.util.ArrayList;


public class SChoice {
	
	public static int EXCLUSIVE = 1;
	public static int MULTIPLE = 2;
	
	private int choiceType;
	private ArrayList items;
	
	public SChoice() {
		items = new ArrayList(5);
	}
	public int getChoiceType() {
		return choiceType;
	}
	public void setChoiceType(int choiceType) {
		this.choiceType = choiceType;
	}
	public ArrayList getItems() {
		return items;
	}
	public void setItems(ArrayList items) {
		this.items = items;
	}
	public void addItem(SItem item) {
		this.items.add(item);
	}
	public SItem getItem(int index) {
		return (SItem) this.items.get(index);
	}
}
