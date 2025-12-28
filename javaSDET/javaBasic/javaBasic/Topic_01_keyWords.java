package javaBasic.javaBasic;

public class Topic_01_keyWords {
    //nguyên thủy

    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1000;
    long lNumber = 10000;
    float fNumber = 15.7f;
    double dDouble = 45.99d;
    boolean bStatus = true;

    //tham chiếu
    String fullName = "Binh Tester";

    //hàm ko cần trả về gì hết;
    void clickLoginBtn() {

    }

    //Hàm này trả về kiểu String
    String getLoginBtn() {
        //chỉ return 1 lần
        return "";
    }

    //bất kỳ class nào cũng truy cập vào đc
    public String address = "27 Tạ Uyen";

    //kế thừa mới sử dụng đc
    protected String city = "Hồ Chí Minh";

    //chỉ class này dùng được
    private String phone = "123";

    //trong cùng package dùng đc
    String zipCode = "234";


}