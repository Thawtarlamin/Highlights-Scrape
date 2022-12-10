package com.thukuma.library;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.thukuma.library.modal.HighlightModal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Highlight {
    private Context context;
    private String url;
    private onComplete complete;
    private onError error;

    public Highlight(Context context, String url, onComplete complete, onError error) {
        this.context = context;
        this.url = url;
        this.complete = complete;
        this.error = error;
        getData(url,complete,error);
    }

    private  void getData(String url,onComplete complete,onError error){
        AndroidNetworking.get(url)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Document doc = Jsoup.parse(response);
                        Elements es = doc.select("div[class=archive-grid-post]");
                        for(Element e:es){
                            String image = e.select("img[class=attachment-medium size-medium wp-post-image]").attr("src");
                            String href = e.select("a[class=aft-post-image-link]").attr("href");
                            String league = e.select("a[class=chromenews-categories category-color-1]").text();
                            String title = e.select("a[class=aft-post-image-link]").text();
                            String date = e.select("span[class=item-metadata posts-date]").text();
//                            Log.d("my-test", "onResponse: "+league);
                            HighlightModal modal = new HighlightModal(
                                    title,image,league,date,href
                            );
                            complete.onComplete(modal);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        error.onError(anError);
                    }
                });
    }
    public interface onComplete{
        void onComplete(HighlightModal modal);
    }
    public interface onError{
        void onError(Exception e);
    }
}
