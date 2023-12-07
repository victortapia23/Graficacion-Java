package MiniCADApp;

public class Rombo {
    int XRom,YRom,AnchoX,AltoY,ColorRom;

    public Rombo(int XRom, int YRom, int AnchoX, int AltoY, int ColorRom) {
        this.XRom = XRom;
        this.YRom = YRom;
        this.AnchoX = AnchoX;
        this.AltoY = AltoY;
        this.ColorRom = ColorRom;
    }

    public int getX() {
        return XRom;
    }

    public void setX(int X) {
        this.XRom = X;
    }

    public int getY() {
        return YRom;
    }

    public void setY(int Y) {
        this.YRom = Y;
    }

    public int getAncho() {
        return AnchoX;
    }

    public void setAncho(int Ancho) {
        this.AnchoX = Ancho;
    }

    public int getAlto() {
        return AltoY;
    }

    public void setAlto(int Alto) {
        this.AltoY = Alto;
    }

    public int getColor() {
        return ColorRom;
    }

    public void setColor(int Color) {
        this.ColorRom = Color;
    }
    
}
