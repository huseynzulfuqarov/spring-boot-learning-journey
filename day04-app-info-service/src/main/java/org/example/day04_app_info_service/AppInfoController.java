package org.example.day04_app_info_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AppInfoController {
    AppInfoProvider appInfoProvider;

    @Autowired
    public AppInfoController(AppInfoProvider appInfoProvider) {
        this.appInfoProvider = appInfoProvider;
    }

    @GetMapping("/info")
    public String getFullAppInfo() {
        return "A name of this app is " + appInfoProvider.getAppName() + " and a version of this app is " + appInfoProvider.getAppVersion();
    }

    @GetMapping("/author/{key}")
    public String getAuthorSpecificInfo(@PathVariable String key) {
        Map<String, String> authorInfo = appInfoProvider.getAuthorInfo();

        String value = authorInfo.get(key);

        if (value != null) {
            return "Author " + key + " is " + value + ".";
        } else {
            return "Info not found for key: " + key + ".";
        }
    }
}