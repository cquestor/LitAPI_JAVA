package com.cquestor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.cquestor.entity.Response;

public class RequestUtil extends HTTPUtil {

    @Override
    protected HttpURLConnection getConnection(String requestUrl, HashMap<String, String> headers) throws IOException {
        HttpURLConnection connection = null;
        URL url = new URL(requestUrl);
        connection = (HttpURLConnection) url.openConnection();
        if (headers != null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                connection.setRequestProperty(key, headers.get(key));
            }
        }
        connection.setUseCaches(false);
        connection.setReadTimeout(10 * 1000);
        connection.setConnectTimeout(8 * 1000);
        connection.setInstanceFollowRedirects(false);
        return connection;
    }

    @Override
    protected void setRequestData(HttpURLConnection connection, String requestData) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        out.write(requestData);
        out.flush();
        out.close();
    }

    @Override
    protected String getResponse(HttpURLConnection connection) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            result.append(line);
        }
        br.close();
        return result.toString().equals("") ? null : result.toString();
    }

    @Override
    public Response doGet(String requestUrl, HashMap<String, String> headers) throws IOException {
        Response response = new Response();
        HttpURLConnection connection = getConnection(requestUrl, headers);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.connect();
        response.setCode(connection.getResponseCode());
        response.setUrl(requestUrl);
        response.setHeaders(connection.getHeaderFields());
        response.setText(getResponse(connection));
        connection.disconnect();
        return response;
    }

    @Override
    public Response doPost(String requestUrl, HashMap<String, String> headers, String requestData)
            throws IOException {
        Response response = new Response();
        HttpURLConnection connection = getConnection(requestUrl, headers);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.connect();
        if (requestData != null && !requestData.equals("")) {
            setRequestData(connection, requestData);
        }
        response.setCode(connection.getResponseCode());
        response.setUrl(requestUrl);
        response.setHeaders(connection.getHeaderFields());
        response.setText(getResponse(connection));
        connection.disconnect();
        return response;
    }

}
