package inc.sam.privatekey;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            byte[] keyBytes = getApplicationContext().getResources().openRawResource(R.raw.privatekey).toString().getBytes();
            Log.d("aaa",keyBytes.toString());

            InputStream inputStream = getApplicationContext().getResources().openRawResource(R.raw.privatekey);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();

            String keyPrivate = null;

            while ((keyPrivate = reader.readLine())!=null){
                sb.append(keyPrivate);
            }
            keyPrivate = sb.toString();
            Log.d("aaa",keyPrivate);


            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyPrivate.getBytes());
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey key = kf.generatePrivate(spec);



            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,key);

            byte [] decryptedBytes = cipher.doFinal(Base64.decode(getApplicationContext().getResources().openRawResource(R.raw.symmetric).toString().getBytes(),Base64.DEFAULT));
            String decrypted = new String(decryptedBytes,"UTF-8");
            Log.d("aaa",decrypted);


        }  catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }   catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }
}
