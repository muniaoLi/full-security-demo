package com.muniao.fullsecuritydemo.bean;

import lombok.Data;

@Data
public class OauthTokenResultVO
{
    String access_token;
    String token_type;
    String refresh_token;
    Long expires_in;
    String scope;
}
