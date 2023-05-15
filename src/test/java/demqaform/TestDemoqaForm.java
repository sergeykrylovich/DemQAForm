package demqaform;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.ClickOptions.*;

import static com.codeborne.selenide.Selenide.*;

public class TestDemoqaForm {

    @BeforeAll
    static void beforeAll () {

        browser = "chrome";
        baseUrl = "https://demoqa.com";
    }

    @Test
    void testForm() {
        //Open practice form
        open("/automation-practice-form");
        //Remove footer, so that it does not interfere with pressing submit button
        executeJavaScript("$('footer').remove()");

        //Set fields with data
        $("#firstName").setValue("John");
        $("#lastName").setValue("Malkovich");
        $("#userEmail").setValue("JohnMalkovich@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("4441122345");

        //Select all data in 'Date of Birth' field
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        //append a birth date to the 'Date of Birth' field and press enter
        $("#dateOfBirthInput").append("02 FEB 1990").pressEnter();

        //add data to the 'Subjects' field
        $("#subjectsInput").setValue("Maths").pressEnter().setValue("Physics").pressEnter();

        //select all checkboxes of the 'Hobbies' field
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();

        //uploading file for picture
        File file = new File("d:/3199.xml");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("17 Dean St, Brooklyn, NY 11201, USA");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click(withTimeout(Duration.ofSeconds(1)));

    }
}
