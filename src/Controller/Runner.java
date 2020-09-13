package Controller;

import Model.Point3D;
import Model.Vector;
import View.VectorPrinter;

import java.util.Random;

/**
 * Класс Runner - класс, который демонстрирует работу с классом Vector.
 *
 * @author Малявко Александра, 3 курс, 12 группа
 * @version 2020 год
 */
public class Runner {
    /**
     * Поле m - количество создаваемых точек и векторов
     */
    private static final int m = 5;

    /**
     * Метод, генерирующий массив объектов Point3D.
     *
     * @return возращает ссылку на массив объектов класса Point3D
     */
    private static Point3D[] generatePoints() {
        Random random = new Random();
        Point3D[] points = new Point3D[m];
        for (int i = 0; i < m; ++i) {
            points[i] = new Point3D(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble());
        }
        return points;
    }

    /**
     * Метод, генерирующий массив объектов Vector.
     *
     * @param points массив объектов класса Point3D,
     *               на основе которых будут генерироваться вектора
     * @return возращает ссылку на массив объектов класса Vector
     */
    private static Vector[] generateVectors(Point3D[] points) {
        Random random = new Random();
        Vector[] vectors = new Vector[m];
        for (int i = 0; i < m; ++i) {
            vectors[i] = new Vector(points[random.nextInt(m)], points[random.nextInt(m)]);
        }
        return vectors;
    }

    public static void main(String[] args) {
        Point3D[] points = generatePoints();        // генерация массива точек
        Vector[] vectors = generateVectors(points); // генерация массива векторов

        Random random = new Random();

        // Проверка случайных m троек векторов из массива на компланарность
        for (int i = 0; i < m; ++i) {
            VectorPrinter.printCoplanar(
                    vectors[random.nextInt(m)],
                    vectors[random.nextInt(m)],
                    vectors[random.nextInt(m)]);
        }
    }
}
