package com.its.pretto.samuele.cipherprojectasimmetrical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

public class MainActivity extends AppCompatActivity {

    EditText edtMsg;

    TextView txtLastMsg;

    Button btnCipher;

    Button btnDecipher;

    KeyPairGenerator kpg;
    KeyPair kp;
    PublicKey publicKey;
    PrivateKey privateKey;
    byte [] encryptedBytes, decryptedBytes;
    Cipher cipher, cipher1;
    String encrypted, decrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMsg= (EditText) findViewById(R.id.editTextMesg);
        txtLastMsg = (TextView) findViewById(R.id.textViewFinalMsg);
        btnCipher = (Button) findViewById(R.id.buttonCipher);
        btnDecipher = (Button) findViewById(R.id.buttonDecipher);

        btnCipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtMsg.length()>0){
                    try {
                        kpg = KeyPairGenerator.getInstance("RSA");
                        kpg.initialize(1024);
                        kp = kpg.genKeyPair();
                        publicKey = kp.getPublic();
                        privateKey = kp.getPrivate();

                        //con la chiave privata cripto la chiave simmetrica
                        //cripto tuttti i dati con la chiave simmetrica decriptata

                        cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
                        encryptedBytes = cipher.doFinal(edtMsg.getText().toString().getBytes("UTF-8"));
                        encrypted = Base64.encodeToString(encryptedBytes,Base64.DEFAULT);
                        txtLastMsg.setText(encrypted);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (NoSuchPaddingException e) {
                        e.printStackTrace();
                    } catch (InvalidKeyException e) {
                        e.printStackTrace();
                    } catch (BadPaddingException e) {
                        e.printStackTrace();
                    } catch (IllegalBlockSizeException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        btnDecipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtLastMsg.length()>0){
                    try {
                        cipher1 = Cipher.getInstance("RSA");
                        cipher1.init(Cipher.DECRYPT_MODE,privateKey);
                        decryptedBytes = cipher1.doFinal(Base64.decode(txtLastMsg.getText().toString().getBytes(),Base64.DEFAULT));
                        decrypted = new String(decryptedBytes,"UTF-8");
                        txtLastMsg.setText(decrypted);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (NoSuchPaddingException e) {
                        e.printStackTrace();
                    } catch (InvalidKeyException e) {
                        e.printStackTrace();
                    } catch (BadPaddingException e) {
                        e.printStackTrace();
                    } catch (IllegalBlockSizeException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }
        });



    }
}
