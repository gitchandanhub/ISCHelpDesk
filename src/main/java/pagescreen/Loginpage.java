package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class Loginpage extends BaseDriver
{
	Library library;
       public Loginpage()
       {
    	   super();
    	   library = new Library();
    	   
       }
       
       public void EnterUsername(String username)
       {
    	   library.clearTextbox(object.getProperty("username_id"), "id");
    	   library.Entertext(object.getProperty("username_id"), "id", username);
    	   log.info("username Entered");
       }
       public void EnterPassword(String password)
       {
    	   library.clearTextbox(object.getProperty("password_id"), "id");
    	   library.Entertext(object.getProperty("password_id"), "id", password);
    	   log.info("password Entered");
       }
       
       public void clickloginbutton()
       {
    	   library.clickonwebelement(object.getProperty("loginbutton_id"), "id");
    	   log.info("login button clicked");
       }
       
       public void selectquuestion(int index)
       {
    	   library.selectIndex(object.getProperty("Question_id"), "id", index);
    	   log.info("Security Question selected");
       }
       
       public void EnterAnswer(String ans)
       {
    	   library.Entertext(object.getProperty("Answer_id"), "id", "1");
    	   log.info("Security Answer selected");
       }
       
       public void clicksubmit()
       {
    	   library.clickonwebelement(object.getProperty("buttonsubmit_id"), "id");
    	   log.info("clicked on submit button");
       }
       public void clickcancel()
       {
    	   library.clickonwebelement(object.getProperty("buttoncancel"), "id");
    	   log.info("clicked on cancel button");
       }
       public void clicksignup()
       {
    	   library.clickonwebelement(object.getProperty("signup_id"), "id");
    	   log.info("SignUp link clicked");
       }
       
       public void clickforgotpassword()
       {
    	   library.clickonwebelement(object.getProperty("forgotpasword_id"), "id");
    	   log.info("ForgotPassword Link clicked");
       }
}
