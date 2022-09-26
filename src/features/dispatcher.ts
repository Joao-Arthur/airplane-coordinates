export type dispatcherType = {
    readonly dispatch: () => void;
    readonly addCallback: (callback: (payload: any) => void) => void;
}