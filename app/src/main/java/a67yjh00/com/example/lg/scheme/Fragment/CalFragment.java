package a67yjh00.com.example.lg.scheme.Fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a67yjh00.com.example.lg.scheme.R;

public class CalFragment extends android.support.v4.app.Fragment {

    public CalFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cal, container, false);
    }
}
