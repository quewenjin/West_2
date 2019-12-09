package nosae;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class HelloWorld {

    private ReentrantLock lock = new ReentrantLock();
    Condition conditionH = lock.newCondition();
    Condition conditionW = lock.newCondition();
    private int flag = 1;
    private int n;

    public HelloWorld( int n){
        this.n = n;
    }

    public void hello() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            try{
                lock.lock();
                if(flag != 1)
                {
                    conditionH.await();//H等待
                }
                System.out.print("Hello");
                flag = 2;
                conditionW.signal();//W激活
            }finally{
                lock.unlock();
            }
        }
    }

    public void world() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            try{
                lock.lock();
                if(flag != 2)
                {
                    conditionW.await();//W等待
                }
                System.out.println("World!");
                flag = 1;
                conditionH.signal();//H激活
            }finally{
                lock.unlock();
            }
        }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}
