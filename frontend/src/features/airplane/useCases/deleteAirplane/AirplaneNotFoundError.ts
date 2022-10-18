import { airplaneType } from '../../models';

export class AirplaneNotFoundError extends Error {
    constructor(id: airplaneType['id']) {
        super(`Avião "${id}" não encontrado para deletar`);
    }
}
