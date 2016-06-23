package com.modacenter.modacenterbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class TelaInicialActivity extends AppCompatActivity {

    private View view1,view2,view3,view4,view5;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        this.toolbar = (Toolbar) findViewById(R.id.tbinicio);
        setSupportActionBar(toolbar);

        View view1 = findViewById(R.id.img_servico);
       // View view2 = findViewById(R.id.img_contato);
        View view3 = findViewById(R.id.img_calendario);
        View view4 = findViewById(R.id.img_informes);
       // View view5 = findViewById(R.id.img_parque);

        view1.setOnClickListener(new OnclickListener(this, ServicosActivity.class));
        // view2.setOnClickListener(new OnclickListener(this, ContatoActivity.class));
        view3.setOnClickListener(new OnclickListener(this, CalendarioActivity.class));
        view4.setOnClickListener(new OnclickListener(this, InformesActivity.class));
       // view5.setOnClickListener(new OnclickListener(this, ParqueInfoActivity.class));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        onNavegationDrawer();


    }

    public void onContact(View view) {
        View view2 = findViewById(R.id.img_contato);
        view2.setOnClickListener(new OnclickListener(this,ContatoActivity.class));
        Intent intent = new Intent(this, ContatoActivity.class);
        intent.putExtra(ContatoActivity.KEY_FILE_NAME, "contato.txt");
        startActivity(intent);
    }

    public void onAboutPark(View view) {
        View view5 = findViewById(R.id.img_parque);
        view5.setOnClickListener(new OnclickListener(this,ContatoActivity.class));
        Intent intent = new Intent(this, ParqueInfoActivity.class);
        intent.putExtra(ParqueInfoActivity.KEY_FILE_NAME, "sobreParque.txt");
        startActivity(intent);
    }

    private class OnclickListener implements View.OnClickListener{

        private Context context;
        private Class aClass;

        private OnclickListener(Context context, Class aClass) {
            this.context = context;
            this.aClass = aClass;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,aClass);
            startActivity(intent);
        }
    }

    private void onNavegationDrawer() {
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(this.toolbar)
                .withHeader(R.layout.nav_header_abertura)
                .withActionBarDrawerToggleAnimated(true).withDrawerGravity(Gravity.LEFT)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIcon(R.drawable.ic_menu_gallery).withName("Galeria"))
                .addDrawerItems(
                        new PrimaryDrawerItem().withIcon(R.drawable.ic_perm_device_information_black_25dp).withName("Desenvolvimento"))
                .withOnDrawerItemClickListener(
                        new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                onClickDrawer(position);
                                return true;
                            }
                        }
                ).build();

    }

    public void onClickDrawer(int i) {

        Intent intent;
        switch (i) {
            case 1:
                intent = new Intent(this,GaleriaDeFotosActivity.class);
                startActivity(intent);
                break;
            /*case 1:
                intent = new Intent(this, RedefinirSenhaActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, AjudaActivity.class);
                startActivity(intent);
                break;
            case 3:

                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case 4:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;
        }*/

        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
