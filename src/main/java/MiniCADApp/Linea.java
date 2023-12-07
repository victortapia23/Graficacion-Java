
package MiniCADApp;

class Linea {//Inicio de la clase Linea, creamos una linea

    public  int X,Y,X2,Y2,opc,Colores1;

    public Linea(int X, int Y, int X2, int Y2, int opc, int Colores1) {
        this.X = X;
        this.Y = Y;
        this.X2 = X2;
        this.Y2 = Y2;
        this.opc = opc;
        this.Colores1 = Colores1;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getX2() {
        return X2;
    }

    public void setX2(int X2) {
        this.X2 = X2;
    }

    public int getY2() {
        return Y2;
    }

    public void setY2(int Y2) {
        this.Y2 = Y2;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public int getColores1() {
        return Colores1;
    }

    public void setColores1(int Colores1) {
        this.Colores1 = Colores1;
    }
}
