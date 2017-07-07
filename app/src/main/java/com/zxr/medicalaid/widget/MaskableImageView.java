package com.zxr.medicalaid.widget;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MaskableImageView extends ImageView {
  
    private boolean touchEffect = true;  
    public final float[] BG_PRESSED = new float[] { 1, 0, 0, 0, -50, 0, 1,  
            0, 0, -50, 0, 0, 1, 0, -50, 0, 0, 0, 1, 0 };  
    public final float[] BG_NOT_PRESSED = new float[] { 1, 0, 0, 0, 0, 0,  
            1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 };  
  
    public MaskableImageView(Context context) {
        this(context,null);
    }  
  
    public MaskableImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }  
  
    public MaskableImageView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
  
    @Override  
    public void setPressed(boolean pressed) {  
        updateView(pressed);  
        super.setPressed(pressed);  
    }  
  
    /** 
     * 根据是否按下去来刷新bg和src 
     * created by minghao.zl at 2014-09-18 
     * @param pressed 
     */  
    private void updateView(boolean pressed){  
        //如果没有点击效果  
        if( !touchEffect ){  
            return;  
        }
//        Drawable drawable = getDrawable();
//        if (drawable == null){
//            return;
//        }
        if( pressed ){//点击  
            /** 
             * 通过设置滤镜来改变图片亮度@minghao 
             */  
            this.setDrawingCacheEnabled(true);
            //mutate 共享元素
//            drawable.mutate().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            this.setColorFilter( new ColorMatrixColorFilter(BG_PRESSED) ) ;
//            this.getBackground().setColorFilter( new ColorMatrixColorFilter(BG_PRESSED) );
        }else{//未点击  
            this.setColorFilter( new ColorMatrixColorFilter(BG_NOT_PRESSED) ) ;
//            drawable.mutate().clearColorFilter();
//            this.getBackground().setColorFilter(
//                    new ColorMatrixColorFilter(BG_NOT_PRESSED));
        }  
    }  
}  