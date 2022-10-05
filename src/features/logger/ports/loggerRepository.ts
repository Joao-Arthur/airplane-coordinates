import { messageType } from '../model/message';

export type loggerRepositoryType = {
    readonly info: (message: string) => void;
    readonly success: (message: string) => void;
    readonly warn: (message: string) => void;
    readonly error: (message: string) => void;
    readonly retrieve: () => readonly messageType[];
    readonly clear: ()=> void;
};
