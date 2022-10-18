export type messageType = {
    readonly type: 'info' | 'success' | 'error' | 'warn';
    readonly content: string;
}
