package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.pizzeria.beans.Produit;
import com.example.pizzeria.service.ProduitService;

public class DetailsActivity extends AppCompatActivity {
    ProduitService ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ps = ProduitService.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent myIntent = getIntent();
        String pizza= myIntent.getStringExtra("id");
        int id=Integer.parseInt(pizza);
        Produit p = ps.findById(id);
        TextView nom = (TextView) findViewById(R.id.nom);
        TextView des = (TextView) findViewById(R.id.descr1);
        TextView ing = (TextView) findViewById(R.id.ingred1);
        ImageView i = (ImageView) findViewById(R.id.imageView4);
        i.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        des.setText(p.getDescription());
        ing.setText(p.getDetailsIngred());




    }
}
