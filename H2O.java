class H2O {
    private Semaphore oxySema;
    private Semaphore hydraSema;

    public H2O() {
        this.oxySema = new Semaphore(0);
        this.hydraSema = new Semaphore(2);

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hydraSema.acquire();
        releaseHydrogen.run();
        oxySema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxySema.acquire(2);
        releaseOxygen.run();
        hydraSema.release(2);

    }
}