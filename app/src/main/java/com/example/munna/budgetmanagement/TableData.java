package com.example.munna.budgetmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TableData extends AppCompatActivity {

    String tableName;
    EditText TableName,BalanceEdit;
    int balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_data);
        TableName=(EditText)findViewById(R.id.TableName);
        BalanceEdit=(EditText)findViewById(R.id.BalanceInitial);

    }
    public void CreateTable(View v){
        tableName=TableName.getText().toString();
        balance=Integer.valueOf(BalanceEdit.getText().toString());

    }
}
