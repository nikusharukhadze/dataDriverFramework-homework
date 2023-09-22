package DataObject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.Selenide.$;

public class DbStudent {

    public static void getStudentInfo() throws SQLException {

        Connection conn = DbConnection.getConnection();
        Statement st =  conn.createStatement();

        String query = "select firstname,lastname,phone  FROM [Student].[dbo].[Students]";

        ResultSet set = st.executeQuery(query);

        while (set.next()){
            String username = set.getString("firstname");
            String lastName =  set.getString("lastname");
            String phone = set.getString("phone");

            $(By.xpath("//*[@id=\"firstName\"]")).sendKeys(username);
            $(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
            $(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(phone);
            $("#userForm").submit();
            WebDriverRunner.getWebDriver().navigate().refresh();
        }

        conn.close();

    }
}
