package com.proj.tessa.tzelee.tessaproject3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CollectInformationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_information);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collect_information, menu);
        return true;
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

    // This is the button onclick handler
    public void callSubmit(View view)
    {
        EditText mText   = (EditText)findViewById(R.id.editText);
        Intent a=new Intent(this, ResultAcitivity.class);
        a.putExtra("general_text", mText.getText().toString());

        EditText mText2   = (EditText)findViewById(R.id.editText2);
        a.putExtra("general_text_2", mText2.getText().toString());

        startActivity(a);
    }

    // Floating action button via image view
    public void callAddDetails(View view)
    {
        EditText mText   = (EditText)findViewById(R.id.editText);
        Intent a=new Intent(this, ResultAcitivity.class);
        a.putExtra("general_text", mText.getText().toString());

        EditText mText2   = (EditText)findViewById(R.id.editText2);
        a.putExtra("general_text_2", mText2.getText().toString());

        startActivity(a);

    }

}
