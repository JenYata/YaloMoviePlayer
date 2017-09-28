package com.example.erunn.yalomovieplayer;

/**
 * Created by erunn on 2017-09-28.
 */
import android.content.ContentResolver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//import co.zaven.digitalimageprocessing.R;


public class ProcessingOptionsActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing_options);
        ButterKnife.bind(this);
        ActivityHelper.setupToolbar(this, toolbar);


        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                getResources().getResourcePackageName(R.drawable.sun_mountain) + '/' +
                getResources().getResourceTypeName(R.drawable.sun_mountain) + '/' +
                getResources().getResourceEntryName(R.drawable.sun_mountain) );

        bundle = new Bundle();
        bundle.putParcelable(KEY_BITMAP, uri);



    }

    @OnClick({R.id.histogram, R.id.edges, R.id.light})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.histogram:
//                ActivityHelper.startActivity(this, HistogramActivity.class, bundle);
                break;
            case R.id.edges:
                ActivityHelper.startActivity(this, DetectEdgesActivity.class, bundle);
                break;
            case R.id.light:
//                ActivityHelper.startActivity(this, DetectLightActivity.class, bundle);
                break;
        }
    }

}
