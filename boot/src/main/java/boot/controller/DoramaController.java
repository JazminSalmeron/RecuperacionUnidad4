package boot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Dorama;
import boot.model.Student;
import boot.service.DoramaService;
import boot.service.StudentService;

@Controller
public class DoramaController {
	
	@Autowired
	private DoramaService doramaService;
	
	@GetMapping("/all-doramas")
	public String allDoramas(HttpServletRequest request){
		request.setAttribute("doramas",doramaService.findAll());
		request.setAttribute("mode","MODE_DORAMAS");
		return "dorama";
	}
	
	@GetMapping("/new-dorama")
	public String newDorama(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "dorama";
	}
	
	@PostMapping("/save-dorama")
	public String saveDorama(@ModelAttribute Dorama dorama, BindingResult bidingResult, HttpServletRequest request){
		doramaService.save(dorama);
		request.setAttribute("doramas", doramaService.findAll());
		request.setAttribute("mode", "MODE_DORAMAS");
		return "dorama";
		
	}
	
	@GetMapping("/update-dorama")
	public String updateDorama(@RequestParam int doramaID, HttpServletRequest request){
		request.setAttribute("dorama", doramaService.findDorama(doramaID));
		request.setAttribute("mode", "MODE_UPDATE");
		return "dorama";
	}
	
	@GetMapping("/delete-dorama")
	public String deleteDorama(@RequestParam int doramaID, HttpServletRequest request){
		doramaService.delete(doramaID);
		request.setAttribute("doramas", doramaService.findAll());
		request.setAttribute("mode", "MODE_DORAMAS");
		return "dorama";
	}



}
