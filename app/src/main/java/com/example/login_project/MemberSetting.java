package com.example.login_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class MemberSetting extends AppCompatActivity {
    private static final String TAG = "MemberSetting";

    TextView nameText;
    TextView ageText;
    TextView weightText;
    TextView heightText;
    TextView sexText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_setting);

        profileSetting();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed(); // 뒤로가기 시 종료
        finish();
    }


    private void profileSetting() {
        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        weightText = findViewById(R.id.weightText);
        heightText = findViewById(R.id.heightText);
        sexText = findViewById(R.id.sexText);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //Log.d(TAG, "DocumentSnapshot : " + document.getData());
                        Map<String, Object> map = document.getData();
                        nameText.setText("이름 : " + (CharSequence)map.get("name"));
                        ageText.setText("나이 : " + (CharSequence)map.get("age"));
                        weightText.setText("몸무게 : " + (CharSequence)map.get("weight"));
                        heightText.setText("키 : " + (CharSequence)map.get("height"));
                        sexText.setText("성별 : " + (CharSequence)map.get("sex"));

                    }
                    else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }


}
