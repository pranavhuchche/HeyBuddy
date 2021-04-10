package com.cs.hackathon.heybuddy.products;

public interface IGetProductsRequestModel {
	
	public static final String FROM = "from";
	public static final String SIZE = "size";
	public static final String SEARCH_TEXT = "searchText";
	public static final String SORT_ORDER = "sortOrder";
	public static final String LISTING_TYPE = "listingType";
	
	public Long getFrom();
	public void setFrom(Long from);
	
	public Long getSize();
	public void setSize(Long size);
	
	public String getSearchText();
	public void setSearchText(String searchText);
	
	public String getSortOrder();
	public void setSortOrder(String sortOrder);
	
	public Integer getListingType();
	public void setListingType(Integer listingType);
	
}
