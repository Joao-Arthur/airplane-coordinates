export class MaxNumberOfAirplanesExceededError extends Error {
    constructor() {
        super('só é possível ter 10 aviões ao mesmo tempo');
    }
}
