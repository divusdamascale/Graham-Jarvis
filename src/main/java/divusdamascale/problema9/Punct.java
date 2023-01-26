package main.java.divusdamascale.problema9;

public class Punct {

    private int x;
    private int y;
    private String nume;
    private int cadran;
    private Punct A;
    private Punct B;
    
    public Punct getA() {
        return A;
    }
    public void setA(Punct a) {
        A = a;
    }
    public Punct getB() {
        return B;
    }
    public void setB(Punct b) {
        B = b;
    }
    public int getCadran() {
        return cadran;
    }
    public void setCadran(int cadran) {
        this.cadran = cadran;
    }
    public Punct(int x, int y, String nume) {
        this.x = x;
        this.y = y;
        this.nume = nume;
        if(x>0 && y>0)
        {
            cadran = 1;
        } else if(x<0 && y >= 0)
        {
            cadran = 2;
        }else if (x <= 0 && y>0)
        {
            cadran = 2;
        }else if (x<0 && y <= 0)
        {
            cadran = 3;
        }else if(x >= 0 && y < 0)
        {
            cadran = 4;
        }
        
    }

    public int determinant(Punct B,Punct O,Punct A)
    {
        return ((B.getX()*O.getY())+(B.getY()*A.getX())+(O.getX()*A.getY())-(A.getX()*O.getY())-(B.getX()*A.getY())-(O.getX()*B.getY()));
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(nume).append(" ( ");
        sb.append(x).append(" , ").append(y).append(" )");
        return sb.toString();
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getNume() {
        return nume;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    
    

    
}
