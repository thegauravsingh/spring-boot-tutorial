package com.springboot.jpa.tutorial;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class TutorialController {
	
	@Autowired
	private TutorialService tutorialService;
	
	@GetMapping("/tutorials")
	public List<Tutorial> getAllTutorials() {
				return tutorialService.getAllTuts();

	}
	@GetMapping("/tutorials/{id}")
	public Tutorial getTutorialById(@PathVariable("id") long id) {	
		return tutorialService.getTutById(id);
	}
	@PostMapping("/tutorials")
	public void createTutorial(@RequestBody Tutorial tutorial) {
		tutorialService.addTut(tutorial);
	}

	@PutMapping("/tutorials/{id}")
	public void updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		tutorialService.updateTut(id,tutorial);
	}
	
	@DeleteMapping("/tutorials/{id}")
	public void deleteTutorial(@PathVariable("id") long id) {
		tutorialService.deleteTut(id);
	}
	
}
