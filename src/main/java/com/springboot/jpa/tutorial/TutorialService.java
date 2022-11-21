package com.springboot.jpa.tutorial;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialrepository;
	
	//private List<Tutorial> tuts = new ArrayList<> (Arrays.asList(
	//		new Tutorial(1,"Life of Pi", "Fiction",true),
	//		new Tutorial(2,"Springboot", "Programming", true),
	//		new Tutorial(3,"Spring", "Programming", true),
	//		new Tutorial(4,"Python", "Programming", true)
	//		));
			
	public List<Tutorial> getAllTuts()
	{
		List<Tutorial> tuts = new ArrayList<> ();
		tutorialrepository.findAll().forEach(tuts::add);
		return tuts;
	}
	public Tutorial getTutById(long Id)
	{
		//return tuts.stream().filter(tut -> tut.getId() == Id).findFirst().get();
		Optional<Tutorial> tutorialPromise = tutorialrepository.findById(Id);
		return tutorialPromise.get();
	}	
	public void addTut(Tutorial tutorial)
	{
	 //tuts.add(tutorial);
		tutorialrepository.save(tutorial);
	}	
	public void updateTut(long Id,Tutorial tutorial)
	{
		//for(int i = 0; i < tuts.size(); i++)
		//{
		//	if (tuts.get(i).getId() == Id) {
		//		tuts.set(i, tutorial);
		//	}
		//}
		tutorialrepository.save(tutorial);
	}
	public void deleteTut(long Id) {
		//tuts.removeIf(tut -> tut.getId() == Id);
		tutorialrepository.deleteById(Id);
	}	
	
}