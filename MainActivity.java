package com.example.alaap.amityyouthfest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Context c=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.app.Fragment
                fragment=new BlankFragment();
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.content_main,fragment);
        ft.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "you're invited to AYF 2017");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent,"Send via.."));
                Snackbar.make(view, "Send Invitation For AYF 2017", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
        AlertDialog.Builder alert=new AlertDialog.Builder(c);
        alert.setMessage("Are you sure ??");
        alert.setTitle("Exit AYF 2017");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
          startActivity(new Intent(this,Settings.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navhome) {
            android.app.Fragment
            fragment=new BlankFragment();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.gallery) {

            android.app.Fragment fragment = new Gallery();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.events) {

            android.app.Fragment fragment = new Events();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.register) {

            android.app.Fragment fragment=new Registration();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.partners) {

            android.app.Fragment fragment=new Partners();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.contact) {

            android.app.Fragment fragment=new Contactus();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        }else if(id == R.id.about_us){

            android.app.Fragment fragment=new AboutUs();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        }else if(id== R.id.feedback){

            android.app.Fragment fragment=new feedback();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        }else if(id== R.id.committee){

            android.app.Fragment fragment=new committee();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.addToBackStack(null);
            ft.commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
