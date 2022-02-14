package at.ac.fhcampuswien.unittesting.point_example;

public class Point {
    private Double x;
    private Double y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {}

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double calcDistance(Point point) {
        if(point == null){
            throw new IllegalArgumentException("p2 is not valid");
        }

        if( this.getX() == null ||  this.getY() == null){
            throw new IllegalArgumentException("p1 is not valid");
        }

        if(point.getX() == null ||  point.getY() == null){
            throw new IllegalArgumentException("parameter in p2 is not valid");
        }

        Double a = point.getX() - this.getX();
        Double b = point.getY() - this.getY();

        Double c = Math.sqrt(a*a + b*b);

        if(c.equals(Double.POSITIVE_INFINITY)){
            throw new IllegalArgumentException("values too high");
        }

        return c;
    }

    public boolean compare(Point p){
        //added for testcase p null
        if(p == null){
            throw new IllegalArgumentException("p2 is not valid");
        }
        if( this.getX() == null ||  this.getY() == null){
            throw new IllegalArgumentException("p1 is not valid");
        }

        if(p.getX() == null ||  p.getY() == null){
            throw new IllegalArgumentException("parameter of p2 is not valid");
        }
        return(this.x.equals(p.getX()) && this.y.equals(p.getY()));
    }

    public String toString(){
        return "x="+this.getX()+" y="+this.getY();
    }

    public void moveTo(double x, double y){
        setX(x);
        setY(y);
    }
}
