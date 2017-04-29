package com.elderstudios.controller;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HelloController {

	@Autowired
	protected GuestBookService guestBookService;

	private static final String GUESTBOOK_FORM = "guestbook";
	private static final String ENTRIES_KEY = "entries";
	private static final String FORM_KEY = "form";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayGuestbook( Model model ) {

		model.addAttribute(ENTRIES_KEY, guestBookService.findAll());
		model.addAttribute(FORM_KEY, new GuestBookEntry());

		return GUESTBOOK_FORM;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String displayGuestbookItem(HttpServletRequest request, Model model ) {

		String item = request.getParameter("item");

		if(item == null){
			return "redirect:/";
		}

		model.addAttribute(ENTRIES_KEY, guestBookService.findByName(item));
		model.addAttribute(FORM_KEY, new GuestBookEntry());

		return GUESTBOOK_FORM;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String changeGuestbook(
			Model model,
			@Valid @ModelAttribute(FORM_KEY) GuestBookEntry form,
			BindingResult bindingResult ) {

		if ( bindingResult.hasErrors() ) {
			model.addAttribute(ENTRIES_KEY, guestBookService.findAll());
			return GUESTBOOK_FORM;
		}

		guestBookService.save(form);

		return "redirect:/";
	}
}