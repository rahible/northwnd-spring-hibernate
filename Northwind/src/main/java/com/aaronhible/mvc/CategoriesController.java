package com.aaronhible.mvc;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aaronhible.model.Category;
import com.aaronhible.service.CategoryService;

@Controller
public class CategoriesController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String all(Model model) {
		model.addAttribute("categories", getCategoriesService().findAll());
		return "categories";
	}

	@RequestMapping(value = "/categories/images/{id}/image.gif", method = RequestMethod.GET)
	public void image(final HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		byte[] image = this.getCategoriesService().findPicture(id);
		int length = image.length;
		String contentType = "image/gif";
		response.setContentType(contentType);
		response.setContentLength(length);
		ServletOutputStream out = response.getOutputStream();
		out.write(image);
		out.flush();
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") int id, Model model) throws IOException {
		Category category = this.getCategoriesService().findById(id);
		model.addAttribute("category", category);
		return "categoriesUpdate";
	}
	
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
	public String update(@RequestParam("picture") MultipartFile upload, 
			@PathVariable("id") int id) throws IOException {
		Category category = this.getCategoriesService().findById(id);
		category.setPicture(upload.getBytes());
		this.getCategoriesService().save(category);
		return "categories";
	}
	
//	@RequestMapping(value = "/categories", method = RequestMethod.POST)
//	public String create(@RequestParam("picture") MultipartFile upload, 
//			@RequestParam(value="id", required=true)  int id) throws IOException {
//		Category category = this.getCategoriesService().findById(id);
//		category.setPicture(upload.getBytes());
//		this.getCategoriesService().save(category);
//		return "categories";
//	}

	public CategoryService getCategoriesService() {
		return categoryService;
	}

}
