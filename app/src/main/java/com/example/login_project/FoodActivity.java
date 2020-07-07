package com.example.login_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
    int temp2;
    int result=0;
    int result2=0;
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
        findViewById(R.id.add_button).setOnClickListener(onClickListener);
        findViewById(R.id.del_button).setOnClickListener(onClickListener);
    }

        View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.add_button:
                    int etc = 0;
                    CheckBox banana = findViewById(R.id.banana_check);
                    CheckBox chicken = findViewById(R.id.ck_check);
                    CheckBox rice = findViewById(R.id.rice_check);
                    CheckBox sweetPotato = findViewById(R.id.s_p_check);
                    CheckBox sweetPumpkin = findViewById(R.id.s_p_check2);
                    CheckBox apple = findViewById(R.id.apple_check);
                    etc = Integer.parseInt(((EditText)findViewById(R.id.etcText)).getText().toString());
                    if(banana.isChecked()) etc = etc+93;
                    if(chicken.isChecked()) etc = etc+ 109;
                    if(rice.isChecked()) etc = etc+ 150;
                    if(sweetPotato.isChecked()) etc = etc+ 66;
                    if(sweetPumpkin.isChecked()) etc = etc+ 51;
                    if(apple.isChecked()) etc = etc+ 93;
                    result = result + etc;
                    eat_cal.setText("" + result);
                    result2 = temp2-result;
                    rest_cal.setText("" + result2);
                    break;

                case R.id.del_button:
                    int del = Integer.parseInt(((EditText)findViewById(R.id.delText)).getText().toString());
                    result2 = result2 + del;
                    rest_cal.setText("" + result2);
                    break;
            }

        }
    };

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
                        height = Double.parseDouble(""+ map.get("height"));
                        weight = Double.parseDouble(""+ map.get("weight"));
                        sex = ""+ map.get("sex");
                        age = Double.parseDouble("" + map.get("age"));
                        initCalorie();

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }

    void initCalorie() {
        rec_cal = findViewById(R.id.rec_cal);
        eat_cal = findViewById(R.id.eat_cal);
        rest_cal = findViewById(R.id.rest_cal);

        double temp;
        if(sex.equals("남자")){
            temp = (66+(13.7*weight) + (5*height)-(6.8*age))*1.55;
        }
        else {
            temp = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * 1.55;
        }
        temp2 = (int)temp;
        rec_cal.setText("" + temp2);
        eat_cal.setText("" + 0);
        rest_cal.setText("" + 0);
    }



}