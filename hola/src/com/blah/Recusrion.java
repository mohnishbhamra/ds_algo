package com.blah;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Stack;

public class Recusrion {
    static void towerOfHanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + A + " to rod " + C);
            return;
        }
        towerOfHanoi(n - 1, A, C, B);
        System.out.println("Move disk " + n + " from rod " + A + " to rod " + C);
        towerOfHanoi(n - 1, B, A, C);
    }

    static int calculateSize(Stack stack, int size) {

        if (stack.empty()) {
            return size;
        }
        Object element = stack.pop();
        ++size;
        size = calculateSize(stack, size);
        stack.push(element);

        return size;
    }

    static Stack reverse(Stack stack) {
        if (stack.empty()) {
            return stack;
        }
        Object element = stack.pop();
        reverse(stack);
        System.out.println("------");
        pushAtTheBottom(stack, element);
        return stack;
    }

    static Stack pushAtTheBottom(Stack stack, Object top) {
        if (stack.empty()) {
            System.out.println("pushing top" + top);
            stack.push(top);
            return stack;
        }

        Object element = stack.pop();
        System.out.println("popped for empty " + element);
        stack = pushAtTheBottom(stack, top);
        System.out.println("pushing for fill" + element);
        stack.push(element);

        return stack;
    }

    static Stack sortStack(Stack stack) {
        if (stack.empty()) {
            return stack;
        }
        int size = calculateSize(stack, 0);
        Integer element, prevElement = null;
        do {
            element = getMinTill(stack, prevElement, null);
            System.out.println("------min is " + element);
            sortStackPushAtBottom(stack, prevElement, element);
            prevElement = element;
            size--;
        } while (size > 0);
        return stack;
    }

    static Integer getMinTill(Stack stack, Integer tillElement, Integer min) {
        if (stack.empty() || (tillElement != null && stack.peek() == tillElement)) {
            return min;
        }
        Integer element = (Integer) stack.pop();
        if (min == null || element < min) {
            min = element;
        }
        min = getMinTill(stack, tillElement, min);
        if (element != min) {
            stack.push(element);
        }
        return min;
    }

    static Stack sortStackPushAtBottom(Stack stack, Integer tillElement, Integer element) {
        if (stack.empty() || (tillElement != null && stack.peek() == tillElement)) {
            System.out.println("pushing top" + element);
            stack.push(element);
            return stack;
        }
        Integer x = (Integer) stack.pop();
        stack = sortStackPushAtBottom(stack, tillElement, element);
        stack.push(x);
        return stack;
    }

    static Stack sortGoodWay(Stack stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        Integer poppedElement = (Integer) stack.pop();
        sortGoodWay(stack);
        //HERE THE CONTROL WILL COME WHEN poppedElement is the last element in stack
        sortedInsertInStack(stack, poppedElement);
        return stack;
    }

    static Stack deleteMiddleOfStack(Stack stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        Integer size = 1, mid = 0;
        deleteMiddleOfStackHelper(stack, size, mid);
        return stack;
    }

    private static Integer deleteMiddleOfStackHelper(Stack stack, Integer count, Integer mid) {
        if (stack.isEmpty()) {
            mid = count/2;
            return mid;
        }
        Object element = stack.pop();
        count++;
        mid = deleteMiddleOfStackHelper(stack, count, mid);
        count--;
        if (count != mid) {
            stack.push(element);
        }
        return mid;
    }


    private static void sortedInsertInStack(Stack stack, Integer poppedElement) {
        if (stack.isEmpty() || poppedElement > (Integer) stack.peek()) {
            stack.push(poppedElement);
            return;
        }
        Integer temp = (Integer) stack.pop();
        sortedInsertInStack(stack, poppedElement);
        stack.push(temp);
    }

}
