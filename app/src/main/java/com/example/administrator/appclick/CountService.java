package com.example.administrator.appclick;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class CountService extends IntentService {

    private static final String EXTRA_PARAM1 = "com.example.administrator.appclick.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.administrator.appclick.extra.PARAM2";

    public static final String NOTIFICATION = "CountService";
    public CountService() {
        super("CountService");
    }



    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {

        Intent intent = new Intent(context, CountService.class);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {

            final String param1 = intent.getStringExtra(EXTRA_PARAM1);
            final String param2 = intent.getStringExtra(EXTRA_PARAM2);
            handleActionBaz(param1, param2);

        }
    }



    private void handleActionBaz(String param1, String param2) {

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra("name", param1);
        sendBroadcast(intent);
    }
}
