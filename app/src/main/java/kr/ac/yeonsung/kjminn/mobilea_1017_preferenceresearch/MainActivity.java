package kr.ac.yeonsung.kjminn.mobilea_1017_preferenceresearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] imgIds = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7,
                R.id.img8, R.id.img9};
//        9개의 투표수를 저장할 변수를 배열로 선언
        final int[] voteCount = new int[imgIds.length];
        ImageView[] imgVs = new ImageView[imgIds.length];
        final String[] imgNames= {"IVE", "New Jeans", "Crush", "아이유", "NCT", "Stray Kids", "BTS",
                "Black Pink", "AESPA"};

        for (int i=0; i< imgIds.length; i++) {
            final int index;
            index = i;

            //i가 0일때, 1일때 값 유지

            imgVs[index] = findViewById(imgIds[index]);
            //이미지뷰 객체가 클릭됐을 때 객체생성
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "현재  "+imgNames[index]+"의 투표 수는 "+
                            ++voteCount[index] +" 입니다.", Toast.LENGTH_SHORT).show();
                }
            });
        } //end for문
        Button btnFinish = findViewById(R.id.btn_vote);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imgNames", imgNames); //이름이 달라도 됨.
                startActivity(intent);
            }
        });
    }
}