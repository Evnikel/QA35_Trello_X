package tests;

import org.testng.annotations.Test;

public class UserModification extends TestBase{
    @Test
    public void  testNewTab(){
        app.getUser().openTabAndSwitch();
        app.getUser().pause(1000);
    }
}
