package com.tan.concurrent.juc.locks.condition;

public class ProductFactory {
    private Inventory inventory;
    
    public ProductFactory(Inventory inventory) {
        this.inventory = inventory;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                inventory.produce(val);
            }
        }.start();
    }
}
