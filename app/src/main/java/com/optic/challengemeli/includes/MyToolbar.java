package com.optic.challengemeli.includes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.optic.challengemeli.R;

/*
 * PERMITE MOSTRAR UN ACTION BAR TOOLBAR EN CUALQUIER ACTIVITY CON UN METODO SIMPLE
 */
public class MyToolbar {

    public static void show(AppCompatActivity activity, String title, boolean upButton) {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

   
}
