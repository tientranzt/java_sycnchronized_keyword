package tientranzt.github.io;

import static tientranzt.github.io.Colors.*;

public class Main {

    public static void main(String[] args) {
        CountNumber countNumber = new CountNumber();
        ThreadCountNumber t1 = new ThreadCountNumber(countNumber);
        t1.setName("t1");
        t1.start();

        ThreadCountNumber t2 = new ThreadCountNumber(countNumber);
        t2.setName("t2");
        t2.start();


    }
}

class CountNumber {

    private int i;

    public void countNumber() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "t1":
                color = ANSI_RED;
                break;
            case "t2":
                color = ANSI_GREEN;
                break;
            default:
                color = ANSI_BLACK;
                break;
        }

        synchronized (color) {

            for (i = 1; i <= 10; i++) {
                System.out.println(color + Thread.currentThread().getName() + "-" + i);
            }
        }
    }
}

class ThreadCountNumber extends Thread {
    CountNumber countNumber;

    public ThreadCountNumber() {
    }

    public ThreadCountNumber(CountNumber countNumber) {
        this.countNumber = countNumber;
    }

    @Override
    public void run() {
        countNumber.countNumber();
    }
}
