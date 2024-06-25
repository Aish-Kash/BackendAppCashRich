package com.cashrich.service.Impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashrich.model.CoinRequest;
import com.cashrich.model.CryptoResponse;
import com.cashrich.model.User;
import com.cashrich.repository.CoinRequestRepository;
import com.cashrich.repository.UserRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinService {

	private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETHLTC";
    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoinRequestRepository coinRequestRepository;

    @Autowired
    private RestTemplate restTemplate;

    public CryptoResponse getCoinDetails( Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        //String url = API_URL + "?symbol=" + coinId;
        Map<String, String> headers = new HashMap();
        CryptoResponse cryptoResponse = new CryptoResponse(); 
        headers.put("X-CMC_PRO_API_KEY", API_KEY);
        
        cryptoResponse = restTemplate.getForObject(API_URL, CryptoResponse.class, headers);

        CoinRequest coinRequest = new CoinRequest();
        coinRequest.setUser(user);
        coinRequest.setSymbol("BTC,ETHLTC");
        coinRequest.setResponse(cryptoResponse.toString());
        coinRequest.setTimestamp(LocalDateTime.now());

        coinRequestRepository.save(coinRequest);

        return cryptoResponse;
    }
}
