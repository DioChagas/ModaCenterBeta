package com.modacenter.modacenterbeta;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import classes.AdaptadorImagem;

import static com.modacenter.modacenterbeta.R.drawable.logodefault;

public class ServicosActivity extends AppCompatActivity {


    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);
        Toolbar servicos = (Toolbar) findViewById(R.id.tbservicos);
        setSupportActionBar(servicos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        int [] imagens = new int[] {R.drawable.icone_estacionamento,R.drawable.icones_hoteis_e_dormitorios,
                R.drawable.icones_praca_de_alimentacao,R.drawable.icones_sac,R.drawable.icone_carrinho_de_compras,
                R.drawable.icones_caixas_eletronicos,R.drawable.icones_wifi,R.drawable.icones_sistema_de_som,
                R.drawable.icone_cameras_de_seguranca,R.drawable.icones_posto_ambulatorial,R.drawable.icones_sistema_de_tv,
                R.drawable.icones_achados_e_perdidos};

        this.gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new AdaptadorImagem(this,imagens));

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








//MÉTODO INVOCADO QUANDO O RETORNO À APLICAÇÃO DEPENDE DE OUTRA (EXEMPLO: VOLTAR DO FACEBOOK PARA A APP)
    /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    //Se a atividade não faz parte do aplicativo, criamos uma nova tarefa
                    // para navegação com a pilha de volta sintetizada.
                    TaskStackBuilder.create(this)
                            // Adiciona todas atividades parentes na pilha de volta
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {
                    //Se essa atividade faz parte da tarefa do app
                    //navegamos para seu parente logico.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
