package com.aaronhible.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aaronhible.model.Category;
import com.aaronhible.service.CategoryService;

@Controller
public class CategoriesController {
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Returns all Categories
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<com.aaronhible.dto.Category> all() {
		return getCategoriesService().findAll();
//		return "categories";
	}

	/**
	 * Returns the Picture as a image.gif from the database.
	 * @param response
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/categories/images/{id}/image.gif", method = RequestMethod.GET)
	public void image(final HttpServletResponse response,
			@PathVariable("id") int id) throws IOException {
		byte[] image = this.getCategoriesService().findPicture(id);
		int length = image.length;
		String contentType = "image/gif";
		response.setContentType(contentType);
		response.setContentLength(length);
		ServletOutputStream out = response.getOutputStream();
		out.write(image);
		out.flush();
	}

	/**
	 * Returns a specified category based on the id, and forwards to the update page.
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Category read(@PathVariable("id") int id)
			throws IOException {
		return this.getCategoriesService().findById(id);
//		model.addAttribute("category", category);
//		return "categoriesUpdate";
	}

	/**
	 * The update is a post since put does not work with a multipart request.  Maybe look
	 * at changing the file update to be separate from the other items updates.  
	 * 
	 * @param upload
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
	public String update(@RequestParam("picture") MultipartFile upload,
			@PathVariable("id") int id) throws IOException {
		Category category = this.getCategoriesService().findById(id);
		if (!upload.isEmpty()) {
			category.setPicture(upload.getBytes());
		}
		this.getCategoriesService().save(category);
		return "redirect:"+id;
	}

	/*
	 * 
	 * public @ResponseBody MyObject getMyOjbect() {
	 * 		return myObject;
	 * } 
	 * 
	 * 
	 */
	
	// @RequestMapping(value = "/categories", method = RequestMethod.POST)
	// public String create(@RequestParam("picture") MultipartFile upload,
	// @RequestParam(value="id", required=true) int id) throws IOException {
	// Category category = this.getCategoriesService().findById(id);
	// category.setPicture(upload.getBytes());
	// this.getCategoriesService().save(category);
	// return "categories";
	// }

	public CategoryService getCategoriesService() {
		return categoryService;
	}

}
