import { mapFns } from '../../../core/mapFns';
import { uniqueIdentifierType } from '../../uniqueIdentifier/ports/uniqueIdentifier';
import { messageType } from '../model';
import { loggerRepositoryType } from '../ports/loggerRepository';

export class LoggerImplementation implements loggerRepositoryType {
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
        return [...mapFns.valueToArray(this.messagesDatabase)].reverse();
    }

    public clear() {
        this.messagesDatabase.clear();
    }
}
