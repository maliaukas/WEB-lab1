package Model;

/**
 * Класс Point3D - точка в пространстве с вещественными координатами.
 *
 * @author Малявко Александра, 3 курс, 12 группа
 * @version 2020 год
 */

public class Point3D {

    /**
     * Каждая точка в пространстве характеризуется тремя координатами: x, y, z.
     */
    private double x;
    private double y;
    private double z;


    /**
     * Конструктор точки по трем координатам.
     *
     * @param x координата x
     * @param y координата y
     * @param z координата z
     */
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод, вычисляющий покоординатную разность двух точек.
     *
     * @param p точка, вычитаемая из this
     * @return возвращает новую точку, координаты которой - разность координат this и p
     */
    public Point3D sub(Point3D p) {
        return new Point3D(x - p.x, y - p.y, z - p.z);
    }

    /**
     * Метод, вычисляющий покоординатную сумму двух точек.
     *
     * @param p точка, прибавляемая к this
     * @return возвращает новую точку, координаты которой - сумма координат this и p
     */
    public Point3D add(Point3D p) {
        return new Point3D(x + p.x, y + p.y, z + p.z);
    }

    /**
     * Геттер для координаты y.
     *
     * @return возвращает значение y
     */
    public double getY() {
        return y;
    }

    /**
     * Геттер для координаты z.
     *
     * @return возвращает значение z
     */
    public double getZ() {
        return z;
    }

    /**
     * Геттер для координаты x.
     *
     * @return возвращает значение x
     */
    public double getX() {
        return x;
    }

    /**
     * Метод, возвращающий строковое представление точки в виде ее координат.
     *
     * @return возвращает строку, содержащую три координаты: x, y, z
     */
    public String toString() {
        return String.format("(%.2f; %.2f; %.2f)", x, y, z);
    }
}
