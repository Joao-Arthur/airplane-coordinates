import { loggerType } from '../ports/logger';

function log(message: string): void {

}

function warn(message: string): void {

}

function error(message: string): void {

}

export const loggerImplementation: loggerType = {
    log,
    warn,
    error,
};
