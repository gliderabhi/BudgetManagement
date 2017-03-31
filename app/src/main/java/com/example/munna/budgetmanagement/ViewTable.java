package com.example.munna.budgetmanagement;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewTable extends AppCompatActivity {
   CustomAdaptor adaptor;
    DbHelper db;
    ArrayList<String> descr,date,Category;
    ArrayList<Integer> values;
    TextView remaining;
    EditText input;
    Integer balance=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_table);
        db=new DbHelper(this);
        date=new ArrayList<String>();
       descr=new ArrayList<String>();
        Category=new ArrayList<>();
       values=new ArrayList<Integer>();
        descr=db.description();
        values=db.Values();
        date=db.DateTime();
       // Category=db.Category();
        remaining=(TextView)findViewById(R.id.RemainingValue);
         ArrayList<BudgetClass> buget=new ArrayList<>();
        BudgetClass bc;
        for(int i=0;i<descr.size();++i){
             bc=new BudgetClass();
            bc.setDesc(descr.get(i));
            bc.setValues(values.get(i));
            bc.setDate(date.get(i));
          //  bc.setCategory(Category.get(i));
            buget.add(bc);
        }
        ListView lst=(ListView)findViewById(R.id.ListDesc);
       adaptor= new CustomAdaptor(buget,getApplicationContext());
         lst.setAdapter(adaptor);
       TextView txt=(TextView)findViewById(R.id.TotalValue);
        int r=db.TotalExpenses().getInt(0);
        remaining.setText(String.valueOf(balance-r));
        txt.setText(String.valueOf(db.TotalExpenses().getInt(0)));
         lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                

             }
         });
            }
    public void AddMore(View v){
        Intent i=new Intent(getApplicationContext(),DataInsert.class);
        startActivity(i);
    }

}
