package com.tan.concurrent.spi;

import java.util.ServiceLoader;

public class SpiApp {
	public static void main(String[] args) throws Exception {
        ServiceLoader<PayService> loaders = ServiceLoader.load(PayService.class);
        for (PayService d : loaders) {
            d.pay();
        }
    }
}
