package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import com.boyue.boyuelauncher.base.BaseView;

public interface FCMSettingView extends BaseView {

    void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable,int timingTime);
}
