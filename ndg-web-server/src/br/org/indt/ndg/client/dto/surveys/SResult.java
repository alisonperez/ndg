package br.org.indt.ndg.client.dto.surveys;


import java.util.HashMap;

public class SResult {
	
	
	private String surveyId;
	private String resultId;
	private String userId;
	private String time;
	private String title;
	private String latitude;
	private String longitude;
	
	private HashMap categories = null;
	
	public SResult() {
		categories = new HashMap(5);
	}
	
	public HashMap getCategories() {
		return categories;
	}
	public void setCategories(HashMap categories) {
		this.categories = categories;
	}
	public void addCategory(int categoryId, SCategory category){
		this.categories.put(new Integer(categoryId), category);
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
