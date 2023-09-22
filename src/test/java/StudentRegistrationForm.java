import DataObject.DbStudent;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {


    @BeforeTest
    public void ConfigTests() {
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.timeout = 8;


    }

    @Test
    public void FillForm() throws SQLException {

        open("https://demoqa.com/automation-practice-form");
        DbStudent.getStudentInfo();

    }


    @AfterTest
    public void Close(){
        Configuration.holdBrowserOpen = false;
    }

}
