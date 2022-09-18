import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { uniqueIdentifierType } from '../ports/uniqueIdentifier';
import { loggerType } from '../ports/logger';

type airplaneParamsType = {
    x: number;
    y: number;
    radius: number;
    angle: number;
    speed: number;
    direction: number;
};

type paramsType = {
    readonly logger: loggerType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};

export function addAirplane({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: paramsType) {
    logger.info('Adicionando avião');
    try {
        const airplaneToSave = {
            id: uniqueIdentifier(),
            x: airplaneParams.x,
            y: airplaneParams.y,
            speed: airplaneParams.speed,
            direction: airplaneParams.direction,
        };
        airplaneRepository.add(airplaneToSave);
        logger.success('Avião adicionado com sucesso');
    } catch (error) {
        if (error instanceof Error)
            logger.error(error.message);
    }
}
