package com.example.login_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class FoodActivity extends AppCompatActivity {
    private static final String TAG = "MemberSetting";
    String S_height;
    String S_weight;
    String S_sex;
    TextView rec_cal;
    TextView eat_cal;
    TextView rest_cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initData();
        calorieCalc();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // 뒤로가기 시 종료
        finish();
    }

    void initData() {
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
                        S_height = "" + (CharSequence) map.get("height");
                        Log.d(TAG, "height : " + S_height);
                        S_weight = "" + (CharSequence) map.get("weight");
                        S_sex = "" + (CharSequence) map.get("sex");
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }

    void calorieCalc() {
        rec_cal = findViewById(R.id.rec_cal);

        //int height = Integer.parseInt(S_height);
        rec_cal.setText("S_height:" + S_height);
        //String cal = Double.toString(height*height*22/10000);

    }
}