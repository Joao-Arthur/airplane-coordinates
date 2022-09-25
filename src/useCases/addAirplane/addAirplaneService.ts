import { airplaneRepositoryType } from '../../models/airplaneRepository';
import { uniqueIdentifierType } from '../../models/uniqueIdentifier';
import { loggerType } from '../../models/logger';
import { addAirplaneBusiness } from './addAirplaneBusiness';

type airplaneParamsType = {
    readonly x: number;
    readonly y: number;
    readonly radius: number;
    readonly angle: number;
    readonly speed: number;
    readonly direction: number;
};

type paramsType = {
    readonly logger: loggerType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};

export function addAirplaneService({
    logger,
    uniqueIdentifier,
    airplaneRepository,
    airplaneParams,
}: paramsType) {
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
