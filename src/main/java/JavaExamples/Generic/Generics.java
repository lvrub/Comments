package JavaExamples.Generic;

public class Generics {
    public static void main(String arg[]) {
        Cell<String> stringCell = new Cell<>();
        Cell<Integer> cll = new Cell();

        stringCell.setT("hello");
        cll.setT(22);
        String s = stringCell.getT();
        Integer intg = cll.getT();
        System.out.println(s);
        System.out.println(intg);
    }

    //        Cell stringCell = new Cell();
//        stringCell.setT("hello");
//        String s= (String) stringCell.getT();
////        Integer integ = (Integer) stringCell.getT();
//
//    }
}

class Cell<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
//
//class Cell{
// Object object;
//
//    public Object getT() {
//        return object;
//    }
//
//    public void setT(Object object) {
//        this.object = object;
//    }
//}