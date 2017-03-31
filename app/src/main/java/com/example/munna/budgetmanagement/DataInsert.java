package com.example.munna.budgetmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DataInsert extends AppCompatActivity {
    EditText description,value,date;
    String desc;
    int values;
    Spinner category;
    String selectedCategory;
    String categories [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);

        /*categories= new String[]{"Food", "Traveling","Udhar","CLothing","Studies","Fashion or Body maintainance,Money Return","Money Added To account"};

        category=(Spinner)findViewById(R.id.CategoryOfExpenses);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(dataAdapter);

        category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory=categories[position];
                Toast.makeText(getApplicationContext(),selectedCategory,Toast.LENGTH_LONG).show();
            }
        });*/
        description=(EditText)findViewById(R.id.ExpensesDescriptionText);
        value=(EditText)findViewById(R.id.ExpenseValueText);
    }
    public void AddValues(View v){
        DbHelper db;
        desc=description.getText().toString();
        values=Integer.valueOf(value.getText().toString());
        db=new DbHelper(this);
        db.insertExpenditure(desc,values/*,selectedCategory*/);
      changeToview();
    }
    public void changeToview(){
        Intent i=new Intent(DataInsert.this,ViewTable.class);
        startActivity(i);
    }
}
