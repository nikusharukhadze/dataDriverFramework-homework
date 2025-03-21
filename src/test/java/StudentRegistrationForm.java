import DataObject.DbStudent;
import Steps.StudentSteps;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    StudentSteps studentSteps = new StudentSteps();

    @BeforeTest
    public void ConfigTests() {
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.timeout = 8;



    }

    @Test
    public void validateInsertedAndUpdatedStudentInfo() throws SQLException {

        studentSteps.InsertStudet().ValidateInsertedValues().UpdateStudet().ValidateUpdatedValue();


    }





    @AfterTest
    public void Close(){
        Configuration.holdBrowserOpen = false;
    }

}
