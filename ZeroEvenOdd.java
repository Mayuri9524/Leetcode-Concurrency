class ZeroEvenOdd {
    private int n;
    private Semaphore ZeroSema;
    private Semaphore EvenSema;
    private Semaphore OddSema;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.ZeroSema = new Semaphore(1);
        this.EvenSema = new Semaphore(0);
        this.OddSema = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for(int i=1;i<=n;i++)
        {
            ZeroSema.acquire();
            printNumber.accept(0);
            if(i%2==0)
            {
                EvenSema.release();
            }
            else
            {
                OddSema.release();
            }}
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2)
        {
            EvenSema.acquire();
            printNumber.accept(i);
            ZeroSema.release();
        }}

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for(int i=1;i<=n;i+=2)
        {
            OddSema.acquire();
            printNumber.accept(i);
            ZeroSema.release();
        }}
}