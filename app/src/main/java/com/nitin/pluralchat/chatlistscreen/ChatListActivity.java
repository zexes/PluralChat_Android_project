package com.nitin.pluralchat.chatlistscreen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nitin.pluralchat.R;

import java.util.ArrayList;

import messagelistscreen.MessageListActivity;

public class ChatListActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView mListView;
    private ChatListAdapter mListAdapter;
    private ArrayList<ChatListItem> mChatListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        mListView = (ListView)findViewById(R.id.chat_list);
        mListAdapter = new ChatListAdapter(this, mChatListItems);
        mListView.setAdapter(mListAdapter);

        mListView.setOnItemClickListener(this);

        updateChatList();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        requestReadContactsPermissions();//requesting Read Contacts Permission
        requestLocationPermission();
    }

    private void requestLocationPermission(){
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            return;

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                101);
    }

    private void requestReadContactsPermissions(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_SMS},
                100);
    }




    private void updateChatList(){
        ChatListItem temp = new ChatListItem("Harry", "How are you son?", "9:30pm");
        mChatListItems.add(temp);
        temp = new ChatListItem("Doakes", "See you at the cabin", "8:00pm");
        mChatListItems.add(temp);
        temp = new ChatListItem("Dexter", "I am out on my boat", "12:30am");
        mChatListItems.add(temp);
        temp = new ChatListItem("Debra", "Want to grab a beer", "yesterday");
        mChatListItems.add(temp);
        temp = new ChatListItem("Morgan", "What's up bro", "yesterday");
        mChatListItems.add(temp);
        temp = new ChatListItem("Rita", "My car broke down", "yesterday");
        mChatListItems.add(temp);
        temp = new ChatListItem("Codey", "Where are my doughnuts", "yesterday");
        mChatListItems.add(temp);
        temp = new ChatListItem("Masuka", "Exciting stuff man", "yesterday");
        mChatListItems.add(temp);
        temp = new ChatListItem("Batista", "Wanna go bowling", "yesterday");
        mChatListItems.add(temp);

        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent=new Intent(this, MessageListActivity.class);
        intent.putExtra(MessageListActivity.EXTRA_CONTACT_NAME, mChatListItems.get(position).contactName);
        startActivity(intent);
    }
}
