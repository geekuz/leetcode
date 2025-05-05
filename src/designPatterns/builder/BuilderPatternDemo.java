package designPatterns.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();
        
        // Create a gaming computer with all options
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .gpu("NVIDIA RTX 3080")
                .wifi(true)
                .bluetooth(true)
                .build();
        
        // Create a work computer with some options
        Computer workComputer = new Computer.Builder("AMD Ryzen 7", "16GB", "512GB SSD")
                .wifi(true)
                .build();
        
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Work Computer: " + workComputer);
    }
}