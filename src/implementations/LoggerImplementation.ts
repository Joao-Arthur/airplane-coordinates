import { mapFns } from '../core/mapFns';
import { loggerType } from '../models/logger';
import { messageType } from '../models/message';
import { uniqueIdentifierType } from '../models/uniqueIdentifier';

export class LoggerImplementation implements loggerType {
    private messagesDatabase = new Map<string, messageType>();

    public constructor(private readonly uniqueIdentifier: uniqueIdentifierType) { }

    public info(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'info', content: message });
    }

    public success(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'success', content: message });
    }

    public warn(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'warn', content: message });
    }

    public error(message: string) {
        this.messagesDatabase.set(this.uniqueIdentifier(), { type: 'error', content: message });
    }

    public retrieve() {
        return mapFns.valueToArray(this.messagesDatabase);
    }
};
