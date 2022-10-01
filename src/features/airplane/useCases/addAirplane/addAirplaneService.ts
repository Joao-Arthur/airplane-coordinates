import { addAirplaneBusiness } from './addAirplaneBusiness';
import { addAirplaneParamsType } from './addAirplaneParams';

export function addAirplaneService({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: addAirplaneParamsType) {
    const numberOfAirplanes = airplaneRepository.retrieve().length;
    try {
        const airplaneToSave = addAirplaneBusiness({
            ...airplaneParams,
            id: uniqueIdentifier(),
            numberOfAirplanes,
            maxNumberOfAirplanes: 10,
        });
        airplaneRepository.add(airplaneToSave);
    } catch (error) {
        if (error instanceof Error)
            logger.error(error.message);
    }
}
