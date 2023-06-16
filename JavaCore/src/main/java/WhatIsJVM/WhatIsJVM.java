package WhatIsJVM;

public class WhatIsJVM {
    public static void main(String[] args) {
        Class c = WhatIsJVM.class;

        System.out.println(c.getClassLoader()); // -> Class be load from System/Application ClassLoader

        Class stringClass = String.class;
        System.out.println(stringClass.getClassLoader()); // null because String be load from Bootstrap ClassLoader

    }
}
