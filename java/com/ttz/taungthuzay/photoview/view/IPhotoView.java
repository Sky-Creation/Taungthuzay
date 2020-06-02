package com.ttz.taungthuzay.photoview.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

public interface IPhotoView {

    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    public static final int DEFAULT_ZOOM_DURATION = 200;


    boolean canZoom();

    RectF getDisplayRect();

    boolean setDisplayMatrix(Matrix finalMatrix);

    Matrix getDisplayMatrix();

    @Deprecated
    float getMinScale();

    @Deprecated
    void setMinScale(float minScale);

    float getMinimumScale();

    void setMinimumScale(float minimumScale);

    @Deprecated
    float getMidScale();

    @Deprecated
    void setMidScale(float midScale);

    float getMediumScale();

    void setMediumScale(float mediumScale);

    @Deprecated
    float getMaxScale();

    @Deprecated
    void setMaxScale(float maxScale);

    float getMaximumScale();

    void setMaximumScale(float maximumScale);

    float getScale();

    void setScale(float scale);

    ImageView.ScaleType getScaleType();

    void setScaleType(ImageView.ScaleType scaleType);

    void setAllowParentInterceptOnEdge(boolean allow);

    void setScaleLevels(float minimumScale, float mediumScale, float maximumScale);

    void setOnLongClickListener(View.OnLongClickListener listener);

    void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener listener);

    PhotoViewAttacher.OnPhotoTapListener getOnPhotoTapListener();

    void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener listener);

    void setRotationTo(float rotationDegree);

    void setRotationBy(float rotationDegree);

    PhotoViewAttacher.OnViewTapListener getOnViewTapListener();

    void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener listener);

    void setScale(float scale, boolean animate);

    void setScale(float scale, float focalX, float focalY, boolean animate);

    void setZoomable(boolean zoomable);

    void setPhotoViewRotation(float rotationDegree);

    Bitmap getVisibleRectangleBitmap();

    void setZoomTransitionDuration(int milliseconds);

    IPhotoView getIPhotoViewImplementation();

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener newOnDoubleTapListener);

    void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener onScaleChangeListener);
}
