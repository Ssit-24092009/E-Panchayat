package example.com.e_panchayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class CerActivity extends AppCompatActivity {

    WebView webView;
    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cer);


        mtoolbar = (Toolbar) findViewById(R.id.certoolbar);
        mtoolbar.setTitle("Certificate");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CerActivity.this,CerificateActivity.class));
                finish();
            }
        });

        String data = getIntent().getStringExtra("certificate_url");
        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl(data);
    }
}
