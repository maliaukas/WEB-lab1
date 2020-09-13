package Model;

/**
 * Класс Vector - вектор в пространстве с вещественными координатами.
 *
 * @author Малявко Александра, 3 курс, 12 группа
 * @version 2020 год
 */

public class Vector {

    /**
     * Каждый вектор характеризуется двумя точками: (start, finish).
     */
    private Point3D start;
    private Point3D finish;

    /**
     * Если привести начало вектора к началу координат, то он будет иметь вид (0, n)
     */
    private Point3D n;


    /**
     * Конструктор вектора по двум точкам.
     *
     * @param a начало вектора
     * @param b конец вектора
     */
    public Vector(Point3D a, Point3D b) {
        start = a;
        finish = b;
        n = b.sub(a);
    }

    /**
     * Конструктор вектора по одной точке.
     *
     * @param n конец вектора (начало подразумевается в т. (0, 0, 0)).
     */
    Vector(Point3D n) {
        start = new Point3D(0, 0, 0);
        finish = n;
        this.n = n;
    }

    /**
     * Метод, проверяющий три вектора на компланарность.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @param c третий вектор
     * @return возвращает компланарны вектора или нет
     */
    public static boolean areCoplanar(Vector a, Vector b, Vector c) {
        return tripleProduct(a, b, c) == 0.0;
    }

    /**
     * Метод, вычисляющий скалярное произведение двух векторов.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @return возвращает скаляр - результат произведения
     */
    public static double dotProduct(Vector a, Vector b) {
        return a.n.getX() * b.n.getX()
                + a.n.getY() * b.n.getY()
                + a.n.getZ() * b.n.getZ();
    }

    /**
     * Метод, вычисляющий векторное произведение двух векторов.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @return возвращает вектор - результат произведения
     */
    public static Vector crossProduct(Vector a, Vector b) {
        Point3D p = new Point3D(
                a.n.getY() * b.n.getZ() - a.n.getZ() * b.n.getY(),
                a.n.getZ() * b.n.getX() - a.n.getX() * b.n.getZ(),
                a.n.getX() * b.n.getY() - a.n.getY() * b.n.getX());
        return new Vector(p);
    }

    /**
     * Метод, вычисляющий смешанное произведение трех векторов.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @param c третий вектор
     * @return возвращает скаляр - результат произведения
     */
    public static double tripleProduct(Vector a, Vector b, Vector c) {
        return dotProduct(a, crossProduct(b, c));
    }

    /**
     * Метод, проверяющий два вектора на пересечение.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @return возвращает пересекаются вектора или нет
     */
    public static boolean intersects(Vector a, Vector b) throws VectorException {
        // Вспомогательный вектор, необходимый для проверки
        Vector aux = new Vector(b.start.sub(a.start));

        // Проверка: лежат ли начальные и конечные точки векторов a и b
        // в одной плоскости
        if (!areCoplanar(a, b, aux))
            throw new VectorException("Points of vectors are not coplanar!");

        // https://mathworld.wolfram.com/Line-LineIntersection.html
        double s = dotProduct(crossProduct(aux, b), crossProduct(a, b))
                / (crossProduct(a, b).norm() * (crossProduct(a, b).norm()));

        return s >= 0.0 && s <= 1.0;
    }

    /**
     * Метод, вычисляющий норму вектора this.
     *
     * @return возвращает скаляр - норму вектора this
     */
    public double norm() {
        return Math.sqrt(dotProduct(this, this));
    }

    /**
     * Метод, проверяющий два вектора на ортогональность.
     *
     * @param v вектор, с которым вектор this проверяется на ортогональность
     * @return возвращает ортогональны вектора или нет
     */
    public boolean isOrthogonal(Vector v) {
        return dotProduct(this, v) == 0;
    }

    /**
     * Метод, проверяющий два вектора на абсолютное равенство:
     * равенство длин и направлений - при приведении к началу координат.
     *
     * @param v вектор, с которым вектор this проверяется на равенство
     * @return возвращает равны вектора или нет
     */
    public boolean equals(Vector v) {
        return this.n == v.n;
    }

    /**
     * Метод, возвращающий строковое представление вектора в виде двух точек.
     *
     * @return возвращает строку, содержащую две точки: start, finish
     */
    public String toString() {
        return "[" + start.toString() + ", " + finish.toString() + "]";
    }

    static class VectorUtils {

    }
}
