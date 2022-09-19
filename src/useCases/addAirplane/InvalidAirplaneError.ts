export class InvalidAirplaneError extends Error {
    constructor() {
        super('necessário informar posição cartesiana ou polar');
    }
}