package com.naver.cafe.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.cafe.fileboard.service.FileBoardCommand;
import com.naver.cafe.fileboard.service.FileBoardService;

@Controller
public class FileBoardController {
	 
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	@Autowired
	private FileBoardService fileBoardService;
	@RequestMapping(value="/FileBoardAdd", method = RequestMethod.GET)
	public String FileBoardAdd(){
		return "FileBoardAdd";
	}
	@RequestMapping(value="/FileBoardAdd", method = RequestMethod.POST)
	public String FileBoardAdd(FileBoardCommand fileboardcommand){
		logger.debug(fileboardcommand.toString());
		fileBoardService.addFileBoard(fileboardcommand);
		return "redirect:/";
	}
}
