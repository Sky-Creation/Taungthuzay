package com.ttz.taungthuzay.notification;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.MenuItem;

public class NotificationCountSetClass extends Activity {
    public NotificationCountSetClass() {
        //constructor
    }

    public static void setAddToCart(Context context, MenuItem item, int numMessages) {
        LayerDrawable icon = (LayerDrawable) item.getIcon();
        SetNotificationCount.setBadgeCount(context, icon, NotificationCountSetClass.setNotifyCount(numMessages));

    }

    public static int setNotifyCount(int numMessages) {
        return numMessages;

    }


}
