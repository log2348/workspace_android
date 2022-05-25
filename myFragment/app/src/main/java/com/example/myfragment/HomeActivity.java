package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container1);

        // 프래그먼트 동적으로 생성하기
        btnCreate.setOnClickListener(view -> {
            fragmentBanner = new FragmentBanner();
            /*
                프래그먼트를 동적으로 만들기 위해서 필요한 준비물
                1. FragmentManager (프래그먼트 트랜잭션 객체를 가져올 수 있다.)
                2. FragmentTransaction

                * Transaction : 작업의 단위 (시작과 끝이 있다.)
                                여러 개의 부분부분 작업들을 한 단위로 만들어 준다.
             */
            FragmentManager manager = getSupportFragmentManager();
            // FragmentManager manager1 = new FragmentManager()
            // FragmentManager manager2 = new FragmentManager()
            // getSupportFragmentManager()로 생성하면 레퍼런스를 못 찾는 등의 오류 방지 할 수 있다.

            // 지금부터 트랜잭션 처리를 할 거야
            FragmentTransaction transaction = manager.beginTransaction();

            // 실행 코드 xml 파일 만들어둔 영역(뷰 컴포넌트에 올려라)
            transaction.replace(R.id.container1, fragmentBanner);
            transaction.commit(); // 시간될 때 완료해 (권장 사항)
            // transaction.commitNow(); // 지금 당장해
            // transaction.commitAllowingStateLoss(); // 하긴 할건데 위험한 상태 (커밋이 없어질 수도 있다. 거의 사용 x)
        });

        // 프래그먼트 제거
        btnDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner); // 제거할 객체 지정
            // transaction.detach(fragmentBanner);
            transaction.commit();
        });
    }
}