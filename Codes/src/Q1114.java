import java.util.concurrent.atomic.AtomicInteger;

class Q1114 {
    AtomicInteger atomicInt;
      public Q1114() { //Should be Foo
          atomicInt = new AtomicInteger(0);
      }
  
      public void first(Runnable printFirst) throws InterruptedException {
          
          // printFirst.run() outputs "first". Do not change or remove this line.
          printFirst.run();
          atomicInt.incrementAndGet();
      }
  
      public void second(Runnable printSecond) throws InterruptedException {
          
          // printSecond.run() outputs "second". Do not change or remove this line.
          while (atomicInt.get() != 1) {}
          printSecond.run();
          atomicInt.incrementAndGet(); 
      }
  
      public void third(Runnable printThird) throws InterruptedException {
          
          // printThird.run() outputs "third". Do not change or remove this line.
          while (atomicInt.get() != 2) {}
          printThird.run();
      }
  }