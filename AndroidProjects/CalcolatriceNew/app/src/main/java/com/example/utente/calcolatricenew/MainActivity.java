package com.example.utente.calcolatricenew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonplus,buttonminus,buttonper,buttondiv,buttonequals,buttoncanc;
    TextView tvrisultato,tvoperazione;
    String operazione="";
    int risultato=0;
    boolean controllo=false;
    String storico="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvoperazione = (TextView) findViewById(R.id.textViewOperazione);
        tvrisultato = (TextView) findViewById(R.id.textViewRisultato);
        if (savedInstanceState != null) {
            operazione = savedInstanceState.getString("STR");

            tvoperazione.setText(operazione);

        }
        else {
            operazione="";

        }
        if (savedInstanceState != null) {

            risultato= savedInstanceState.getInt("NUM");

            tvrisultato.setText(Integer.toString(risultato));
        }
        else {
            risultato=0;
        }




            button0 = (Button) findViewById(R.id.button0);

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("0");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button1 = (Button) findViewById(R.id.button1);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("1");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button2 = (Button) findViewById(R.id.button2);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("2");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button3 = (Button) findViewById(R.id.button3);

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("3");
                        tvoperazione.setText(operazione);
                    }

                }
            });
            button4 = (Button) findViewById(R.id.button4);

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("4");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button5 = (Button) findViewById(R.id.button5);

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("5");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button6 = (Button) findViewById(R.id.button6);

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("6");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button7 = (Button) findViewById(R.id.button7);

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("7");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button8 = (Button) findViewById(R.id.button8);

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("8");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            button9 = (Button) findViewById(R.id.button9);

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {

                    } else {
                        operazione = operazione.concat("9");
                        tvoperazione.setText(operazione);
                    }

                }
            });

            buttonplus = (Button) findViewById(R.id.buttonplus);

            buttonplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione != "") {
                        if (operazione.charAt(operazione.length() - 1) == '+' || operazione.charAt(operazione.length() - 1) == '-' || operazione.charAt(operazione.length() - 1) == '*' || operazione.charAt(operazione.length() - 1) == '/' || operazione.charAt(operazione.length() - 1) == '=') {
                        } else {
                            operazione = operazione.concat("+");
                            tvoperazione.setText(operazione);
                        }

                    }

                }
            });

            buttonminus = (Button) findViewById(R.id.buttonminus);

            buttonminus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione != "") {
                        if (operazione.charAt(operazione.length() - 1) == '+' || operazione.charAt(operazione.length() - 1) == '-' || operazione.charAt(operazione.length() - 1) == '*' || operazione.charAt(operazione.length() - 1) == '/' || operazione.charAt(operazione.length() - 1) == '=') {
                        } else {
                            operazione = operazione.concat("-");
                            tvoperazione.setText(operazione);
                        }

                    }
                }
            });

            buttonper = (Button) findViewById(R.id.buttonper);

            buttonper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione != "") {
                        if (operazione.charAt(operazione.length() - 1) == '+' || operazione.charAt(operazione.length() - 1) == '-' || operazione.charAt(operazione.length() - 1) == '*' || operazione.charAt(operazione.length() - 1) == '/' || operazione.charAt(operazione.length() - 1) == '=') {
                        } else {
                            operazione = operazione.concat("*");
                            tvoperazione.setText(operazione);
                        }
                    }

                }
            });

            buttondiv = (Button) findViewById(R.id.buttondiv);

            buttondiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione != "") {
                        if (operazione.charAt(operazione.length() - 1) == '+' || operazione.charAt(operazione.length() - 1) == '-' || operazione.charAt(operazione.length() - 1) == '*' || operazione.charAt(operazione.length() - 1) == '/' || operazione.charAt(operazione.length() - 1) == '=') {

                        } else {
                            operazione = operazione.concat("/");
                            tvoperazione.setText(operazione);
                        }
                    }

                }
            });

            buttonequals = (Button) findViewById(R.id.buttonequals);

            buttonequals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operazione != "") {
                        if (operazione.charAt(operazione.length() - 1) == '+' || operazione.charAt(operazione.length() - 1) == '-' || operazione.charAt(operazione.length() - 1) == '*' || operazione.charAt(operazione.length() - 1) == '/' || operazione.charAt(operazione.length() - 1) == '=') {
                        } else {
                            operazione = operazione.concat("=");
                            tvoperazione.setText(operazione);
                            String[] arrayoperazione = operazione.split("(?<=[-+*/=])|(?=[-+*/=])");

                            for (int indice = 0; indice < arrayoperazione.length; indice++) {

                                switch (arrayoperazione[indice]) {

                                    case "+":
                                        if (controllo == false) {
                                            risultato = Integer.parseInt(arrayoperazione[indice - 1]) + Integer.parseInt(arrayoperazione[indice + 1]);
                                            controllo = true;
                                        } else {
                                            risultato = risultato + Integer.parseInt(arrayoperazione[indice + 1]);
                                        }
                                        break;
                                    case "-":
                                        if (controllo == false) {
                                            risultato = Integer.parseInt(arrayoperazione[indice - 1]) - Integer.parseInt(arrayoperazione[indice + 1]);
                                            controllo = true;
                                        } else {
                                            risultato = risultato - Integer.parseInt(arrayoperazione[indice + 1]);
                                        }
                                        break;
                                    case "*":
                                        if (controllo == false) {
                                            risultato = Integer.parseInt(arrayoperazione[indice - 1]) * Integer.parseInt(arrayoperazione[indice + 1]);
                                            controllo = true;
                                        } else {
                                            risultato = risultato * Integer.parseInt(arrayoperazione[indice + 1]);
                                        }
                                        break;
                                    case "/":
                                        if (controllo == false) {
                                            risultato = Integer.parseInt(arrayoperazione[indice - 1]) / Integer.parseInt(arrayoperazione[indice + 1]);
                                            controllo = true;
                                        } else {
                                            risultato = risultato / Integer.parseInt(arrayoperazione[indice + 1]);
                                        }
                                        break;

                                }
                                tvrisultato.setText(Integer.toString(risultato));

                            }
                            storico+=operazione+risultato+"\n";
                            System.out.println(Arrays.toString(arrayoperazione));
                            arrayoperazione = null;
                        }


                    }
                }
            });


            buttoncanc = (Button) findViewById(R.id.buttoncanc);

            buttoncanc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (operazione.length() != 0 && operazione.charAt(operazione.length() - 1) == '=') {
                        operazione = "";
                        tvoperazione.setText("0");
                        tvrisultato.setText("0");
                        risultato = 0;
                        controllo = false;
                }
                if (operazione.length()!=0){
                        operazione=operazione.substring(0,operazione.length()-1);
                        tvoperazione.setText(operazione);
                    }
                    if(operazione.length()==0){
                        operazione = "";
                        tvoperazione.setText("0");
                    }

            }
    });

            buttoncanc.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    operazione = "";
                    tvoperazione.setText("0");
                    tvrisultato.setText("0");
                    risultato = 0;
                    controllo = false;
                    Intent vIntent = new Intent(MainActivity.this,Main2Activity.class);
                    Bundle vBundle = new Bundle();
                    vBundle.putString("CRONO", storico);
                    vIntent.putExtras(vBundle);
                    startActivity(vIntent);
                    return false;
                }
            });

        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("STR", operazione);
        outState.putInt("NUM", risultato);
    }
}
