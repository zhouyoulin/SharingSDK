package com.share.sharingsdk;

import android.content.Context;

import com.share.sharingsdk.config.SharingEventCode;
import com.share.sharingsdk.listener.SharingListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhouyoulin on 2019/5/5.
 */

public class SharingSDK {

    private static SharingSDK sharingSDK;

    private SharingListener sharingListener;

    private SharingSDK(){

    }

    public static SharingSDK getInstance(){
        if (sharingSDK == null) {
            sharingSDK = new SharingSDK();
        }
        return sharingSDK;
    }

    public void setSharingListener(SharingListener sharingListener){
        this.sharingListener = sharingListener;
    }

    /**
     * 初始化sdk
     * @param context 上下文
     * @param params json对象包含productId和productKey
     */
    public void init(Context context, JSONObject params) {
        try {
            String productId = params.getString("productId");
            String productKey = params.getString("productKey");
        } catch (JSONException e) {
            sharingListener.onInitFailed(SharingEventCode.EVEBT_CODE_PARAM_ERROR, "");
            e.printStackTrace();
        }
    }

    public void login(Context context) {

    }

    public void logout(Context context) {

    }

    public void pay(Context context, JSONObject payParams) {

    }

    public void commitRole(Context context, JSONObject roleParams) {

    }
}
