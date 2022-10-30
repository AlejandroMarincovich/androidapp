package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ImageView iv1;
    private Bundle bundle;
    private TextView tvSaludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iv1=findViewById(R.id.iv1);
        tvSaludo = (TextView) findViewById(R.id.tvSaludo);

        bundle = getIntent().getExtras();

        String saludo = bundle.getString("nombre");

        tvSaludo.append(" " + saludo + " :D");



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();


    }

    private void Atras(View view){
        Intent Atras = new Intent(this, MainActivity.class);
        startActivity(Atras);
    }
    public void Verdatos(View view) {
        Intent Verdatos = new Intent(this, MainActivity3.class);
        startActivity(Verdatos);
}
final int CAPTURA_IMAGEN=1;

    public void tomarFoto(View v){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAPTURA_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAPTURA_IMAGEN && resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            Bitmap bitmap=(Bitmap)extras.get("data");
            iv1.setImageBitmap(bitmap);
        }
    }
}