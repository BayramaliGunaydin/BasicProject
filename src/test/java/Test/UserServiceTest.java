package Test;

import Model.LoginUser;
import Model.User;
import Utils.Constant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserServiceTest {
    public static User user;
    public static LoginUser loginUser;
    @Test
    @Given("Check failed username with {string} parameter")
    public void getuserbyıd(String username){
        user=new User();
        Response response=given().auth().oauth2(Constant.token)
                .when().get(Constant.baseUrl+"/user/1");
        user=response.then().extract().as(User.class);
        System.out.print(user);
        Assert.assertEquals("Status code not 400",response.statusCode(),400);
        Assert.assertNotEquals("Wrong name",user.getUsername(),username);
    }

    @Test
    @Given("Check successful Login with {string} and {string} parameters")
    public void succeslogin(String username,String password){
        loginUser=new LoginUser();
        String data="{\n \"username\":\""+username+"\",\n \"password\":\""+password+"\"\n}";
        Response response= given().contentType(ContentType.JSON).body(data).post(Constant.baseUrl+"/login");
        loginUser=response.then().extract().as(LoginUser.class);
        Assert.assertEquals("Status code not 200",response.statusCode(),200);
        Assert.assertEquals("Login failed because of id",loginUser.getId()>0,true);
        Assert.assertNotEquals("Login failed because user role null",loginUser.getRole(),null);
        Assert.assertNotEquals("Login failed because token is null",loginUser.getMessage(),null);
    }
    @Test
    @Given("Check failed Login with {string} and {string} parameters")
    public void faillogin(String username,String password){
        String data="{\n \"username\":\""+username+"\",\n \"password\":\""+password+"\"\n}";
        Response response= given().contentType(ContentType.JSON).body(data).post(Constant.baseUrl+"/login");
        Assert.assertEquals("Status code not 401",response.statusCode(),401);
    }
}
