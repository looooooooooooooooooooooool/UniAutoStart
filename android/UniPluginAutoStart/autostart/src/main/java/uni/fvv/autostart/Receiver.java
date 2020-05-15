package uni.fvv.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {

    private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("fvv auto start::", intent.getAction());

        if (intent.getAction().equals(ACTION_BOOT)) {
            Intent intentMainActivity = new Intent(intent.ACTION_MAIN);
            intentMainActivity.setClassName(context.getPackageName(),"io.dcloud.PandoraEntry");
            intentMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentMainActivity);
        }
    }
}
