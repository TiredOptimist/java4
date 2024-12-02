package ru.pankova.task1;

public class Box<T> {
    private T subject;
    private boolean isEmpty = true; // коробка пуста

    public void setSubject(T newSubject) {
        if (newSubject == null) {
            throw new IllegalArgumentException("Нельзя установить null значение в коробку");
        }
        if (!isEmpty) {
            throw new IllegalStateException("Коробка не пуста");
        }
        this.subject = newSubject;
        isEmpty = false;
    }

    public T getSubject() {
        if (isEmpty) {
            throw new IllegalStateException("Коробка пуста");
        }
        T temp = this.subject;
        this.subject = null;
        isEmpty = true;
        return temp;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        if (isEmpty) return "Коробка пуста!";
        return "В коробке лежит " + subject.toString();
    }
}



