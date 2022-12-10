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
//        Highlight highlight = new Highlight(this, "https://www.fasthighlights.net/tag/home/page/3/", new Highlight.onComplete() {
//            @Override
//            public void onComplete(HighlightModal modal) {
//                Log.d("my-test", "onComplete: "+modal.getHref());
//                Log.d("my-test", "onComplete: "+modal.getDate());
//                Log.d("my-test", "onComplete: "+modal.getImage());
//                Log.d("my-test", "onComplete: "+modal.getLeague());
//                Log.d("my-test", "onComplete: "+modal.getTitle());
//            }
//        }, new Highlight.onError() {
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
        new Stream(this, "https://www.fasthighlights.net/2022/12/netherlands-vs-argentina-world-cup-highlights/", new Stream.onComplete() {
            @Override
            public void onComplete(StreamModal modal) {
                Log.d("my-test", "onComplete: "+modal.getLink());
            }
        }, new Stream.onError() {
            @Override
            public void onError(Exception e) {

                Log.d("my-test", "onError: "+e);
            }
        });

    }
}