import { describe, expect, it } from 'vitest';
import { uniqueIdentifierBig } from '../../uniqueIdentifier/adapters/uniqueIdentifierBig';
import { LoggerImplementation } from './LoggerImplementation';

describe('LoggerImplementation', () => {
    it('should recover the saved registers', () => {
        const loggerImplementation = new LoggerImplementation(uniqueIdentifierBig);
        loggerImplementation.info('this is a info message');
        loggerImplementation.success('this is a success message');
        loggerImplementation.success('this is a success message');
        loggerImplementation.success('this is a success message');
        loggerImplementation.warn('this is a warning message');
        loggerImplementation.error('this is a error message');
        loggerImplementation.error('this is a error message');
        expect(loggerImplementation.retrieve()).toEqual([
            { type: 'error', content: 'this is a error message', amount: 2 },
            { type: 'warn', content: 'this is a warning message', amount: 1 },
            { type: 'success', content: 'this is a success message', amount: 3 },
            { type: 'info', content: 'this is a info message', amount: 1 },
        ]);

    });

    it('should clear the registers', () => {
        const loggerImplementation = new LoggerImplementation(uniqueIdentifierBig);
        loggerImplementation.info('this is a info message');
        loggerImplementation.clear();
        expect(loggerImplementation.retrieve()).toEqual([]);
    });
});
