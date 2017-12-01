package demo.zxhua.daggerdemo.binding;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.utils.ImageLoaderUtils;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class MyBindingAdapter {
    @Inject
    public ImageLoaderUtils imageLoaderUtils;
//
//    @BindingAdapter("bind:image")
//    public void imageLoader(ImageView imageView, String url) {
//        imageLoaderUtils.displayImage(imageView, url);
//    }
}
