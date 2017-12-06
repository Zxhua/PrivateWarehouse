package demo.zxhua.daggerdemo.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class MyBindingAdapter {

    @SuppressWarnings("uncheck")
    @BindingAdapter({"app:image", "app:erro"})
    public static void imageLoader(ImageView imageView, String url, Drawable erro) {
        Glide.with(imageView.getContext()).load(url).error(erro).into(imageView);
    }

}
