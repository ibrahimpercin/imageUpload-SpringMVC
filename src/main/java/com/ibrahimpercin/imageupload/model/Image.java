package com.ibrahimpercin.imageupload.model;

import java.io.Serializable;
import java.util.Date;

public class Image implements Serializable {

	private static final long serialVersionUID = 33789533663910218L;

	private String description;

	private String base64image;

	private byte[] imageFile;

	private Date uploadDate;

	private int views;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBase64image() {
		return base64image;
	}

	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

}
