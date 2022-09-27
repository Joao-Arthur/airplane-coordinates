import { addAirplaneBusiness } from './addAirplaneBusiness';
import { addAirplaneParamsType } from './addAirplaneParams';

export function addAirplaneService({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: addAirplaneParamsType) {
    logger.info('Adicionando avião');
    try {
        const airplaneToSave = addAirplaneBusiness({
            ...airplaneParams,
            id: uniqueIdentifier(),
        });
        airplaneRepository.add(airplaneToSave);
        logger.success('Avião adicionado com sucesso');
    } catch (error) {
        if (error instanceof Error)
            logger.error(`Erro ao adicionar avião: ${error.message}`);
    }
}
