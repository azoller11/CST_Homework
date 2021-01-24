package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class User {
	
	private String firstName;
	private String lastName;
	
	public User() {
		firstName = "Alex";
		lastName = "Zoller";
	}
	public String onFlash() {
		//Get the user value from the input form;
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("You clicked the flash button: " + user.getFirstName() +" " + user.getLastName());
		
		// Send the information to the POST request
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		FacesContext.getCurrentInstance().getExternalContext().getFlash();
		//To open  new page after the button is hit, return the file name of the desired page
		return "TestResponse.xhtml";
		    //return "TestResponse.xhtml?faces-redirect=true";
		}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
