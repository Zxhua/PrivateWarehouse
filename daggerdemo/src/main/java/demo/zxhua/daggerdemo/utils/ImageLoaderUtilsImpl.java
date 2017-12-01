package demo.zxhua.daggerdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ImageLoaderUtilsImpl implements ImageLoaderUtils {
    @Inject
    public Context context;

    @Override
    public void displayImage(ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }
}
