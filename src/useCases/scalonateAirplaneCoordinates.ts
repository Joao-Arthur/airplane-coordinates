import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    selectedIds: any[];
    x: number;
    y: number;
};

export function scalonateAirplaneCoordinates({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: paramsType) {
    logger.info('Aplicando escalonamento de coordenadas');
}
