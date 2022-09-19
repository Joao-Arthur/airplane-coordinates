import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { loggerType } from '../../ports/logger';
import { rotateAirplaneCoordinatesBusiness } from './rotateAirplaneCoordinatesBusiness';

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
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = rotateAirplaneCoordinatesBusiness({
        airplanes,
        angle,
        centerOfRotationX,
        centerOfRotationY
    });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Rotação realizada com sucesso!');
}
