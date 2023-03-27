package com.interview.mvc.model;

public class TableItem {

	private String tableName;
	private String colName;
	private String colValue;
	private Boolean isAutoInc;
	private String colType;
	private String updateValue;
	
	
	public String getUpdateValue() {
		return updateValue;
	}
	public void setUpdateValue(String updateValue) {
		this.updateValue = updateValue;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColValue() {
		return colValue;
	}
	public void setColValue(String colValue) {
		this.colValue = colValue;
	}
	public Boolean getIsAutoInc() {
		return isAutoInc;
	}
	public void setIsAutoInc(Boolean isAutoInc) {
		this.isAutoInc = isAutoInc;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String toString() {
		return "TableItem [tableName=" + tableName + ", colName=" + colName + ", colValue=" + colValue + ", isAutoInc="
				+ isAutoInc + ", colType=" + colType + ", updateValue=" + updateValue + "]";
	}
	 
}
