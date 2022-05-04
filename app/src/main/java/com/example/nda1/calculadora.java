package com.example.nda1;

import android.os.Bundle;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calculadora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calculadora extends Fragment {
    public static boolean completa=true;
    public static View v=null;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calculadora() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calculadora.
     */
    // TODO: Rename and change types and number of parameters
    public static calculadora newInstance(String param1, String param2) {
        calculadora fragment = new calculadora();
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
    Button btnRaiz, btnPi,btnPotencia,btnFactorial,btnParentesisAbierto,btnSeno,btnCos,btnTangente,btnParentesisCerrado,btnE,btnLogaritNatural,btnLogaritmo,btnAC,btnradiasexa,btnPorcentaje,btnDivicion,btnSiete,btnOcho,btnNueve,
            btnPor,btnCuatro,btnCinco,btnSeis,btnMenos,btnUno,btnDos,btnTres,btnMas,btnCero,btnPunto,btnIgual;
    ImageButton btnBorrar;
    TextView txtResultado;
    String problema="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calculadora, container, false);

        btnRaiz=(Button)  view.findViewById(R.id.btnRaiz);
        btnPi=(Button)  view.findViewById(R.id.btnPi);
        btnPotencia=(Button)  view.findViewById(R.id.btnPotencia);
        btnFactorial=(Button) view.findViewById(R.id.btnFactorial);
        btnParentesisAbierto=(Button) view.findViewById(R.id.btnParentesisAbierto);
        btnSeno=(Button) view.findViewById(R.id.btnSeno);
        btnCos=(Button) view.findViewById(R.id.btnCos);
        btnTangente=(Button) view.findViewById(R.id.btnTangente);
        btnParentesisCerrado=(Button) view.findViewById(R.id.btnParentesisCerrado);
        btnE=(Button) view.findViewById(R.id.btnE);
        btnLogaritNatural=(Button) view.findViewById(R.id.btnLogaritNatural);
        btnLogaritmo=(Button) view.findViewById(R.id.btnLogaritmo);
        btnAC=(Button) view.findViewById(R.id.btnAC);
        btnradiasexa=(Button) view.findViewById(R.id.btnradiasexa);
        btnPorcentaje=(Button) view.findViewById(R.id.btnPorcentaje);
        btnDivicion=(Button) view.findViewById(R.id.btnDivicion);
        btnSiete=(Button) view.findViewById(R.id.btnSiete);
        btnOcho=(Button) view.findViewById(R.id.btnOcho);
        btnNueve=(Button) view.findViewById(R.id.btnNueve);
        btnPor=(Button) view.findViewById(R.id.btnPor);
        btnCuatro=(Button) view.findViewById(R.id.btnCuatro);
        btnCinco=(Button) view.findViewById(R.id.btnCinco);
        btnSeis=(Button) view.findViewById(R.id.btnSeis);
        btnMenos=(Button) view.findViewById(R.id.btnMenos);
        btnUno=(Button) view.findViewById(R.id.btnUno);
        btnDos=(Button) view.findViewById(R.id.btnDos);
        btnTres=(Button) view.findViewById(R.id.btnTres);
        btnMas=(Button) view.findViewById(R.id.btnMas);
        btnCero=(Button) view.findViewById(R.id.btnCero);
        btnPunto=(Button) view.findViewById(R.id.btnPunto);
        btnBorrar=(ImageButton) view.findViewById(R.id.btnBorrar);
        btnIgual=(Button) view.findViewById(R.id.btnIgual);
        txtResultado=(TextView) view.findViewById(R.id.txtResultado);
        MotionLayout ml=view.findViewById(R.id.mlcalculadora);
        v=view;
        if(!completa){
            ml.transitionToEnd();
        }

        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"√(";
                txtResultado.setText(problema);
//                double numero1=Double.parseDouble(txtNum1.getText().toString());
//                double numero2=Double.parseDouble(txtNum2.getText().toString());
//                double resultado=numero1+numero2;
//                txtResultado.setText("El resultado es : "+resultado);
            }

        });
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"π";
                txtResultado.setText(problema);
            }
        });
        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"^";
                txtResultado.setText(problema);

            }
        });
        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"!";
                txtResultado.setText(problema);

            }
        });
        btnParentesisAbierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"(";
                txtResultado.setText(problema);
            }
        });
        btnSeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"sin(";
                txtResultado.setText(problema);
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"cos(";
                txtResultado.setText(problema);
            }
        });
        btnTangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"tan(";
                txtResultado.setText(problema);

            }
        });
        btnParentesisCerrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+")";
                txtResultado.setText(problema);
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"e";
                txtResultado.setText(problema);

            }
        });
        btnLogaritNatural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"ln(";
                txtResultado.setText(problema);
            }
        });
        btnLogaritmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"log(";
                txtResultado.setText(problema);
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema="";
                txtResultado.setText("");
            }
        });
        btnradiasexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnradiasexa.getText()=="SXG") {
                    btnradiasexa.setText("RAD");
                }else{
                    btnradiasexa.setText("SXG");
                }
            }
        });
        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"%";
                txtResultado.setText(problema);
            }
        });
        btnDivicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"➗";
                txtResultado.setText(problema);

            }
        });
        btnSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"7";
                txtResultado.setText(problema);
            }
        });
        btnOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"8";
                txtResultado.setText(problema);

            }
        });
        btnNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"9";
                txtResultado.setText(problema);
            }
        });
        btnPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"✖";
                txtResultado.setText(problema);
            }
        });
        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"4";
                txtResultado.setText(problema);

            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"5";
                txtResultado.setText(problema);

            }
        });
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"6";
                txtResultado.setText(problema);
            }
        });
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"➖";
                txtResultado.setText(problema);

            }
        });
        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"1";
                txtResultado.setText(problema);
            }
        });
        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"2";
                txtResultado.setText(problema);

            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"3";
                txtResultado.setText(problema);
            }
        });
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"➕";
                txtResultado.setText(problema);

            }
        });
        btnCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+"0";
                txtResultado.setText(problema);
            }
        });
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problema=problema+".";
                txtResultado.setText(problema);
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(problema.length()-1>=0) {
                    problema = problema.substring(0, problema.length() - 1);
                    txtResultado.setText(problema);
                }


            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter interpreter = new Interpreter();

                try {
                    if(problema.contains("!")){

                        String factor="";

                        for (int i = 0; i <problema.length(); i++) {

                            if(problema.charAt(i)=='!') {

                                for (int u = i-1; u >=0; u--) {

                                    if (!Character.isDigit(problema.charAt(u))) {

                                        problema=problema.replace(factor+"!",factorial(Long.parseLong(factor)));
                                        factor="";
                                        break;
                                    } else {
                                        factor = problema.charAt(u) + factor;
                                    }if(u-1<0){
                                        problema=problema.replace(factor+"!",factorial(Long.parseLong(factor)));
                                        factor="";
                                    }
                                }
                            }
                        }
                    }
                    if(problema.contains("^")){

                        String factor="";
                        String exponenete="";
                        for (int i = 0; i <problema.length()-1; i++) {

                            if(problema.charAt(i)=='^') {
                                for (int u = i + 1; u < problema.length(); u++) {

                                    if (!Character.isDigit(problema.charAt(u))) {

                                        if (problema.charAt(u) != '.') {
                                            for (int j = i - 1; j >= 0; j--) {
                                                if (!Character.isDigit(problema.charAt(j))) {

                                                    if (problema.charAt(j) != '.') {
                                                        problema = problema.replace(factor + "^" + exponenete,"Math.pow("+factor+","+exponenete+")");
                                                        factor = "";
                                                        exponenete = "";
                                                        break;
                                                    } else {

                                                        factor = problema.charAt(j) + factor;

                                                    }
                                                } else {
                                                    factor = problema.charAt(j) + factor;
                                                }
                                            }

                                        } else {
                                            exponenete = problema.charAt(u) + exponenete;
                                        }
                                    } else {
                                        exponenete = problema.charAt(u) + exponenete;
                                    }
                                    if(u+1==problema.length()){
                                        if(factor=="") {
                                            for (int j = i - 1; j >= 0; j--) {
                                                if (!Character.isDigit(problema.charAt(j))) {

                                                    if (problema.charAt(j) != '.') {
                                                        problema = problema.replace(factor + "^" + exponenete,"Math.pow("+factor+","+exponenete+")");
                                                        factor = "";
                                                        exponenete = "";
                                                        break;
                                                    } else {

                                                        factor = problema.charAt(j) + factor;
                                                    }
                                                } else {

                                                    factor = problema.charAt(j) + factor;
                                                }
                                            }
                                        }

                                        problema = problema.replace(factor + "^" + exponenete,"Math.pow("+factor+","+exponenete+")");
                                        factor="";
                                        exponenete="";

                                    }



                                }
                            }

                        }
                    }


                    if(btnradiasexa.getText()=="SXG"){
                        problema=problema.replace("sin(","Math.sin((Math.PI/180)*").replace("cos","Math.cos((Math.PI/180)*").replace("tan","Math.tan((Math.PI/180)*");

                    }else{
                        problema=problema.replace("sin","Math.sin").replace("cos","Math.cos")
                                .replace("tan","Math.tan");
                    }
                    if(problema.contains("(")) {
                        for (int i = 0; i <problema.length(); i++) {
                            if (problema.charAt(i)=='('&i!=0){
                                if(Character.isDigit(problema.charAt(i-1))){
                                    problema=problema.replace(problema.charAt(i-1)+"(",problema.charAt(i-1)+"*(");
                                }
                            }
                            if (problema.charAt(i)==')'& i!=problema.length()-1){
                                if(Character.isDigit(problema.charAt(i+1))){
                                    problema=problema.replace(")"+problema.charAt(i+1),")*"+problema.charAt(i+1));
                                }
                            }

                        }


                    }

                    problema=problema.replace("➕","+").replace("✖","*").replace("➖","-").replace("➗","/").replace("√","Math.sqrt")
                            .replace("π","Math.PI").replace("e","Math.E" ).replace("log","Math.log").replace("ln","Math.log10")
                            .replace("%","*1/100");
                    interpreter.eval("float result = (float)"+problema);



                    problema=interpreter.get("result").toString();
                    if(problema.charAt(problema.length()-1)=='0'&&problema.charAt(problema.length()-2)=='.'){
                        problema=problema.replace(".0","");
                    }
                    txtResultado.setText(problema);
                } catch (Error | EvalError e) {
                    Toast.makeText(getContext(),"La Operacion no es Valida "+ e,Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
    public static void cambiar(){
        MotionLayout ml=v.findViewById(R.id.mlcalculadora);
        if(!completa){
            ml.transitionToEnd();
        }else{
            ml.transitionToStart();
        }
    }
    public String factorial(Long numero){
        int n=1;
        for(int i=1;i<=numero;i++){
            n=n*i;
        }
        return String.valueOf(n);
    }

}