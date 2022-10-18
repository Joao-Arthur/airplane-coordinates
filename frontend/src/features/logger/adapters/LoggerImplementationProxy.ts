import { dispatcherType } from '../../dispatcher';
import { uniqueIdentifierType } from '../../uniqueIdentifier/ports/uniqueIdentifier';
import { messageType } from '../model';
import { loggerRepositoryType } from '../ports/loggerRepository';
import { LoggerImplementation } from './LoggerImplementation';

export class LoggerImplementationProxy implements loggerRepositoryType, dispatcherType {
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

    public clear() {
        this.loggerImplementation.clear();
        this.dispatch();
    }

    public dispatch() {
        const payload = this.retrieve();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: readonly messageType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
}
