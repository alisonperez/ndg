package br.org.indt.ndg.client.transformer;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jboss.util.Base64;

import br.org.indt.ndg.common.Category;
import br.org.indt.ndg.common.Field;
import br.org.indt.ndg.common.FieldType;
import br.org.indt.ndg.common.Item;
import br.org.indt.ndg.common.Resources;
import br.org.indt.ndg.common.ResultXml;
import br.org.indt.ndg.common.SurveyXML;

public class ExcelTransformer extends Transformer {

	private Boolean exportWithImages;
	
	public ExcelTransformer(SurveyXML survey, Boolean exportWithImages) {
		super(survey);
		this.exportWithImages = exportWithImages;
	}

	public void write(String path) {
		ArrayList<ResultXml> results = survey.getResults();
		processResults(path, results);	
	}

	public void write(String path, Collection<ResultXml> results) {
		processResults(path, results);
	}
	
	public byte[] getBytes(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ArrayList<ResultXml> results = survey.getResults();
		HSSFWorkbook wb = new HSSFWorkbook();
	    HSSFSheet sheet = wb.createSheet("Sheet1");

	    /** Header **/
		HSSFRow row = sheet.createRow((short)0);
		int fieldcounter = 0;
		row.createCell((short)fieldcounter++).setCellValue("ResultId");
		row.createCell((short)fieldcounter++).setCellValue("SurveyId");
		row.createCell((short)fieldcounter++).setCellValue("Imei");
		row.createCell((short)fieldcounter++).setCellValue("PhoneNumber");
		row.createCell((short)fieldcounter++).setCellValue("Lat");
		row.createCell((short)fieldcounter++).setCellValue("Lon");
		
		/** Header - Fields **/
		TreeMap<Integer,Category> categories = survey.getCategories();
		
		for (Category category : categories.values()) {
			for (Field field : category.getFields()) {
				row.createCell((short)fieldcounter++).setCellValue(field.getDescription());
			}
		}
						
		int countrow = 0;
		row = sheet.createRow((short)++countrow);
		
		/** Content **/
		for (ResultXml result : results) {
			fieldcounter = 0;
			row.createCell((short)fieldcounter++).setCellValue(result.getResultId());
			row.createCell((short)fieldcounter++).setCellValue(result.getSurveyId());
			row.createCell((short)fieldcounter++).setCellValue(result.getImei());
			row.createCell((short)fieldcounter++).setCellValue(result.getPhoneNumber());
			row.createCell((short)fieldcounter++).setCellValue(result.getLatitude());
			row.createCell((short)fieldcounter++).setCellValue(result.getLongitude());
			for (Category category : result.getCategories().values()) {
				for (Field field : category.getFields()) {
					String value = null;
					if (field.getFieldType() == FieldType.STR) {
						value = field.getValue() == null ? "" : field.getValue();
					} else if (field.getFieldType() == FieldType.DATE){
						value = (field.getValue() == null || field.getValue() == "") ? "" : Resources.toDate(Long.parseLong(field.getValue()));	
					} else if (field.getFieldType() == FieldType.INT){
						value = (field.getValue() == null || field.getValue() == "") ? "0" : field.getValue();	
					} else if (field.getFieldType() == FieldType.DECIMAL){
						value = (field.getValue() == null || field.getValue() == "") ? "0" : field.getValue();		
					} else if (field.getFieldType() == FieldType.CHOICE){
						StringBuffer tmp = new StringBuffer();
						int countitem = 0;
						for(Item item : field.getChoice().getItems()) {
							if (item.getValue() != null) {
								if(item.getOtr() != null) {
									if (item.getOtr().equals("1")) {
										String s = survey.getItemValue(field.getCategoryId(), field.getId(), item.getIndex());
										tmp.append(s + " " + item.getValue());
										tmp.append( (++countitem < field.getChoice().getItems().size() ? ", " : "") );
									}
								} else {
									tmp.append(item.getValue());
								}
							} else {
								String s = survey.getItemValue(field.getCategoryId(), field.getId(), item.getIndex());
								tmp.append(s);
								tmp.append(" ");
							}
						}
						value = tmp.toString() == null ? "" : tmp.toString();
					} else if (field.getFieldType() == FieldType.IMAGE) {
						String imagePath = File.separator + PHOTOS_DIR + File.separator + 
						   				   result.getResultId() + 
						   				   UNDERLINE_SEPARATOR + category.getId() + 
						   				   UNDERLINE_SEPARATOR + field.getId() + JPG_EXTENSION;
						
						value = "<img>";
						
						if (exportWithImages == true && !field.getValue().equals("")) {
							
							value = imagePath;
							
							try
							{
								FileOutputStream arqImg = new FileOutputStream(result.getSurveyId() + imagePath);
								
								arqImg.write(Base64.decode(field.getValue()));
								arqImg.close();
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
					}
					value = value.trim().replaceAll("\n", "");
					row.createCell((short)fieldcounter++).setCellValue(value);
				}
			}
			row = sheet.createRow((short)++countrow);
		}
		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return out.toByteArray();
	}
	
	
	
	
	private void processResults(String path, Collection<ResultXml> results){
		String file = path;
		HSSFWorkbook wb = new HSSFWorkbook();
	    HSSFSheet sheet = wb.createSheet("Sheet1");
	    FileOutputStream out = null; 
			
		try {
			out = new FileOutputStream(file);
			/** Header **/
			HSSFRow row = sheet.createRow((short)0);
			int fieldcounter = 0;
			row.createCell((short)fieldcounter++).setCellValue("ResultId");
			row.createCell((short)fieldcounter++).setCellValue("SurveyId");
			row.createCell((short)fieldcounter++).setCellValue("Imei");
			row.createCell((short)fieldcounter++).setCellValue("PhoneNumber");
			row.createCell((short)fieldcounter++).setCellValue("Lat");
			row.createCell((short)fieldcounter++).setCellValue("Lon");
			
			/** Header - Fields **/
			TreeMap<Integer,Category> categories = survey.getCategories();
			
			for (Category category : categories.values()) {
				
				for (Field field : category.getFields()) {
					row.createCell((short)fieldcounter++).setCellValue(field.getDescription());
				}
			}
						
			int countrow = 0;
			row = sheet.createRow((short)++countrow);
			
			/** Content **/
			
			for (ResultXml result : results) {
				fieldcounter = 0;
				row.createCell((short)fieldcounter++).setCellValue(result.getResultId());
				row.createCell((short)fieldcounter++).setCellValue(result.getSurveyId());
				row.createCell((short)fieldcounter++).setCellValue(result.getImei());
				row.createCell((short)fieldcounter++).setCellValue(result.getPhoneNumber());
				row.createCell((short)fieldcounter++).setCellValue(result.getLatitude());
				row.createCell((short)fieldcounter++).setCellValue(result.getLongitude());
				
				
				for (Category category : result.getCategories().values()) {
					for (Field field : category.getFields()) {
						String value = null;
						if (field.getFieldType() == FieldType.STR) {
							value = field.getValue() == null ? "" : field.getValue();
						} else if (field.getFieldType() == FieldType.DATE){
							value = (field.getValue() == null || field.getValue() == "") ? "" : Resources.toDate(Long.parseLong(field.getValue()));	
						} else if (field.getFieldType() == FieldType.INT){
							value = (field.getValue() == null || field.getValue() == "") ? "0" : field.getValue();	
						} else if (field.getFieldType() == FieldType.DECIMAL){
							value = (field.getValue() == null || field.getValue() == "") ? "0" : field.getValue();		
						} else if (field.getFieldType() == FieldType.CHOICE){
							StringBuffer tmp = new StringBuffer();
							int countitem = 0;
							for(Item item : field.getChoice().getItems()) {
								if (item.getValue() != null) {
									if(item.getOtr() != null) {
										if (item.getOtr().equals("1")) {
											String s = survey.getItemValue(field.getCategoryId(), field.getId(), item.getIndex());
											tmp.append(s + " " + item.getValue());
											tmp.append( (++countitem < field.getChoice().getItems().size() ? ", " : "") );
										}
									} else {
										tmp.append(item.getValue());
									}
								} else {
									String s = survey.getItemValue(field.getCategoryId(), field.getId(), item.getIndex());
									tmp.append(s);
									tmp.append(" ");
								}
							}
							value = tmp.toString() == null ? "" : tmp.toString();
						}						
						row.createCell((short)fieldcounter++).setCellValue(value);
					}
				}
								
				row = sheet.createRow((short)++countrow);
			}
			wb.write(out);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	}
}
