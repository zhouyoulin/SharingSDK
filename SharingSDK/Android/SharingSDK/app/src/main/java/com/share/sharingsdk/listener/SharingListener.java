package com.share.sharingsdk.listener;

/**
 * Created by zhouyoulin on 2019/5/5.
 */

public interface SharingListener {

    void onInitSuccess(int code, String msg);

    void onInitFailed(int code, String msg);

    void onLoginSuccess(int code, String msg);

    void onLoginFailed(int code, String msg);

    void onLogoutSuccess(int code, String msg);

    void onLogoutFailed(int code, String msg);

    void onPaySuccess(int code, String msg);

    void onPayFailed(int code, String msg);

    void onCommitSuccess(int code, String msg);

    void onCommitFailed(int code, String msg);
}
