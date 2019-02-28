package com.example.cf17ericvisier.jdarestaurant;

import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements InicioFragment.OnFragmentInteractionListener, PlatsFragment.OnFragmentInteractionListener, ReservasFragment.OnFragmentInteractionListener, RecyclerReservasFragment.OnFragmentInteractionListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        InicioFragment inicioFragment = new InicioFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, inicioFragment).commit();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.elementos_toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_plats:
                Log.i("ActionBar", "Nuevo!");
                FragmentManager fragmentManager = getSupportFragmentManager();
                PlatsFragment platsFragment = new PlatsFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, platsFragment).commit();
                return true;
            case R.id.action_reservas:
                Log.i("ActionBar", "Buscar!");;
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                ReservasFragment reservasFragment = new ReservasFragment();
                fragmentManager2.beginTransaction().replace(R.id.fragment_container, reservasFragment).commit();
                return true;
            case R.id.action_vreservas:
                Log.i("ActionBar", "Settings!");;
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                RecyclerReservasFragment recyclerReservasFragment = new RecyclerReservasFragment();
                fragmentManager3.beginTransaction().replace(R.id.fragment_container, recyclerReservasFragment, "ListaReservas").commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void añadirReserva() {
        FirebaseDatabase.getInstance().getReference().child("reservas").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Reservas user = dataSnapshot.getValue(Reservas.class);
                RecyclerReservasFragment recyclerReservasFragment = (RecyclerReservasFragment) getSupportFragmentManager().findFragmentByTag("ListaReservas");
                recyclerReservasFragment.addUserToList(user);



            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
