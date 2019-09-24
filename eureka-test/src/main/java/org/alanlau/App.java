package org.alanlau;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //调用n次服务并输出结果
        for (int i = 0; i < 50; i++) {
            //调用GET请求服务
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
