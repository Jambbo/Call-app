package com.example.callapp;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CallAppService {

    private final RestTemplate restTemplate;

    private String url = "https://qrcodegenbot.onrender.com/3d7b43e3-8b70-4ee2-ac11-f3e33de19417";

    @Scheduled(fixedRate = 50000)
    public void callExternalApp() {
        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Response from external: " + response);
        } catch (Exception ignore) {
        }
    }

}
