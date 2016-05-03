package com.jayasudha.safetygirl.womensafety;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.widget.RadioGroup.LayoutParams.*;

public class ViewContactDB extends ActionBarActivity implements View.OnClickListener {


    private static final String MYPREFERENCES = "UserDetails";
    Button delete;
    //private static final String MYPREF = "Number";
    SharedPreferences store,store2;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact_db);


        store = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        delete=(Button)findViewById(R.id.delete);
        delete.setOnClickListener(this);

//        store2 = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);

        dynamic();
    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
                case  R.id.delete:
            Intent l=new Intent("android.intent.action.Delete_Contact");
            startActivity(l);
            break;
        }
    }

    private void dynamic() {


        /*List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();*/

        int size = store.getInt("Size", 0);
      //  int size2=store2.getInt("Size",0);

        String name ;
        String number="";
        LinearLayout l=(LinearLayout)findViewById(R.id.linear_layout);
        TableLayout t=(TableLayout)findViewById(R.id.table_layout);
        //t.removeAllViewsInLayout();
        TableRow tr1=new TableRow(this);
        tr1.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        TextView col1=new TextView(this);
         col1.setText("Name");
        TextView col2=new TextView(this);
        col2.setText(" "+" "+" "+" "+" "+" "+" "+" "+ " "+"Number");

        tr1.addView(col1);
        tr1.addView(col2);
        t.addView(tr1, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));


        for (int i = 1; i <= size; i++) {
       /*     Set<String> set = new HashSet<String>();
            set = store.getStringSet("_" + i, null);
            Set<String> set2 = new HashSet<String>();
            set2 = store2.getStringSet("contact_" + i, null); */

            String str = "";
            int count = 0;
            TableRow tr=new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT));

            TextView c1=new TextView(this);
            TextView c2=new TextView(this);
                c1.setText(store.getString("name_"+i,""));
                tr.addView(c1);
                c2.setText(" "+" "+" "+" "+" "+" "+" "+" "+ " "+store.getString("number_"+i,""));
              // c2.setCol(2);
                tr.addView(c2);



       /*     for (String a : set) {

                if (count == 0) {
                    name = a;
                    c1.setText(name);
                    tr.addView(c1);
                }
            }
            count=1;
             for(String b:set2)
             {

                if (count == 1) {
                   number=" "+" "+" "+" "+" "+b;
                    c2.setText(number);
                   tr.addView(c2);
                }


            } */

            t.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));


        }

    }
}

