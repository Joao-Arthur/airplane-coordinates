export type dispatcherType = {
    readonly dispatch: () => void;
    readonly addCallback: (callback: (payload: unknown) => void) => void;
}
