package com.sudodev.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Map;

public class MainActivity extends BaseActivity {
    Button login;
    EditText username, password;
    TextView text;
    String user, pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        login.setEnabled(false);
        final UserInfo userInfo = new UserInfo();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        text = findViewById(R.id.text);

        password.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                login.setEnabled(false);
                login.setBackgroundResource(R.color.disabled);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login.setBackgroundResource(R.color.enabled);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!password.getText().toString().isEmpty())
                    login.setEnabled(true);
                else {
                    login.setEnabled(false);
                    login.setBackgroundResource(R.color.disabled);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = username.getText().toString();
                pass = password.getText().toString();

                if (user.equals(userInfo.getUsername()) && pass.equals(userInfo.getPassword())) {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final String TAG = "FireStore";

        db.collection("users").document("user1")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            assert document != null;
                            if (document.exists()) {
                                Map<String, Object> map = document.getData();
                                assert map != null;
                                if (map.containsKey("username")) {
                                    userInfo.setUsername((String) map.get("username"));
                                    userInfo.setPassword((String) map.get("password"));
                                }
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}