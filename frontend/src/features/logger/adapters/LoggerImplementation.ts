import { maps } from 'funis';
import { uniqueIdentifierType } from '../../uniqueIdentifier/ports/uniqueIdentifier';
import { messageType } from '../model';
import { loggerRepositoryType } from '../ports/loggerRepository';

export class LoggerImplementation implements loggerRepositoryType {
    private messagesDatabase = new Map<string, messageType>();

    public constructor(private readonly uniqueIdentifier: uniqueIdentifierType) { }

    private addMessage(message: messageType) {
        const top = maps.last(this.messagesDatabase);
        const sameContent = top?.[1].content === message.content;
        if (sameContent)
            this.messagesDatabase.set(top[0], {
                ...message,
                amount: top[1].amount + 1,
            });
        else
            this.messagesDatabase.set(this.uniqueIdentifier(), message);
    }

    public info(message: string) {
        this.addMessage({ type: 'info', content: message, amount: 1 });
    }

    public success(message: string) {
        this.addMessage({ type: 'success', content: message, amount: 1 });
    }

    public warn(message: string) {
        this.addMessage({ type: 'warn', content: message, amount: 1 });
    }

    public error(message: string) {
        this.addMessage({ type: 'error', content: message, amount: 1 });
    }

    public retrieve() {
        return [...maps.values(this.messagesDatabase)].reverse();
    }

    public clear() {
        this.messagesDatabase.clear();
    }
}
