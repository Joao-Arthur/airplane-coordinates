export type loggerType = {
    readonly log: (message: string) => void;
    readonly warn: (message: string) => void;
    readonly error: (message: string) => void;
};
