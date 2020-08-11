package messagelistscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

/**
 * Created by nitinsingh on 30/09/18.
 */

public class UserStatusUpdateReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        updateUserStatus();

        Toast.makeText(context, "true" + "", Toast.LENGTH_LONG).show();
    }


    private boolean hasPermissionToWriteChatContacts(Context context){
        PackageManager pm = context.getPackageManager();
        return pm.checkPermission("com.nitin.pluralchat.WRITE_CHAT_CONTACTS", "com.nitin.myapplication") == PackageManager.PERMISSION_GRANTED;
    }














    private void updateUserStatus(){

    }

}
