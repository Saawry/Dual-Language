package com.gadware.duallanguage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

public final class ContextUtil extends ContextWrapper {


    public ContextUtil( Context base) {
        super(base);
    }


    public static ContextWrapper updateLocale( Context c,Locale localeToSwitchTo) {


        Context context = c;
        Resources resources = c.getResources();


        Configuration configuration = resources.getConfiguration();


        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = new LocaleList(localeToSwitchTo);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
        } else {
            configuration.locale = localeToSwitchTo;
        }

        if (Build.VERSION.SDK_INT >= 25) {
            context = c.createConfigurationContext(configuration);

        } else {
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }

        return new ContextUtil(context);
    }
}
