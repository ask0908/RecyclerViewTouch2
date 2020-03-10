package com.example.recyclerviewtouch2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/* 메인 액티비티에서 리사이클러뷰 클릭 이벤트 수행하는 예제 */
public class MainActivity extends AppCompatActivity {

    private SimpleTextAdapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            list.add(String.format("TEXT %d", i)) ;
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recycler1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        adapter = new SimpleTextAdapter(list);
        adapter.setOnItemClickListener(new SimpleTextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos)
            {
                if (pos == 0) {
                    Toast.makeText(MainActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "메인에서 건드린 포지션 값 : " + pos);
                } else if (pos == 1) {
                    Toast.makeText(MainActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "메인에서 건드린 포지션 값 : " + pos);
                }
            }
        });

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        recyclerView.setAdapter(adapter) ;
    }
}
