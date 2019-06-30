package JavaExamples;

public class PointImmutab {

    int point1;
    int point2;

    public PointImmutab(int point1, int point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void setPoints(int point1, int point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
}

class Delivery {
    public static void main(String[] arg) {
        PointImmutab pointImmutab = new PointImmutab(0, 1);
        System.out.println(pointImmutab.point1 + " " + pointImmutab.point2);
        pointImmutab.setPoints(2, 3);
        System.out.println(pointImmutab.point1 + " " + pointImmutab.point2);

        String s = "New String";
        System.out.println(s);
        s.replaceAll("New", "old");
        String s1 = s.toUpperCase();
        System.out.println(s);
        System.out.println(s1);


    }
}
//    Point myPoint = new Point( 0, 0 );
//    System.out.println( myPoint );
//            myPoint.setLocation( 1.0, 0.0 );
//            System.out.println( myPoint );
//            String myString = new String( "old String" );
//            System.out.println( myString );
//            myString.replaceAll( "old", "new" );
//            System.out.println( myString );
