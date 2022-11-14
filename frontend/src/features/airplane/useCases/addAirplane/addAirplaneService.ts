import { addAirplaneBusiness } from './addAirplaneBusiness';
import { addAirplaneParamsType } from './addAirplaneParams';

export function addAirplaneService({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: addAirplaneParamsType) {
    const numberOfAirplanes = airplaneRepository.retrieve().length;
    const id = uniqueIdentifier();
    try {
        addAirplaneBusiness({
            ...airplaneParams,
            id,
            numberOfAirplanes,
            maxNumberOfAirplanes: 10,
        });
        const airplaneToSave = {
            ...airplaneParams,
            id,
        };
        airplaneRepository.add(airplaneToSave);
    } catch (error) {
        if (error instanceof Error)
            logger.error(error.message);
    }
}
