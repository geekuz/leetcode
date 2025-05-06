package designPatterns.singleton;

//1. basic
/*public class Logger {
    private static Logger instance;

    private Logger() {} // private constructor

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // not thread-safe!
        }
        return instance;
    }
}*/
//------------------------------------------------------------------------------------

//2. synchronized but slow
/*public class Logger {
    private static Logger instance;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}*/
//------------------------------------------------------------------------------------

//3. double checked locking singleton
/*public class Logger {
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}*/
//------------------------------------------------------------------------------------

//4. Bill Pugh Singleton (Recommended – Java native way)
//public class Logger {
//    private Logger() {}
//
//    private static class Holder {
//        private static final Logger INSTANCE = new Logger();
//    }
//
//    public static Logger getInstance() {
//        return Holder.INSTANCE;
//    }
//}
//------------------------------------------------------------------------------------

//5. Enum Singleton (Best for most cases)
public enum Logger {
    INSTANCE;

    public void log(String message) {
        System.out.println(message);
    }
}