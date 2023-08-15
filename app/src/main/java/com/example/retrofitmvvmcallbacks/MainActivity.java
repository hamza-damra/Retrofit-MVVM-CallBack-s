package com.example.retrofitmvvmcallbacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     PostModelAdapter postModelAdapter;
     ApiService apiService;
     RecyclerView recyclerView;
     PostViewModel postViewModel;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = new ApiService();

        postViewModel = new ViewModelProvider(MainActivity.this).get(PostViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button);
        postModelAdapter = new PostModelAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(postModelAdapter);

      button.setOnClickListener(view ->{
          postViewModel.fetchPosts();
          postViewModel.liveData.observe(MainActivity.this, posts ->{ postModelAdapter.addPosts(posts); if(postModelAdapter.getItemCount() > 0)
          {
              Toast.makeText(MainActivity.this,"Number Of Posts: "+postModelAdapter.getItemCount(),Toast.LENGTH_LONG).show();
          } });





      });




    }
}