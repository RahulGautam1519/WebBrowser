package com.ml.webbrowser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UrlSearch extends AppCompatActivity implements View.OnClickListener {
    private Button SearchUrlButton;
    private EditText UrlInput;
    private Button HomeButton;
    private WebView SearchWebAddress;
    String url;
    private ProgressDialog Loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);

        Loadingbar = new ProgressDialog(this);

        SearchUrlButton =(Button) findViewById(R.id.search_url_button);
        UrlInput = (EditText) findViewById(R.id.input_search_url);
        HomeButton = (Button) findViewById(R.id.home_button);
        SearchWebAddress = (WebView) findViewById(R.id.SearchWebsite);


        url = getIntent().getExtras().get("url_address").toString();
        UrlInput.setText(url);

        WebSettings webSettings = SearchWebAddress.getSettings();
        webSettings.setJavaScriptEnabled(true);
        SearchWebAddress.loadUrl(url);
        SearchWebAddress.setWebViewClient(new WebViewClient());

        SearchUrlButton.setOnClickListener(this);
        HomeButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if(SearchWebAddress.canGoBack()){
            SearchWebAddress.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == HomeButton)
        {
            finish();



            Intent homepage = new Intent(UrlSearch.this,MainActivity.class);
            startActivity(homepage);
        }

        if(view == SearchUrlButton)
        {
            SearchWebAddress();
        }

    }


    private void SearchWebAddress() {

        String Url_Address = UrlInput.getText().toString();
        if(TextUtils.isEmpty(Url_Address))
        {
            Toast empty = Toast.makeText(UrlSearch.this,"Please enter Url or Web Address",Toast.LENGTH_LONG);
            empty.show();
        }
        else
        {
            String url_Without_https = Url_Address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            Intent search = new Intent(UrlSearch.this,UrlSearch.class);
            search.putExtra("url_address",https+www+url_Without_https);
            startActivity(search);

            UrlInput.setText("");
            UrlInput.requestFocus();
        }

    }
}
