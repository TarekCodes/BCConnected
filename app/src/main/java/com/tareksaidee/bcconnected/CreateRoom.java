package com.tareksaidee.bcconnected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateRoom extends AppCompatActivity {

    EditText roomNameField;
    Button createRoomButton;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mRoomsDatabaseReference;
    private HashMap<String, String> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);
        rooms = (HashMap<String,String>) getIntent().getSerializableExtra("rooms");
        roomNameField = (EditText) findViewById(R.id.room_name_field);
        createRoomButton = (Button) findViewById(R.id.create_room_button);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRoomsDatabaseReference = mFirebaseDatabase.getReference();
        createRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = roomNameField.getText().toString();
                if(!name.equals("")){
                    if(rooms.containsKey(name)){
                        Toast.makeText(CreateRoom.this,"Already exists",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mRoomsDatabaseReference.push().setValue(name);
                    finish();
                }
            }
        });

    }


}
