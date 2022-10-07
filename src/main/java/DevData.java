//package org.example;
import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.utils.URIBuilder;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;

public class DevData {

    public static void main(String[] args) throws IOException, URISyntaxException {


        URI uri = new URIBuilder()

                .setScheme("https")

                .setHost("api.careeronestop.org")

                .setPath("/v1/comparesalaries/xflCdZWW2l8zbe8/wage")

                .setParameter("keyword", "15-1252.00")

                .setParameter("location", "Chicago,IL")

                .setParameter("enableMetaData", "false")

                .build();

        CloseableHttpResponse response = null;

        HttpGet httpGet = null;

        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();

            httpGet = new HttpGet(uri);

            httpGet.setHeader("Content-Type","application/json");

            httpGet.setHeader("Authorization", "Bearer MZJrWnj/TLpyPfvDYAlE+Rjgf2jvIrqFR/HyNBRDxu+qRXx9nXvYFNauE3ZEd6YaH/bS+dftVr0C9Qv8jWFmqQ==");

            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            String result =EntityUtils.toString(entity);
            System.out.println(result);
            //System.out.println(result.indexOf("105550"));
            //System.out.println("Job Description: "+result.substring(385,532)+"Median Salary:$"+result.substring(1634,1640));
            String info="Job Description: "+result.substring(385,532)+"Median Salary:$"+result.substring(1634,1640);
            System.out.println(info);

        } finally {

            if(httpGet != null) httpGet.releaseConnection();

            if(response != null) response.close();

        }

        //Testing out how to get variables



    }

}
