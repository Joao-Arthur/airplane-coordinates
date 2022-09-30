import { airplaneType } from '../../models';

export class AirplaneNotFoundError extends Error {
    constructor(id: airplaneType['id']) {
        super(`avião "${id}" não encontrado para deletar`);
    }
}
