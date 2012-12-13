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

import com.aaronhible.model.Categories;
import com.aaronhible.service.CategoriesService;

@Controller
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(value = "/categories/all", method = RequestMethod.GET)
	public String allCategories(Model model) {
		model.addAttribute("categories", getCategoriesService().findAll());
		return "categories";
	}

	@RequestMapping(value = "/categories/images/{categoryId}/image.gif", method = RequestMethod.GET)
	public void image(final HttpServletResponse response, @PathVariable("categoryId") int id) throws IOException {
		byte[] image = this.getCategoriesService().findPicture(id);
		int length = image.length;
		String contentType = "image/gif";
		response.setContentType(contentType);
		response.setContentLength(length);
		ServletOutputStream out = response.getOutputStream();
		out.write(image);
		out.flush();
	}

	@RequestMapping(value = "/categories/show", method = RequestMethod.GET)
	public String show(@RequestParam(value="categoryId", required=true)  int id, Model model) throws IOException {
		Categories categories = this.getCategoriesService().findById(id);
		model.addAttribute("categories", categories);
		return "categoriesUpdate";
	}
	
	
	@RequestMapping(value = "/categories/update", method = RequestMethod.POST)
	public String update(@RequestParam("picture") MultipartFile upload, 
			@RequestParam(value="categoryId", required=true)  int id) throws IOException {
		Categories categories = this.getCategoriesService().findById(id);
		categories.setPicture(upload.getBytes());
		this.getCategoriesService().save(categories);
		return "categories";
	}
	
	public CategoriesService getCategoriesService() {
		return categoriesService;
	}

}
