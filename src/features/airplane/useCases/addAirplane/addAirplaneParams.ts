import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { uniqueIdentifierType } from '../../../uniqueIdentifier/ports/uniqueIdentifier';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type airplaneParamsType = ({
    readonly x: number;
    readonly y: number;
} | {
    readonly radius: number;
    readonly angle: number;
}) & {
    readonly speed: number;
    readonly direction: number;
};

export type addAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};
