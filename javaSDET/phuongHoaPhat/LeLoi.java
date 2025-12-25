package phuongHoaPhat;

import phuongHoaXuan.DinhBoLinh;

public class LeLoi {
    public static void main(String[] args) {
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.cartimor = "New Cafe";
        System.out.println(dinhBoLinh.getCartimor());
    }
}
