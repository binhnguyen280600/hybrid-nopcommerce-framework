package javaInherritance;

public class AddressPO implements IBrowser, IServer{
    @Override
    public boolean isDisplayed() {
        return false;
    }
}
