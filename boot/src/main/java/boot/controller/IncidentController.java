package boot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Incident;
import boot.model.Student;
import boot.service.IncidentService;
import boot.service.StudentService;

@Controller
public class IncidentController {
	
	@Autowired
	private IncidentService incidentService;
	
	@GetMapping("/all-incidents")
	public String allIncidents(HttpServletRequest request){
		request.setAttribute("incidents",incidentService.findAll());
		request.setAttribute("mode","MODE_INCIDENTS");
		return "incident";
	}
	
	@GetMapping("/new-incident")
	public String newIncident(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "incident";
	}
	
	@PostMapping("/save-incident")
	public String saveIncident(@ModelAttribute Incident incident, BindingResult bidingResult, HttpServletRequest request){
		incidentService.save(incident);
		request.setAttribute("incidents", incidentService.findAll());
		request.setAttribute("mode", "MODE_INCIDENTS");
		return "incident";
		
	}
	
	@GetMapping("/update-incident")
	public String updateIncident(@RequestParam int incidentID, HttpServletRequest request){
		request.setAttribute("incident", incidentService.findIncident(incidentID));
		request.setAttribute("mode", "MODE_UPDATE");
		return "incident";
	}
	
	@GetMapping("/delete-incident")
	public String deleteIncident(@RequestParam int incidentID, HttpServletRequest request){
		incidentService.delete(incidentID);
		request.setAttribute("incidents", incidentService.findAll());
		request.setAttribute("mode", "MODE_INCIDENTS");
		return "incident";
	}



}
