export class BadFunctionError extends Error {
    constructor() {
        super('Can\'t execute a function with Infinite coefficient');
    }
}
