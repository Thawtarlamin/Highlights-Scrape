package com.thukuma.library;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.thukuma.library.modal.StreamModal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Stream {

    private Context context;
    private String url;
    private onComplete complete;
    private onError error;

    public Stream(Context context, String url, onComplete complete, onError error) {
        this.context = context;
        this.url = url;
        this.complete = complete;
        this.error = error;
        getStream(url,complete,error);
    }

    private void getStream(String url,onComplete complete,onError error){
        AndroidNetworking.get(url)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Document doc = Jsoup.parse(response);
                        Elements es = doc.select("div[class=entry-content-wrap]");
                        for (Element e:es){
                            String link = e.select("source[type=application/x-mpegURL]").attr("src");
                            StreamModal modal = new StreamModal(link);
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
        void onComplete(StreamModal modal);
    }
    public interface onError{
        void onError(Exception e);
    }
}
