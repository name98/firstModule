package com.example.firstmodule.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.firstmodule.R;
import com.example.firstmodule.items.Counter;

public class ZoomActivity extends AppCompatActivity {

    private static String COUNTER_START_VALUE_KEY = "counterValueKey";
    private Counter counter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_activity);
        counter = new Counter();
        counter.setNumberOfClicks(getIntent().getIntExtra(COUNTER_START_VALUE_KEY,-1));
        if(savedInstanceState != null)
            counter.setNumberOfClicks(savedInstanceState.getInt(COUNTER_START_VALUE_KEY));
        bind();
    }



    public static Intent getStartIntent(Context context, int counterValue) {
        Intent intent = new Intent(context, ZoomActivity.class);
        intent.putExtra(COUNTER_START_VALUE_KEY, counterValue);
        return intent;
    }

    private void bind() {
        setNumberOfClicks();
        setIncreaseListener();
    }

    private void setNumberOfClicks() {
        TextView numberOfClicksTextView = findViewById(R.id.number_of_clicks_text_view);
        numberOfClicksTextView.setText(String.valueOf(counter.getNumberOfClicks()));
        animateNumberOfClicks();
    }

    private void setIncreaseListener() {
        Button increaseButton = findViewById(R.id.increase_button);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadNumberOfClicks();
            }
        });
    }

    private void reloadNumberOfClicks() {
        counter.increaseNumberOfClicks();
        setNumberOfClicks();
    }

    private void animateNumberOfClicks() {
        TextView numberOfClicksTextView = findViewById(R.id.number_of_clicks_text_view);
        YoYo.with(Techniques.FlipInX)
                .duration(700)
                .playOn(numberOfClicksTextView);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(COUNTER_START_VALUE_KEY,counter.getNumberOfClicks());
        super.onSaveInstanceState(outState);
    }
}
