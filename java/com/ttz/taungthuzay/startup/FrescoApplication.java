package com.ttz.taungthuzay.startup;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.ttz.taungthuzay.cache.ImagePipelineConfigFactory;

public class FrescoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }

}
