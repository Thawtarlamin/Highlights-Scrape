package com.thukuma.highlightsscrape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.thukuma.library.Highlight;
import com.thukuma.library.Stream;
import com.thukuma.library.modal.HighlightModal;
import com.thukuma.library.modal.StreamModal;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Highlight highlight = new Highlight(this, "https://www.fasthighlights.net/tag/home", new Highlight.onComplete() {
//            @Override
//            public void onComplete(HighlightModal modal) {
//                Log.d("my-test", "onComplete: "+modal.getHref());
//            }
//        }, new Highlight.onError() {
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
        new Stream(this, "https://www.fasthighlights.net/2022/10/bologna-vs-lecce-highlights/", new Stream.onComplete() {
            @Override
            public void onComplete(StreamModal modal) {
                Log.d("my-test", "onComplete: "+modal.getLink());
            }
        }, new Stream.onError() {
            @Override
            public void onError(Exception e) {

            }
        });

    }
}