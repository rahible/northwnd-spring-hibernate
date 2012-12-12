package com.aaronhible.mvc;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaronhible.service.CategoriesService;

@Controller
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping("/categories")
	public String allCategories(Model model) {
		model.addAttribute("categories", getCategoriesService().findAll());
		return "categories";
	}

	@RequestMapping("/categories/{id}/image.gif")
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

	public CategoriesService getCategoriesService() {
		return categoriesService;
	}

}
