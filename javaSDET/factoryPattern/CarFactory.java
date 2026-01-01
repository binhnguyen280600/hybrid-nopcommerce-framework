package factoryPattern;

public abstract class CarFactory {
        //Hàm abstract có tên hàm/ chưa có phần thân
        //Những class kế thừa nó cần implement lại
        //Khung để các class khác follow theo đúng bussiness /structure

        public abstract void viewCar();

        public abstract void bookCar();

        public abstract void driveCar();
    }


