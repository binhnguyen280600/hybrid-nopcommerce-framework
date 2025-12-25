package javaOOP;

public class Flowers extends Tree {
    @Override
    void setTreeName() {
    }

    public static void main(String[] args) {
        Tree tree = new Tree() {
            @Override
            void setTreeName() {

            }
        };
    }
}
