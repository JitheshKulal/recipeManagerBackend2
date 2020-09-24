package com.api.recipeManager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.api.recipeManager.service.FileService;

@RequestMapping("upload/")
@RestController
public class FileUploadController {

	@Autowired
	FileService fileService;

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		fileService.uploadFile(file);

		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

}
