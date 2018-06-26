package com.tan.concurrent.juc.locks.condition;

public class Seller {
 private Inventory inventory;
    
    public Seller(Inventory inventory) {
        this.inventory = inventory;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                inventory.consume(val);
            }
        }.start();
    }
}
