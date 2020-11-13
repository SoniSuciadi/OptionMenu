package com.sonisuciadi.si52.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Integer id=item.getItemId();
        switch (id){
            case R.id.menuAccount:
                Intent intent=new Intent(MainActivity.this,AccountActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this,"Setting",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuLogout:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Keluar");
                builder.setMessage("Yakin Keluar?");
                builder.setPositiveButton("YA?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Anda Keluar",Toast.LENGTH_LONG).show();
                        finish();

                        System.exit(0);
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        
                    }
                });
                builder.show();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}