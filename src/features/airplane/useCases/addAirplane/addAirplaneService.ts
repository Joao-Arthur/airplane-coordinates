import { addAirplaneBusiness } from './addAirplaneBusiness';
import { addAirplaneParamsType } from './addAirplaneParams';

export function addAirplaneService({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: addAirplaneParamsType) {
    try {
        const numberOfAirplanes = airplaneRepository.retrieve().length;
        const airplaneToSave = addAirplaneBusiness({
            ...airplaneParams,
            id: uniqueIdentifier(),
            numberOfAirplanes
        });
        airplaneRepository.add(airplaneToSave);
    } catch (error) {
        if (error instanceof Error)
            logger.error(`Erro ao adicionar avião: ${error.message}`);
    }
}
