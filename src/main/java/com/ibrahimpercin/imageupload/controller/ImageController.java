package com.ibrahimpercin.imageupload.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibrahimpercin.imageupload.model.Image;
import com.ibrahimpercin.imageupload.model.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	ImageService imageService;

	/*
	 * This method displays images on the home screen
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getImages(Model model) {
		model.addAttribute("images", imageService.getImages());
		return "home";	
	}
	
	/*
	 * This method creates an instance of Image and redirect to upload page
	 */
	@RequestMapping(value = "/upload-image")
	public String inputImage(Model model) {
		model.addAttribute("image", new Image());
		return "uploadImage";
	}

	/*
	 * This method saves an image instance as Image model
	 */
	@RequestMapping(value = "/save-image", method = RequestMethod.POST)
	public String uploadImage(@ModelAttribute("image") Image image, 
			@RequestParam("file") MultipartFile file,
			Model model) throws Exception {
		
		imageService.addImage(image, file);
		return "redirect:/";
	}

	/*
	 * This method increases fullscreen image count and views on the home screen
	 */
	@RequestMapping(value = "/increase-image-views", method = RequestMethod.POST)
	@ResponseBody
	public String increaseImageViews(Model model, @RequestParam("index") int index) {
		return imageService.increaseImageViews(index);
	}

}
