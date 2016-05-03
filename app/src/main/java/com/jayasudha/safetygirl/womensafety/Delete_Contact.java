package com.jayasudha.safetygirl.womensafety;

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
import android.widget.EditText;
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

public class Delete_Contact extends ActionBarActivity implements View.OnClickListener {
    TextView contactdel;
    EditText contacttextdel;
    Button delete_button;
    String s;



    private static final String MYPREFERENCES = "UserDetails";
    //private static final String MYPREF = "Number";
    SharedPreferences store;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__contact);



        contactdel=(TextView)findViewById(R.id.contactdel);
        contacttextdel=(EditText)findViewById(R.id.contacttextdel);
        delete_button=(Button)findViewById(R.id.delete_button);
        store = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        delete_button.setOnClickListener(this);

//        store2 = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);


    }
     public void onClick(View v)
     {

         switch(v.getId())
         {
             case R.id.delete_button: s= (contacttextdel.getText()).toString();
                 dynamic();
                 break;
         }
     }
    private void dynamic() {


        /*List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();*/

        int size = store.getInt("Size", 0);
        //  int size2=store2.getInt("Size",0);


        String name ;
        String number="";




        for (int i = 1; i <= size; i++) {


            String str = "";
            int count = 0;
         str=store.getString("name_"+i,"");
            if(s.equals(str)==true)
            {
                store.edit().remove("name_"+i).commit();
                store.edit().remove("number_"+i).commit();
            }







        }

    }
}

