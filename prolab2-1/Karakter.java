package Prolab2_1;

import java.awt.*;

public class Karakter extends Konum{

	private int id;
    private String ad;
    private int width;
    private int height;

    public Karakter(int x, int y, int id, String ad,int width,int height) {
        super(x, y);
        this.id = id;
        this.ad = ad;
        this.setWidth(width);
        this.setHeight(height);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
