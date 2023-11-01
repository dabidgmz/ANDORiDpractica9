package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.practica9.adapter.PermisoAdapter;
import com.example.practica9.model.Permiso;

import java.util.ArrayList;
import java.util.List;
import android.Manifest;

public class MainActivity extends AppCompatActivity implements PermisoAdapter.PermissionRequester{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permiso> Lista_permisos = new ArrayList<>();
        Lista_permisos.add(new Permiso("Camara", "Permite el acceso a la camara", Manifest.permission.CAMERA));
        Lista_permisos.add(new Permiso("Contactos", "Permite el acceso a los contactos", Manifest.permission.READ_CONTACTS));
        Lista_permisos.add(new Permiso("Llamar", "Permite el acceso a la llamada", Manifest.permission.CALL_PHONE));

        PermisoAdapter pa = new PermisoAdapter(Lista_permisos);
        RecyclerView rc = findViewById(R.id.rcPermisos);
        rc.setAdapter(pa);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);

    }

    @Override
    public void requestPermission(String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, 204);
        }
    }
}