package section_09_data_structures_stacks_and_queues;

import java.util.ArrayList;
import java.util.List;

public class StackWithArrayList<T> {

    List<T> arrayList;

    public int size() {
        return arrayList.size();
    }

    ;

    public T top;
    public T bottom;

    public StackWithArrayList() {
        arrayList = new ArrayList<>();

        top = bottom = null;
    }

    public T peek() {
        if (arrayList.isEmpty()) {
            return null;
        } else {
            return arrayList.get(arrayList.size() - 1);
        }
    }

    public void push(T value) {
        if (arrayList.isEmpty()) {
            top = bottom = value;
        } else {
            top = value;
        }

        arrayList.add(value);

    }

    public void pop() {
        if (arrayList.isEmpty()) {
            return;
        }

        if (arrayList.size() == 1) {
            top = bottom = null;
            arrayList.remove(0);
        } else {
            arrayList.remove(arrayList.size() - 1);
            top = arrayList.get(arrayList.size() - 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Stack:\n");


        result.append("+---+\n");

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            T current = arrayList.get(i);

            result.append(current).append("\n");
        }


        result.append("+---+\n");

        result.append("Size: ").append(size());

        return result.toString();
    }

    public static void main(String[] args) {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        System.out.println(stack.peek());

        System.out.println(stack);

        stack.push("google");
        stack.push("udemy");
        stack.push("discord");

        System.out.println(stack);

        System.out.println(stack.peek());

        stack.pop();
        stack.pop();

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
    }


}
