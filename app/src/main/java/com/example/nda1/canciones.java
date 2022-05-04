package com.example.nda1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link canciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class canciones extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public canciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment canciones.
     */
    // TODO: Rename and change types and number of parameters
    public static canciones newInstance(String param1, String param2) {
        canciones fragment = new canciones();
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
        View view= inflater.inflate(R.layout.fragment_canciones, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnpop=view.findViewById(R.id.pop);
        Button btnelectro=view.findViewById(R.id.Electro);
        Button btnrock80=view.findViewById(R.id.Rock_80);
        Button btnsalsa=view.findViewById(R.id.Salsa);
        Button btncumbia=view.findViewById(R.id.Cumbia);
        Button btnbachata=view.findViewById(R.id.Bachata);
        btnpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               generon(view,0);
            }
        });
        btnelectro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generon(view,1);
            }
        });
        btnrock80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generon(view,2);
            }
        });
        btnsalsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generon(view,3);
            }
        });
        btncumbia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generon(view,4);
            }
        });
        btnbachata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generon(view,5);
            }
        });

    }
    public void generon(View view,Integer i){
        Bundle result = new Bundle();
        result.putInt("index", i);
        Navigation.findNavController(view).navigate(R.id.canciones_escogida,result);
    }


}
