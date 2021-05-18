package com.psycare.android;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {
    private MutableLiveData<String> selectedTab;

    public MutableLiveData<String> getSelectedTab() {
        if (selectedTab == null) {
            selectedTab = new MutableLiveData<String>();
        }
        return selectedTab;
    }
}
