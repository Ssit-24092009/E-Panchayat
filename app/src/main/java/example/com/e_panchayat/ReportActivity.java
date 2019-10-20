package example.com.e_panchayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class ReportActivity extends AppCompatActivity {

    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        mtoolbar = (Toolbar) findViewById(R.id.reporttoolbar);
        mtoolbar.setTitle("Report");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportActivity.this,DashboardActivity.class));
                finish();
            }
        });

        WebView webView = (WebView) findViewById(R.id.webreport);
        webView.loadUrl("https://planningonline.gov.in/ReportData.do?ReportMethod=getAnnualPlanReport");
    }
}
