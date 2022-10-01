export class MaxNumberOfAirplanesExceededError extends Error {
    constructor(maxNumberOfAirplanes: number) {
        super(`Só é possível ter ${maxNumberOfAirplanes} aviões ao mesmo tempo`);
    }
}
