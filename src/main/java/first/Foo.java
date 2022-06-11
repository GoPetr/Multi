package first;

import java.util.concurrent.Semaphore;

public class Foo {
  Semaphore semaphoreB = new Semaphore(0);
  Semaphore semaphoreC = new Semaphore(0);

  public void first(Runnable r) {
    System.out.println("first");

  }

  public void second(Runnable r) {
    System.out.println("second");
  }

  public void third(Runnable r) {
    System.out.println("third");
  }

  public static void main(String[] args) {
    Foo foo = new Foo();

    Thread thread = new Thread(new ThreadA("A", foo));
    Thread thread2 = new Thread(new ThreadB("B", foo));
    Thread thread3 = new Thread(new ThreadC("C", foo));

    thread.start();
    thread2.start();
    thread3.start();
  }
}


