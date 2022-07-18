package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isSignOutNow()){
            app.getHelperUser().login(new User().setEmail("d020797@gmail.com").setPassword("Ww12345$"));
        }
        app.contact().providerContactData();
    }

    @Test
    public void removeOneContactSuccess(){
        app.contact().pause(500);
        Assert.assertEquals(app.contact().removeOneContact(),1);

    }

    @Test
    public void removeAllContactsSuccess(){
        app.contact().removeAllContacts();
        app.contact().pause(500);
        Assert.assertTrue(app.contact().isNoContactsHere());
    }
}

