export class InvalidAirplaneError extends Error {
    constructor() {
        super('Necessário informar posição cartesiana ou polar');
    }
}
