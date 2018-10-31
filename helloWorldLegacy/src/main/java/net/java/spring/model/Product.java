package net.java.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id, name;
	private Integer price;
	private List<MultipartFile> images;
	private String imagesnames;
	
	public Product() {
		this.id = "";
		this.name = "";
		this.price = 0;
		this.images = new ArrayList<MultipartFile>();
		this.imagesnames = "";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public List<MultipartFile> getImages() {
		return images;
	}
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	public String getImagesnames() {
		return imagesnames;
	}
	public void setImagesnames(String imagesnames) {
		this.imagesnames = imagesnames;
	}
	
	
	
	
	

}
