package nosae;

import java.util.Scanner;

class HelloWorld {
    //private int sum = 0;   //次数验证
    private int flag = 0;
    private int n;
    public HelloWorld( int n){
        this.n = n;
    }
    public synchronized void hello() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            if(flag == 0)
            {
                //System.out.print( (++sum) + "   ");   //次数验证
                System.out.print("Hello");
                flag = 1;
                notifyAll();
            }
            wait();
        }
    }

    public synchronized void world() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            if(flag == 1)
            {
                System.out.println("World!");
                flag = 0;
                notifyAll();
            }
            wait();
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

