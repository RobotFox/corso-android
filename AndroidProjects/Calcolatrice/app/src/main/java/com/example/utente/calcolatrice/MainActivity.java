package com.example.utente.calcolatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int valoreprimo;
    int valoresecondo;
    int operatore;
    String risultato="";
    Button plus;
    Button minus;
    Button moltiply;
    Button div;
    Button equal;
    Button canc;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    TextView operazione;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        plus=(Button)findViewById(R.id.buttonplus);
        minus=(Button) findViewById(R.id.buttonminus);
        moltiply=(Button) findViewById(R.id.buttonmoltiply);
        div=(Button) findViewById(R.id.buttondiv);
        equal=(Button)findViewById(R.id.buttonequal);
        canc=(Button)findViewById(R.id.buttoncanc);
        zero=(Button)findViewById(R.id.button0);
        one=(Button)findViewById(R.id.button1);
        two=(Button)findViewById(R.id.button2);
        three=(Button)findViewById(R.id.button3);
        four=(Button)findViewById(R.id.button4);
        five=(Button)findViewById(R.id.button5);
        six=(Button)findViewById(R.id.button6);
        seven=(Button)findViewById(R.id.button7);
        eight=(Button)findViewById(R.id.button8);
        nine=(Button)findViewById(R.id.button9);
        operazione=(TextView)findViewById(R.id.textViewrisultato);


        if(savedInstanceState!=null){
            risultato=savedInstanceState.getString("FRA");
            operazione.setText(risultato);
        }
        else {
            risultato="";
        }

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length()==0)
                {
                    risultato="1";
                    operazione.setText(risultato);
                }
                else{
                    risultato=risultato.concat("1");
                    operazione.setText(risultato);
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length()==0)
                {
                    risultato="2";
                    operazione.setText(risultato);
                }
                else{
                    risultato=risultato.concat("2");
                    operazione.setText(risultato);
                }
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "3";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("3");
                    operazione.setText(risultato);
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "4";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("4");
                    operazione.setText(risultato);
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "5";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("5");
                    operazione.setText(risultato);
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "6";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("6");
                    operazione.setText(risultato);
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "7";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("7");
                    operazione.setText(risultato);
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "8";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("8");
                    operazione.setText(risultato);
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length() == 0) {
                    risultato = "9";
                    operazione.setText(risultato);
                } else {
                    risultato = risultato.concat("9");
                    operazione.setText(risultato);
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (risultato.length()>0) {
                    risultato = risultato.concat("0");
                    operazione.setText(risultato);
                }
            }
        });

        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                risultato="";
                operazione.setText("0");

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (risultato.length()==0)
                {
                    risultato="0";
                    valoreprimo=Integer.parseInt(risultato);
                    operatore=1;
                    operazione.setText("0");
                }

                valoreprimo=Integer.parseInt(risultato);
                operazione.setText("");
                risultato="";
                operatore=1;

                }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (risultato.length()==0)
                {
                    risultato="0";
                    valoreprimo=Integer.parseInt(risultato);
                    operatore=2;
                    operazione.setText("0");
                }

                valoreprimo=Integer.parseInt(risultato);
                operazione.setText("");
                risultato="";
                operatore=2;
            }
        });
        moltiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (risultato.length() == 0) {
                    risultato = "0";
                    valoreprimo = Integer.parseInt(risultato);
                    operatore = 3;
                    operazione.setText("0");
                }

                valoreprimo = Integer.parseInt(risultato);
                operazione.setText("");
                risultato="";
                operatore = 3;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (risultato.length() == 0) {
                    risultato = "0";
                    valoreprimo = Integer.parseInt(risultato);
                    operatore = 4;
                    operazione.setText("0");
                }

                valoreprimo = Integer.parseInt(risultato);
                operazione.setText("");
                risultato="";
                operatore = 4;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            valoresecondo=Integer.parseInt(risultato);
            switch (operatore){
                case 1:
                    risultato=Integer.toString(valoreprimo+valoresecondo);
                    operazione.setText(risultato);
                    break;
                case 2:
                    risultato=Integer.toString(valoreprimo-valoresecondo);
                    operazione.setText(risultato);
                    break;
                case 3:
                    risultato=Integer.toString(valoreprimo*valoresecondo);
                    operazione.setText(risultato);
                    break;
                case 4:
                    risultato=Integer.toString(valoreprimo/valoresecondo);
                    operazione.setText(risultato);
                    break;
            }
            }
        });
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("FRA",risultato);
    }

    private void setDisplay(){
        operazione.setText(risultato);
    }
}
