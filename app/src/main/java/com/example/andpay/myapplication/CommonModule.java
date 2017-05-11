package com.example.andpay.myapplication;

import me.andpay.timobileframework.config.TiMobileModule;

public class CommonModule extends TiMobileModule {

    @Override
    protected void configure() {

       bindEventController(MainEventController.class);



       // bindEventController(ConfirmTransferEventControl.class);


    }


}
