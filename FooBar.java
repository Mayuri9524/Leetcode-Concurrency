class FooBar {
    private int n;
    private Semaphore foosema;
    private Semaphore barsema;

    public FooBar(int n) {
        this.n = n;
        this.foosema= new Semaphore(1);
        this.barsema= new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foosema.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barsema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barsema.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foosema.release();
        }
    }
}