package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @Test
    public void registrationSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("d020797000@gmail.com","Ww12345$");
        app.getHelperUser().submitRegistration();
    }
}
