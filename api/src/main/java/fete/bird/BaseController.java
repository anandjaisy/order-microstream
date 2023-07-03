package fete.bird;

import fete.bird.utils.IServiceBus;

public abstract class BaseController {
    protected final IServiceBus _iServiceBus;

    public BaseController(IServiceBus iServiceBus) {
        _iServiceBus = iServiceBus;
    }
}
