package com.example.nda1;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link canciones_escogida#newInstance} factory method to
 * create an instance of this fragment.
 */
public class canciones_escogida extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public canciones_escogida() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment canciones_escogida.
     */
    // TODO: Rename and change types and number of parameters
    public static canciones_escogida newInstance(String param1, String param2) {
        canciones_escogida fragment = new canciones_escogida();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final MediaPlayer[] mp = {new MediaPlayer()};
        ArrayAdapter<CharSequence> genero = ArrayAdapter.createFromResource(getContext(),R.array.generos,android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> autores = ArrayAdapter.createFromResource(getContext(),R.array.autor,android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> canciones = ArrayAdapter.createFromResource(getContext(),R.array.canciones,android.R.layout.simple_list_item_1);
        String[] cancionesS = canciones.getItem(getArguments().getInt("index")).toString().split("---");
        String[] autors = autores.getItem(getArguments().getInt("index")).toString().split("---");
        View view=inflater.inflate(R.layout.fragment_canciones_escogida, container, false);
        TextView txttitulo=view.findViewById(R.id.textTitulo);
        txttitulo.setText(genero.getItem(getArguments().getInt("index")));
        LinearLayout ll=view.findViewById(R.id.fondo);
        if(txttitulo.getText().toString().equals("POP")){
            ll.setBackground(getResources().getDrawable(R.drawable.michaeljackson));
        }
        else if(txttitulo.getText().toString().equals("ELECTRO")){
            ll.setBackground(getResources().getDrawable(R.drawable.avicii));

        }
        else if(txttitulo.getText().toString().equals("ROCK 80")){
            ll.setBackground(getResources().getDrawable(R.drawable.cyndilauper));
        }
        else if(txttitulo.getText().toString().equals("SALSA")){
            ll.setBackground(getResources().getDrawable(R.drawable.daniela));
        }
        else if(txttitulo.getText().toString().equals("CUMBIA")){
            ll.setBackground(getResources().getDrawable(R.drawable.marama));
        }
        else if(txttitulo.getText().toString().equals("BACHATA")){
            ll.setBackground(getResources().getDrawable(R.drawable.romeosantos));
        }



//        ll.setBackground(getResources().getDrawable(getResources().getIdentifier( fondo.getItem(getArguments().getInt("index")).toString(), "string", this.getContext().getPackageName())));
        Button cancion1=view.findViewById(R.id.cancion1);
        cancion1.setText(cancionesS[0]);
        Button cancion2=view.findViewById(R.id.cancion2);
        cancion2.setText(cancionesS[1]);
        Button cancion3=view.findViewById(R.id.cancion3);
        cancion3.setText(cancionesS[2]);
        Button cancion4=view.findViewById(R.id.cancion4);
        cancion4.setText(cancionesS[3]);
        Button cancion5=view.findViewById(R.id.cancion5);
        cancion5.setText(cancionesS[4]);
        ImageButton playm =view.findViewById(R.id.playm);

        ImageButton pausem =view.findViewById(R.id.pausem);
        MaterialButtonToggleGroup toggleButtonGroup = view.findViewById(R.id.toggleButtonGroup);
        ArrayAdapter<CharSequence> mp3 = ArrayAdapter.createFromResource(getContext(),R.array.mp3,android.R.layout.simple_list_item_1);
        String[] mp3s = mp3.getItem(getArguments().getInt("index")).toString().split("---");
        toggleButtonGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                Button btn=view.findViewById(group.getCheckedButtonId());
                mp[0].stop();
                TextView autor=view.findViewById(R.id.autor);
                autor.setText(autors[Integer.valueOf(btn.getTag().toString())]);
                mp[0] = MediaPlayer.create(getActivity(),getResources().getIdentifier(mp3s[Integer.valueOf(btn.getTag().toString())],"raw",getContext().getPackageName()));
                mp[0].start();
            }
        });

        playm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp[0].start();
            }
        });
        pausem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp[0].pause();
            }
        });



        return view;
    }
}