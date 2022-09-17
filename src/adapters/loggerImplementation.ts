import { loggerType } from '../ports/logger';

function log(message: string): void {
    console.log(message);
}

function warn(message: string): void {
    console.log(message);
}

function error(message: string): void {
    console.log(message);
}

export const loggerImplementation: loggerType = {
    log,
    warn,
    error,
};
