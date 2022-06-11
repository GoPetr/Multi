package first;

public class ThreadB implements Runnable {
  String name;
  Foo foo;

  public ThreadB(String name, Foo foo) {
    this.name = name;
    this.foo = foo;
  }

  @Override
  public void run() {
    try {
      foo.semaphoreB.acquire();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    foo.second(this);
    foo.semaphoreC.release();
  }
}
