//package com.sudodev.demoapp;
//
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.util.Log;
//        import android.view.View;
//        import android.view.WindowManager;
//        import android.widget.Button;
//
//        import androidx.annotation.NonNull;
//
//        import com.google.android.gms.tasks.OnCompleteListener;
//        import com.google.android.gms.tasks.OnFailureListener;
//        import com.google.android.gms.tasks.OnSuccessListener;
//        import com.google.android.gms.tasks.Task;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//        import com.google.firebase.firestore.DocumentReference;
//        import com.google.firebase.firestore.DocumentSnapshot;
//        import com.google.firebase.firestore.FirebaseFirestore;
//        import com.google.firebase.firestore.QueryDocumentSnapshot;
//        import com.google.firebase.firestore.QuerySnapshot;
//
//        import org.w3c.dom.Document;
//
//        import java.util.HashMap;
//        import java.util.List;
//        import java.util.Map;
//        import java.util.Objects;
//
//public class MainActivity extends BaseActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
//                WindowManager.LayoutParams.FLAG_SECURE);
//        setContentView(R.layout.activity_main);
//        Button next = findViewById(R.id.next);
//
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//
////        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
////        DatabaseReference mDatabaseReference = mDatabase.getReference();
////        mDatabaseReference = mDatabase.getReference().child("name");
////        mDatabaseReference.setValue("Donald Duck");
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        final String TAG = "FireStore";
//
//        db.collection("users").document("user1")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            DocumentSnapshot document = task.getResult();
//                            assert document != null;
//                            if (document.exists()) {
//                                Map<String, Object> map = document.getData();
//                                assert map != null;
//                                if (map.containsKey("username")) {
//                                    UserInfo userInfo = new UserInfo();
//                                    userInfo.setUsername((String) map.get("username"));
//                                    userInfo.setPassword((String) map.get("password"));
//                                }
//                            } else {
//                                Log.d(TAG, "No such document");
//                            }
//                        } else {
//                            Log.w(TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//                });
//
////        Map<String, Object> user = new HashMap<>();
////        user.put("username", "user");
////        user.put("password", "password");
////
////        db.collection("users").document("user1")
////                .set(user)
////                .addOnSuccessListener(new OnSuccessListener<Void>() {
////                    @Override
////                    public void onSuccess(Void aVoid) {
////                        Log.d(TAG, "DocumentSnapshot successfully written!");
////                    }
////                })
////                .addOnFailureListener(new OnFailureListener() {
////                    @Override
////                    public void onFailure(@NonNull Exception e) {
////                        Log.w(TAG, "Error writing document", e);
////                    }
////                });
//    }
//}