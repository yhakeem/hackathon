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
    private  String info;
    public String data;
//constuctor
    public DevData(String keyword) throws URISyntaxException, IOException {


        URI uri = new URIBuilder()

                .setScheme("https")

                .setHost("api.careeronestop.org")

                .setPath("/v1/comparesalaries/xflCdZWW2l8zbe8/wage")

                .setParameter("keyword", keyword)

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
            //System.out.println(result);
            if(keyword.equals("15-1252.00")){
                data="Job Description: "+result.substring(385,532)+"Median Salary:$"+result.substring(1118,1124);
            }else if(keyword.equals("15-1255.00")){
                data="Job Description:"+ result.substring(340,496)+" Median Salary:$"+result.substring(1286,1291);
            }else if(keyword.equals("15-1299.08")){
                data="Job Description:"+ " Design and develop solutions to complex applications problems, system administration issues, or network concerns. Perform systems management and integration functions."+" Median Salary:$"+result.substring(637,642);
            }else if(keyword.equals("15-1299.05")){
                data="Job Description:"+"Build, maintain and upgrade security technology, such as firewalls, for the safe use of computer networks and the transmission and retrieval of information."+"Median Salary:$"+result.substring(630,635);
            }else{
                 data= "There's a problem";
            }


           this.info=data;
           //System.out.println(info);


        } finally {

            if(httpGet != null) httpGet.releaseConnection();

            if(response != null) response.close();

        }




    }


    // dont need a Setter, see contructor


    // Getter
    public String getInfo() {

        return this.info ;
    }




}




