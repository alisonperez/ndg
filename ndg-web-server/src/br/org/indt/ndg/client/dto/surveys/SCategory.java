package br.org.indt.ndg.client.dto.surveys;

import java.util.Vector;

public class SCategory {
	
	private int id;
	private String name;
	private Vector fields;
	
	
	public SCategory() {
		fields = new Vector(5);
	}
	
	public void addField(SField field) {
		fields.add(field);
	}
	
	public SField getFieldByIndex(int index) {
		return (SField) fields.get(index);
	}
	
	public Vector getFields() {
		return fields;
	}
	
	public void setFields(Vector fields) {
		this.fields = fields;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public SField getFieldById(int fieldId) {
		SField tmpField = null;
		for (int i=0; i < fields.size(); i++) {
			SField field = (SField) fields.get(i);
			if (field.getId() == fieldId) {
				tmpField = field;
				break;
			}
		}
		return tmpField;
	}

}
