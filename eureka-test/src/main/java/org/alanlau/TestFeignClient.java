package org.alanlau;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 测试集成了 Hystrix 的 Feign 的功能
 */
public class TestFeignClient {
    public static void main(String[] args) throws InterruptedException {
        //创建默认的HttpClient
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        //调用多次服务并输出结果
        for (int i = 0; i < 50; i++) {
            //建立线程访问接口
            Thread t = new Thread() {
                @Override
                public void run() {
                    String url = "http://localhost:9000/feign/hello";
                    //调用Get方法请求服务
                    HttpGet httpGet = new HttpGet(url);
                    //获取响应
                    try {
                        HttpResponse response = httpClient.execute(httpGet);
                        //根据响应解析出字符串
                        System.out.println(EntityUtils.toString(response.getEntity()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            t.start();
        }

        //等待完成
        Thread.sleep(15000);
    }
}
