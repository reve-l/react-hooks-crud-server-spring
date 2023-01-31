package com.cdev.reacthookscrudserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdev.reacthookscrudserver.model.Tutorial;
import com.cdev.reacthookscrudserver.repository.TutorialRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080"}, allowCredentials = "false")
public class TutorialController {
	
	 	@Autowired
	 	TutorialRepository tutorialRepository;
	 	
	 	//get all tutorials 	
	 	@GetMapping("/Tutorials")
	 	public List<Tutorial> getAllTutorials(){
	 		return tutorialRepository.findAll();
	 	}
	 	
	 	//Insert one tutorial
	 	@PostMapping("/Tutorials")
	 	public Tutorial createTutorial(@RequestBody Tutorial tutorial){
	 		return tutorialRepository.save(tutorial);
	 	}
	 	
	 	//get One tutorial 	
	 	@GetMapping("/Tutorials/{id}")
	 	public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id){
	 		Tutorial tutorial = tutorialRepository.findById(id)
	 				.orElseThrow(); 				
	 				//.orElseThrow(()-> new ResourceNotFoundException("Tuto n'existe pas avec id"+id));
	 		return ResponseEntity.ok(tutorial);
	 	}
	 	
	 	
	 	//Update One tutorial REST API	
	 	@PutMapping("/Tutorials/{id}")
	 	public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id, @RequestBody Tutorial tutorialupdt){
	 		Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(); 				
	 				
	 		tutorial.setTitle(tutorialupdt.getTitle());
	 		tutorial.setNbpage(tutorialupdt.getNbpage());
	 		tutorial.setDescription(tutorialupdt.getDescription());
	 		tutorial.setAuteur(tutorialupdt.getAuteur());
	 		tutorial.setPublished(tutorialupdt.isPublished());
	 		tutorial.setUpdatedAt(new Date());
	 		tutorial.setDateEdit(tutorialupdt.getDateEdit());
	 		
	 		Tutorial updateTutorial = tutorialRepository.save(tutorial);
	 		
	 		return ResponseEntity.ok(updateTutorial);
	 	}
	 	
	 	
	 	//Delete One tutorial REST API	
	 	@DeleteMapping("/Tutorials/{id}")
	 	public ResponseEntity<Map<String, Boolean>> deleteTutorial(@PathVariable Long id){
	 		Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(); 				
	 						
	 		tutorialRepository.delete(tutorial);
	 		Map<String, Boolean> response = new HashMap <>();
	 		
	 		return ResponseEntity.ok(response);
	 	}
	 	
	 	//Delete AlL tutorials REST API	
	 	@DeleteMapping("/Tutorials")
	 	public ResponseEntity<Map<String, Boolean>> deleteAllTutorial(){
	 		tutorialRepository.deleteAll(); 				
	 		Map<String, Boolean> response = new HashMap <>();
	 		
	 		return ResponseEntity.ok(response);
	 	}
	 	
	 	//Search tutorial with title 	
	 	@GetMapping("/Searcht")
	 	public ResponseEntity<List<Tutorial>> searchTutoByTitle(@RequestParam(required=false) String title){
	 		
	 	try {
	 		List<Tutorial> tutorials = new ArrayList<Tutorial>();
	 		tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
	 		
	 		if(tutorials.isEmpty()) {
	 			return new ResponseEntity<>(HttpStatus.OK);
	 		}
	 		
	 	return new ResponseEntity<>(tutorials, HttpStatus.OK);	
	 	}catch (Exception e) {
	 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 	}
	 	}
	 	
}
