package classes;

import android.text.TextPaint;
import android.text.style.URLSpan;

/**
 * Created by CHAGAS on 23/06/2016.
 */
public class URLSpanNoUnderline extends URLSpan {

    public URLSpanNoUnderline(String url) {
        super(url);
    }
    @Override public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }
}
