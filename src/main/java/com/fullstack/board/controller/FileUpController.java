package com.fullstack.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileUpController {
	
//	private final FileService fileService;
	@Value("$(file.dir)")
	private String filePath;
	
	@GetMapping("/upload")
	public String tUploadForm() {
		return "/upload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws Exception{
//		fileService.saveFile(file);
//		
//		for(MultipartFile multipartFile : files) {
//			fileService.saveFile(multipartFile);
//		}
		return "redirect:/";
	}
	
}
