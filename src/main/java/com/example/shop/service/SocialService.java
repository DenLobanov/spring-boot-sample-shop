package com.example.shop.service;


import com.example.shop.model.SocialAccount;

public interface SocialService {

	String getAuthorizeUrl();

	SocialAccount getSocialAccount(String authToken);
}
