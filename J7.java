// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1,-] - пример Deque
// [5,4,3]- пример второго Deque
// 1) -123 * 345 = -42 435
// Ответ всегда - связный список, в обычном порядке
// [-,4,2,4,3,5] - пример ответа


package JAVA;
import java.util.Deque;
import java.util.LinkedList;
public class J7 {
public static void main(String[] args) {
    Deque<Integer> deque1 = new LinkedList<>();
        deque1.add(3);
        deque1.add(2);
        deque1.add(1);
    Deque<Integer> deque2 = new LinkedList<>();
        deque2.add(5);
        deque2.add(4);
        deque2.add(3);
// Буквально костыль без которого у меня не получается, чтобы две функции работали с одним наборо deque        
    Deque<Integer> copy1 = new LinkedList<>();
        copy1.add(3);
        copy1.add(2);
        copy1.add(1);
    Deque<Integer> copy2 = new LinkedList<>();
        copy2.add(5);
        copy2.add(4);
        copy2.add(3);



System.out.println("Первое обратное число: " + deque1);
System.out.println("Второе обратное число: " + deque2); 
    Deque<Integer> summa = sum(deque1, deque2);
    Deque<Integer> result = multiply(copy1, copy2);
System.out.println("Сложением чисел выше будет: " + summa);
System.out.println("Умножением чисел выше будет: " + result);
    }

public static Deque<Integer> sum(Deque<Integer> deque1, Deque<Integer> deque2) {
    LinkedList<Integer> summa = new LinkedList<>();
    while (!deque1.isEmpty() || !deque2.isEmpty()) {
        int sum = 0;
        if (!deque1.isEmpty())
            sum += deque1.removeLast();
        if (!deque2.isEmpty())
            sum += deque2.removeLast();
        summa.add(sum % 10);
        }
    return summa;
    }

public static Deque<Integer> multiply(Deque<Integer> copy1, Deque<Integer> copy2) {
    int num1 = 0;
    int num2 = 0;
    int multiplier = 1;
    while(!copy1.isEmpty()) {
        num1 += copy1.removeFirst() * multiplier;
        multiplier *= 10;
        }
        multiplier = 1;
    while(!copy2.isEmpty()) {
        num2 += copy2.removeFirst() * multiplier;
        multiplier *= 10;
        }
    int product = num1 * num2;
    Deque<Integer> result = new LinkedList<>();
    while(product != 0) {
        result.addFirst(product % 10);
        product /= 10;
        }
    return result;
    }
}

// Я НЕ ЗНАЮ, КАК СДЕЛАТЬ, ЧТОБЫ ЗАРАБОТАЛО С МИНУСОМ. КОГДА ПРОВЕРИТЕ ДЗ МОЖНО СОВЕТ В КОММЕНТАРИЯХ


