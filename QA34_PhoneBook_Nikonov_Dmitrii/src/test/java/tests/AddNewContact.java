package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AddNewContact extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isSignOutNow()){
            app.getHelperUser().login(new User().setEmail("d020797@gmail.com").setPassword("Ww12345$"));
        }

    }

    @Test
    public void addNewContactSuccess(){
        Contact contact = Contact.builder()
                .name("Ron")
                .lastName("Bin")
                .phone("0673456787")
                .address("Tel Aviv")
                .description("friend")
                .build();
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().save();

    }
}
