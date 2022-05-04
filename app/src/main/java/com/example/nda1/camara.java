package com.example.nda1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link camara#newInstance} factory method to
 * create an instance of this fragment.
 */
public class camara extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public camara() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment camara.
     */
    // TODO: Rename and change types and number of parameters
    public static camara newInstance(String param1, String param2) {
        camara fragment = new camara();
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
    final int Photo=1;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_camara, container, false);
        Button btniac=view.findViewById(R.id.ircamara);
        btniac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=getContext().getPackageManager().getLaunchIntentForPackage("com.android.camera");
                startActivity(n);
            }
        });
        Button btntf=view.findViewById(R.id.tomarfoto);
        btntf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tomarfoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(tomarfoto.resolveActivity(getActivity().getPackageManager())!=null){
                    File photofile=null;
                    try{
                        photofile=crearfoto();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(photofile!=null){
                        Uri photoUri= FileProvider.getUriForFile(getContext(),"com.example.nda1",photofile);
                        tomarfoto.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);

                        startActivityForResult(tomarfoto,Photo);
                    }
                }
            }
        });
        return view;
    }
    String mA="";
    private File crearfoto() throws IOException {
        String timestap = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String imageFile = "imagen " + timestap;
        File storageFile = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File photofile = File.createTempFile(
                imageFile, ".jpg", storageFile
        );
        mA=photofile.getAbsolutePath();
        return photofile;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==Photo && resultCode==getActivity().RESULT_OK){
            Uri uri=Uri.parse(mA);
            ImageView imgcamara=view.findViewById(R.id.imgcamara);
            imgcamara.setImageURI(uri);


        }
    }
}
