import { describe, expect, it } from "vitest";
import { LoggerImplementation } from "./LoggerImplementation";
import { uniqueIdentifierBig } from "./uniqueIdentifierBig";

describe('LoggerImplementation', () => {
    it('should recover the saved registers', () => {
        const loggerImplementation = new LoggerImplementation(uniqueIdentifierBig);
        loggerImplementation.info('this is a info message');
        loggerImplementation.success('this is a success message');
        loggerImplementation.warn('this is a warning message');
        loggerImplementation.info('this is a error message');
        expect(loggerImplementation.retrieve()).toEqual([
            { content: 'this is a info message', type: 'info' },
            { content: 'this is a success message', type: 'success' },
            { content: 'this is a warning message', type: 'warn' },
            { content: 'this is a error message', type: 'info' },
        ]);
    })
})