package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);

        textToSpeech = new TextToSpeech(this, i -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.5f);
        });

        button.setOnClickListener(v -> {
            String textInEditText = editText.getText().toString();
            textToSpeech.speak(textInEditText, TextToSpeech.QUEUE_FLUSH, null);
        });
    }
}