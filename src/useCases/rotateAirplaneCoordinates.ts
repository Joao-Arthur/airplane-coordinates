import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    selectedIds: any[];
    angle: number;
    centerOfRotationX: number;
    centerOfRotationY: number;
};

export function rotateAirplaneCoordinates({
    logger,
    airplaneRepository,
    selectedIds,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: paramsType) {
    logger.info('Aplicando rotação de coordenadas');
}
