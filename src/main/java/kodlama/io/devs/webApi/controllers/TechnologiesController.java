package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.technologies.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return this.technologyService.getAll();

	}

	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		this.technologyService.add(createTechnologyRequest);
	}

	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		this.technologyService.update(updateTechnologyRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		this.technologyService.delete(deleteTechnologyRequest);
	}

}
