package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
RecyclerView rv1;
    String []nombres={"Alejandro Marincovich","Yiordano Ignacio","Marcianeke","Pablo Chill-e","Paloma Mami"};
    int[]edades={22,19,25,23,28};
    int[]fotos={R.drawable.yo, R.drawable.jordano,R.drawable.marcianeke,R.drawable.pablochill,R.drawable.palomamami};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rv1 = findViewById(R.id.rv1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);

        rv1.setAdapter(new AdaptadorPersona());



    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersona.AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.tarjetas,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {

            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

          class AdaptadorPersonaHolder extends  RecyclerView.ViewHolder{
           ImageView iv1;
           TextView tv1, tv2;
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                iv1=itemView.findViewById(R.id.imageView);
                tv1=itemView.findViewById(R.id.tvnombre);
                tv2=itemView.findViewById(R.id.tvedad);
            }


              public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText("Edad;"+edades[position]);
              }
          }
    }
}