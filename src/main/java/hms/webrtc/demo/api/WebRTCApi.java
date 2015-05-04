/*
*  (C) Copyright 2010-2015 hSenid Mobile Solutions (Pvt) Limited.
*  All Rights Reserved.
*
*  These materials are unpublished, proprietary, confidential source code of
*  hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
*  of hSenid Mobile Solutions (Pvt) Limited.
*
*  hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
*  property rights in these materials.
*/

package hms.webrtc.demo.api;

import hms.webrtc.demo.util.ResponseKey;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WebRTCApi {

    private String appId;
    private String appPassword;
    private RestTemplate restTemplate;

    private String createComponentUrl;
    private String requestScriptUrl;
    private String revokeComponentUrl;

    public boolean createComponent(String adId, String mobileNumber) {
        ProvisionComponentRequest provisionComponentRequest = new ProvisionComponentRequest();
        provisionComponentRequest.setApplicationId(appId);
        provisionComponentRequest.setPassword(appPassword);
        provisionComponentRequest.setExternalRefNo(adId);
        provisionComponentRequest.setSubscriberId(mobileNumber);
        Map<String, Object> provisionNumberResponse
                = restTemplate.postForObject(createComponentUrl, provisionComponentRequest, Map.class);
        return ResponseCode.S1000.name().equals(provisionNumberResponse.get(ResponseKey.STATUS_CODE));
    }

    public String requestScript(String adId) {
        final String scriptUrl =  createScriptUrl(requestScriptUrl, appId, appPassword, adId);
        Map<String, Object> apiScriptResponse = restTemplate.getForObject(scriptUrl, Map.class);
        if (ResponseCode.S1000.name().equals(apiScriptResponse.get(ResponseKey.STATUS_CODE))) {
            return (String) apiScriptResponse.get(ResponseKey.SCRIPT);
        }
        return "";
    }

    public boolean revokeComponent(String adId) {
        RevokeComponentRequest revokeComponentRequest = new RevokeComponentRequest();
        revokeComponentRequest.setApplicationId(appId);
        revokeComponentRequest.setPassword(appPassword);
        revokeComponentRequest.setExternalRefNo(adId);
        Map<String, Object> revokeNumberResponse = restTemplate.postForObject(revokeComponentUrl, revokeComponentRequest, Map.class);
        return ResponseCode.S1000.name().equals(revokeNumberResponse.get(ResponseKey.STATUS_CODE));
    }


    private String createScriptUrl(String requestScriptUrl, String appId, String appPassword, String adId) {
        StringBuilder scriptBuilder = new StringBuilder();
        scriptBuilder.append(requestScriptUrl).append("/app/").append(appId)
                .append("/password/").append(appPassword).append("/ref/").append(adId);
        return scriptBuilder.toString();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public String getCreateComponentUrl() {
        return createComponentUrl;
    }

    public void setCreateComponentUrl(String createComponentUrl) {
        this.createComponentUrl = createComponentUrl;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRequestScriptUrl() {
        return requestScriptUrl;
    }

    public void setRequestScriptUrl(String requestScriptUrl) {
        this.requestScriptUrl = requestScriptUrl;
    }

    public String getRevokeComponentUrl() {
        return revokeComponentUrl;
    }

    public void setRevokeComponentUrl(String revokeComponentUrl) {
        this.revokeComponentUrl = revokeComponentUrl;
    }
}
