package first;

public class ThreadA implements Runnable {

  String name;
  Foo foo;

  public ThreadA(String name, Foo foo) {

    this.name = name;
    this.foo = foo;

  }

  @Override
  public void run() {
    foo.first(this);
    foo.semaphoreB.release();
  }
}


