package com.zeninbox ;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class SessionTest {

    @Test
    public void SignUp_With_TempEmail() {
        // Base URL for the API
        RestAssured.baseURI = "https://teaching-bat-60.clerk.accounts.dev";
        
        // Prepare the request payload and headers
        String requestBody = "email_address=fdampa%40yopmail.com&password=Passdd%40123&first_name=tblisi&last_name=georgian";
        
        // Send the POST request with the required headers and payload
        given()
            .header("Sec-Ch-Ua", "\"Chromium\";v=\"123\", \"Not:A-Brand\";v=\"8\"")
            .header("Sec-Ch-Ua-Platform", "\"Linux\"")
            .header("Sec-Ch-Ua-Mobile", "?0")
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.122 Safari/537.36")
            .header("Accept", "*/*")
            .header("Origin", "https://staging.zeninbox.ai")
            .header("Sec-Fetch-Site", "cross-site")
            .header("Sec-Fetch-Mode", "cors")
            .header("Sec-Fetch-Dest", "empty")
            .header("Referer", "https://staging.zeninbox.ai/")
            .header("Accept-Encoding", "gzip, deflate, br")
            .header("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
            .header("Priority", "u=1, i")
            .body(requestBody)
        .when()
            .post("/v1/client/sign_ups?__clerk_api_version=2024-10-01&_clerk_js_version=5.43.2&__clerk_db_jwt=dvb_2qqKMU6QpczRO5nMwHRszrd03Iy")
        .then()
            .statusCode(200) // Verify successful status code
            .log().all();  // Logs response details for inspection

    }
    @Test
    public void charverifiertest()
    {
        Specialchars tester = new Specialchars();
        tester.specialcharverfier();
    }
    @Test
    public void mailverifiertest()
    {
        Duplicatemail tester = new Duplicatemail();
        tester.mailverfier();
    }
@Test
    public void SQLinjectionverifiertest()
    {
        SQLinjectionverifier tester =new SQLinjectionverifier();
        tester.SQLverfier();

    }

}


