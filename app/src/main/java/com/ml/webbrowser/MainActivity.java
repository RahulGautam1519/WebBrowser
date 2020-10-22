package com.ml.webbrowser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener

{

    private Button SearchButtonhome;
    private EditText InputURl;
    private Button facebook_btn;
    private Button youtube_btn;
    private Button instagram_btn;
    private Button yahoo_btn;
    private Button snapchat_btn;
    private Button google_btn;
    private ProgressDialog Loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Loadingbar = new ProgressDialog(this);

        SearchButtonhome = (Button) findViewById(R.id.search_button_home);
        InputURl = (EditText) findViewById(R.id.search_url_home);
        facebook_btn = (Button) findViewById(R.id.facebook);
        youtube_btn = (Button) findViewById(R.id.youtube);
        instagram_btn = (Button) findViewById(R.id.instagram);
        yahoo_btn = (Button) findViewById(R.id.yahoo);
        snapchat_btn = (Button) findViewById(R.id.snapchat);
        google_btn = (Button) findViewById(R.id.google);

        Loadingbar.setTitle("Hello&Welcome");
        Loadingbar.setMessage("Welcome to the world fastest browser.");
        Loadingbar.show();

        SearchButtonhome.setOnClickListener(this);
        facebook_btn.setOnClickListener(this);
        youtube_btn.setOnClickListener(this);
        instagram_btn.setOnClickListener(this);
        yahoo_btn.setOnClickListener(this);
        snapchat_btn.setOnClickListener(this);
        google_btn.setOnClickListener(this);

    }



    @Override
    public void onClick(View view)
    {
        if(view == SearchButtonhome)
        {
            OpenWebsite();
        }
        if(view == facebook_btn)
        {
            Intent Open_facebook = new Intent(MainActivity.this,UrlSearch.class);
            Open_facebook.putExtra("url_address","https://www.facebook.com");
            startActivity(Open_facebook);
        }
        if(view == youtube_btn)
        {
            Intent Open_youtube = new Intent(MainActivity.this,UrlSearch.class);
            Open_youtube.putExtra("url_address","https://www.youtube.com");
            startActivity(Open_youtube);
        }
        if(view == instagram_btn)
        {
            Intent Open_instagram = new Intent(MainActivity.this,UrlSearch.class);
            Open_instagram.putExtra("url_address","https://www.instagram.com");
            startActivity(Open_instagram);
        }
        if(view == yahoo_btn)
        {
            Intent Open_yahoo = new Intent(MainActivity.this,UrlSearch.class);
            Open_yahoo.putExtra("url_address","https://www.yahoo.com");
            startActivity(Open_yahoo);
        }
        if(view == snapchat_btn)
        {
            Intent Open_snapchat = new Intent(MainActivity.this,UrlSearch.class);
            Open_snapchat.putExtra("url_address","https://www.snapchat.com");
            startActivity(Open_snapchat);
        }
        if(view == google_btn)
        {
            Intent Open_google = new Intent(MainActivity.this,UrlSearch.class);
            Open_google.putExtra("url_address","https://www.google.com");
            startActivity(Open_google);
        }

    }

    private void OpenWebsite() {
        Loadingbar.setTitle("Loading..");
        Loadingbar.setMessage("Please wait while we are opening your requested web address.");
        Loadingbar.show();

        String Url_Address = InputURl.getText().toString();
        if(TextUtils.isEmpty(Url_Address))
        {
           Toast empty = Toast.makeText(MainActivity.this,"Please enter Url or Web Address",Toast.LENGTH_LONG);
           empty.show();
        }
        else
        {
            String url_Without_https = Url_Address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            Intent search = new Intent(MainActivity.this,UrlSearch.class);
            search.putExtra("url_address",https+www+url_Without_https);
            startActivity(search);

            InputURl.setText("");
            InputURl.requestFocus();
        }
    }
}





