package com.cs.hackathon.heybuddy.products;

public class GetProductsRequestModel implements IGetProductsRequestModel {

	protected Long from = 0l;
	protected Long size = 20l;
	protected String searchText;
	protected String sortOrder;
	protected Integer listingType;
	protected String username;
	
	@Override
	public Long getFrom() {
		return from;
	}
	
	@Override
	public void setFrom(Long from) {
		this.from = from;
	}
	
	@Override
	public Long getSize() {
		return size;
	}
	
	@Override
	public void setSize(Long size) {
		this.size = size;
	}
	
	@Override
	public String getSearchText() {
		return searchText;
	}
	
	@Override
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	@Override
	public String getSortOrder() {
		return sortOrder;
	}
	
	@Override
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	@Override
	public Integer getListingType() {
		return listingType;
	}
	
	@Override
	public void setListingType(Integer listingType) {
		this.listingType = listingType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
