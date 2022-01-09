package com.miguelstudiodeveloper.pythonwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py = Python.getInstance();
        PyObject pyobj = py.getModule("script");

        //init ui reference
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        PyObject object = pyobj.callAttr("integrate");
        textView.setText(object.toString());

        //funcaoComParametros
        PyObject object2 = pyobj.callAttr("funcaoComParametros", "10", "4");
        textView2.setText(object2.toString());
    }
}