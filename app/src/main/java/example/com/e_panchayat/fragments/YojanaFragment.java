package example.com.e_panchayat.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import example.com.e_panchayat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YojanaFragment extends Fragment {

    WebView webView;
    View root;

    public YojanaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_yojana, container, false);

        webView = (WebView) root.findViewById(R.id.webview1);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://sarkariyojana.com/maharashtra/");
        return root;
    }

}
