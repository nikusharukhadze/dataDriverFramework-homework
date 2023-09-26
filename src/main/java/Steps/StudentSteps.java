package Steps;

import DataObject.DbStudent;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.sql.SQLException;

public class StudentSteps {


    @Step
    public StudentSteps InsertStudet() throws SQLException {
        DbStudent.InsertStudent();
        return this;
    }

    @Step
    public StudentSteps ValidateInsertedValues() throws SQLException {
        Assert.assertEquals(DbStudent.getStudentInfo().get(0).get(3),"Nikusha");
        Assert.assertEquals(DbStudent.getStudentInfo().get(0).get(2),"Tiko");
        Assert.assertEquals(DbStudent.getStudentInfo().get(0).get(1),"Irina");
        Assert.assertEquals(DbStudent.getStudentInfo().get(0).get(0),"Alina");

        Assert.assertEquals(DbStudent.getStudentInfo().get(1).get(3),"Rukhadze");
        Assert.assertEquals(DbStudent.getStudentInfo().get(1).get(2),"Mzhavanadze");
        Assert.assertEquals(DbStudent.getStudentInfo().get(1).get(1),"Inashvili");
        Assert.assertEquals(DbStudent.getStudentInfo().get(1).get(0),"Tkabladze");


        Assert.assertEquals(DbStudent.getStudentInfo().get(2).get(3),"5551111234");
        Assert.assertEquals(DbStudent.getStudentInfo().get(2).get(2),"5558578965");
        Assert.assertEquals(DbStudent.getStudentInfo().get(2).get(1),"5558578965");
        Assert.assertEquals(DbStudent.getStudentInfo().get(2).get(0),"5558578965");


        return this;
    }

    @Step
    public StudentSteps UpdateStudet() throws SQLException {
        DbStudent.updateStudent();
        return this;
    }

    @Step
    public StudentSteps ValidateUpdatedValue() throws SQLException {
        Assert.assertEquals(DbStudent.getStudentInfo().get(0).get(3),"Giorgi");
        return this;
    }


}
