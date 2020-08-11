package messagelistscreen;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.nitin.pluralchat.R;

import java.util.ArrayList;
import java.util.List;

public class MessageListActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT_NAME = "MessageListActivity.contactName";

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private List<Message> mMessageList = new ArrayList<>();
    private String sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        this.sender = getIntent().getStringExtra(MessageListActivity.EXTRA_CONTACT_NAME);

        setTitle(sender);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageAdapter = new MessageListAdapter(this, mMessageList);
        mMessageRecycler.setAdapter(mMessageAdapter);

        updateMessageList();

        findViewById(R.id.button_take_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }

    //TO take picture
    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    public void updateMessageList(){
        Message temp = new Message("Hiiii", "12:10pm", this.sender ,false);
        mMessageList.add(temp);
        temp = new Message("Hey", "12:11pm", this.sender ,true);
        mMessageList.add(temp);
        temp = new Message("What's the plan?", "12:14pm", this.sender ,false);
        mMessageList.add(temp);
        temp = new Message("You are coming to the party right?", "12:14pm", this.sender ,false);
        mMessageList.add(temp);
        temp = new Message("Yep! I am in", "12:20pm", this.sender ,true);
        mMessageList.add(temp);
        temp = new Message("Cool, Cya at my place then", "12:22pm", this.sender ,false);
        mMessageList.add(temp);
        temp = new Message("Same time", "12:30pm", this.sender ,false);
        mMessageList.add(temp);
        temp = new Message("Cya", "12:35pm", this.sender ,true);
        mMessageList.add(temp);

        mMessageAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
