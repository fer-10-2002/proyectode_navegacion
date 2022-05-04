package com.example.nda1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link peliculas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class peliculas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public peliculas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment peliculas.
     */
    // TODO: Rename and change types and number of parameters
    public static peliculas newInstance(String param1, String param2) {
        peliculas fragment = new peliculas();
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
    Integer i=0;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_peliculas, container, false);
        i=0;
        v=view;
        Button btns=view.findViewById(R.id.siguientep);
        Button btna=view.findViewById(R.id.anteriorp);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente(view);
            }
        });
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anterior(view);
            }
        });
        return view;
    }
    public void crear(Integer fin){
        ImageButton btnguia=v.findViewById(R.id.btnguia);
        ImageButton btnguia2=v.findViewById(R.id.btnguia2);
        TableLayout tableLayout=v.findViewById(R.id.tablelayout);
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) btnguia.getLayoutParams();
        LinearLayout.LayoutParams params1= (LinearLayout.LayoutParams) btnguia2.getLayoutParams();
        ArrayAdapter<CharSequence> pelis= ArrayAdapter.createFromResource(getContext(),R.array.links,android.R.layout.simple_list_item_1);
        TableRow row = new TableRow(getContext());
        TableRow rowdes=new TableRow(getContext());

        while(i!=fin){
            if(i%2==0){
                rowdes=new TableRow(getContext());
                row = new TableRow(getContext());
            }

            ImageButton ib= new ImageButton(getContext());
            ImageButton b= new ImageButton(getContext());
            CharSequence string = pelis.getItem(i);
            String[] array = string.toString().split("---");
            ib.setImageResource(this.getResources().getIdentifier("@drawable/"+ array[0], "string", getContext().getPackageName()));
            b.setTag(array[1]);
            ib.setLayoutParams(params);
            b.setLayoutParams(params1);
            b.setImageResource(R.drawable.pelicula);
            b.setBackgroundResource(R.color.transparente);
            b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ib.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ib.setTag(i);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    des(ib);
                }
            });
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    peliculaescogida(b);
                }
            });

            //ib.setText(array!!.get(0))
            ib.setBackgroundResource(R.color.transparente);
            row.addView(ib);
            rowdes.addView(b);
            if(i%2==0) {
                tableLayout.addView(rowdes,0);
                tableLayout.addView(row, 0);
            }
            i++;

        }

    }
    public void anterior(View view) {
        TableLayout tableLayout=view.findViewById(R.id.tablelayout);
        Integer cantidad=i;
        ArrayAdapter<CharSequence> pelis= ArrayAdapter.createFromResource(getContext(),R.array.links,android.R.layout.simple_list_item_1);

        if(i>8) {
            tableLayout.removeAllViews();
            if (i%8==0) {
                cantidad=i;
                i=i-8;
            } else {
                while(i%8!=0){
                    i--;
                }
                cantidad=i;
                i=i-8;
            }
            crear(cantidad);
        }
    }
    void des(View view){
        String index=view.getTag().toString();
        Bundle result = new Bundle();
        result.putString("index", index);
        Navigation.findNavController(view).navigate(R.id.descripcion,result);

    }
    public void siguiente(View view) {
        TableLayout tableLayout=view.findViewById(R.id.tablelayout);
        Integer cantidad=0;

        ArrayAdapter<CharSequence> pelis = ArrayAdapter.createFromResource(getContext(),R.array.links,android.R.layout.simple_list_item_1);
        if(i<pelis.getCount()) {
            tableLayout.removeAllViews();
            if (i + 8 > pelis.getCount()) {
                cantidad = pelis.getCount();
            } else {
                cantidad = i + 8;
            }
            crear(cantidad);
        }
    }
    public void peliculaescogida(View view) {
        String pelicula=view.getTag().toString();
        Intent intent= new Intent(getContext(), verpelicula.class);
        intent.putExtra("pelicula",pelicula);
        startActivity(intent);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crear(8);
    }






}