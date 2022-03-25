package com.cquestor;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import com.cquestor.entity.Response;
import com.cquestor.util.RequestUtil;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    public static void main(String[] args) {
        Response response = null;
        RequestUtil request = new RequestUtil();
        HashMap<String, String> headers = new HashMap<String, String>(){{
            put("cookie", "sessionid=9wl18i4yq308i7xdpuyg67wrexfkfakj;client_vpn_ticket=ECRPB3utL67CEQDs;");
            put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82Safari/537.36");
        }};
        try {
            response = request.doGet("https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNi4xNjMuMjA1LjE2NC45OS4xNjkuMTQ5LjE1MC45Ni4yMDcuMTYxLjIxNC4xNDUuMjAzLjIwMi4xNjguOTQuMTk4LjE2Ng==/?vpn-0", headers);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(response.getHeaders());
    }
}
