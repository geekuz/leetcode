package designPatterns.factory.custom;

public class CarFactory {
    public Car makeCar(String model){
        if (model==null){
            return null;
        }
        if(model.equalsIgnoreCase("AUDI")){
            return new Audi();
        }else if(model.equalsIgnoreCase("BMW")){
            return new BMW();
        }
        return null;
    }
}
