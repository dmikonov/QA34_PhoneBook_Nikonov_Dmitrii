package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContact extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isSignOutNow()){
            app.getHelperUser().login(new User().setEmail("d020797@gmail.com").setPassword("Ww12345$"));
        }

    }

    @Test (invocationCount = 1)
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Ron"+i)
                .lastName("Bin")
                .phone("0673456787")
                .email("ddd@gmail.com")
                .address("Tel Aviv")
                .description("friend")
                .build();
        logger.info("Contact is -> "+contact.toString());
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().save2();
        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        logger.info("Check name - "+contact.getName());
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));
        logger.info("Check phone - "+contact.getPhone());


    }
}
