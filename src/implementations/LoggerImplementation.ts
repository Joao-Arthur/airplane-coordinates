import { mapFns } from '../core/mapFns';
import { dispatcherType } from '../models/dispatcher';
import { loggerType } from '../models/logger';
import { messageType } from '../models/message';
import { uniqueIdentifierType } from '../models/uniqueIdentifier';

export class LoggerImplementation implements loggerType, dispatcherType<readonly messageType[]> {
    private callbacks: ((payload: readonly messageType[]) => void)[] = [];
    private messagesDatabase = new Map<string, messageType>();

    public constructor(private readonly uniqueIdentifier: uniqueIdentifierType) { }

    public info(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'info', content: message });
        this.dispatch();
    }

    public success(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'success', content: message });
        this.dispatch();
    }

    public warn(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'warn', content: message });
        this.dispatch();
    }

    public error(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'error', content: message });
        this.dispatch();
    }

    public retrieve() {
        return mapFns.valueToArray(this.messagesDatabase);
    }

    public dispatch() {
        const payload = this.retrieve();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: readonly messageType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
};
