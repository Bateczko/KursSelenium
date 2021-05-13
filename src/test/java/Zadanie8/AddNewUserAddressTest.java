package Zadanie8;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/Cucumber/Features/add-new-user-address.feature",
            plugin = {"pretty","html:out"})

    public class AddNewUserAddressTest {
}
