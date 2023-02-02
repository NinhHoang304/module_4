package com.example.service;

import com.example.model.Setting;

import java.util.HashMap;
import java.util.Map;

public class SettingService {
    private static Map<Integer, Setting> settingMap;

    static {
        settingMap = new HashMap<>();

        settingMap.put(1, new Setting("Languages", "Page Size", "Spams filter", "Signature"));
        settingMap.put(2, new Setting("Ngôn ngữ", "Kích cỡ trang", "Bộ lọc thư rác", "Chữ ký"));
    }

}
