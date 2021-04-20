package org.fbstepDefinition;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.global.BaseClass;
import org.junit.Assert;
import org.pojo.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class FbLogics extends BaseClass{
	
	
	 
	@Given("openChromebrowser and launch url")
	public void openchromebrowser_and_launch_url() throws MalformedURLException {
		launchStack();
		
	    loadBrowser();
	    launchUrl("https://www.facebook.com/");
	    max();
	}
	
	@When("User have to enter valid username and valid password")
	public void user_have_to_enter_valid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
		List<Map<String, String>> usr = d.asMaps();
		 String user = usr.get(0).get("USERNAME");
		 LoginPojo lp= new LoginPojo();
		 fill(lp.getTxtEmail(),user );
		 String pass = usr.get(0).get("PASSWORD");
		 fill(lp.getTxtPass(), pass);
		}
	@Then("click login button")
	public void click_login_button() {
		LoginPojo lp=new LoginPojo();
		
	   lp.getLogin().click();
	}

	@When("User have to enter invalid username and invalid password")
	public void user_have_to_enter_invalid_username_and_invalid_password(io.cucumber.datatable.DataTable d) {
		List<Map<String, String>> usr = d.asMaps();
		 String user = usr.get(0).get("USERNAME");
		LoginPojo lp= new LoginPojo();
		 fill(lp.getTxtEmail(),user );
		 String pass = usr.get(0).get("PASSWORD");
		 fill(lp.getTxtPass(), pass);
		 

		
	}


}
