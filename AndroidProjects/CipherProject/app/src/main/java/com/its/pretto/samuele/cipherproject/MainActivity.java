package com.its.pretto.samuele.cipherproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    EditText edtInputCipher;
    TextView txtOutputCipher;
    Button btnCipher, btnDecipher;
    Cipher cipher;
    Key key;
    byte[] cipherBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInputCipher = (EditText) findViewById(R.id.editTextCipherInput);

        txtOutputCipher = (TextView) findViewById(R.id.textViewCipherResult);

        btnCipher = (Button) findViewById(R.id.button);

        btnCipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                        SecureRandom sr = new SecureRandom();
                        SecretKey key2 = KeyGenerator.getInstance("AES").generateKey();
                        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        byte[] iv = new byte[cipher2.getBlockSize()];
                        sr.nextBytes(iv);
                    IvParameterSpec ivParams = new IvParameterSpec(iv);
                    cipher2.init(Cipher.ENCRYPT_MODE,key2,ivParams);
                    byte[] plainText = edtInputCipher.getText().toString().getBytes("UTF-8");
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] output = cipher2.update(plainText);
                    output = cipher2.doFinal();
                    txtOutputCipher.setText(new String(output,"UTF-8"));


                    /*if (!edtInputCipher.getText().toString().isEmpty()) {

                        String msg = edtInputCipher.getText().toString();
                        byte[] stringBytes = msg.getBytes("UTF-8");

                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                        keyGenerator.init(128);
                        key = keyGenerator.generateKey();

                        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(Cipher.ENCRYPT_MODE, key);
                        cipherBytes = cipher.doFinal(stringBytes);
                        Log.d("aaa",new String(cipherBytes));
                        txtOutputCipher.setText(new String(cipherBytes, "UTF-8"));

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Scrivi qualcosa", Toast.LENGTH_SHORT).show();
                    }*/


                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        btnDecipher = (Button) findViewById(R.id.button2);
        btnDecipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (txtOutputCipher.getText().length()>0){
                        String msgC = txtOutputCipher.getText().toString();
                        cipher.init(Cipher.DECRYPT_MODE,key,cipher.getParameters());
                        byte[] plainBytesDecrypted = cipher.doFinal(msgC.getBytes("UTF-8"));
                        txtOutputCipher.setText(new String(plainBytesDecrypted));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Non c'è niente da decriptare", Toast.LENGTH_SHORT).show();
                    }
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
