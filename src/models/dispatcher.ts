export type dispatcherType<T> = {
    readonly dispatch: () => void;
    readonly addCallback: (callback: (payload: T) => void) => void;
}