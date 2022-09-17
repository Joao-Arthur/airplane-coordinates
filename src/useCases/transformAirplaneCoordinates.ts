import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    selectedIds: any[];
    x: number;
    y: number;
};

export function transformAirplaneCoordinates({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: paramsType) {
    logger.info('Aplicando transformação de coordenadas');
}
