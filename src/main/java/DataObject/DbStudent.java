package DataObject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class DbStudent {

    public static List<List> getStudentInfo() throws SQLException {

        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();

        List allInfo = new ArrayList<>();
        List names = new ArrayList<>();
        List lastnames = new ArrayList<>();
        List phones = new ArrayList<>();

        String query = "select firstname,lastname,phone  FROM [Student].[dbo].[Students]";

        ResultSet set = st.executeQuery(query);

        while (set.next()) {
            String username = set.getString("firstname");
            String lastName = set.getString("lastname");
            String phone = set.getString("phone");
            names.add(username);
            lastnames.add(lastName);
            phones.add(phone);

        }

        allInfo.add(names);
        allInfo.add(lastnames);
        allInfo.add(phones);

        conn.close();

        return allInfo;

    }

    public static void InsertStudent() throws SQLException {
        String sql = "INSERT INTO [Student].[dbo].[Students](ID,FirstName,LastName,Phone)" + "Values(?,?,?,?)";
        Connection connection = DbConnection.getConnection();
        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setInt(1, 1004);
            st.setString(2, "Nikusha");
            st.setString(3, "Rukhadze");
            st.setString(4, "5551111234");
             int row = st.executeUpdate();
            connection.commit();
            if(row > 0)
            {
                System.out.println("Inserted Successfully!");
            } else {
                System.out.println("Not Inserted!");
            };

        } catch (SQLException e) {
            connection.rollback();
            e.getMessage();
        }

        connection.close();
    }



    public static void updateStudent() throws SQLException {
        String sql = "UPDATE  [Student].[dbo].[Students] SET FirstName='Giorgi' WHERE FirstName='Nikusha' ";
        Connection connection = DbConnection.getConnection();
        try(Statement statement = connection.createStatement()) {

            int row = statement.executeUpdate(sql);
            connection.commit();
            if (row > 0) {
                System.out.println("Updated Successfully!");
            } else {
                System.out.println("Not Updated!");
            }
            ;
        }catch (SQLException e) {
            connection.rollback();
            e.getMessage();
        }

        connection.close();




    }





}
