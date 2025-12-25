package phuongHoaXuan;

public class DinhBoLinh {
    //Private chỉ đc sử dụng trong class chứa nó
    private String espresso;

    private void setEspresso(String espresso) {
        this.espresso = espresso;
    }

    private String getEspresso() {
        return espresso;
    }

    //Default (Chỉ cho phép các class trong cùng package truy cập được)
    String capuchino;

    String getCapuchino() {
        return capuchino;
    }

    //Protected (Chỉ cho phép kế thừa mới sử dụng được)
    protected String cherry;

    protected String getCherry() {
        return cherry;
    }

    //Public (
    public String cartimor;

    public String getCartimor() {
        return cartimor;
    }

    public static String monokai;

    public static void main(String[] args) {
        //Hàm là stactic ko thể chạy tới biến non static/ gọi trực tiếp tới 1 biến
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.espresso = "Espresso";
        System.out.println(dinhBoLinh.getEspresso());

        dinhBoLinh.capuchino = "Capuchino";
        System.out.println(dinhBoLinh.getCapuchino());

        dinhBoLinh.cherry = "Cherry";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.cartimor = "Cartimorr";
        System.out.println(dinhBoLinh.getCartimor());

        monokai = "Momokai";
    }
}
