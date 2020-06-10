package com.example.login_project;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemberInitActivity extends AppCompatActivity {
    private static final String TAG = "MemberInitActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_init);

        findViewById(R.id.checkButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed(); // 뒤로가기 시 종료
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.checkButton:
                    profileUpdate();
                    break;
            }

        }
    };

    private void profileUpdate() {
        String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        String age = ((EditText) findViewById(R.id.ageEditText)).getText().toString();
        String weight = ((EditText) findViewById(R.id.weightEditText)).getText().toString();
        String height = ((EditText) findViewById(R.id.heightEditText)).getText().toString();

        if (name.length() > 0 && age.length() > 0 && weight.length() > 0 && height.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            MemberInfo memberInfo = new MemberInfo(name, age, weight, height);

            if(user != null) {
                db.collection("users").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("회원정보 등록을 성공하였습니다.");
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("회원정보 등록에 실패하였습니다.");
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }

        } else {
            startToast("회원 정보를 입력해주세요");
        }


    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



}