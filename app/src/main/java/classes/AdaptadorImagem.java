package classes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.modacenter.modacenterbeta.ServicosActivity;

/**
 * Created by CHAGAS on 21/06/2016.
 */
public class AdaptadorImagem extends BaseAdapter {

    private Context ctx;
    private int[] imagens;

    public AdaptadorImagem(Context ctx, int[] imagens){
        this.ctx = ctx;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return imagens[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(ctx);
        imageView.setImageResource(imagens[position]);
        imageView.setLayoutParams(new GridView.LayoutParams(190,190));
        imageView.setAdjustViewBounds(true);
        return imageView;
    }
}
