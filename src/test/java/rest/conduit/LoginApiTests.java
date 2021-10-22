package rest.conduit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LoginApiTests {
    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://13.245.237.41:5000/api")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void testApiLogin(){
        given().spec(requestSpec)
               .body("{\r\n" +
                        "  \"user\" : {\r\n" +
                        "  				\"email\" : \"testuser@mail.com\",\r\n" +
                        "  				\"password\" : \"password\"\r\n" +
                        "  			  }\r\n" +
                        "}")
        .when()
               .post("/users/login")
        .then()
               .assertThat().statusCode(200);
    }
}
