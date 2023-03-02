package com.fullstack.board.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullstack.board.service.FileService;

import javax.persistence.criteria.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RequiredArgsConstructor
@Controller
public class FileUpController {
	
	private final FileService fileService;
	
	@Value("${file.dir}")
    private String filePath;

	
	@GetMapping("/upload")
	public String tUploadForm() {
		return "/upload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) throws Exception{
		System.out.println("파일 요청됨");
		
		Long id = null;
		id = fileService.saveFile(file);
		
		Long ids[] = new Long[files.length];
		
		for(int i = 0; i<files.length;i++) {
			ids[i] = fileService.saveFile(files[i]);
		}
		
//		for(MultipartFile multipartFile : files) {
//			id = fileService.saveFile(multipartFile);
//		}
		
		redirectAttributes.addFlashAttribute("id",(ids.length!=0?ids:id));
		
		return "redirect:/success";
	}
	@GetMapping("/success")
	public void success() {
		log.info("파일 저장 완료");
	}
	
}
