package JavaExamples.Patterns.Factory.Example2;

enum DoughnutTypes {
    CHERRY,
    CHOCOLATE,
    ALMOND
}

public class DoughnutFactory {

    Doughnut doughnut = null;

    public Doughnut getDoughnut(DoughnutTypes doughnutTypes) {
        //start
//        if (doughnutTypes == DoughnutTypes.CHERRY) {
//            doughnut = new CherryDoughnut();
//        }
//        if (doughnutTypes==DoughnutTypes.CHOCOLATE){
//            doughnut = new ChocolateDoughnut();
//        }
//        if (doughnutTypes ==DoughnutTypes.ALMOND) {
//            doughnut = new AlmondDoughnut();
//        }
        //end
        switch (doughnutTypes) {
            case CHERRY:
                doughnut = new CherryDoughnut();
                break;
            case CHOCOLATE:
                doughnut = new ChocolateDoughnut();
                break;
            case ALMOND:
                doughnut = new AlmondDoughnut();
                break;
        }
        return doughnut;
    }
}