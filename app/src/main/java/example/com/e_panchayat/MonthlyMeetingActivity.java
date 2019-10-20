package example.com.e_panchayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class MonthlyMeetingActivity extends AppCompatActivity {

    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_meeting);


        mtoolbar = (Toolbar) findViewById(R.id.meetingtoolbar);
        mtoolbar.setTitle("Monthly Meeting");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    }
}
