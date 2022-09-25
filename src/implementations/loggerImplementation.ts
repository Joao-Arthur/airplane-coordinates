import { loggerType } from '../models/logger';

function info(message: string): void {
    console.log(message);
}

function success(message: string): void {
    console.log(message);
}

function warn(message: string): void {
    console.warn(message);
}

function error(message: string): void {
    console.error(message);
}

export const loggerImplementation: loggerType = {
    info,
    success,
    warn,
    error,
};
