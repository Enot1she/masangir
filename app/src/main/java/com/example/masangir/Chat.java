package com.example.masangir;

import static com.example.masangir.R.drawable.you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class Chat extends AppCompatActivity {

//    private LinearLayout mLayout1;
    private EditText mEditText;
    private Button mButton;
    private LinearLayout mLayout2;
//    private String otvet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

//        while (true) do{
//            mLayout2.addView(createNewTextView(otvet.getText().toString()));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        mLayout1 = (LinearLayout) findViewById(R.id.chat1);
        mLayout2 = (LinearLayout) findViewById(R.id.chat2);
        mEditText = (EditText) findViewById(R.id.editText);
//        otvet = (String) с сервака;
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout2.addView(createNewTextView(mEditText.getText().toString()));
                mEditText.getText().clear();
//                mLayout.addView(createNewImView());

            }
        });
    }

//    public void onResume(Bundle savedInstanceState) {
//        super.onResume();
//                while (true) do{
//            mLayout2.addView(createNewTextView(otvet.getText().toString()));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);

        textView.setLayoutParams(lparams);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setTextSize(20);
        textView.setText("Alex. Gon. \n" + text);

        return textView;
    }

//    private ImageView createNewImView() {
//        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        final ImageView imageView = new ImageView(this);
//
//        imageView.setLayoutParams(lparams);
//        imageView.setImageDrawable(getResources().getDrawable(you));;
//
//        return imageView;
//    }
}
