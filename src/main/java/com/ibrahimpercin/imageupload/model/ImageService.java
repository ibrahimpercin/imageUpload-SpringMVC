package com.ibrahimpercin.imageupload.model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageService {

	final static Logger logger = Logger.getLogger(ImageService.class);
	
	@Resource(name="myProperties")
	private Properties myProperties;
	
	private List<Image> images = new ArrayList();
	
	/*
	 * This method adding uploaded image in the List<Images>
	 * @param image an object who creates Image class instance
	 * */
	public void addImage(Image image, MultipartFile file) throws Exception{

		checkImages(images);

		byte[] bytes = file.getBytes();
		image.setImageFile(bytes);

		byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
		String base64Encoded = new String(encodeBase64, "UTF-8");
		image.setBase64image(base64Encoded);

		//Date currentDate = new Date();
		
		Random rand = new Random();

		int  n = rand.nextInt(2) + 14;
		int  h = rand.nextInt(24);
		int  m = rand.nextInt(60);
		Date currentDate = new GregorianCalendar(2017, Calendar.NOVEMBER, n, h, m).getTime();
		
		image.setUploadDate(currentDate);

		image.setViews(0);

		images.add(image);
		
		logger.info("Image is uploaded successfully!");
	}
	
	
	public List<Image> getImages(){
		sort();
		return images;
	}
	
	/*
	 * This method checks if it reaches the maximum number of maxImageCount
	 * if it reaches, it deletes the biggest file
	 */
	public void checkImages(List<Image> images) {
		
		int n = Integer.parseInt(myProperties.getProperty("maxImageCount"));


		if (images.size() >= n) {
			Collections.sort(images, new Comparator<Image>() {
				public int compare(Image o1, Image o2) {
					if (o1.getImageFile().length == o2.getImageFile().length) {
						return 0;
					} else if (o1.getImageFile().length > o2.getImageFile().length) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			Collections.reverse(images);
			images.remove(0);
		}
	}
	
	/*
	 * This method sorts the images by date desc and time asc
	 */
	public void sort() {
		Collections.sort(images, new Comparator<Image>() {
			public int compare(Image o1, Image o2) {
				Date d1 = o1.getUploadDate();
				Date d2 = o2.getUploadDate();
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
			    c1.setTime(d1);
			    c2.setTime(d2);
			    
			    if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) & 
			    		c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) &
			    		c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
			    	if(c1.getTimeInMillis() == c2.getTimeInMillis()) {
			    		return 0;
			    	} else if(c1.getTimeInMillis() > c2.getTimeInMillis()) {
			    		return -1;
			    	} else {
			    		return 1;
			    	}
			    }
				return d1.compareTo(d2);
			}
		});
		Collections.reverse(images);
	}
	
	/*
	 * This method increases image views by its index in the list
	 */
	public String increaseImageViews(int index) {
		Image image = images.get(index);
		image.setViews(image.getViews() + 1);
		
		return String.valueOf(image.getViews());
	}
}
