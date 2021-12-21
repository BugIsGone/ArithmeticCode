package draft;

public class Rectangle {
    private int lang;
    private int wide;
    private double langd;
    private double wided;

    public double getLangd() {
        return langd;
    }

    public void setLangd(double langd) {
        this.langd = langd;
    }

    public double getWided() {
        return wided;
    }

    public void setWided(double wided) {
        this.wided = wided;
    }

    public Rectangle() {
    }

    public Rectangle(int lang, int wide) {
        this.lang = lang;
        this.wide = wide;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public int perimeter(){
        return  (lang+wide)*2;
    }
    public int area(){
        return lang*wide;
    }
    public double perimeterd(){
        return (lang+wided)*2;
    }
    public double aread(){
        return lang*wided;
    }
    public double perimeterdd(){
        return (langd+wided)*2;
    }
    public double areadd(){
        return langd*wided;
    }


}
