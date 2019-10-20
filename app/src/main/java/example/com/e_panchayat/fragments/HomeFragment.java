package example.com.e_panchayat.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.e_panchayat.CerificateActivity;
import example.com.e_panchayat.ETaxActivity;
import example.com.e_panchayat.GrievenceActivity;
import example.com.e_panchayat.MonthlyMeetingActivity;
import example.com.e_panchayat.R;
import example.com.e_panchayat.ReportActivity;
import example.com.e_panchayat.YojanaActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Dialog mDialog;
    CardView grievence,certificate,yojana,aam_sabha,monthly_meeting,e_tax,report;
    View root;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_home, container, false);

        mDialog = new Dialog(getActivity());

        aam_sabha = root.findViewById(R.id.aam_sabha_card);
        aam_sabha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUp();
            }
        });

        grievence = (CardView) root.findViewById(R.id.grievence_card);
        grievence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrievenceActivity.class));
            }
        });

        certificate = (CardView) root.findViewById(R.id.certificate_card);
        certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CerificateActivity.class));
            }
        });
        yojana = (CardView) root.findViewById(R.id.yojana_card);
        yojana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), YojanaActivity.class));
            }
        });

        monthly_meeting = (CardView) root.findViewById(R.id.monthly_meeting);
        monthly_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MonthlyMeetingActivity.class));
            }
        });
        e_tax = (CardView) root.findViewById(R.id.e_tax_card);
        e_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ETaxActivity.class));
            }
        });
        report = (CardView) root.findViewById(R.id.report_card);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ReportActivity.class));
            }
        });
        return root;
    }
    public void ShowPopUp(){
        mDialog.setContentView(R.layout.gram_sabha_popup);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

}
