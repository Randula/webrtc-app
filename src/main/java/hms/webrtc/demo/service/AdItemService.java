/*
 * (C) Copyright 2010-2014 hSenid Mobile Solutions (Pvt) Limited.
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 *  of hSenid Mobile Solutions (Pvt) Limited.
 *
 * hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 */

package hms.webrtc.demo.service;


import hms.webrtc.demo.controller.bean.AdItemForm;
import hms.webrtc.demo.controller.bean.AdvertisementType;
import hms.webrtc.demo.dao.AdItemDao;
import hms.webrtc.demo.domain.AdItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdItemService {

    @Autowired
    private AdItemDao adItemDao;
    private String msisdnPatternOne;
    private String msisdnPatternTwo;
    private String codeOne;
    private String codeTwo;

    private static final Logger logger = LoggerFactory.getLogger(AdItemService.class);


    public boolean saveAdItem(AdItemForm adItemForm, String adId, String requestedScript, String uploadPosterURL) {
        try {
            AdItem adItem = createAdItem(adItemForm, uploadPosterURL, adId, requestedScript);
            adItemDao.save(adItem);
            logger.debug("Ad item Created Successfully.");
            return true;
        } catch (Exception ex) {
            logger.error("Error Occurred While creating Ad Item.", ex);
        }
        return false;
    }

    private AdItem createAdItem(AdItemForm adItemForm, String uploadPosterURL, String adId,
                                String requestedScript) {
        AdItem adItem = new AdItem();
        adItem.setAdTopic(adItemForm.getAdTopic());
        adItem.setAdCategory(adItemForm.getAdvertisementType().name());
        adItem.setAdDescription(adItemForm.getAdDescription());
        adItem.setItemPrice(adItemForm.getItemPrice());
        adItem.setMobileNumber(createCorrectMobileNumber(adItemForm.getMobileNumber()));
        adItem.setPosterUrl(uploadPosterURL);
        adItem.setDate(new Date());
        adItem.setAdId(adId);
        adItem.setScript(requestedScript);
        return adItem;
    }

    private String createCorrectMobileNumber(String mobileNumber) {
        Pattern patternOne = createPattern(msisdnPatternOne);
        Pattern patternTwo = createPattern(msisdnPatternTwo);
        if (isMatching(mobileNumber, patternOne)) {
            return codeOne + mobileNumber;
        } else if (isMatching(mobileNumber, patternTwo)) {
            return codeTwo + mobileNumber.replaceFirst("0", "");
        } else {
            return codeTwo + mobileNumber;
        }
    }

    public Pattern createPattern(String patternText) {
        return Pattern.compile(patternText);
    }

    public boolean isMatching(String data, Pattern pattern) {
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public List<AdItem> getAllAdItems() {
        return adItemDao.getAllAdItems();
    }

    public AdItem getAdUnitById(String adItemId) {
        return adItemDao.getAdUnitById(adItemId);
    }


    public void setMsisdnPatternOne(String msisdnPatternOne) {
        this.msisdnPatternOne = msisdnPatternOne;
    }

    public void setMsisdnPatternTwo(String msisdnPatternTwo) {
        this.msisdnPatternTwo = msisdnPatternTwo;
    }


    public void setCodeOne(String codeOne) {
        this.codeOne = codeOne;
    }

    public void setCodeTwo(String codeTwo) {
        this.codeTwo = codeTwo;
    }
}
