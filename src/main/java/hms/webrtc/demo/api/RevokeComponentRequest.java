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

import java.io.Serializable;

public class RevokeComponentRequest implements Serializable {
    private static final long serialVersionUID = 796216566531619067L;
    private String applicationId;
    private String password;
    private String externalRefNo;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExternalRefNo() {
        return externalRefNo;
    }

    public void setExternalRefNo(String externalRefNo) {
        this.externalRefNo = externalRefNo;
    }

    @Override
    public String toString() {
        return "RevokeNumberRequest{" +
                "applicationId='" + applicationId + '\'' +
                ", password='" + password + '\'' +
                ", externalRefNo='" + externalRefNo + '\'' +
                '}';
    }
}
