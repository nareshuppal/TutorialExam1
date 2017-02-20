package com.target.check.skills;

public class TargetData {
	
	public TargetData(String productNumber, String productDesc)
	{
		this.productNumber=productNumber;
		this.productDesc=productDesc;
	}
	//This is domain object
	
	private String productNumber;
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	private String productDesc;

}
