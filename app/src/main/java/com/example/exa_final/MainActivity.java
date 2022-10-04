package com.example.exa_final;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.exa_final.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel=new ViewModelProvider(this).get(MainViewModel.class);

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        viewModel.listarproductos();
        Productadapter adapter= new Productadapter();
        adapter.setOnItemClickListener(earthquake ->{









        });

        binding.eqRecycler.setAdapter(adapter);
        viewModel.getProducto().observe(this, productList-> {
            adapter.submitList(productList);



            Product eqq=productList.get(4);
            binding.setProduct(eqq);
            imageView=binding.imageView;





            if (productList.isEmpty()){



                binding.empyView.setVisibility(View.VISIBLE);
            }else{
                binding.empyView.setVisibility(View.GONE);
            }
        });
    }



}