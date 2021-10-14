package Util;

public class position{
    private int row,col;

    public position(int row,int col){
        this.row=row;
        this.col=col;
    }

    public int row(){
        return row;
    }

    public int col(){
        return col;
    }

    public String toString(){
        return row+","+col;
    }
}