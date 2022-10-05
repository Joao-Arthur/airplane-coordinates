import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { uniqueIdentifierType } from '../../../uniqueIdentifier/ports/uniqueIdentifier';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type airplaneParamsType = {
    readonly x: number | undefined;
    readonly y: number | undefined;
    readonly radius: number | undefined;
    readonly angle: number | undefined;
    readonly speed: number;
    readonly direction: number;
};

export type addAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};
