package com.nov.openview.utils;

import android.content.Context;

import com.nov.openview.bean.EssayDetailBean;

import java.util.List;

/**
 * 豆瓣一刻文章解析
 * Created by yangzhicong on 2017/2/20.
 */
public class EssayContentVonvert {
    public static String convertDoubanContent(EssayDetailBean bean, Context mContext) {

        String content = bean.getContent();
        if (content == null) {
            return null;
        }
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/douban_dark.css\" type=\"text/css\">";
        List<EssayDetailBean.PhotosBean> imageList = bean.getPhotos();
        for (int i = 0; i < imageList.size(); i++) {
            String old = "<img id=\"" + imageList.get(i).getTag_name() + "\" />";
            String newStr = "<img id=\"" + imageList.get(i).getTag_name() + "\" "
                    + "src=\"" + imageList.get(i).getMedium().getUrl() + "\"/>";
            content = content.replace(old, newStr);
        }
        StringBuilder builder = new StringBuilder();
        builder.append( "<!DOCTYPE html>\n");
        builder.append("<html lang=\"ZH-CN\" xmlns=\"http://www.w3.org/1999/xhtml\">\n");
        builder.append("<head>\n<meta charset=\"utf-8\" />\n");
        builder.append(css);
        builder.append("\n</head>\n<body>\n");
        builder.append("<div class=\"container bs-docs-container\">\n");
        builder.append("<div class=\"post-container\">\n");
        builder.append(content);
        builder.append("</div>\n</div>\n</body>\n</html>");

        return builder.toString();
    }
}
