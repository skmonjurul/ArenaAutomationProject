package com.restassured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static io.restassured.RestAssured.*;

public class RestApiBaseClass implements RestAssuredApiBaseVariable{
    public RestApiBaseClass() { }

    public RestApiBaseClass(String customBaseURI, int customPort, String customBasePath){
        baseURI = customBaseURI;
        port = customPort;
        basePath = customBasePath;
    }


    public URL getURL(String urlLink){
        URL url=null;
        try{
            url = new URL(urlLink);
        }
        catch (MalformedURLException e){

        }
        return url;
    }

    public URI getURI(String uriLink){
        URI uri = null;
        try{
            uri = new URI(uriLink);
        }
        catch(URISyntaxException e){

        }
        return uri;
    }
    public Response getResponseAsResponse(String path, String type){
        Response response = null;
        try{
            if(type.equalsIgnoreCase("URL"))
                response = getResponseAsResponse(new URL(path));
            if(type.equalsIgnoreCase("URI"))
                response = getResponseAsResponse(new URI(path));
        }
        catch (MalformedURLException | URISyntaxException e){
            e.printStackTrace();
        }
        return response;
    }

    public Response getResponseAsResponse(URL url){
        return when().get(url);
    }

    public Response getResponseAsResponse(URI uri){
        return when().get(uri);
    }

    public Response getJSONResponse(URL url){
        return given().accept(ContentType.JSON).when().get(url);
    }

    public Response getJSONResponse(URI uri){
        return given().accept(ContentType.JSON).when().get(uri);
    }

    public Response getXMLResponse(URL url){
        return given().accept(ContentType.XML).when().get(url);
    }

    public Response getXMLResponse(URI uri){
        return given().accept(ContentType.XML).when().get(uri);
    }

    public String getResponseAsString(Response response){
        return response.asString();
    }

    public int getStatusCode(Response response){
        return response.thenReturn().statusCode();
    }

    public void validateStatusCodeOK(Response response){
        response.then().assertThat().statusCode(SC_OK);
    }

    public void validateStatusCodeCreated(Response response){
        response.then().assertThat().statusCode(SC_CREATED);
    }

    public boolean isStatusCode(Response response, int code){
        if(response.thenReturn().statusCode() == code)
            return true;
        else
            return false;
    }

    public void assertStatusCode(Response response, int code){
        Assert.assertEquals(response.thenReturn().statusCode(), code);
    }
}
