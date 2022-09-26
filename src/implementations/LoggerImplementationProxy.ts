import { dispatcherType } from '../models/dispatcher';
import { loggerType } from '../models/logger';
import { messageType } from '../models/message';
import { uniqueIdentifierType } from '../models/uniqueIdentifier';
import { LoggerImplementation } from './LoggerImplementation';

export class LoggerImplementationProxy implements loggerType, dispatcherType {
    private callbacks: ((payload: readonly messageType[]) => void)[] = [];
    private readonly loggerImplementation;

    public constructor(readonly uniqueIdentifier: uniqueIdentifierType) {
        this.loggerImplementation = new LoggerImplementation(uniqueIdentifier);
    }

    public info(message: string) {
        this.loggerImplementation.info(message);
        this.dispatch();
    }

    public success(message: string) {
        this.loggerImplementation.success(message);
        this.dispatch();
    }

    public warn(message: string) {
        this.loggerImplementation.warn(message);
        this.dispatch();
    }

    public error(message: string) {
        this.loggerImplementation.error(message);
        this.dispatch();
    }

    public retrieve() {
        return this.loggerImplementation.retrieve();
    }

    public dispatch() {
        const payload = this.retrieve();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: readonly messageType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
};
