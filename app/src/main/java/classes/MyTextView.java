package classes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.modacenter.modacenterbeta.R;

/**
 * Created by CHAGAS on 29/06/2016.
 */
public class MyTextView extends TextView {

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
            String minhaFonte = a.getString(R.styleable.MyTextView_minhaFonte);

            if (minhaFonte!=null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+minhaFonte);
                setTypeface(myTypeface);
            }

            a.recycle();
        }
    }
}
