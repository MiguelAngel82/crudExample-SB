package com.example.controller;

import com.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("authors", authorService.list());
		return "author/list";
	}
	
	@RequestMapping("/view")
	public String view(Model model){
		return "author/view";
	}
}
