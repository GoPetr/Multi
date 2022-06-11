package second;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

  public synchronized void first(Runnable r) {
    System.out.println("first");
  }

  public synchronized void second(Runnable r) {
    System.out.println("second");
  }

  public synchronized void third(Runnable r) {
    System.out.println("third");
  }

  public static void main(String[] args) throws InterruptedException {
    Semaphore sem = new Semaphore(1);
    Foo foo = new Foo();
    DemoThread demoThreadA = new DemoThread(sem, "A", foo);
    DemoThread demoThreadB = new DemoThread(sem, "B", foo);
    DemoThread demoThreadC = new DemoThread(sem, "C", foo);
  }
}