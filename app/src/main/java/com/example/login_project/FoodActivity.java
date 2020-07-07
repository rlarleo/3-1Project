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
    String sex;
    double height;
    double weight;
    double age;
    TextView rec_cal;
    TextView eat_cal;
    TextView rest_cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initData();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // 뒤로가기 시 종료
        finish();
    }

    void initData() {
        rec_cal = findViewById(R.id.rec_cal);

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
                        height = Double.parseDouble(""+ map.get("height"));
                        weight = Double.parseDouble(""+ map.get("weight"));
                        sex = ""+ map.get("sex");
                        age = Double.parseDouble("" + map.get("age"));
                        calorieCalc();
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
        eat_cal = findViewById(R.id.eat_cal);
        rest_cal = findViewById(R.id.rest_cal);
        double temp;
        int temp2;
        Log.d(TAG, "cccccccccccccccccccccccccccccccc"+ sex);

        if(sex.equals("남자")){
            temp = (66+(13.7*weight) + (5*height)-(6.8*age))*1.55;
            rest_cal.setText("" + temp);

        }
        else {
            temp = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * 1.55;
            eat_cal.setText("" + temp);

        }
        temp2 = (int)temp;
        rec_cal.setText("" + temp2);




    }
}