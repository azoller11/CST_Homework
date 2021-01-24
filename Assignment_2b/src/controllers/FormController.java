package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class FormController {
	
	public String onSubmit() {
		
		//Get the user value from the input form;
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("You clicked the submit button: " + user.getFirstName() +" " + user.getLastName());
		
		// Send the information to the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//To open  new page after the button is hit, return the file name of the desired page
		return "TestResponse.xhtml";
	}
	
	public String onFlash() {
		System.out.println("Flash!");
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		 FacesContext.getCurrentInstance().getExternalContext().getFlash().put("#{username}", "Hello World!");
		    return "TestResponse.xhtml?faces-redirect=true";
	}

}
