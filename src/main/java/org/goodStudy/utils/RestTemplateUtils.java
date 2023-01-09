package org.goodStudy.utils;

import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import com.alibaba.fastjson.JSON;
/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.Util
 * @Date 2021/5/14 5:35 下午
 * @Version 1.0
 */
@Component
public class RestTemplateUtils {
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * get请求，不需要配置请求头
     * 直接返回请求结果
     * @param url
     * @return
     */
    public String get(String url){
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * get请求，不需要配置请求头, 参数以object形式传入
     * 直接返回请求结果
     * @param url
     * @return
     */
    public String get(String url, Object param){
        return restTemplate.getForObject(url, String.class, param);
    }

    /**
     * get请求，需要配置请求头
     * 直接返回请求结果
     * @param url
     * @param httpHeaders
     * @return
     */
    public String get(String url , HttpHeaders httpHeaders){
        return restTemplate.getForObject(url, String.class , httpHeaders);
    }

    /**
     * get请求，不需要配置请求头
     * 返回response完成内容
     * @param url
     * @return
     */
    public String getForEntity(String url){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

    /**
     * post请求，参数形式
     * @param url
     * @param param
     * @return
     */
    public String post(String url , Map<String, Object> param){
        return restTemplate.postForObject(url, JSON.toJSON(param) , String.class);
    }

    /**
     * post请求，参数以对象的形式
     * @param url
     * @param object
     * @return
     */
    public String post(String url , Object object){
        return restTemplate.postForObject(url, object.toString(), object.getClass()).toString();
    }

    /**
     * post请求，form表单形式
     * @param url
     * @param param
     * @return
     */
    public String post(String url , MultiValueMap<String, Object> param){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<?> requestBody = new HttpEntity <>(param, headers);
        return restTemplate.postForObject(url, requestBody , String.class);
    }

    /**
     * post请求，请求体的形式
     * @param url
     * @param httpEntity
     * @param timeout
     * @return
     */
    public String post(String url , HttpEntity <?> httpEntity , int timeout){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(timeout);
        requestFactory.setReadTimeout(timeout);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate.postForObject(url, httpEntity , String.class);
    }
}
