package com.calc.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calc.entity.User;
import com.calc.service.CalService;

@Controller
public class BaseContoller {
	
	@Autowired
	 private final CalService calserv;
	 
	 
	    public BaseContoller(CalService calserv) {
	        this.calserv = calserv;
	    }
	
	
	
	int ans=0;
	int enteredValue=0;
int marks;
String name;


	@GetMapping("/cal")
	public String welcomepage()	 {
		return "welcome";
	}
	@GetMapping("/about")
	public String defectDetails() {
	    return "about";
	}
	
	@GetMapping("/details")
	public String basicdetails(Model model){
		
		return "details";
	}
	@PostMapping("/details")
	public String detailspage(@RequestParam("name") String userName,Model model) {
		name=userName;
		System.out.println("name= "+ name);
		System.out.println(userName);
        return "redirect:/startgame";
	}

	
	@GetMapping("/highscore")
	public String showTopScores(Model model) {
	    List<User> topScores = calserv.getTopScores();
	    model.addAttribute("topScores", topScores);
	    return "Scoreboard";
	}
	@RequestMapping("/startgame")
	
/*public String game(Model model) {
		
		//gererate random numbers
		
		
		int num1 = generateRandomNumber();
        int num2 = generateRandomNumber();
        String captcha = num1 + " + " + num2;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("captcha", captcha);
        
        //generate operator
        String operators[] = {"+", "-", "*"};
        String selectedOperator = operators[(int) (Math.random() * operators.length)];
        model.addAttribute("operator", selectedOperator);

        ans= performOperation(num1, num2, selectedOperator);
        model.addAttribute("result", ans);
	       System.out.println("answer"+ans);

	       System.out.println("model"+model.toString());

 	    return "startgame";
	
	}
	
	 @PostMapping("/startgame")
		 public String submitForm( @ModelAttribute("user") User user, @RequestParam("sum") int userSum, Model model) {
		        
	       System.out.println("inside submit form"+ans);
     	System.out.println("outside if " +user.getInput());
     	
     	//User us= new User();
        //model.addAttribute("user",us);
        user.setInput(userSum);
     	if(ans==userSum) {
     		
         model.addAttribute("userInput",user.getInput());
         System.out.println("marks " +marks);
         marks=marks+5;

         user.setScore(marks);
         System.out.println("marks " +user.getScore());

         System.out.println("inside if loop");
         
         
         int num1 = generateRandomNumber();
         int num2 = generateRandomNumber();
         String captcha = num1 + " + " + num2;
         model.addAttribute("num1", num1);
         model.addAttribute("num2", num2);
         model.addAttribute("captcha", captcha);
         
         //generate operator
         String operators[] = {"+", "-", "*"};
         String selectedOperator = operators[(int) (Math.random() * operators.length)];
         model.addAttribute("operator", selectedOperator);

         ans= performOperation(num1, num2, selectedOperator);
         model.addAttribute("result", ans);
         System.out.println(model.toString());

 	    return "startgame";

     	}else {
             model.addAttribute("userInput",ans);
             model.addAttribute("score",marks);
             System.out.println(model.toString());
             System.out.println("inside else loop");
             return "resultpage";
     	}

	  
	 }*/
	public String game(@ModelAttribute("user") User user,  Model model) {
		
		//gererate random numbers
		
		int num1 = generateRandomNumber();
        int num2 = generateRandomNumber();
        String captcha = num1 + " + " + num2;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("captcha", captcha);
        
        //generate operator
        String operators[] = {"+", "-", "*"};
        String selectedOperator = operators[(int) (Math.random() * operators.length)];
        model.addAttribute("operator", selectedOperator);

        ans= performOperation(num1, num2, selectedOperator);
        
        User us= new User();
        model.addAttribute("result", ans);
        model.addAttribute("user",us);
        model.addAttribute("name",name);
        System.out.println(model.toString());
        //System.out.println("level"+us.getLevel());
        
        
        
        
        
	    return "startgame";
	}
	
	  @PostMapping("/submit")
	    public String submitForm( @ModelAttribute("user") User user,  Model model) {
		  
	       System.out.println("inside submit form"+ans);
        	System.out.println("outside if " +user.getInput());
        	
        	if(ans==user.getInput()) {
        		
            model.addAttribute("userInput",user.getInput());
            System.out.println("marks " +marks);
            marks=marks+5;
            System.out.println("inside if loop");
            System.out.println(model.toString());
            
            int num1 = generateRandomNumber();
            int num2 = generateRandomNumber();
            String captcha = num1 + " + " + num2;
            model.addAttribute("num1", num1);
            model.addAttribute("num2", num2);
            model.addAttribute("captcha", captcha);
            model.addAttribute("name",name);

            //generate operator
            String operators[] = {"+", "-", "*"};
            String selectedOperator = operators[(int) (Math.random() * operators.length)];
            model.addAttribute("operator", selectedOperator);

            ans= performOperation(num1, num2, selectedOperator);
            model.addAttribute("result", ans);
            System.out.println(model.toString());

    	    return "startgame";

        	}else {
                model.addAttribute("userInput",ans);
                model.addAttribute("score",marks);
                System.out.println(model.toString());
                System.out.println("inside else loop"+marks+name);
                
                calserv.saveDetails(name,marks);//save details into table

    
                return "resultpage";
        	}

	        
	       
	
	  }
	  
	 
	  
	  
	 private int generateRandomNumber() {
	        return (int) (Math.random() * 100) + 1; // Generate a random number between 1 and 10
	    }
	 
	 public static int performOperation(int num1, int num2, String operator) {
	        switch (operator) {
	            case "+":
	                return num1 + num2;
	            case "-":
	                return num1 - num2;
	            case "*":
	                return num1 * num2;
	            
	            default:
	                throw new IllegalArgumentException("Invalid operator.");
	        }
}
}
