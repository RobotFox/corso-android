package com.its.samuele.constatazioneamichevole.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.its.samuele.constatazioneamichevole.R;
import com.its.samuele.constatazioneamichevole.utility.Comune;
import com.its.samuele.constatazioneamichevole.utility.Provincia;
import com.its.samuele.constatazioneamichevole.utility.Regione;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Samuele.Pretto on 30/09/2016.
 */

public class LuogoFragment extends Fragment {

    AutoCompleteTextView edtPaese, edtVia;
    ArrayList<Regione> regioniList;
    ArrayList<Provincia> provinciaList;
    ArrayList<Comune> comuniList;

    public interface ILuogo{
        public void changeLuogo();
    }

    ILuogo listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.luogo_fragment, container,false);

        String x =leggiDocumentoRegioniProvinceComuni();
        try {
            ottieniRegioni(x);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Regione regioni[] = regioniList.toArray(new Regione[regioniList.size()]);
        Provincia province[] = provinciaList.toArray(new Provincia[provinciaList.size()]);
        Comune comuni[] = comuniList.toArray(new Comune[comuniList.size()]);
        String [] nomeComuni;


        edtPaese = (AutoCompleteTextView) view.findViewById(R.id.editTextPaese);
        edtVia = (AutoCompleteTextView) view.findViewById(R.id.editTextVia);



        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILuogo){
            listener = (ILuogo) activity;
        }
        else {
            listener = null;
        }
    }

    private String leggiDocumentoRegioniProvinceComuni() {

        InputStream is = getResources().openRawResource(R.raw.italia_comuni);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String jsonStringTotale = writer.toString();
        return jsonStringTotale;
    }

    private void ottieniRegioni(String jsonString) throws JSONException {
        JSONObject temp = new JSONObject(jsonString);
        JSONArray jsTempRegioni = temp.getJSONArray("regioni");
        Regione regione;
        regioniList =new ArrayList<Regione>();
        for (int a = 0; a < jsTempRegioni.length(); a++) {
            JSONObject regTemp = jsTempRegioni.getJSONObject(a);
            regione = new Regione();
            regione.setNomeRegione(regTemp.getString("nome"));
            JSONArray provTempArr = regTemp.getJSONArray("province");
            Provincia provincia;
            provinciaList = new ArrayList<>();
            for (int b = 0; b < provTempArr.length(); b++) {
                JSONObject provTemp = provTempArr.getJSONObject(b);
                provincia = new Provincia();
                provincia.setCodeProvincia(provTemp.getString("code"));
                provincia.setNomeProvincia(provTemp.getString("nome"));
                JSONArray comTempArr = provTemp.getJSONArray("comuni");
                Comune comune;
                comuniList = new ArrayList();
                for (int c = 0; c < comTempArr.length(); c++) {
                    JSONObject comTemp = comTempArr.getJSONObject(c);
                    comune = new Comune();
                    comune.setCap(comTemp.getString("cap"));
                    comune.setCodeComune(comTemp.getString("code"));
                    comune.setNomeComune(comTemp.getString("nome"));
                    comuniList.add(comune);
                    if (c == comTempArr.length() - 1) {
                        provincia.setComuniArrayList(comuniList);
                    }
                }
                provinciaList.add(provincia);
                if (b == provTempArr.length() - 1) {
                    regione.setProvinceArrayList(provinciaList);
                }
            }
            regioniList.add(regione);
        }
    }
}
