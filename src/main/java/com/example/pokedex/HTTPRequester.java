package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

// Single purpose : only 1 purpose for the class : make an HTTP request
public class HTTPRequester implements HTTPRequesterInterface {
    public String makeRequest(String url) {
        String response;
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            response = EntityUtils.toString(result.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            response = "";
        }
        return response;
    }
}
