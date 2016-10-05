package org.sajjadshirazy.cordova.notification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.PendingIntent;

/**
 * This class echoes a string called from JavaScript.
 */
public class Notification extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("notify")) {
            int id = args.getInt(0);
            String title = args.getString(1);
            String message = args.getString(2);
            this.notify(id, title, message, callbackContext);
            return true;
        }
        return false;
    }

    private void notify(int id, String title, String message, CallbackContext callbackContext) {
        Context context = cordova.getActivity().getCurrentFocus().getContext();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
        .setSmallIcon(context.getApplicationInfo().icon)
        .setContentTitle(title)
        .setContentText(message);

        Intent resultIntent = new Intent(context, cordova.getActivity().getClass());

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(cordova.getActivity().getClass());
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        
        NotificationManager mNotificationManager = (NotificationManager) cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id, mBuilder.build());
    }
}
