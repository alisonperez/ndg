package br.org.indt.ndg.client.dto.surveys;

import java.util.ArrayList;
import java.util.HashMap;


public class SSurvey{

	private String id;
	private String display; 
	private String title;
	private int displayCategory;
	private int displayQuestion;
	private HashMap categories;
	private ArrayList results;

	public SSurvey() {
		this.id = "";
		this.display = "";
		this.categories = new HashMap(5);
		this.displayCategory = 0;
		this.displayQuestion = 0;
		this.results = new ArrayList(5);
	}

	public HashMap getCategories() {
		return categories;
	}
	public void setCategories(HashMap categories) {
		this.categories = categories;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
		/*
		StringTokenizer st = new StringTokenizer(display, "-");
		if (st.countTokens() == 2) {
			int count = 1;
			while(st.hasMoreTokens()) {
				this.displayCategory = (count == 1 ? Integer.parseInt(st.nextToken()) : this.displayCategory);
				this.displayQuestion = (count == 2 ? Integer.parseInt(st.nextToken()) : this.displayQuestion);
				count++;
			}
		}*/

	}

	public int getDisplayCategory() {
		return displayCategory;
	}

	public int getDisplayQuestion() {
		return displayQuestion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList getResults() {
		return results;
	}

	public void setResults(ArrayList results) {
		this.results = results;
	}

	public void addResult(SResult result) {
		this.results.add(result);
	}

	public int getResultsSize() {
		return results.size();
	}

	public void addCategory(int categoryId, SCategory category){
		this.categories.put(new Integer(categoryId), category);
	}
	
	public String getItemValue(int categoryId, int FieldId, int itemIndex) {
		SCategory category = (SCategory) categories.get(new Integer(categoryId));
		SField field = category.getFieldById(FieldId);
		SChoice choice = field.getChoice();
		String value = choice.getItem(itemIndex).getValue();
		return value;
	}
	


}
