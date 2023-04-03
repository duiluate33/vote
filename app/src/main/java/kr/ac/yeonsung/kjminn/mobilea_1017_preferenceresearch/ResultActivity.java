package kr.ac.yeonsung.kjminn.mobilea_1017_preferenceresearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");
        int[] textIds = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5,
                R.id.text6, R.id.text7, R.id.text8, R.id.text9};
        int[] rbIds = {R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6,
                R.id.rb7, R.id.rb8, R.id.rb9};
        TextView[] tArr = new TextView[textIds.length];
        RatingBar[] rArr = new RatingBar[rbIds.length];

        for(int i=0; i<tArr.length; i++){
            tArr[i] = findViewById(textIds[i]);
            rArr[i] = findViewById(rbIds[i]);
            tArr[i].setText(imgNames[i]);
            rArr[i].setRating(voteCount[i]);
        }
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //현재 액티비티 종료할때 쓰는 메소드: finish()
            }
        });
    }
}