package com.vm.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.vm.base.util.Response;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 向服务提供者发起请求失败时的回滚处理
 * hystrix的回滚能力
 *
 * @author Jfei
 */
@Component
public class ServerFallback implements ZuulFallbackProvider {


    @Override
    public String getRoute() {
        return "*";//api服务id，如果需要所有调用都支持回退，则return "*"或return null
    }

    /**
     * 如果请求服务提供者失败，返回什么信息给消费者客户端
     */
    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {

            @Override
            public InputStream getBody() throws IOException {

                Response response = new Response();
                return new ByteArrayInputStream(JSONObject.toJSONString(response).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                //和body中的内容编码一致，否则容易乱码  
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return null;
            }

            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的， 
             * 不应该把api的404,500等问题抛给客户端 
             * 网关和api服务集群对于客户端来说是黑盒子 
             */


            @Override
            public int getRawStatusCode() throws IOException {

                return Response.ResponseCode.FAILURE.getCode();
            }

            @Override
            public String getStatusText() throws IOException {

                return Response.ResponseCode.FAILURE.getMsg();
            }

            @Override
            public void close() {


            }

        };
    }

}  