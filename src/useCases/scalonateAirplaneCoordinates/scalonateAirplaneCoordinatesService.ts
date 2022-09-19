import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { loggerType } from '../../ports/logger';
import { scalonateAirplaneCoordinatesBusiness } from './scalonateAirplaneCoordinatesBusiness';

type paramsType = {
    readonly logger: loggerType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly string[];
    readonly x: number;
    readonly y: number;
};

export function scalonateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: paramsType) {
    logger.info('Aplicando escalonamento de coordenadas');
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = scalonateAirplaneCoordinatesBusiness({ airplanes, x, y });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Escalonamento realizado com sucesso!');
}
