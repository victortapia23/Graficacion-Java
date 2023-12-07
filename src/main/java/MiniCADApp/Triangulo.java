package MiniCADApp;

public class Triangulo {
    int XTri,YTri,AnchoTri,AltoTri,ColorTri;

    public Triangulo(int XTri, int YTri, int AnchoTri, int AltoTri, int ColorTri) {
        this.XTri = XTri;
        this.YTri = YTri;
        this.AnchoTri = AnchoTri;
        this.AltoTri = AltoTri;
        this.ColorTri = ColorTri;
    }

    public int getXTri() {
        return XTri;
    }

    public void setXTri(int XTri) {
        this.XTri = XTri;
    }

    public int getYTri() {
        return YTri;
    }

    public void setYTri(int YTri) {
        this.YTri = YTri;
    }

    public int getAnchoTri() {
        return AnchoTri;
    }

    public void setAnchoTri(int AnchoTri) {
        this.AnchoTri = AnchoTri;
    }

    public int getAltoTri() {
        return AltoTri;
    }

    public void setAltoTri(int AltoTri) {
        this.AltoTri = AltoTri;
    }

    public int getColorTri() {
        return ColorTri;
    }

    public void setColorTri(int ColorTri) {
        this.ColorTri = ColorTri;
    }
    
}
