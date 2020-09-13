package View;

import Model.Vector;

/**
 * Класс VectorPrinter - класс, печатающий характеристики класса Vector.
 *
 * @author Малявко Александра, 3 курс, 12 группа
 * @version 2020 год
 */
public class VectorPrinter {

    /**
     * Метод, печатающий компланарны ли три вектора.
     *
     * @param a первый вектор
     * @param b второй вектор
     * @param c третий вектор
     */
    public static void printCoplanar(Vector a, Vector b, Vector c) {
        System.out.printf("The following vectors:\na = %s\nb = %s\nc = %s\nare ", a, b, c);
        if (!Vector.areCoplanar(a, b, c)) {
            System.out.print("not ");
        }
        System.out.println("coplanar.\n");
    }
}
