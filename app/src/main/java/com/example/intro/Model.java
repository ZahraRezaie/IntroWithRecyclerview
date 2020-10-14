package com.example.intro;

import android.view.animation.Animation;

public class Model {

    int img1;
    int img2;
    Animation animation1;
    Animation animation2;

    public Model(int img1, int img2, Animation animation1, Animation animation2) {
        this.img1 = img1;
        this.img2 = img2;
        this.animation1 = animation1;
        this.animation2 = animation2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public Animation getAnimation1() {
        return animation1;
    }

    public Animation getAnimation2() {
        return animation2;
    }
    
    public int getImg1() {
        return img1;
    }

    public int getImg2() {
        return img2;
    }
}
