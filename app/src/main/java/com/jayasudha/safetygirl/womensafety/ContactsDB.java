package com.jayasudha.safetygirl.womensafety;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;




public class ContactsDB extends ActionBarActivity implements View.OnClickListener{




        TextView name, number;
        EditText nametext,numtext;
        Button btSubmit;

        private static final String MYPREFERENCES = "UserDetails";
    private static final String MYPREF="Number";




        SharedPreferences store,store2;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contacts_db);

            initialise();

            btSubmit.setOnClickListener(this);
        }

        private void initialise() {
            name = (TextView) findViewById(R.id.name);
          number = (TextView) findViewById(R.id.number);


            nametext= (EditText) findViewById(R.id.nametext);
            numtext=(EditText) findViewById(R.id.numtext);


            btSubmit = (Button) findViewById(R.id.addbutton);

            store = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
          //  store2 = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);



        }




        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onClick(View v) {

            SharedPreferences.Editor editor = store.edit();
        //    SharedPreferences.Editor editor2 = store2.edit();


            int size = store.getInt("Size",0);
          //  int size2=store2.getInt("Size",0);

            size++;
          //  size2++;

            editor.putInt("Size",size);
         //   editor.putInt("Size",size2);

          /*  Set<String> set= new HashSet<String>();
            Set<String>set2=new HashSet<String>();

            set.add(nametext.getText().toString());
            set2.add(numtext.getText().toString()); */


            editor.putString("name_" + size, nametext.getText().toString());
            editor.putString("number_"+size, numtext.getText().toString());
            editor.commit();
           // editor.commit();
            Dialog d = new Dialog(this);
            d.setTitle("Contact Added");
            TextView tv = new TextView(this);
            tv.setText("Success");
            d.setContentView(tv);
            d.show();
            nametext.setText("");
            numtext.setText("");


        }
    }
