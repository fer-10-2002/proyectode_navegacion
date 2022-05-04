package com.example.nda1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link descripcion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class descripcion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public descripcion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment descripcion.
     */
    // TODO: Rename and change types and number of parameters
    public static descripcion newInstance(String param1, String param2) {
        descripcion fragment = new descripcion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private static final long SPLASH_SCREEN_DELAY=4000;
    Animation logon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_descripcion, container, false);
        TextView nombrepeli=view.findViewById(R.id.nombrepeli);
        logon= AnimationUtils.loadAnimation(getContext(),R.anim.logo_animation);
        TextView descri=view.findViewById(R.id.descri);
        descri.setAnimation(logon);
        ImageView imagenpeli=view.findViewById(R.id.imagenpeli);
        ImageButton play=view.findViewById(R.id.play);

        TimerTask time=new TimerTask() {
            @Override
            public void run() {
            }
        };
        Timer timer=new Timer();
        timer.schedule(time,SPLASH_SCREEN_DELAY);


        ArrayAdapter<CharSequence> pelis = ArrayAdapter.createFromResource(getContext(),R.array.links,android.R.layout.simple_list_item_1);
        String peli= getArguments().getString("index").toString();

        String[] array = pelis.getItem(Integer.valueOf(peli)).toString().split("---");
        nombrepeli.setText(array[2]);
        descri.setText(array[3]);
        imagenpeli.setImageResource(this.getResources().getIdentifier("@drawable/"+ array[0], "string", getContext().getPackageName()));
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pelicula=array[1];
                play(pelicula,view);
            }
        });
        return view;
    }
    void play(String pelicula,View view){
        Intent intent= new Intent(getContext(), verpelicula.class);
        intent.putExtra("pelicula",pelicula);
        startActivity(intent);
    }



}
