package first;

public class ThreadC implements Runnable {

  String name;
  Foo foo;

  public ThreadC( String name, Foo foo) {

    this.name = name;
    this.foo = foo;

  }

  @Override
  public void run() {
    try {
      foo.semaphoreC.acquire();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    foo.third(this);
    foo.third(this);
    foo.third(this);
  }
}
