import { dispatcherType } from '../models/dispatcher';

export class DispatcherImplementation<T> implements dispatcherType<T> {
    private callbacks: ((payload: T) => void)[] = [];

    public constructor(private readonly payloadCallback: () => T) { }

    public dispatch() {
        const payload = this.payloadCallback();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: T) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
}