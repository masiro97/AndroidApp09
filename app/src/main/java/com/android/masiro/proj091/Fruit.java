package com.android.masiro.proj091;

/**
 * Created by haeyoung on 2017-04-27.
 */

public class Fruit {

    private String name = "";
    private int imgno =0;
    private String price = "";
    static public int imglist[] = {R.drawable.abocado, R.drawable.banana,
                R.drawable.cherry, R.drawable.cranberry, R.drawable.grape,
            R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    static public int pricelist[] = {1000,2000,3000,4000,5000,6000,7000,8000};

    public void setName(String name) {
        this.name = name;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static void setImglist(int[] imglist) {
        Fruit.imglist = imglist;
    }

    public static void setPricelist(int[] pricelist) {
        Fruit.pricelist = pricelist;
    }

    public Fruit(String name, int imgno, String price){
        this.name = name;
        this.imgno = imgno;

        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImgno() {
        return imgno;
    }

    public String getPrice(){
        return price;
    }
    public static int[] getImglist() {
        return imglist;
    }
}
