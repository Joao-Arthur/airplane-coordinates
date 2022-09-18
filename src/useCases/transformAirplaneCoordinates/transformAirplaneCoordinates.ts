import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { loggerType } from '../../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    selectedIds: string[];
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
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const selectedAirplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of selectedAirplanes)
        airplaneRepository.update({
            ...airplane,
            x: airplane.x + x,
            y: airplane.y + y,
        });
    logger.success('Transformação realizada com sucesso!');
}