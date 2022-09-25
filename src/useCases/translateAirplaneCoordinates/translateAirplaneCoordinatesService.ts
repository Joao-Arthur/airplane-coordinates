import { airplaneRepositoryType } from '../../models/airplaneRepository';
import { loggerType } from '../../models/logger';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';

type paramsType = {
    readonly logger: loggerType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly string[];
    readonly x: number;
    readonly y: number;
};

export function translateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: paramsType) {
    logger.info('Aplicando transformação de coordenadas');
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = translateAirplaneCoordinatesBusiness({ airplanes, x, y });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Transformação realizada com sucesso!');
}
