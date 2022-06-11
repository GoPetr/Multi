package second;

import java.util.concurrent.Semaphore;

public class DemoThread implements Runnable {
  public volatile static int COUNT = 1;
  Thread t;
  Semaphore sem;
  String name;
  Foo foo;

  DemoThread(Semaphore sem, String name, Foo foo) {
    this.sem = sem;
    this.name = name;
    this.foo = foo;
    t = new Thread(this);
    t.start();

  }

  @Override
  public void run() {
    try {
      if (COUNT == 1) {
        COUNT++;
        sem.acquire();
        foo.first(this);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      sem.release();
    }

    try {
      if (COUNT == 2) {
        sem.acquire();
        COUNT++;
        foo.second(this);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      sem.release();
    }

    try {
      if (COUNT == 3) {
        sem.acquire();
        foo.third(this);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      sem.release();
    }

  }
}
