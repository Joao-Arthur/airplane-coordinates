import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { loggerType } from '../../ports/logger';

type paramsType = {
    readonly logger: loggerType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly string[];
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
};

export function rotateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: paramsType) {
    logger.info('Aplicando rotação de coordenadas');
}
