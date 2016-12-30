package com.example.utente.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class Game extends AppCompatActivity {

    ImageButton Button1;
    ImageButton Button2;
    ImageButton Button3;
    ImageButton Button4;
    ImageButton Button5;
    ImageButton Button6;
    ImageButton Button7;
    ImageButton Button8;
    ImageButton Button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        Button1 = (ImageButton) findViewById(R.id.imageButton1);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button1.setBackgroundResource(R.drawable.signx);
                Button1.setEnabled(false);
                Prova(Button1);
            }
        });

        Button2 = (ImageButton) findViewById(R.id.imageButton2);

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button2.setBackgroundResource(R.drawable.signx);
                Button2.setEnabled(false);
                Prova(Button2);
            }
        });

        Button3 = (ImageButton) findViewById(R.id.imageButton3);

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button3.setBackgroundResource(R.drawable.signx);
                Button3.setEnabled(false);
                Prova(Button3);
            }
        });

        Button4 = (ImageButton) findViewById(R.id.imageButton4);

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button4.setBackgroundResource(R.drawable.signx);
                Button4.setEnabled(false);
                Prova(Button4);
            }
        });

        Button5 = (ImageButton) findViewById(R.id.imageButton5);

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button5.setBackgroundResource(R.drawable.signx);
                Button5.setEnabled(false);
                Prova(Button5);
            }
        });

        Button6 = (ImageButton) findViewById(R.id.imageButton6);

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button6.setBackgroundResource(R.drawable.signx);
                Button6.setEnabled(false);
                Prova(Button6);
            }
        });

        Button7 = (ImageButton) findViewById(R.id.imageButton7);

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button7.setBackgroundResource(R.drawable.signx);
                Button7.setEnabled(false);
                Prova(Button7);
            }
        });

        Button8 = (ImageButton) findViewById(R.id.imageButton8);

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button8.setBackgroundResource(R.drawable.signx);
                Button8.setEnabled(false);
                Prova(Button8);
            }
        });

        Button9 = (ImageButton) findViewById(R.id.imageButton9);

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button9.setBackgroundResource(R.drawable.signx);
                Button9.setEnabled(false);
                Prova(Button9);
            }
        });
    }

    public void Prova(ImageButton b) {


        Random r = new Random();
        int Low = 1;
        int High = 9;
        int Result = r.nextInt(High - Low) + Low;
        switch (Result) {
            case 1:
                if (Button1.isEnabled()){
                    Button1.setBackgroundResource(R.drawable.circle);
                    Button1.setEnabled(false);
                }
                else Prova(Button1);
                break;
            case 2:
                if (Button2.isEnabled()){
                    Button2.setBackgroundResource(R.drawable.circle);
                    Button2.setEnabled(false);
                }
                else Prova(Button2);
                break;
            case 3:
                if (Button3.isEnabled()){
                    Button3.setBackgroundResource(R.drawable.circle);
                    Button3.setEnabled(false);
                }
                else Prova(Button3);
                break;
            case 4:
                if (Button4.isEnabled()){
                    Button4.setBackgroundResource(R.drawable.circle);
                    Button4.setEnabled(false);
                }
                else Prova(Button4);
                break;
            case 5:
                if (Button5.isEnabled()){
                    Button5.setBackgroundResource(R.drawable.circle);
                    Button5.setEnabled(false);
                }
                else Prova(Button5);
                break;
            case 6:
                if (Button6.isEnabled()){
                    Button6.setBackgroundResource(R.drawable.circle);
                    Button6.setEnabled(false);
                }
                else Prova(Button6);
                break;
            case 7:
                if (Button7.isEnabled()){
                    Button7.setBackgroundResource(R.drawable.circle);
                    Button7.setEnabled(false);
                }
                else Prova(Button7);
                break;
            case 8:
                if (Button8.isEnabled()){
                    Button8.setBackgroundResource(R.drawable.circle);
                    Button8.setEnabled(false);
                }
                else Prova(Button8);
                break;
            case 9:
                if (Button9.isEnabled()){
                    Button9.setBackgroundResource(R.drawable.circle);
                    Button9.setEnabled(false);
                }
                else Prova(Button9);
                break;
        }
    }

}

