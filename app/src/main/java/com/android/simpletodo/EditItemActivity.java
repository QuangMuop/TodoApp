package com.android.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    ArrayList<String> items;
    ImageButton btnEdit, btnSave, btnDelete, btnClose;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editText = (EditText) findViewById(R.id.edtEdit);
        btnSave = (ImageButton)findViewById(R.id.btnSave);
        btnDelete = (ImageButton)findViewById(R.id.btnDelete);
        btnClose = (ImageButton)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        );

        Bundle bd = getIntent().getExtras();
        if(bd!=null){
            String text = bd.getString("item");
            editText.setText(text);
        }
        else {
            editText.setText("");
        }
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newTxt = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newText", newTxt);
                setResult(10, intent);
                finish();
            }
        }
        );

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newTxt = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newText", newTxt);
                setResult(20, intent);
                finish();
            }
        }
        );
    }

}
