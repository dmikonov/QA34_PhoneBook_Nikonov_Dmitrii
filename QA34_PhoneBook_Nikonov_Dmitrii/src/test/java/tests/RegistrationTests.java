package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        int i = (int)System.currentTimeMillis()/1000;
        User user3 = new User().setEmail("d020797"+i+"@gmail.com").setPassword("Ww12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm2(user3);
        app.getHelperUser().submitRegistration();

    }

}
