import { messageType } from "./message";

export type loggerType = {
    readonly info: (message: string) => void;
    readonly success: (message: string) => void;
    readonly warn: (message: string) => void;
    readonly error: (message: string) => void;
    readonly retrieve: () => readonly messageType[];
};
