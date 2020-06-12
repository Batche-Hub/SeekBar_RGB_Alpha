package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar alpha;
    private SeekBar rouge;
    private SeekBar vert;
    private SeekBar bleu;

    private TextView chiffreAlpha;
    private TextView chiffreRouge;
    private TextView chiffreVert;
    private TextView chiffreBleu;
    private TextView resulat;
    private EditText hexColor;

    private Integer alphaValeur;
    private Integer rougeValeur;
    private Integer vertvaleur;
    private Integer bleuvaleur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha = (SeekBar) findViewById(R.id.seekBarAlpha);
        rouge = (SeekBar) findViewById(R.id.seekBarRouge);
        vert = (SeekBar) findViewById(R.id.seekBarVert);
        bleu = (SeekBar) findViewById(R.id.seekBarBleu);

        chiffreAlpha = (TextView) findViewById(R.id.textviewNombreAlpha);
        chiffreAlpha.setText(String.valueOf(alpha.getProgress()));

        chiffreRouge = (TextView) findViewById(R.id.textviewNombreRouge);
        chiffreRouge.setText(String.valueOf(rouge.getProgress()));

        chiffreVert = (TextView) findViewById(R.id.textviewNombreVert);
        chiffreVert.setText(String.valueOf(vert.getProgress()));

        chiffreBleu = (TextView) findViewById(R.id.textviewNombreBleu);
        chiffreBleu.setText(String.valueOf(bleu.getProgress()));

        hexColor = (EditText) findViewById(R.id.editTextHex);

        resulat = (TextView) findViewById(R.id.textViewResulat);

        changeColor();

        alpha.setOnSeekBarChangeListener(alphaListener);
        rouge.setOnSeekBarChangeListener(rougeListener);
        vert.setOnSeekBarChangeListener(vertListener);
        bleu.setOnSeekBarChangeListener(bleuListener);

    }

    private SeekBar.OnSeekBarChangeListener alphaListener = new SeekBar.OnSeekBarChangeListener() {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            alphaValeur = progress;
            changeColor();
            chiffreAlpha.setText(String.valueOf(alphaValeur));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            changeColor();
            chiffreAlpha.setText(String.valueOf(alphaValeur));
        }
    };

    private SeekBar.OnSeekBarChangeListener rougeListener = new SeekBar.OnSeekBarChangeListener() {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            rougeValeur = progress;
            changeColor();
            chiffreRouge.setText(String.valueOf(rougeValeur));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            changeColor();
            chiffreRouge.setText(String.valueOf(rougeValeur));
        }
    };

    private SeekBar.OnSeekBarChangeListener vertListener = new SeekBar.OnSeekBarChangeListener() {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            vertvaleur = progress;
            changeColor();
            chiffreVert.setText(String.valueOf(vertvaleur));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            changeColor();
            chiffreVert.setText(String.valueOf(vertvaleur));
        }
    };

    private SeekBar.OnSeekBarChangeListener bleuListener = new SeekBar.OnSeekBarChangeListener() {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            bleuvaleur = progress;
            changeColor();
            chiffreBleu.setText(String.valueOf(bleuvaleur));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            changeColor();
            chiffreBleu.setText(String.valueOf(bleuvaleur));
        }
    };

    private void changeColor () {
        alphaValeur = alpha.getProgress();
        rougeValeur = rouge.getProgress();
        vertvaleur = vert.getProgress();
        bleuvaleur = bleu.getProgress();
        int colortext = Color.argb(alphaValeur,rougeValeur,vertvaleur,bleuvaleur);
        resulat.setTextColor(colortext);

        if(alphaValeur>0 && rougeValeur>0 && rougeValeur.equals(vertvaleur) && bleuvaleur==0){
            resulat.setText("Jaune");
        }else if(alphaValeur>0 && rougeValeur>0 && rougeValeur.equals(bleuvaleur) && vertvaleur==0){
            resulat.setText("Magenta");
        }else if(alphaValeur>0 && vertvaleur>0 && bleuvaleur.equals(vertvaleur) && rougeValeur==0){
            resulat.setText("Cyan");
        }else{
            resulat.setText("Résultat");
        }

        hexColor.setText("#"+Integer.toHexString(colortext).toUpperCase());
    }
}

