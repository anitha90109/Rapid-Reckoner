package com.calc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calc.entity.User;
import com.calc.repository.CalRepository;

@Service
public class CalService {
	
	@Autowired
	private final CalRepository calrepo;
	User entity =new User();

	
	public CalService(CalRepository calrepo) {
		this.calrepo=calrepo;
	}
	

	public void saveDetails(String name, int marks) {
		
		/*boolean a= calrepo.findByName(name);
		if(a) {
			System.out.println("save details inside if block");

			calrepo.updateScore(name,marks);
		}
		else{
		System.out.println("save details inside else block"); 
		List<User> al=  calrepo.findByName(name);
		if(! al.isEmpty()) {
			System.out.println("Score update");
			try {
			calrepo.updateScore(name, marks);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}else {*/
		entity.setName(name);
		entity.setScore(marks);
		calrepo.save(entity);

		
	}

	

	public List<User> getTopScores() {
		 return calrepo.findAll().stream()
	                .sorted((score1, score2) -> Integer.compare(score2.getScore(), score1.getScore()))
	                .limit(5)
	                .collect(Collectors.toList());
		
	}

	public boolean findByName(String name) {
		System.out.println("find by name");
		System.out.println("save details inside ");

		return calrepo.findAll().stream().equals(name);
	}
}
